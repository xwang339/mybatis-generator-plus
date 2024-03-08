package org.mybatis.mybatisGenerator.plugins;

import org.mybatis.generator.api.*;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.config.JDBCConnectionConfiguration;
import org.mybatis.generator.internal.JDBCConnectionFactory;
import org.mybatis.generator.internal.ObjectFactory;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.mybatis.generator.internal.util.messages.Messages.getString;

/**
 * 逆向辅助注解插件
 * todo:索引信息生成还没做
 */
public class ReverseAnnotationPlugin extends PluginAdapter {
    private final FullyQualifiedJavaType TableGeneratorDoc;
    private final FullyQualifiedJavaType ColumnGeneratorDoc;

    private DatabaseMetaData databaseMetaData;

    public ReverseAnnotationPlugin() {
        TableGeneratorDoc = new FullyQualifiedJavaType("org.mybatis.mybatisGenerator.annotation.TableGeneratorDoc");
        ColumnGeneratorDoc = new FullyQualifiedJavaType("org.mybatis.mybatisGenerator.annotation.ColumnGeneratorDoc"); //$NON-NLS-1$
    }

    public DatabaseMetaData getDatabaseMetaData() {
        if (this.databaseMetaData == null) {
            try (Connection connection = getConnection()) {
                DatabaseMetaData metaData = connection.getMetaData();
                ResultSet singleIndexResultSet = metaData.getIndexInfo(null, null, "Users", false, false);
                System.out.println("单列索引信息：");

                while (singleIndexResultSet.next()) {
                    String indexName = singleIndexResultSet.getString("INDEX_NAME");
                    String columnName = singleIndexResultSet.getString("COLUMN_NAME");
                    System.out.println("索引名称：" + indexName + ", 列名：" + columnName);
                }

                // 获取联合索引信息
                ResultSet compositeIndexResultSet = metaData.getIndexInfo(null, null, "Users", false, false);
                System.out.println("联合索引信息：");
                while (compositeIndexResultSet.next()) {
                    String indexName = compositeIndexResultSet.getString("INDEX_NAME");
                    String columnName = compositeIndexResultSet.getString("COLUMN_NAME");
                    System.out.println("索引名称：" + indexName + ", 列名：" + columnName);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return null;
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
        topLevelClass.addImportedType(TableGeneratorDoc);
        topLevelClass.addJavaDocLine(String.format(annotation, introspectedTable.getRemarks(), introspectedTable.getFullyQualifiedTable()));
        return true;
    }

    @Override
    public boolean modelRecordWithBLOBsClassGenerated(
            TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String annotation = "@TableGeneratorDoc(remark = \"%s\",name = \"%s\")";
        topLevelClass.addImportedType(TableGeneratorDoc);
        topLevelClass.addJavaDocLine(String.format(annotation, introspectedTable.getRemarks(), introspectedTable.getFullyQualifiedTable()));
        return true;
    }

    @Override
    public boolean modelFieldGenerated(Field field,
                                       TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn,
                                       IntrospectedTable introspectedTable,
                                       Plugin.ModelClassType modelClassType) {

        getDatabaseMetaData();
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
        topLevelClass.addImportedType(ColumnGeneratorDoc);
//            this.databaseMetaData.getIndexInfo()
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

}
