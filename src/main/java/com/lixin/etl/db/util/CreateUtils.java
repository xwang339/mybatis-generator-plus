package com.lixin.etl.db.util;


import com.lixin.etl.db.model.DbType;
import com.lixin.etl.db.model.ModeType;
import com.lixin.etl.db.provider.ModelSqlProvider;
import com.lixin.etl.db.provider.SqlProvider;
import com.lixin.etl.db.provider.TableOrFileProvider;
import com.lixin.etl.db.table.MysqlTableSchema;
import com.lixin.etl.db.table.PostgreSqlTableSchema;
import com.lixin.etl.db.table.SqlModel;
import com.lixin.etl.db.table.TableSchema;

import java.util.List;

/**
 * Description:
 * Copyright:   Copyright (c)2023
 * Company:     sci
 *
 * @author: 张李鑫
 * @version: 1.0
 * Create at:   2023-03-16 17:40:57
 * <p>
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2023-03-16     张李鑫                     1.0         1.0 Version
 */
public class CreateUtils {

    public static TableSchema createTable(DbType dbType, List<SqlModel> sqlModels, String tableName, String doc) {
        return switch (dbType) {
            case MYSQL -> new MysqlTableSchema(sqlModels, tableName,doc);
            case POSTGRESQL -> new PostgreSqlTableSchema(sqlModels, tableName,doc);
            default -> throw new RuntimeException("构造失败");
        };
    }


    public static TableSchema createTable(DbType dbType, List<SqlModel> sqlModels, String tableName) {
        return switch (dbType) {
            case MYSQL -> new MysqlTableSchema(sqlModels, tableName);
            case POSTGRESQL -> new PostgreSqlTableSchema(sqlModels, tableName);
            default -> throw new RuntimeException("构造失败");
        };
    }


    public static SqlProvider builderSqlProvider(ModeType modeType) {
        return switch (modeType) {
            case EXCEL, TABLE -> new TableOrFileProvider();
            case BEAN -> new ModelSqlProvider();
            default -> throw new RuntimeException("构造失败");
        };
    }
}
