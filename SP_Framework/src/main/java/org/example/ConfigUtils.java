package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ConfigUtils {
    static public Properties getProps(String filename) {
        Properties myProps = new Properties();
        try {
            File propFile = new File("src/test/resources/" + filename + ".properties");
            if (propFile.exists())
                myProps.load(new FileInputStream(propFile));
            else
                System.out.println("File not found" + filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myProps;
    }
}
