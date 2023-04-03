package com.lixin.etl.db.provider;


import com.lixin.etl.db.model.MysqlColumn;
import com.lixin.etl.db.table.ColumnWithValue;
import com.lixin.etl.db.table.TableSchema;
import org.apache.ibatis.jdbc.SQL;

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
public interface  SqlProvider {

    public final String lineFeed = " \n";

    public final String ending = ";";
    default String getValueString(Object value, byte type) {
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
