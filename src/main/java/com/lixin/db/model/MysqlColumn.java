package com.lixin.db.model;

import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description: 只做了一些常用的类型
 * Copyright:   Copyright (c)2023
 * Company:     sci
 *
 * @author: 张李鑫
 * @version: 1.0
 * Create at:   2023-03-23 15:56:26
 * <p>
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2023-03-23     张李鑫                     1.0         1.0 Version
 */
@Getter
public enum MysqlColumn {

    TEXT("text",  -1, false),
    BLOB("blob",  -4, false),
    INTEGER("int(%s)",  4, true),
    TIMESTAMP("timestamp",  93, false),
    // 从目前看到的状况来看 mybatis 这个版本不支持datetime 默认会把datetime编程timestamp
//    DATETIME("datetime", 6, false),
    CHAR("CHAR(%s)",  1, true),
    TINYINT("tinyint",  -6, false),
    BIT("tinyint(%s)",  -7, true),
    BIGINT("bigint",  -5, false),
    GEOMETRY("geometry",  -2, false),
    VARCHAR("VARCHAR(%s)",  12, true);



    private final String suffix;
    private final int value;
    private final boolean hasSuffix;

    public static final Map<Integer, MysqlColumn> enumMap = toMap();

    private MysqlColumn(String suffix, int value, boolean hasSuffix) {
        this.suffix = suffix;
        this.value = value;
        this.hasSuffix = hasSuffix;
    }

    private static Map<Integer, MysqlColumn> toMap() {
        Map<Integer, MysqlColumn> statusMap = new LinkedHashMap<Integer, MysqlColumn>();
        for (MysqlColumn tmp : MysqlColumn.values()) {
            statusMap.put(tmp.value, tmp);
        }
        return statusMap;
    }

}
