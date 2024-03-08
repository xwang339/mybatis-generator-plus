package com.lixin.db.model;

import lombok.Getter;

/**
 * 索引类型枚举
 */
@Getter
public enum IndexType  {
    unique("unique",(byte)1),

    normal("normal",(byte)2),
    fulltext("fulltext",(byte)3),
    spatial("spatial",(byte)0);

    private final String description;
    private final byte value;

    IndexType(String description, byte value) {
        this.description = description;
        this.value = value;
    }
}
