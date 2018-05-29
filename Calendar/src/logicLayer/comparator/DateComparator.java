package logicLayer.comparator;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

public class DateComparator implements Comparator<Date>{
	
	public static final DateComparator INSTANCE = new DateComparator();

	@Override
	public int compare(Date d1, Date d2) {
		if(d1 == d2) {
			return 0;
		}

		Calendar cal = Calendar.getInstance();
		cal.setTime(d1);
		int year1 = cal.get(Calendar.YEAR);
		int month1 = cal.get(Calendar.MONTH);
		int day1 = cal.get(Calendar.DAY_OF_MONTH);
		
		cal.setTime(d2);
		int year2 = cal.get(Calendar.YEAR);
		int month2 = cal.get(Calendar.MONTH);
		int day2 = cal.get(Calendar.DAY_OF_MONTH);
		
		int yearRet = compareDateComponent(year1, year2);
		if(yearRet == 0) {
			int monthRet = compareDateComponent(month1, month2);
			if(monthRet == 0) {
				return  compareDateComponent(day1, day2);
			}else {
				return monthRet;
			}
		}else {
			return yearRet;
		}		
	}
		  		
		public int compareDateComponent(int x1, int x2) {
			if(x1-x2 < 0) {
				return 1;
			}
			else if(x1-x2==0) {
				return 0;
			}
			else {
				return -1;
			}
	}
	
	public static boolean isDateBetween(Date start, Date actual, Date end) {
		boolean isGreaterOrEqualStart = INSTANCE.compare(start, actual) != -1;
		boolean isLessOrEqualEnd = INSTANCE.compare(end, actual) != 1;
		return isGreaterOrEqualStart && isLessOrEqualEnd;
	}

}
