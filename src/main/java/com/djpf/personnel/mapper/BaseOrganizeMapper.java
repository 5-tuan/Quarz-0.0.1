package com.djpf.personnel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.djpf.personnel.entity.BaseOrganize;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BaseOrganizeMapper extends BaseMapper<BaseOrganize> {

    List<BaseOrganize> seletcOrganizeAll();

    int selectOrganizeBySortCode(String fParentid);

    int selectRootBySortCode();
}
