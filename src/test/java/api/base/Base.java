package api.base;

import java.util.ResourceBundle;

public class Base {
	
	
	public static String getUrl(String key) {
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		
		return routes.getString(key);
	}
}
