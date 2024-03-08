package com.lixin.db.model;

import lombok.Getter;

/**
 * 索引方法
 */

@Getter
public enum IndexMethod {

    BTREE("BTREE",(byte)1),
    HASH("HASH",(byte)2);

    private final String description;
    private final byte value;

    IndexMethod(String description, byte value) {
        this.description = description;
        this.value = value;
    }
}
