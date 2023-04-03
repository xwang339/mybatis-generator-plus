package com.lixin.etl;

import com.lixin.etl.db.model.DbType;
import com.lixin.etl.db.model.ModeType;
import com.lixin.etl.db.model.MysqlColumn;
import com.lixin.etl.db.provider.MybatisSqlProvider;
import com.lixin.etl.db.sql.SqlExecutor;
import com.lixin.etl.db.table.SqlModel;
import com.lixin.etl.db.util.CreateUtils;
import org.apache.tomcat.util.buf.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Description:
 * Copyright:   Copyright (c)2023
 * Company:     sci
 *
 * @author: 张李鑫
 * @version: 1.0
 * Create at:   2023-03-24 13:44:49
 * <p>
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2023-03-24     张李鑫                     1.0         1.0 Version
 */
public class SqlExecutorTest {

    //MysqlColumn
    public SqlExecutor getSqlmanager() {
        SqlModel sqlModel = new SqlModel("id", "id", MysqlColumn.INTEGER.getValue(), 20, false, true, true);
        List<SqlModel> sqlModels = new ArrayList<>();
        sqlModels.add(sqlModel);
        for (int i = 0; i < 10; i++) {
            SqlModel model = new SqlModel("INTEGER" + i, "INTEGER" + i, MysqlColumn.INTEGER.getValue(), 20, i % 2 == 0, false, false);
            sqlModels.add(model);
        }
        for (int i = 0; i < 10; i++) {
            SqlModel model = new SqlModel("TEXT" + i, "TEXT" + i, MysqlColumn.TEXT.getValue(), 0, i % 2 == 0, false, false);
            sqlModels.add(model);
        }
        for (int i = 0; i < 10; i++) {
            SqlModel model = new SqlModel("VARCHAR" + i, "VARCHAR" + i, MysqlColumn.VARCHAR.getValue(), 20, i % 2 == 0, false, false);
            sqlModels.add(model);
        }
        for (int i = 0; i < 10; i++) {
            SqlModel model = new SqlModel("TIMESTAMP" + i, "TIMESTAMP" + i, MysqlColumn.TIMESTAMP.getValue(), 0, i % 2 == 0, false, false);
            sqlModels.add(model);
        }
        return new SqlExecutor(CreateUtils.createTable(DbType.MYSQL, sqlModels, "tableNameNoAuto", "测试表1111"), ModeType.EXCEL);
    }


    @Test
    public void getCreateTableSql() {
        SqlExecutor sqlManager = getSqlmanager();
        long l = System.currentTimeMillis();
        MybatisSqlProvider mybatisSqlProvider = new MybatisSqlProvider();

        ArrayList<HashMap<String, Object>> datas = new ArrayList<>();

        List<SqlModel> models = sqlManager.getTable().getModels();
        for (int i = 0; i < 10; i++) {
            HashMap<String, Object> map = new HashMap<>();
            for (SqlModel model : models) {
                if (model.getPrimaryKey().isPrimaryKey()) {
                    continue;
                }
                if (model.getType().getValue() == MysqlColumn.TIMESTAMP.getValue()) {
                    map.put(model.getColumn(), new Date());
                    continue;
                }
                map.put(model.getColumn(), i + 1);
            }
            datas.add(map);
        }
        List<String> sqls = new ArrayList<>();
        datas.forEach(map -> sqls.add(mybatisSqlProvider.getInsertStatement(sqlManager.getTable(), map)));
        sqls.forEach(sql -> System.out.println(sql + ";"));
    }

    @Test
    public void executeSql() {
    }


    /**
     *
     */
    @Test
    public void getCreateSql() {
        long l = System.currentTimeMillis();
        SqlExecutor sqlManager = getSqlmanager();
        String createTableSql = sqlManager.buildCreateTableSql();
        System.out.println(createTableSql);
        System.out.println(System.currentTimeMillis() - l);
    }


    @Test
    public void getCommentSql() {
        long l = System.currentTimeMillis();
        SqlExecutor sqlManager = getSqlmanager();
        String createTableSql = sqlManager.getCommentSql();
        System.out.println(createTableSql);
        System.out.println(System.currentTimeMillis() - l);
    }

    @Test
    public void getCreateTableAndCommentSql() {
        long l = System.currentTimeMillis();
        String createTableSql = getSqlmanager().getCreateTableAndCommentSql();
        System.out.println(createTableSql);
        System.out.println(System.currentTimeMillis() - l);
    }

}
