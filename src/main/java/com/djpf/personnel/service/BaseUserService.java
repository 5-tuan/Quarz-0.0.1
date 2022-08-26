package com.djpf.personnel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.djpf.personnel.entity.BaseUser;

import java.util.List;

public interface BaseUserService extends IService<BaseUser> {
    /**
     * 新增
     *
     * @param baseUser
     * @return 结果
     */
    public void insertBaseUser(BaseUser baseUser);

    /**
     * 根据orgIndexCode查询
     *
     * @param orgIndexCode
     * @return 结果
     */
    public BaseUser queryBaseUser(String orgIndexCode);

    /**
     * 修改
     *
     * @param baseUser
     * @return 结果
     */
    public void updateBaseUser(String id, BaseUser baseUser);

    /**
     * 删除
     *
     * @param baseUser
     * @return 结果
     */
    public void deleteBaseUser(String id, BaseUser baseUser);

    /**
     * 查询所有用户
     *
     * @param
     * @return 结果
     */
    public List<BaseUser> seletcUserAll();

}
