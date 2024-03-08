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
