package util;


	import java.text.SimpleDateFormat;
	import java.util.Date;
	 
	public class DateTime {
		long diff;
		public long getDifference(String StartTime, String endTime){
	 
		
	 
			//HH converts hour in 24 hours format (0-23), day calculation
			SimpleDateFormat format = new SimpleDateFormat("yyyy/dd/MM HH:mm:ss");
	 
			Date d1 = null;
			Date d2 = null;
	 
			try {
				d1 = format.parse(StartTime);
				d2 = format.parse(endTime);
	 
				//in milliseconds
				 diff = d2.getTime() - d1.getTime();
	 
	 
			} catch (Exception e) {
				e.printStackTrace();
			}
	 return diff/1000;
		}
		
	 
	}


