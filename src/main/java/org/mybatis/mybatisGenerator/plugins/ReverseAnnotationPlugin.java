package org.mybatis.mybatisGenerator.plugins;

import com.lixin.db.index.IndexMethod;
import com.lixin.db.index.IndexType;
import com.lixin.db.index.IndexModel;
import org.mybatis.generator.api.*;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.config.JDBCConnectionConfiguration;
import org.mybatis.generator.internal.JDBCConnectionFactory;
import org.mybatis.generator.internal.ObjectFactory;
import org.mybatis.reverseGenerator.annotation.ColumnGeneratorDoc;
import org.mybatis.reverseGenerator.annotation.IndexGeneratorDoc;
import org.mybatis.reverseGenerator.annotation.IndexGeneratorDocs;
import org.mybatis.reverseGenerator.annotation.TableGeneratorDoc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 逆向辅助注解插件
 * todo:索引信息生成还没做
 * 目前这个类 只针对innodb这个引擎 做了一些小部分功能的实现
 */
public class ReverseAnnotationPlugin extends PluginAdapter {
    private final FullyQualifiedJavaType TableGeneratorDocAnno;
    private final FullyQualifiedJavaType ColumnGeneratorDocAnno;
    private final FullyQualifiedJavaType indexGeneratorDocs;
    private final FullyQualifiedJavaType indexGeneratorDoc;
    private final FullyQualifiedJavaType indexType;
    private final FullyQualifiedJavaType indexMethod;

    private String indexSql = "show  index from %s";

    private DatabaseMetaData databaseMetaData;


    static class IndexInfo {
        String columnName;
        String indexType;
        String comment;

        String keyName;

        public IndexInfo(String columnName, String indexType, String comment, String keyName) {
            this.columnName = columnName;
            this.indexType = indexType;
            this.comment = comment;
            this.keyName = keyName;
        }
    }

    public ReverseAnnotationPlugin() {
        TableGeneratorDocAnno = new FullyQualifiedJavaType(TableGeneratorDoc.class.getName());
        indexGeneratorDocs = new FullyQualifiedJavaType(IndexGeneratorDocs.class.getName());
        indexGeneratorDoc = new FullyQualifiedJavaType(IndexGeneratorDoc.class.getName());
        ColumnGeneratorDocAnno = new FullyQualifiedJavaType(ColumnGeneratorDoc.class.getName()); //$NON-NLS-1$
        indexType = new FullyQualifiedJavaType(IndexType.class.getName()); //$NON-NLS-1$
        indexMethod = new FullyQualifiedJavaType(IndexMethod.class.getName()); //$NON-NLS-1$
    }


    public HashMap<String, IndexModel> getIndexes(String tableName) {
        HashMap<String, IndexModel> indexModelHashMap = new HashMap<>();
        try (Connection connection = getConnection()) {
            ResultSet resultSet = connection.createStatement().executeQuery(String.format(indexSql, tableName));
            buildIndexModel(resultSet, indexModelHashMap);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return indexModelHashMap;
    }


    public void buildIndexModel(ResultSet resultSet, HashMap<String, IndexModel> indexModelHashMap) throws SQLException {
        while (resultSet.next()) {
            String keyName = resultSet.getString("Key_name");
            if (keyName.equals("PRIMARY")) {
                continue;
            }
            String columnName = resultSet.getString("column_name");
            String indexType = resultSet.getString("Index_type");
            int unique = resultSet.getInt("Non_unique");
            String comment = resultSet.getString("Index_comment");
            IndexModel oldModel = indexModelHashMap.get(keyName);
            List<String> columnNames = indexModelHashMap.containsKey(keyName) ? oldModel.getColumns() : new ArrayList<>();
            columnNames.add(columnName);
            indexModelHashMap.computeIfAbsent(keyName, (k) -> new IndexModel(keyName, indexType, unique, columnNames, comment));
        }
    }


    private Connection getConnection() throws SQLException {
        ConnectionFactory connectionFactory;
        JDBCConnectionConfiguration jdbcConnectionConfiguration = this.context.getJdbcConnectionConfiguration();
        connectionFactory = jdbcConnectionConfiguration != null ? new JDBCConnectionFactory(jdbcConnectionConfiguration) : ObjectFactory.createConnectionFactory(this.context);
        return connectionFactory.getConnection();
    }

    public boolean validate(List<String> warnings) {
        return true;
    }

    /**
     * 实体对象注释
     *
     * @param topLevelClass     the generated base record class
     * @param introspectedTable The class containing information about the table as
     *                          introspected from the database
     * @return
     */
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String annotation = "@TableGeneratorDoc(remark = \"%s\",name = \"%s\")";
        HashMap<String, IndexModel> indexes = getIndexes(introspectedTable.getFullyQualifiedTable().getIntrospectedTableName());
        addIndexDoc(indexes, topLevelClass);
        addTableGeneratorDocAnno(topLevelClass, String.format(annotation, introspectedTable.getRemarks(), introspectedTable.getFullyQualifiedTable()));
        return true;
    }

