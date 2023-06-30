package genericLibraries;


import java.util.Date;
import java.util.Random;

public class JavaLibrary {
	
	
	/**
	 *  This method will generate the system date as per the application calender date format
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		String[] dArr = d.toString().split(" ");
		String month = dArr[1];
		String date = dArr[2];
		String year = dArr[5];
		String time = dArr[3].replace(":", "-");
		
		String systemdate =month+" "+date+", "+year;    
		return systemdate;
				
	}
	
	
	/**
	 * This method will generate the system date with Timestamp
	 * @return
	 */
	public String getSystemDateWithTimeStamp()
	{
		Date d = new Date();
		String[] dArr = d.toString().split(" ");
		String month = dArr[1];
		String date = dArr[2];
		String year = dArr[5];
		String time = dArr[3].replace(":", "-");
		
		String systemdate = date+"-"+month+"-"+year+"-"+time;
		return systemdate;
	}

}
