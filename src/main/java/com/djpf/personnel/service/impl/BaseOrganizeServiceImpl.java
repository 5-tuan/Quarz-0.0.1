package com.djpf.personnel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.djpf.personnel.entity.BaseOrganize;
import com.djpf.personnel.mapper.BaseOrganizeMapper;
import com.djpf.personnel.service.BaseOrganizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseOrganizeServiceImpl extends ServiceImpl<BaseOrganizeMapper, BaseOrganize> implements BaseOrganizeService {

    @Autowired
    private BaseOrganizeMapper baseOrganizeMapper;

    @Override
    public void insertBaseOrganize(BaseOrganize baseOrganize) {
        this.save(baseOrganize);
    }

    @Override
    public BaseOrganize queryBaseOrganize(String orgIndexCode) {
        QueryWrapper<BaseOrganize> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(BaseOrganize::getFOrgIndexCode, orgIndexCode);
        return this.getOne(queryWrapper);
    }

    @Override
    public void updateBaseOrganize(String id, BaseOrganize baseOrganize) {
        baseOrganize.setFId(id);
        this.updateById(baseOrganize);
    }

    @Override
    public void deleteBaseOrganize(String id, BaseOrganize baseOrganize) {
        baseOrganize.setFId(id);
        baseOrganize.setFDeletemark(Long.valueOf(1));
        this.updateById(baseOrganize);
    }

    @Override
    public List<BaseOrganize> seletcOrganizeAll() {
        return baseOrganizeMapper.seletcOrganizeAll();
    }

    @Override
    public int selectOrganizeBySortCode(String fParentid) {
        return baseOrganizeMapper.selectOrganizeBySortCode(fParentid);
    }

    @Override
    public int selectRootBySortCode() {
        return baseOrganizeMapper.selectRootBySortCode();
    }
}
