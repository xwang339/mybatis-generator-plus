package com.lixin.db.index;


import java.util.ArrayList;

public class MysqlIndexProvider extends IndexProvider{

    private final String sqlTemplate="ALTER TABLE $s ADD  %s INDEX $s(%s);";

    //ALTER TABLE $s ADD  %s INDEX $s(%s);
    @Override
    String createUnique(IndexForm form) {
        String.format(
                sqlTemplate,
                form.getTableName());

        return null;
    }

    @Override
    String createNormal(IndexForm form) {
        return null;
    }

    @Override
    String createFullText(IndexForm form) {
        return null;
    }

    @Override
    String createFullSpatial(IndexForm form) {
        return null;
    }

    public static void main(String[] args) {
        ArrayList<String> integers = new ArrayList<>();
        integers.add("1");
        String join = String.join(",",integers);
        System.out.println(join);

    }
}
