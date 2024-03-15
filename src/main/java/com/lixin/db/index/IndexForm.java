package com.lixin.db.index;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode
@Accessors(chain = true)
public class IndexForm {
    public IndexModel indexModel;
    public String tableName;

    public IndexForm(IndexModel indexModel , String tableName) {
        this.indexModel = indexModel;
        this.tableName = tableName;
    }
}
