package com.djpf.personnel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.djpf.personnel.entity.BaseOrganize;

import java.util.List;

public interface BaseOrganizeService extends IService<BaseOrganize> {
    /**
     * 新增
     *
     * @param baseOrganize
     * @return 结果
     */
    public void insertBaseOrganize(BaseOrganize baseOrganize);

    /**
     * 根据orgIndexCode查询
     *
     * @param orgIndexCode
     * @return 结果
     */
    public BaseOrganize queryBaseOrganize(String orgIndexCode);

    /**
     * 修改
     *
     * @param baseOrganize
     * @return 结果
     */
    public void updateBaseOrganize(String id, BaseOrganize baseOrganize);

    /**
     * 删除
     *
     * @param baseOrganize
     * @return 结果
     */
    public void deleteBaseOrganize(String id, BaseOrganize baseOrganize);

    /**
     * 查询所有用户
     *
     * @param
     * @return 结果
     */
    List<BaseOrganize> seletcOrganizeAll();

    /**
     * 查询排序最大值
     *
     * @param
     * @return 结果
     */
    int selectOrganizeBySortCode(String fParentid);

    /**
     * 查询root排序倒数第二值
     *
     * @param
     * @return 结果
     */
    int selectRootBySortCode();
}
