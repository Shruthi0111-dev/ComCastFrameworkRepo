package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	

		public int getRandumNumber() {
			Random random = new Random();
			int ranDomNumber = random.nextInt(5000);
			return ranDomNumber;
			}
		
		public String getSystemDateYYYYMMDD() {
			Date dateObj = new Date();
			
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			 String date = sdf.format(dateObj);
			return date;
}
		public String getRequiredDateYYYYMMDD(int days)
		{
			Date obj= new Date();
			SimpleDateFormat sis = new SimpleDateFormat("yyyy-MM-dd");
			String date= sis.format(obj);
			Calendar cal = sis.getCalendar();
			cal.add(Calendar.DAY_OF_MONTH, days);
			String reqDate = sis.format(cal.getTime());
			return reqDate;
		}
}
