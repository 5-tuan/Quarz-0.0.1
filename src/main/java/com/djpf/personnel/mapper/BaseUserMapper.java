package com.djpf.personnel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.djpf.personnel.entity.BaseUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BaseUserMapper extends BaseMapper<BaseUser> {

    List<BaseUser> seletcUserAll();
}
