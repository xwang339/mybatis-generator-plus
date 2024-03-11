package mybatisGenerator;

import com.lixin.db.model.DbType;
import org.junit.jupiter.api.Test;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.reverseGenerator.ReverseGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ReverseGeneratorTest {

    @Test
    public void testGenerateMyBatis3WithInvalidConfig() throws Exception {
        List<String> warnings = new ArrayList<String>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(this.getClass().getClassLoader().getResourceAsStream("generatorConfig.xml"));

        try {
            String filePath="/Users/user/Documents/GitHub/mybatis-generator-plus/";
            String fileName="db.sql";
            ReverseGenerator myBatisGenerator = new ReverseGenerator(config);
            List<String> reverse = myBatisGenerator.reverse(true,
                    DbType.MYSQL,
                    false,
                    filePath,fileName);
            reverse.forEach(System.out::println);
            if (!warnings.isEmpty()) {
                for (String warning : warnings) {
                    System.out.println(warning);
                }
            }
        } catch (InvalidConfigurationException e) {
            assertEquals(2, e.getErrors().size());
            throw e;
        }
    }


}
