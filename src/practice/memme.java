package practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class memme {

	public static Date date;
	
	public static String myDateFomat(Calendar c, String formatStr) {
		Date date = c.getTime();
		return new SimpleDateFormat(formatStr).format(date);
	}

	public static String[] myDiffDate() throws ParseException{
		String today = "2021/10/11";
		String future = "2021/12/25";
		
		Date formatToday = new SimpleDateFormat("yyyy/MM/dd").parse(today);
		Date formatFuture = new SimpleDateFormat("yyyy/MM/dd").parse(future);
		
		long sec = (formatFuture.getTime() - formatToday.getTime()) / 1000;
		long min = (formatFuture.getTime() - formatToday.getTime()) / 60000;
		long hor = (formatFuture.getTime() - formatToday.getTime()) / 360000;
		long day = sec / (24*60*60);
		
		String[] strArr = new String[4];
		strArr[0] = sec + "초 남음";
		strArr[1] = min + "분 남음";
		strArr[2] = hor + "시간 남음";
		strArr[3] = day + "일 남음";
		return strArr;
	}
	
	
	public static void main(String[] args) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		
		System.out.println("오늘날짜" + myDateFomat(calendar, "yyyy-MM-dd"));
		System.out.println("현재시간" + myDateFomat(calendar, "HH:mm:ss"));
		
		Calendar calendar2 = Calendar.getInstance();
		calendar2.add(Calendar.DATE, 1);
		String dateStr = myDateFomat(calendar2, "yyyy-MM-dd");
		System.out.println("내일날짜" + dateStr);
		
		System.out.println("1월" + (Calendar.JANUARY+1));
		
		String [] returnArr = myDiffDate();
		for(String st : returnArr) {
			System.out.println(st);
		}
	}
}
