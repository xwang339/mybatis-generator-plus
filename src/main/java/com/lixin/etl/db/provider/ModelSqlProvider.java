package com.lixin.etl.db.provider;

import com.lixin.etl.db.table.SqlModel;
import com.lixin.etl.db.table.TableSchema;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Objects;

/**
 * Description:
 * Copyright:   Copyright (c)2023
 * Company:     sci
 *
 * @author: 张李鑫
 * @version: 1.0
 * Create at:   2023-03-24 10:16:31
 * <p>
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2023-03-24     张李鑫                     1.0         1.0 Version
 */
public class ModelSqlProvider extends SqlProvider {

    @Override
    public String insertSelective(TableSchema tableSchema) {
//        Objects.requireNonNull(tableSchema, "tableSchema cannot be null");
//        List<SqlModel> models = tableSchema.getModels();
//        SQL sql = new SQL();
//        models.forEach(model -> {
//            if (!ObjectUtils.isEmpty(model.getInsertValue())) {
//            }
//        });
        return "";
    }



//    private String
}
