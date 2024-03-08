package com.lixin.db.table;

import com.lixin.db.model.IndexMethod;
import com.lixin.db.model.IndexType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
    private List<String>columns;
    private String remark;


    public IndexModel() {
    }

    public IndexModel(String indexName, IndexType indexType, IndexMethod indexMethod, List<String> columns, String remark) {
        this.indexName = indexName;
        this.indexType = indexType;
        this.indexMethod = indexMethod;
        this.columns = columns;
        this.remark = remark;
    }
}
