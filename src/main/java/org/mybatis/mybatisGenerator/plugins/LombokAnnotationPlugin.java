package org.mybatis.mybatisGenerator.plugins;


import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.Plugin;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

/**
 * lombok 注解生成
 * 在类上生成注解
 * 取消getAndSet的函数生成
 * todo:通过配置的方式进行注解的自定义生成 目前暂时就提供自己用的数据
 */

public class LombokAnnotationPlugin extends PluginAdapter {

    private final FullyQualifiedJavaType accessors;
    private final FullyQualifiedJavaType equalsAndHashCode;
    private final FullyQualifiedJavaType data;

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    public LombokAnnotationPlugin() {
        accessors = new FullyQualifiedJavaType("lombok.experimental.Accessors");
        equalsAndHashCode = new FullyQualifiedJavaType("lombok.EqualsAndHashCode");
        data = new FullyQualifiedJavaType("lombok.Data");
    }

    /**
     * 实体对象注释
     *
     * @param topLevelClass     the generated base record class
     * @param introspectedTable The class containing information about the table as
     *                          introspected from the database
     * @return
     */
    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        buildAndAddJavaDocLine(topLevelClass, introspectedTable);
        return true;
    }

    private void buildAndAddJavaDocLine(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String data = "@Data";
        topLevelClass.addImportedType(this.data);
        topLevelClass.addJavaDocLine(String.format(data, introspectedTable.getRemarks(), introspectedTable.getFullyQualifiedTable()));

        String accessors = "@Accessors(chain = true)";
        topLevelClass.addImportedType(this.accessors);
        topLevelClass.addJavaDocLine(String.format(accessors, introspectedTable.getRemarks(), introspectedTable.getFullyQualifiedTable()));

        String eq = "@EqualsAndHashCode(callSuper = false)";
        topLevelClass.addImportedType(this.equalsAndHashCode);
        topLevelClass.addJavaDocLine(String.format(eq, introspectedTable.getRemarks(), introspectedTable.getFullyQualifiedTable()));
    }

    @Override
    public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        buildAndAddJavaDocLine(topLevelClass, introspectedTable);
        return true;
    }

    /**
     * 下述两个方法阻止get set方法的生成
     *
     * @param method             the getter, or accessor, method generated for the specified
     *                           column
     * @param topLevelClass      the partially implemented model class. You can add additional
     *                           imported classes to the implementation class if necessary.
     * @param introspectedColumn The class containing information about the column related
     *                           to this field as introspected from the database
     * @param introspectedTable  The class containing information about the table as
     *                           introspected from the database
     * @param modelClassType     the type of class that the field is generated for
     * @return
     */
    @Override
    public boolean modelGetterMethodGenerated(Method method,
                                              TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn,
                                              IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return false;
    }

    @Override
    public boolean modelSetterMethodGenerated(Method method,
                                              TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn,
                                              IntrospectedTable introspectedTable,
                                              Plugin.ModelClassType modelClassType) {
        return false;
    }
}
