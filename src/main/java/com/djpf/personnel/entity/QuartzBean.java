package com.djpf.personnel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@TableName("test_task")
public class QuartzBean {
    /** 自然主键 */
    @TableId("id")
    private Integer id;

    /** 任务名称 */
    @TableField("job_name")
    @JsonProperty("jobName")
    private String jobName;

    /** 任务执行类 */
    @TableField("job_class")
    @JsonProperty("jobClass")
    private String jobClass;

    /** 任务运行时间表达式 */
    @TableField("cron_expression")
    @JsonProperty("cronExpression")
    private String cronExpression;

    /** 任务状态 启动还是暂停*/
    @TableField("job_status")
    @JsonProperty("jobStatus")
    private Integer jobStatus;
}
