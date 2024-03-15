package com.lixin.db.index;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode
@Accessors(chain = true)
public class IndexForm {
    public IndexModel indexModel;
    public IndexType indexType;
    public IndexMethod indexMethod;
    public String tableName;

    public IndexForm(IndexModel indexModel, IndexType indexType, IndexMethod indexMethod, String tableName) {
        this.indexModel = indexModel;
        this.indexType = indexType;
        this.indexMethod = indexMethod;
        this.tableName = tableName;
    }
}
