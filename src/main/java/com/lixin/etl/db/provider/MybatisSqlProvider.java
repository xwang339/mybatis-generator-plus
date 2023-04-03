package com.lixin.etl.db.provider;

import com.lixin.etl.db.keyword.SqlKeyword;
import com.lixin.etl.db.table.TableSchema;

import java.util.Map;

/**
 * Description: 基于mybatis 实现的sql提供者
 * Copyright:   Copyright (c)2023
 * Company:     sci
 *
 * @author: 张李鑫
 * @version: 1.0
 * Create at:   2023-03-24 10:16:31
 * <p>
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2023-03-24     张李鑫                     1.0         1.0 Version
 */
public class MybatisSqlProvider implements SqlProvider {

    private static final String PARENTHESES_PRE = "(";
    private static final String PARENTHESES_SUFFIX = ")";
    private static final String comma = ",";

    /**
     * 获取insert语句
     *
     * @param tableSchema 表对象
     * @param data        数据对象
     * @return
     */
    public String getInsertStatement(TableSchema tableSchema, Map<String, Object> data) {
        StringBuilder sql = new StringBuilder();
        sql.append(SqlKeyword.InsertKeyword.getDescription()).append(tableSchema.getTableName()).append(PARENTHESES_PRE);

        StringBuilder values = new StringBuilder();
        values.append(SqlKeyword.VALUES.getDescription()).append(PARENTHESES_PRE);

        tableSchema.getModels().forEach(model -> {
            //如果是自增主键，且值为空，则不插入
            if (model.getPrimaryKey().isAutoIncrement()&data.get(model.getColumn())==null) {
                return;
            }
            sql.append(model.getColumn()).append(comma);
            values.append(getValueString(data.get(model.getColumn()), model.getType().getValue())).append(comma);
        });
        sql.deleteCharAt(sql.length() - 1);
        values.deleteCharAt(values.length() - 1);
        sql.append(PARENTHESES_SUFFIX).append(values).append(PARENTHESES_SUFFIX);
        return sql.toString();
    }


}
