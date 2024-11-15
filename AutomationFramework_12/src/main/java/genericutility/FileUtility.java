package genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * @author prashant
 */
public class FileUtility {
	
public String getDataFromProperty(String key) throws IOException {
	/**
	 * This method is used data from property file
	 */
	FileInputStream fis=new FileInputStream("./src/test/resources/TestData/commondata.properties");
	Properties prop=new Properties();
	prop.load(fis);
	return prop.getProperty(key);
	
	
}
}
