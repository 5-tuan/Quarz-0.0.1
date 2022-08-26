package com.djpf.personnel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
@TableName("base_user")
public class BaseUser {

    /** 自然主键 */
    @TableId("f_id")
    private String fId;

    /** 同步索引 */
    @TableField("person_id")
    @JsonProperty("personId")
    private String personId;

    /** 账户 */
    @TableField("F_Account")
    @JsonProperty("fAccount")
    private String fAccount;

    /** 姓名 */
    @TableField("F_RealName")
    @JsonProperty("fRealname")
    private String fRealname;

    /** 快速查询 */
    @TableField("F_QuickQuery")
    @JsonProperty("fQuickquery")
    private String fQuickquery;

    /** 呢称 */
    @TableField("F_NickName")
    @JsonProperty("fNickname")
    private String fNickname;

    /** 头像 */
    @TableField("F_HeadIcon")
    @JsonProperty("fHeadicon")
    private String fHeadicon;

    /** 性别 */
    @TableField("F_Gender")
    @JsonProperty("fGender")
    private Long fGender;

    /** 生日 */
    @TableField("F_Birthday")
    @JsonProperty("fBirthday")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date fBirthday;

    /** 手机 */
    @TableField("F_MobilePhone")
    @JsonProperty("fMobilephone")
    private String fMobilephone;

    /** 电话 */
    @TableField("F_TelePhone")
    @JsonProperty("fTelephone")
    private String fTelephone;

    /** F_Landline */
    @TableField("F_Landline")
    @JsonProperty("fLandline")
    private String fLandline;

    /** 邮箱 */
    @TableField("F_Email")
    @JsonProperty("fEmail")
    private String fEmail;

    /** 民族 */
    @TableField("F_Nation")
    @JsonProperty("fNation")
    private String fNation;

    /** 籍贯 */
    @TableField("F_NativePlace")
    @JsonProperty("fNativeplace")
    private String fNativeplace;

    /** 入职日期 */
    @TableField("F_EntryDate")
    @JsonProperty("fEntrydate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date fEntrydate;

    /** 证件类型 */
    @TableField("F_CertificatesType")
    @JsonProperty("fCertificatestype")
    private String fCertificatestype;

    /** 证件号码 */
    @TableField("F_CertificatesNumber")
    @JsonProperty("fCertificatesnumber")
    private String fCertificatesnumber;

    /** 文化程度 */
    @TableField("F_Education")
    @JsonProperty("fEducation")
    private String fEducation;

    /** F_UrgentContacts */
    @TableField("F_UrgentContacts")
    @JsonProperty("fUrgentcontacts")
    private String fUrgentcontacts;

    /** 紧急电话 */
    @TableField("F_UrgentTelePhone")
    @JsonProperty("fUrgenttelephone")
    private String fUrgenttelephone;

    /** 通讯地址 */
    @TableField("F_PostalAddress")
    @JsonProperty("fPostaladdress")
    private String fPostaladdress;

    /** 自我介绍 */
    @TableField("F_Signature")
    @JsonProperty("fSignature")
    private String fSignature;

    /** 密码 */
    @TableField("F_Password")
    @JsonProperty("fPassword")
    private String fPassword;

    /** 秘钥 */
    @TableField("F_Secretkey")
    @JsonProperty("fSecretkey")
    private String fSecretkey;

    /** 首次登录时间 */
    @TableField("F_FirstLogTime")
    @JsonProperty("fFirstlogtime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date fFirstlogtime;

    /** 首次登录IP */
    @TableField("F_FirstLogIP")
    @JsonProperty("fFirstlogip")
    private String fFirstlogip;

    /** 前次登录时间 */
    @TableField("F_PrevLogTime")
    @JsonProperty("fPrevlogtime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date fPrevlogtime;

    /** 前次登录IP */
    @TableField("F_PrevLogIP")
    @JsonProperty("fPrevlogip")
    private String fPrevlogip;

    /** 最后登录时间 */
    @TableField("F_LastLogTime")
    @JsonProperty("fLastlogtime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date fLastlogtime;

    /** 最后登录IP */
    @TableField("F_LastLogIP")
    @JsonProperty("fLastlogip")
    private String fLastlogip;

    /** 登录成功次数 */
    @TableField("F_LogSuccessCount")
    @JsonProperty("fLogsuccesscount")
    private Long fLogsuccesscount;

    /** 登录错误次数 */
    @TableField("F_LogErrorCount")
    @JsonProperty("fLogerrorcount")
    private Long fLogerrorcount;

    /** 最后修改密码时间 */
    @TableField("F_ChangePasswordDate")
    @JsonProperty("fChangepassworddate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date fChangepassworddate;

    /** 系统语言 */
    @TableField("F_Language")
    @JsonProperty("fLanguage")
    private String fLanguage;

    /** 系统样式 */
    @TableField("F_Theme")
    @JsonProperty("fTheme")
    private String fTheme;

    /** 常用菜单 */
    @TableField("F_CommonMenu")
    @JsonProperty("fCommonmenu")
    private String fCommonmenu;

    /** 是否管理员 */
    @TableField("F_IsAdministrator")
    @JsonProperty("fIsadministrator")
    private int fIsadministrator;

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
    private int fSortcode;

    /** 有效标志 */
    @TableField("F_EnabledMark")
    @JsonProperty("fEnabledmark")
    private int fEnabledmark;

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

    /** 删除时间 */
    @TableField("F_DeleteTime")
    @JsonProperty("fDeletetime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date fDeletetime;

    /** 删除用户 */
    @TableField("F_DeleteUserId")
    @JsonProperty("fDeleteuserid")
    private String fDeleteuserid;

    /** 删除标志 */
    @TableField("F_DeleteMark")
    @JsonProperty("fDeletemark")
    private Long fDeletemark;

    /** 主管主键 */
    @TableField("F_ManagerId")
    @JsonProperty("fManagerid")
    private String fManagerid;

    /** 组织主键 */
    @TableField("F_OrganizeId")
    @JsonProperty("fOrganizeid")
    private String fOrganizeid;

    /** 岗位主键 */
    @TableField("F_PositionId")
    @JsonProperty("fPositionid")
    private String fPositionid;

    /** 角色主键 */
    @TableField("F_RoleId")
    @JsonProperty("fRoleid")
    private String fRoleid;

    /** $column.columnComment */
    @TableField("F_PortalId")
    @JsonProperty("fPortalid")
    private String fPortalid;

}
