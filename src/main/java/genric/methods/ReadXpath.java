package genric.methods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadXpath {
	
	public static String xpathReader(String element) throws IOException {
		Properties properties=new Properties();
		FileInputStream fis=new FileInputStream("./config/WebXpathRepositry.properties");
		properties.load(fis);
		String xpath=properties.getProperty(element);
		return xpath;
	}

}
