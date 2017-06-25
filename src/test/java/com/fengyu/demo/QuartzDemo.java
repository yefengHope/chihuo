package com.fengyu.demo;

import org.quartz.CronExpression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.ParseException;

import java.util.Date;

/**
 * 定时任务demo
 * Created by HanFeng on 2017/6/25.
 */
public class QuartzDemo {

    private static Logger logger = LoggerFactory.getLogger(QuartzDemo.class);

    public static void main(String[] args) {
        Date curTime = new Date();
        System.out.println(curTime);

        CronExpression expression;
        try
        {
            expression = new CronExpression("0 30 15 * * ?");
            Date newDate = expression.getNextValidTimeAfter(curTime);
            System.out.println(newDate);
        } catch (ParseException e) {
            logger.error("fail to parse cron express", e);
        } catch (Exception e) {
            logger.error("fail to update rule nextTime", e);
        }

    }
}
