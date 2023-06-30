package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileLibrary {
	
	
	/**
	 * This method will read the value from property file for the key given by user
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException 
	{
		FileInputStream fis = new FileInputStream(IConstantLibrary.propertyFilePath);
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
		
	}

}
