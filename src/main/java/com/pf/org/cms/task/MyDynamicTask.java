package com.pf.org.cms.task;

import com.pf.org.cms.exception.CmsException;
import com.pf.org.cms.manage.RedisManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @Auther: pf
 * @Date: 2018/3/30 19:41
 * @Description:
 */
@Component
public class MyDynamicTask implements SchedulingConfigurer {
    private static Logger log = LoggerFactory.getLogger(MyDynamicTask.class);

    @Autowired
    RedisManager redisManager;

    private static String cron;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(doTask(), getTrigger());
    }

    private Runnable doTask() {
        return new Runnable() {
            @Override
            public void run() {
                // 业务逻辑
                log.info("执行了MyDynamicTask,时间为:" + new Date(System.currentTimeMillis()));
            }
        };
    }

    private Trigger getTrigger() {
        return new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                // 触发器
                CronTrigger trigger = new CronTrigger(getCron());
                return trigger.nextExecutionTime(triggerContext);
            }
        };
    }

    public String getCron() {
        String newCron = redisManager.getStr("cms:MyDynamicTask");
        if (StringUtils.isEmpty(newCron)) {
            throw new CmsException("The config cron expression is empty");
        }
        if (!newCron.equals(cron)) {
            log.info(new StringBuffer("Cron has been changed to:'").append(newCron).append("'. Old cron was:'").append(cron).append("'").toString());
            cron = newCron;
        }
        return cron;
    }
}
