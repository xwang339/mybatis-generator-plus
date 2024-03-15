package com.lixin.db.index;

import lombok.Getter;

import java.util.HashMap;

/**
 * 索引类型枚举
 * //show  index from tables;
 * 根据这个sql语句来总结的
 *
 */
@Getter
public enum IndexType {

    UNIQUE("UNIQUE", (byte) 3),
    NORMAL("NORMAL", (byte) 1),
    NULL("null", (byte) 0),
    fulltext("FULLTEXT", (byte) 4),
    spatial("SPATIAL", (byte) 5);


    private final String description;
    private final byte value;

    public static HashMap<String, IndexType> map;

    public static IndexType getIndexType(String description) {
        return toMaps().get(description);
    }

    public static HashMap<String, IndexType> toMaps() {
        if (map == null) {
            map = new HashMap<>();
            for (IndexType indexType : IndexType.values()) {
                map.put(indexType.getDescription(), indexType);
            }
        }
        return map;
    }


    IndexType(String description, byte value) {
        this.description = description;
        this.value = value;
    }
}
