package oracle.assignmnet.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	
	public static String getProperty(String key) throws IOException
	{
		FileInputStream fis = null;
	    Properties prop = null;
	    String value = null;
	      try 
	      {
	    	 
	         fis = new FileInputStream("C:\\Users\\PRABHAT\\eclipse-workspace\\oracle-assignment-2\\src\\test\\resources\\TestControl.properties");
	         prop = new Properties();
	         prop.load(fis);
	         value = (String) prop.get(key);
	      }
	      catch(FileNotFoundException fnfe) 
	      {
	         fnfe.printStackTrace();
	      } 
	      catch(IOException ioe) 
	      {
	         ioe.printStackTrace();
	      } 
	      finally 
	      {
	         fis.close();
	         return value;
	      }
	}
	
	public static void main(String[] args) {
		try
		{
		System.out.println(getProperty("browser"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
