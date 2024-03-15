package com.lixin.db.index;

import lombok.Getter;

import java.util.HashMap;

/**
 * Description:
 * Copyright:   Copyright (c)2024
 * Company:     sci
 *
 * @author: 张李鑫
 * @version: 1.0
 * Create at:   2024-03-12 14:22:48
 * <p>
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2024-03-12     张李鑫                     1.0         1.0 Version
 */
@Getter
public enum IndexMethod {


    BTREE("BTREE", (byte) 1),
    NULL("null", (byte) 0),
    HASH("HASH", (byte) 2);


    private final String description;
    private final byte value;

    public static HashMap<String, IndexMethod> map;
    IndexMethod(String description, byte value) {
        this.description = description;
        this.value = value;
    }
    public static IndexMethod getIndexMethod(String description) {
        return toMaps().get(description);
    }
    public static HashMap<String, IndexMethod> toMaps() {
        if (map == null) {
            map = new HashMap<>();
            for (IndexMethod indexMethod : IndexMethod.values()) {
                map.put(indexMethod.getDescription(), indexMethod);
            }
        }
        return map;
    }
}
