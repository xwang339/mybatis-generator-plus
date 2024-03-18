package com.lixin.db.util;


import com.lixin.db.model.DbType;
import com.lixin.db.model.ModeType;
import com.lixin.db.provider.DefaultSqlProvider;
import com.lixin.db.provider.SqlProvider;
import com.lixin.db.provider.TableOrFileProvider;
import com.lixin.db.table.MysqlTableSchema;
import com.lixin.db.table.PostgreSqlTableSchema;
import com.lixin.db.table.SqlModel;
import com.lixin.db.table.TableSchema;


import java.util.List;

public class CreateUtils {

    public static TableSchema createTable(DbType dbType, List<SqlModel> sqlModels, String tableName, String doc) {
        switch (dbType) {
            case MYSQL:
                return new MysqlTableSchema(sqlModels, tableName, doc);
            case POSTGRESQL:
                return new PostgreSqlTableSchema(sqlModels, tableName, doc);
            default:
                throw new RuntimeException("构造失败");
        }
    }


    public static SqlProvider builderSqlProvider(ModeType modeType) {
        switch (modeType) {
            case EXCEL:
            case TABLE:
                return new TableOrFileProvider();
            case BEAN:
                return new DefaultSqlProvider();
            default:
                throw new RuntimeException("构造失败");
        }
    }
}
