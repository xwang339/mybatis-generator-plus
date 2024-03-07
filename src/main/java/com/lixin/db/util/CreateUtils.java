package com.lixin.db.util;


import com.lixin.db.model.DbType;
import com.lixin.db.model.ModeType;
import com.lixin.db.provider.MybatisSqlProvider;
import com.lixin.db.provider.SqlProvider;
import com.lixin.db.provider.TableOrFileProvider;
import com.lixin.db.table.MysqlTableSchema;
import com.lixin.db.table.PostgreSqlTableSchema;
import com.lixin.db.table.SqlModel;
import com.lixin.db.table.TableSchema;


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
            case BEAN -> new MybatisSqlProvider();
            default -> throw new RuntimeException("构造失败");
        };
    }
}
