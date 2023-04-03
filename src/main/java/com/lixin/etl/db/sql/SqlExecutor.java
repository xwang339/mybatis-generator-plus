package com.lixin.etl.db.sql;

import com.lixin.etl.db.model.ModeType;
import com.lixin.etl.db.table.TableSchema;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

/**
 * Description: sql管理器 可以植入业务 比如建表检查 执行器的植入
 * Copyright:   Copyright (c)2023
 * Company:     sci
 *
 * @author: 张李鑫
 * @version: 1.0
 * Create at:   2023-03-16 15:56:40
 * <p>
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2023-03-16     张李鑫                     1.0         1.0 Version
 */
public class SqlExecutor extends SqlBuilder {

    /**
     * 数据库连接对象
     */
    private DataSource dataSource;

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
    public void executeCreateTableSql() {
        execute(getCreateTableAndCommentSql());
    }

}
