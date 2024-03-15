package com.lixin.db.index;


public class MysqlIndexProvider extends IndexProvider {

    private final String sqlTemplate = "ALTER TABLE %s ADD  %s INDEX %s(%s);";

    @Override
    String createUnique(IndexForm form) {
        return createSql(form);
    }

    @Override
    String createNormal(IndexForm form) {
        return createSql(form);
    }

    @Override
    String createFullText(IndexForm form) {
        return createSql(form);
    }

    @Override
    String createSpatial(IndexForm form) {
        return createSql(form);
    }
    @Override
    public String createSql(IndexForm form){
        IndexModel indexModel = form.getIndexModel();

        return String.format(
                sqlTemplate,
                form.getTableName(),
                indexModel.getIndexType().getPre(),
                indexModel.getIndexName(),
                String.join(",", indexModel.getColumns())
        );
    }
}
