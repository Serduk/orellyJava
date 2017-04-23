package edu.mainRun;


import java.util.Calendar;

/**
 * Class work for Calendar. Work with Calendar methods
 * Created by serdyuk on 4/23/17.
 */
public class CalendarWokExample {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
//        Set date 7 january 2004. 15 hours 40 minutes
        calendar.set(2004, 0, 7, 15, 40);

//        convert day to milliseconds
        long day1 = calendar.getTimeInMillis();
//        convert date to hours from milliseconds
        day1 += 1000 * 60 * 60;


        calendar.setTimeInMillis(day1);
        System.out.println("New Hour = " + calendar.get(Calendar.HOUR_OF_DAY));

//        add to date 35 days
        calendar.add(Calendar.DATE, 35);
        System.out.println("Add 35 days " + calendar.getTime());

//        Scroll day to for 35 days
        calendar.roll(Calendar.DATE, 35);
        System.out.println("Scroll 35 days " + calendar.getTime());

//        don't use increment. just set a date
        calendar.set(Calendar.DATE, 1);
        System.out.println("Set date to 1 " + calendar.getTime());
    }
}
