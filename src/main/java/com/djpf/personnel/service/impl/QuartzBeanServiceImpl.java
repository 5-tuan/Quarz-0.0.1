package com.djpf.personnel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.djpf.personnel.entity.QuartzBean;
import com.djpf.personnel.mapper.QuartzBeanMapper;
import com.djpf.personnel.service.QuartzBeanService;
import org.springframework.stereotype.Service;

@Service
public class QuartzBeanServiceImpl extends ServiceImpl<QuartzBeanMapper, QuartzBean> implements QuartzBeanService {
    @Override
    public QuartzBean queryQuartzBean(Integer id) {
        QueryWrapper<QuartzBean> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(QuartzBean::getId, id);
        return this.getOne(queryWrapper);
    }
}
