package com.djpf.personnel.controller;

import com.djpf.personnel.entity.QuartzBean;
import com.djpf.personnel.service.QuartzBeanService;
import com.djpf.personnel.utils.JobUtil;
import lombok.extern.java.Log;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Log
@Controller
@RequestMapping("/quartz/")
public class QuartzBeanController {

    @Autowired
    private Scheduler scheduler;
    @Autowired
    private QuartzBeanService quartzBeanService;

    @RequestMapping("/createJob")
    @ResponseBody
    public String createJob() {
        try {
            QuartzBean quartzBean = quartzBeanService.queryQuartzBean(12334);
            log.info("创建任务定时Cron: {" + quartzBean.getCronExpression() + "}");
            JobUtil.createScheduleJob(scheduler,quartzBean);
        } catch (Exception e) {
            return "创建失败，e { " + e + " }";
        }
        return "创建成功";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update() {
        try {
            QuartzBean quartzBean = quartzBeanService.queryQuartzBean(12334);
            log.info("更新任务定时Cron: {" + quartzBean.getCronExpression() + "}");
            JobUtil.updateScheduleJob(scheduler,quartzBean);
        } catch (Exception e) {
            return "启动失败 e {" + e + "}";
        }
        return "启动成功";
    }
}
