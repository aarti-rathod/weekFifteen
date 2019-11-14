package loadproperty;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by JANVI on 10/11/2019.
 */
public class LoadProperty {

    static Properties prop;

    static FileInputStream input;

    String projectPath = System.getProperty("user.dir");

    public String getProperty(String key) {
        prop = new Properties();

        try {
            input = new FileInputStream(projectPath + "\\src\\properties\\config.properties");
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }
}
