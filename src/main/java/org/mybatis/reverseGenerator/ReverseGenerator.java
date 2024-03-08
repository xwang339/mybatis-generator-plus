package org.mybatis.reverseGenerator;

import com.lixin.db.model.DbType;
import com.lixin.db.sql.SqlExecutor;
import com.lixin.db.table.IndexModel;
import com.lixin.db.table.SqlModel;
import com.lixin.db.table.TableSchema;
import com.lixin.db.util.CreateUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.mybatis.generator.api.ShellCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.JavaModelGeneratorConfiguration;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.ShellException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.reverseGenerator.annotation.ColumnGeneratorDoc;
import org.mybatis.reverseGenerator.annotation.IndexGeneratorDoc;
import org.mybatis.reverseGenerator.annotation.IndexGeneratorDocs;
import org.mybatis.reverseGenerator.annotation.TableGeneratorDoc;

import java.io.File;
import java.util.*;

import static org.mybatis.generator.internal.util.messages.Messages.getString;


public class ReverseGenerator {

    /**
     * 沿用mybatis的配置文件
     * 根据mybatis生成的饿文件去做逆向
     */
    private final Configuration configuration;

    private final ShellCallback shellCallback;

    private final List<String> classList;

    private final HashMap<String, Table> tableMaps;


    public ReverseGenerator(Configuration configuration) throws InvalidConfigurationException {
        if (configuration == null) {
            throw new IllegalArgumentException(getString("RuntimeError.2")); //$NON-NLS-1$
        }
        this.shellCallback = new DefaultShellCallback(false);
        this.configuration = configuration;
        this.configuration.validate();
        this.classList = new ArrayList<>();
        this.tableMaps = new HashMap<>();
    }


    public List<String> reverse(boolean writeFiles, DbType dbType, boolean execute) throws Exception {
        getClassPath(configuration.getContexts());
        collectMetadata();
        List<TableSchema> tableSchemas = convert(dbType);
        List<String> result = new ArrayList<>();
        SqlExecutor sqlExecutor = new SqlExecutor();
        tableSchemas.forEach((tableSchema) -> result.add(execute ? sqlExecutor.getTableDDLAndExecute(tableSchema) : sqlExecutor.getTableDDL(tableSchema)));
        if (writeFiles) {
            //todo
        }
        return result;
    }

    /**
     * 把注解信息转换成class
     */
    private List<TableSchema> convert(DbType dbType) {
        List<TableSchema> tableSchemas = new ArrayList<>();
        tableMaps.forEach((tableName, table) -> {
            TableGeneratorDoc tableGeneratorDoc = table.tableGeneratorDoc;
            List<SqlModel> sqlModels = convertColumnGeneratorDocs2SqlModel(table.columnGeneratorDocs);
            TableSchema tableSchema = CreateUtils.createTable(dbType, sqlModels, tableGeneratorDoc.name(), tableGeneratorDoc.remark());
            tableSchema.setIndexModels(convertIndexDocs2IndexModel(table.indexGeneratorDoc));
            tableSchemas.add(tableSchema);
        });
        return tableSchemas;
    }

    public List<IndexModel> convertIndexDocs2IndexModel(List<IndexGeneratorDoc> indexGeneratorDocs) {
        return indexGeneratorDocs.stream().map(this::buildIndexModel).filter((Objects::nonNull)).toList();
    }

    private IndexModel buildIndexModel(IndexGeneratorDoc indexGeneratorDoc) {
        if (indexGeneratorDoc == null) {
            return null;
        }
        //todo
        return new IndexModel();
    }

    public List<SqlModel> convertColumnGeneratorDocs2SqlModel(List<ColumnGeneratorDoc> columnGeneratorDocs) {
        return columnGeneratorDocs.stream().map(this::buildSqlModel).filter((Objects::nonNull)).toList();
    }

    public SqlModel buildSqlModel(ColumnGeneratorDoc column) {
        if (column == null) {
            return null;
        }
        return new SqlModel(column.name(),
                column.remark(),
                column.jdbcType(),
                column.length(),
                column.isNull(),
                column.isPrimaryKey(),
                column.isAuto()
        );
    }

    /**
     * 获取配置文件路径配置信息 拼接成class path
     *
     * @param contextsToRun
     * @throws ShellException
     */
    private void getClassPath(List<Context> contextsToRun) throws ShellException {
        for (Context context : contextsToRun) {
            JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = context.getJavaModelGeneratorConfiguration();
            File[] files = shellCallback
                    .getDirectory(javaModelGeneratorConfiguration.getTargetProject(), javaModelGeneratorConfiguration.getTargetPackage())
                    .listFiles();

            if (files != null) {
                for (File file : files) {
                    classList.add(javaModelGeneratorConfiguration.getTargetPackage() + "." + file.getName().replace(".java", ""));
                }
            }
        }
    }

    /**
     * 收集元数据信息
     * 注解信息包含表信息 字段信息
     *
     * @throws ClassNotFoundException
     */
    private void collectMetadata() throws ClassNotFoundException {
        for (String path : classList) {
            collectAnnotation(Class.forName(path));
        }
    }

    private void collectAnnotation(Class<?> beanClass) {
        TableGeneratorDoc tableGeneratorDoc = beanClass.getAnnotation(TableGeneratorDoc.class);
        if (tableGeneratorDoc != null) {
            tableMaps.computeIfAbsent(tableGeneratorDoc.name(), (k) -> new Table(tableGeneratorDoc));
            Table table = tableMaps.get(tableGeneratorDoc.name());
            setColumnGeneratorDocs(beanClass, table);
            setIndexDoc(beanClass, table);
        }
    }


    private void setIndexDoc(Class<?> beanClass, Table table) {
        IndexGeneratorDocs indexGeneratorDoc = beanClass.getAnnotation(IndexGeneratorDocs.class);
        if (indexGeneratorDoc != null) {
            IndexGeneratorDoc[] value = indexGeneratorDoc.value();
            if (value != null && value.length > 0) {
                table.getIndexGeneratorDoc().addAll(Arrays.asList(value));
            }
        }
    }

    private void setColumnGeneratorDocs(Class<?> beanClass, Table table) {
        Arrays.stream(beanClass.getDeclaredFields())
                .filter((field -> field.getAnnotation(ColumnGeneratorDoc.class) != null))
                .forEach((field) -> table.getColumnGeneratorDocs().add(field.getAnnotation(ColumnGeneratorDoc.class)));
    }

    /**
     * 表的所有注解信息
     */
    @Data
    @EqualsAndHashCode
    @Accessors(chain = true)
    static class Table {
        TableGeneratorDoc tableGeneratorDoc;
        List<IndexGeneratorDoc> indexGeneratorDoc;
        List<ColumnGeneratorDoc> columnGeneratorDocs;

        public Table(TableGeneratorDoc tableGeneratorDoc) {
            this.tableGeneratorDoc = tableGeneratorDoc;
            this.indexGeneratorDoc = new ArrayList<>();
            this.columnGeneratorDocs = new ArrayList<>();
        }
    }

}
