package mybatisGenerator;


import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Description:
 * Copyright:   Copyright (c)2024
 * Company:
 *
 * @author: 张李鑫
 * @version: 1.0
 * Create at:   2024-03-07 13:25:42
 * <p>
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2024-03-07     张李鑫                     1.0         1.0 Version
 */
public class FileTest {


    @Test
    public void fileTest() throws IOException {
        File parent = new File("/Users/user/Documents/fileTest/image");
        //![826b2bcf57455823e10784b77fe7e82](/Users/user/Documents/fileTest/我的好大哥/地府号/826b2bcf57455823e10784b77fe7e82.png)
        File[] fileList = parent.listFiles();
        assert fileList != null;
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        String path="/Users/user/Documents/fileTest/image/md/";

        for (File file : fileList) {
            System.out.println(file.getName());
            if (file.isDirectory()) {
                File md = new File(path+ file.getName() + ".md");
                fileWriter = new FileWriter(md.getAbsoluteFile(), true);
                File[] files = file.listFiles();
                assert files != null;
                bufferedWriter = new BufferedWriter(fileWriter);
                for (File childFiles : files) {
                    if (!childFiles.getName().contains(".png")){
                        continue;
                    }
                    String chileFileName = childFiles.getName();
                    String content = "![%s](%s)";
                    bufferedWriter.write(content.formatted(chileFileName.replace(".png", ""), file.getPath() + "/" + chileFileName));
                    bufferedWriter.newLine();
                    bufferedWriter.newLine();
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
                fileWriter.close();
            }
        }
    }
}
