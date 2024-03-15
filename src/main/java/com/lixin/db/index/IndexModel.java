package com.lixin.db.index;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.mybatis.reverseGenerator.annotation.IndexGeneratorDoc;

import java.util.Arrays;
import java.util.List;

/**
 * Description: 没有把主键归类为索引 是因为主键在定义表结构的时候就会确定
 * 但是索引可能会在后续的查询中根据业务的变化而变化 所以把主键跟索引给分开了
 * Copyright:   Copyright (c)2024
 * Company:
 *
 * @author: 张李鑫
 * @version: 1.0
 * Create at:   2024-03-08 11:50:52
 * <p>
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2024-03-08     张李鑫                     1.0         1.0 Version
 */

@Data
@EqualsAndHashCode
@Accessors(chain = true)
public class IndexModel {
    private String indexName;
    private IndexType indexType;
    private IndexMethod indexMethod;
    private List<String> columns;
    private String remark;


    public IndexModel(IndexGeneratorDoc indexGeneratorDoc) {
        this.indexName = indexGeneratorDoc.keyName();
        this.indexType = indexGeneratorDoc.indexType();
        this.remark = indexGeneratorDoc.remark();

        String column = indexGeneratorDoc.column();
        column = column.substring(1, column.length() - 1);
        this.columns = Arrays.asList(column.split(","));
    }


    /**
     * @param indexName 索引名称
     * @param indexType 在mysql show  index from tables 中 把 索引类型跟索引方法都放在了一个字段里 即(bree,SPATIAL)等等所以暂时先这么处理把
     *                  index type 的值 bree hash FULLTEXT SPATIAL
     * @param unique    是否是唯一索引
     * @param columns   联合字段
     * @param remark    备注
     */
    public IndexModel(String indexName, String indexType, int unique, List<String> columns, String remark) {
        this.columns = columns;
        this.remark = remark;
        this.indexName = indexName;
        /**
         * 如果是唯一索引或者普通索引的时候 设置索引 设置索引方法 在唯一索引或者普通索引的时候只有bree 跟hash
         *
         */
        if (unique == 0 || (indexType.equals(IndexMethod.BTREE.getDescription()) || indexType.equals(IndexMethod.HASH.getDescription()))) {
            this.indexType = unique == 0 ? IndexType.UNIQUE : IndexType.NORMAL;
            this.indexMethod = IndexMethod.getIndexMethod(indexType);
            return;
        }
        this.indexType = IndexType.getIndexType(indexType);
        this.indexMethod = IndexMethod.NULL;//非普通索引 唯一索引的时候不会有索引方法
    }
}
