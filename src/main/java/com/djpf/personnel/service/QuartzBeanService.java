package com.djpf.personnel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.djpf.personnel.entity.QuartzBean;

public interface QuartzBeanService extends IService<QuartzBean> {

    QuartzBean queryQuartzBean(Integer id);
}
