package org.legopiraat.util;

import org.legopiraat.service.DailyResources;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.CronScheduleBuilder.*;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class OLoggerStartup {

    private JobDetail dailyHistoryCalcJob;
    private CronTrigger dailyHistoryCalcTrigger;

    @PostConstruct
    private void scheduleJob() {
        createJob();
        createTrigger();

        try {
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.scheduleJob(dailyHistoryCalcJob, dailyHistoryCalcTrigger);

            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    private void createTrigger() {
        dailyHistoryCalcTrigger = TriggerBuilder.newTrigger().withIdentity("dailyResourceCalculation", "group1")
                .withSchedule(dailyAtHourAndMinute(12, 01))
                .build();
    }

    private void createJob() {
        dailyHistoryCalcJob = JobBuilder.newJob(DailyResources.class)
                .withIdentity("dailyResourceCalculation", "group1")
                .build();
    }
}
