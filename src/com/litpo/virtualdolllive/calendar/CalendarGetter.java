package com.litpo.virtualdolllive.calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public class CalendarGetter {

	public static boolean isBusy(Context context) {
		// 日历里面相应的Event的URI
		Uri uri = Uri.parse("content://com.android.calendar/events");
		// String[] column=new String[]{"_id","title"};
		Calendar curDate = Calendar.getInstance();
		long nextDay = new GregorianCalendar(curDate.get(Calendar.YEAR),
				curDate.get(Calendar.MONTH), curDate.get(Calendar.DATE) + 1, 0,
				0, 0).getTimeInMillis();
		long now = Calendar.getInstance().getTimeInMillis();
		String selection = "dtstart>" + now + " and dtstart<" + nextDay;
		System.out.println(selection);
		Cursor cur = context.getContentResolver().query(uri, null, selection,
				null, null);
		if (cur!=null && cur.moveToFirst()) {
			System.out.println(cur.getString(cur.getColumnIndex("title")));
			System.out.println(cur.getString(cur.getColumnIndex("dtstart")));
			return true;
		} else {
			return false;
		}
	}
}
