package com.lixin.db.model;

import lombok.Getter;

import java.util.HashMap;

/**
 * 索引方法
 */

@Getter
public enum IndexUnique {

    isUnique(  0),
    notUnique(1);

    private final int value;


    public static HashMap<String, IndexUnique> map;
    IndexUnique(int value) {
        this.value = value;
    }

    public static IndexUnique from(int value) {
        for (IndexUnique tmp : IndexUnique.values()) {
            if (tmp.getValue() == value) {
                return tmp;
            }
        }
        return null;
    }


}
