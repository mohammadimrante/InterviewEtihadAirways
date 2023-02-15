package genric.methods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadTestData {
	
	public static String propertyReader(String propertyData) throws IOException {
		Properties properties=new Properties();
		FileInputStream fis=new FileInputStream("./config/TestData.properties");
		properties.load(fis);
		String value=properties.getProperty(propertyData);
		System.out.println("Selected property is "+value);
		return value;
	}
}
