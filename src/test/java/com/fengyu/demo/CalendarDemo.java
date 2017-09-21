package com.fengyu.demo;

import freemarker.template.SimpleDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

/**
 * Created by HanFeng on 2017/9/2.
 */
public class CalendarDemo {

    public static void main(String[] args) {

        Calendar now = Calendar.getInstance();
        System.out.println(now.get(Calendar.DAY_OF_WEEK)); // 真实值需要-1
        System.out.println(now.get(Calendar.MONTH)); // 真实值需要+1

        now.set(2017,3,2);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sf.format(now.getTime()));

        LocalDateTime todayTime = LocalDateTime.now();
        todayTime.plusSeconds(1L);

        LocalDate today = LocalDate.now();
        today.plus(1L, ChronoUnit.DAYS);
        today.plusYears(1L);
        today.minus(1L,ChronoUnit.DAYS);

        LocalDate localDate2014 = LocalDate.of(2014,1,1);
        System.out.println(localDate2014);

        LocalDate localDate201405 = LocalDate.of(2014,5,1);
        System.out.println(localDate201405.format(DateTimeFormatter.ofPattern("yyyy -- MM -- dd")));

        // 必须严格的yyyy-MM-dd形式，如2013-7-2会异常，当然可以自定义
        LocalDate localDate2013 = LocalDate.parse("2013-05-02");
        System.out.println(localDate2013);

        SimpleDateFormat sfYears = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date20130908 = sfYears.parse("2013-9-08");
            System.out.println(date20130908);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
