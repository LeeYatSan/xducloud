package com.xdu.cloud.controller;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.Calendar;

@Controller
@EnableScheduling
public class Test {

    @Scheduled(cron = "0/1 * * * * ?") //每5秒执行一次
    private void autoUpdate() {
        System.out.println("自动检查更新: " + Calendar.getInstance().getTimeInMillis());
    }

}
