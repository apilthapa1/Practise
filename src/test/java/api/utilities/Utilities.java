package api.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Utilities {
	public static Properties loadPropertiesFile() {
		Properties properties = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"/src/test/resources/routes.properties");
		
		try {
			FileInputStream fis = new FileInputStream(propFile);
			properties.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties;
	}
}
