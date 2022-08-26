package com.djpf.personnel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.djpf.personnel.entity.BaseUser;
import com.djpf.personnel.mapper.BaseUserMapper;
import com.djpf.personnel.service.BaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseUserServiceImpl extends ServiceImpl<BaseUserMapper, BaseUser> implements BaseUserService {

    @Autowired
    private BaseUserMapper baseUserMapper;

    @Override
    public void insertBaseUser(BaseUser baseUser) {
        this.save(baseUser);
    }

    @Override
    public BaseUser queryBaseUser(String personId) {
        QueryWrapper<BaseUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(BaseUser::getPersonId, personId);
        return this.getOne(queryWrapper);
    }

    @Override
    public void updateBaseUser(String id, BaseUser baseUser) {
        baseUser.setFId(id);
        this.updateById(baseUser);
    }

    @Override
    public void deleteBaseUser(String id, BaseUser baseUser) {
        baseUser.setFId(id);
        baseUser.setFDeletemark(Long.valueOf(1));
        this.updateById(baseUser);
    }

    @Override
    public List<BaseUser> seletcUserAll() {
        return baseUserMapper.seletcUserAll();
    }
}