    private void addIndexDoc(HashMap<String, IndexModel> indexes, TopLevelClass topLevelClass) {
        String docLine = builderIndexDoc(indexes);
        if (!docLine.isEmpty()) {
            topLevelClass.addImportedType(indexGeneratorDocs);
            topLevelClass.addImportedType(indexType);
            topLevelClass.addImportedType(indexMethod);
            topLevelClass.addImportedType(indexGeneratorDoc);
            topLevelClass.addJavaDocLine(docLine);
        }
    }

    private String builderIndexDoc(HashMap<String, IndexModel> indexes) {
        String space = "        ";
        if (!indexes.isEmpty()) {
            String preFix = "@IndexGeneratorDocs({\n";
            String LINE_FEED_HAS_NEXT = ",\n";
            StringBuilder stringBuilder = new StringBuilder(preFix);
            String suffix = ")";
            indexes.forEach((k, v) -> {
                IndexType indexType = v.getIndexType();
                IndexMethod indexMethod = v.getIndexMethod();
                String childAnno =
                        "@IndexGeneratorDoc(keyName = \"" + k + "\"" +
                                ",indexType = IndexType." + indexType +
                                ",indexMethod = IndexMethod." + indexMethod +
                                ",remark = \"" + v.getRemark() + "\"" +
                                ",column = \"" + v.getColumns().toString() + "\" )";

                stringBuilder.append(space).append(childAnno).append(LINE_FEED_HAS_NEXT);
            });
            stringBuilder.delete(stringBuilder.length() - LINE_FEED_HAS_NEXT.length(), stringBuilder.length() - 1).append("}");
            return stringBuilder.append(suffix).toString();
        }
        return "";
    }

    private void addTableGeneratorDocAnno(TopLevelClass topLevelClass, String docLine) {
        topLevelClass.addImportedType(TableGeneratorDocAnno);
        topLevelClass.addJavaDocLine(docLine);
    }

    @Override
    public boolean modelRecordWithBLOBsClassGenerated(
            TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String annotation = "@TableGeneratorDoc(remark = \"%s\",name = \"%s\")";
        addTableGeneratorDocAnno(topLevelClass, String.format(annotation, introspectedTable.getRemarks(), introspectedTable.getFullyQualifiedTable()));
        return true;
    }


    @Override
    public boolean modelFieldGenerated(Field field,
                                       TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn,
                                       IntrospectedTable introspectedTable,
                                       Plugin.ModelClassType modelClassType) {

        List<IntrospectedColumn> primaryKeyColumns = introspectedTable.getPrimaryKeyColumns();
        boolean isPrimaryKey = primaryKeyColumns.contains(introspectedColumn);
        String format = buildBaseAnnotation(introspectedColumn);
        //添加主键相关注释
        if (primaryKeyColumns.contains(introspectedColumn)) {
            format += ",isPrimaryKey = %b,isAuto = %b";
            format = String.format(format, isPrimaryKey, introspectedColumn.isAutoIncrement());

        }
        format += ")";
        field.addJavaDocLine(format);
        topLevelClass.addImportedType(ColumnGeneratorDocAnno);
        return true;
    }

    /**
     * 构造基础的注解
     *
     * @param introspectedColumn
     * @return
     */
    private static String buildBaseAnnotation(IntrospectedColumn introspectedColumn) {
        String annotation = "@ColumnGeneratorDoc(typeName = \"%s\"," +
                "name = \"%s\", " +
                "jdbcType = %d, " +
                "isNull = %b, " +
                "length = %d, " +
                "Scale = %d, " +
                "Identity = %b, " +
                "type = 1, " +
                "remark = \"%s\"";

        return String.format(
                annotation,
                introspectedColumn.getJdbcTypeName(),
                introspectedColumn.getActualColumnName(),
                introspectedColumn.getJdbcType(),
                introspectedColumn.isNullable(),
                introspectedColumn.getLength(),
                introspectedColumn.getScale(),
                introspectedColumn.isIdentity(),
                introspectedColumn.getRemarks()
        );
    }

    public static void main(String[] args) {
        String list = "[username]";


    }

}
