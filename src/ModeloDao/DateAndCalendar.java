/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Daniel Lucas
 */
public class DateAndCalendar {

    //Convert Date to Calendar
    public Calendar dateToCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    //Convert Calendar to Date
    public Date calendarToDate(Calendar calendar) {
        return calendar.getTime();
    }
}
