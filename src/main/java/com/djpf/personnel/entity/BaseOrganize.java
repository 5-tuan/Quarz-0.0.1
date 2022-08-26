package com.djpf.personnel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
@TableName("base_organize")
public class BaseOrganize {

    /** 自然主键 */
    @TableId("f_id")
    private String fId;

    /** 机构上级 */
    @TableField("F_ParentId")
    @JsonProperty("fParentid")
    private String fParentid;

    /** 机构分类 */
    @TableField("F_Category")
    @JsonProperty("fCategory")
    private String fCategory;

    /** 机构编号 */
    @TableField("F_EnCode")
    @JsonProperty("fEncode")
    private String fEncode;

    /** 机构名称 */
    @TableField("F_FullName")
    @JsonProperty("fFullname")
    private String fFullname;

    /** 机构主管 */
    @TableField("F_ManagerId")
    @JsonProperty("fManagerid")
    private String fManagerid;

    /** 扩展属性 */
    @TableField("F_PropertyJson")
    @JsonProperty("fPropertyjson")
    private String fPropertyjson;

    /** 描述 */
    @TableField("F_Description")
    @JsonProperty("fDescription")
    private String fDescription;

    /** 排序 */
    @TableField("F_SortCode")
    @JsonProperty("fSortcode")
    private Long fSortcode;

    /** 有效标志 */
    @TableField("F_EnabledMark")
    @JsonProperty("fEnabledmark")
    private Long fEnabledmark;

    /** 创建时间 */
    @TableField("F_CreatorTime")
    @JsonProperty("fCreatortime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date fCreatortime;

    /** 创建用户 */
    @TableField("F_CreatorUserId")
    @JsonProperty("fCreatoruserid")
    private String fCreatoruserid;

    /** 修改时间 */
    @TableField("F_LastModifyTime")
    @JsonProperty("fLastmodifytime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date fLastmodifytime;

    /** 修改用户 */
    @TableField("F_LastModifyUserId")
    @JsonProperty("fLastmodifyuserid")
    private String fLastmodifyuserid;

    /** 删除标志 */
    @TableField("F_DeleteMark")
    @JsonProperty("fDeletemark")
    private Long fDeletemark;

    /** 删除时间 */
    @TableField("F_DeleteTime")
    @JsonProperty("fDeletetime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date fDeletetime;

    /** 删除用户 */
    @TableField("F_DeleteUserId")
    @JsonProperty("fDeleteuserid")
    private String fDeleteuserid;

    /** 同步标志 */
    @TableField("F_orgIndexCode")
    @JsonProperty("fOrgIndexCode")
    private String fOrgIndexCode;
}
