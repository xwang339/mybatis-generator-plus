package com.lixin.etl.db.provider;


import com.lixin.etl.db.model.MysqlColumn;
import com.lixin.etl.db.table.ColumnWithValue;
import com.lixin.etl.db.table.TableSchema;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * Copyright:   Copyright (c)2023
 * Company:     sci
 *
 * @author: 张李鑫
 * @version: 1.0
 * Create at:   2023-03-23 17:07:40
 * <p>
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2023-03-23     张李鑫                     1.0         1.0 Version
 */
public abstract class SqlProvider {

    public final String lineFeed = " \n";

    public final String ending = ";";

    abstract String insertSelective(TableSchema sqlModel);





    /**
     * 获取插入语句
     *
     * @param tableSchema 表对象
     * @param data        数据对象
     * @return
     */
    protected String getInsertStatement(TableSchema tableSchema, Map<String, Object> data) {

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO ").append(tableSchema.getTableName()).append(" (");

        StringBuilder values = new StringBuilder();
        values.append(" VALUES (");

        tableSchema.getModels().forEach(model -> {
            sql.append(model.getColumn()).append(",");
            values.append(getValueString(data.get(model.getColumn()), model.getType().getValue())).append(",");
        });

        sql.deleteCharAt(sql.length() - 1);
        values.deleteCharAt(values.length() - 1);

        sql.append(")").append(values).append(")");
        return sql.toString();
    }

    /**
     * 获取插入语句
     *
     * @param tableSchema {@link TableSchema}
     * @param list        {@link ColumnWithValue}
     * @return
     */
    protected String getInsertStatement(TableSchema tableSchema, List<ColumnWithValue> list) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO ").append(tableSchema.getTableName()).append(" (");
        StringBuilder values = new StringBuilder();
        values.append(" VALUES (");
        //循环外部设置的key 如果在表中存在 则添加到sql中
        list.stream().filter(model -> tableSchema.getModelSet().contains(model.getSqlModel().getColumn())).forEach(model -> {
            sql.append(model.getSqlModel().getColumn()).append(",");
            values.append(getValueString(model.getValue(), model.getSqlModel().getType().getValue())).append(",");
        });
        sql.deleteCharAt(sql.length() - 1);
        values.deleteCharAt(values.length() - 1);
        sql.append(")").append(values).append(")");
        return sql.toString();
    }

    protected String getValueString(Object value, byte type) {
        if (value == null) {
            return "null";
        }
        if (type == (MysqlColumn.CHAR.getValue()) || type == MysqlColumn.VARCHAR.getValue()) {
            return "'" + value + "'";
        } else if (type == MysqlColumn.DATETIME.getValue() || type == MysqlColumn.TIMESTAMP.getValue()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return "'" + dateFormat.format(value) + "'";
        } else {
            return value.toString();
        }
    }
}
