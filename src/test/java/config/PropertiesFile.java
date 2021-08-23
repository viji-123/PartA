package config;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {

    WebDriver driver;

    public PropertiesFile(WebDriver pdriver){
        this.driver = pdriver;
    }
    public Properties readPropertiesFile(){
        Properties prop = new Properties();
        try {
            InputStream input = new FileInputStream("src/test/java/config/config.properties");
            prop.load(input);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }
}
