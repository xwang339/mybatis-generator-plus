package com.lixin.db.sql;

import com.lixin.db.model.ModeType;
import com.lixin.db.table.TableSchema;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;


@Log4j2
public class SqlExecutor extends SqlBuilder {

    /**
     * 数据库连接对象
     */
    private DataSource dataSource;

    public SqlExecutor() {
    }


    public SqlExecutor(TableSchema tableSchema, ModeType modeType) {
        super(tableSchema, modeType);
    }

    public SqlExecutor(TableSchema tableSchema, ModeType modeType, DataSource dataSource) {
        super(tableSchema, modeType);
        this.dataSource = dataSource;
    }

    public SqlExecutor(TableSchema tableSchema) {
        super(tableSchema);
    }


    public SqlExecutor(TableSchema tableSchema, DataSource dataSource) {
        super(tableSchema);
        this.dataSource = dataSource;
    }


    public void execute(String sql) {
        if (dataSource == null) {
            throw new RuntimeException("dataSource is null");
        }
        if (StringUtils.isBlank(sql)) {
            return;
        }
        try (Connection connection = dataSource.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute(sql);
            connection.commit();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 获取执行语句并执行建表语句
     */
    public String getTableDDL() {
        return getCreateTableAndCommentSql();
    }

    /**
     * 替换table信息并且获取新表的信息
     *
     * @param tableSchema
     * @return
     */
    public String getTableDDL(TableSchema tableSchema) {
        this.setTableSchema(tableSchema);
        return getTableDDL();
    }

    public String getTableDDLAndExecute() {
        String tableDDL = getTableDDL();
        execute(tableDDL);
        return tableDDL;
    }

    public String getTableDDLAndExecute(TableSchema tableSchema) {
        this.setTableSchema(tableSchema);
        return getTableDDLAndExecute();
    }

}
