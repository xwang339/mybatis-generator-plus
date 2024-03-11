package org.mybatis.mybatisGenerator.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;


public class FileUtils {
    private static final Logger log = LoggerFactory.getLogger(FileUtils.class);




    public static void writeFile(File file, String content, String fileEncoding) {
        try {
            FileOutputStream fos = new FileOutputStream(file, false);
            OutputStreamWriter osw;
            osw = fileEncoding == null ? new OutputStreamWriter(fos) : new OutputStreamWriter(fos, fileEncoding);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(content);
            bw.close();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

}
