package com.lixin.db.index;

/**
 * Description:
 * Copyright:   Copyright (c)2024
 * Company:     sci
 *
 * @author: 张李鑫
 * @version: 1.0
 * Create at:   2024-03-12 15:26:16
 * <p>
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2024-03-12     张李鑫                     1.0         1.0 Version
 */
public abstract class  IndexProvider {

    /**
     * 提供alter 的方式生成sql 语句
     * @return
     */
    abstract String createUnique(IndexForm form);
    abstract String createNormal(IndexForm form);
    abstract String createFullText(IndexForm form);
    abstract String createSpatial(IndexForm form);


    public abstract String createSql(IndexForm form);
}
