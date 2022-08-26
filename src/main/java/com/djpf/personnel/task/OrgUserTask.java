package com.djpf.personnel.task;

import com.djpf.personnel.utils.DoGetOne;
import org.quartz.*;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@DisallowConcurrentExecution
@Component
public class OrgUserTask extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        DoGetOne doGetOne = new DoGetOne();
        doGetOne.doGetTestOne();
    }
}
