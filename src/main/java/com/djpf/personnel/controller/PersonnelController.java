package com.djpf.personnel.controller;

import com.alibaba.fastjson.JSON;
import com.djpf.personnel.entity.BaseOrganize;
import com.djpf.personnel.entity.BaseUser;
import com.djpf.personnel.service.BaseOrganizeService;
import com.djpf.personnel.service.BaseUserService;
import com.djpf.personnel.utils.MD5Util;
import com.djpf.personnel.utils.PinyinUtil;
import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.hikvision.artemis.sdk.config.ArtemisConfig;
import lombok.extern.java.Log;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

@Log
@Controller
public class PersonnelController {

    @Autowired
    private BaseUserService baseUserService;
    @Autowired
    private BaseOrganizeService baseOrganizeService;

    private static final String ARTEMIS_PATH = "/artemis";

    static String GetPersonJSON(){
        ArtemisConfig artemisConfig = new ArtemisConfig();
        //设置IP地址＋端口号
        artemisConfig.setHost("218.76.35.186:1443");
        //设置密钥AppKey
        artemisConfig.setAppKey("23420620");
        //设置AppSecret
        artemisConfig.setAppSecret("a7K738G8mSVcV9TdvY95");
        //设置接口地址
        String  getCamsApi = ARTEMIS_PATH + "/api/resource/v2/person/personList";
        //设置body
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("pageNo", "1");
        paramMap.put("pageSize", "1000");
        String body = JSON.toJSON(paramMap).toString();
        Map<String, String> path = new HashMap<String, String>(2) {
            {
                put("https://", getCamsApi);
            }
        };
        //设置Headers
        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, "application/json");
        return result;
    }

    static String GetOrgJSON(){
        ArtemisConfig artemisConfig = new ArtemisConfig();
        //设置IP地址＋端口号
        artemisConfig.setHost("218.76.35.186:1443");
        //设置密钥AppKey
        artemisConfig.setAppKey("23420620");
        //设置AppSecret
        artemisConfig.setAppSecret("a7K738G8mSVcV9TdvY95");
        //设置接口地址
        String  getCamsApi = ARTEMIS_PATH + "/api/resource/v1/org/orgList";
        //设置body
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("pageNo", "1");
        paramMap.put("pageSize", "1000");
        String body = JSON.toJSON(paramMap).toString();
        Map<String, String> path = new HashMap<String, String>(2) {
            {
                put("https://", getCamsApi);
            }
        };
        //设置Headers
        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, "application/json");
        return result;
    }

    @ResponseBody()
    @PostMapping("/SetUser")
    public String SetUser() {
        //解析第一层JSON
        JSONObject json = JSONObject.fromObject(GetPersonJSON());
        //解析并取出第一层JSON中的data数据
        JSONObject dataObj = json.optJSONObject("data");
        //解析并取出第二层JSON中的list数据，然后进行数据封装
        JSONArray listArray =dataObj.optJSONArray("list");
        JSONObject per = json.optJSONObject("list");
        //String转Date格式工具
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //MD5加密工具
        MD5Util md5Util = new MD5Util();
        //拼音取首字母转小写工具
        PinyinUtil pinyinUtil = new PinyinUtil();
        try {
            //遍历并取出list数据，进行存储数据
            for (int i = 0; i < listArray.size(); i++){
                JSONObject listsObj = listArray.optJSONObject(i);
                //更新人员表
                if (listsObj.containsKey("jobNo")){
                    BaseUser baseUser = baseUserService.queryBaseUser(listsObj.getString("personId"));
                    if (baseUser != null){
                        baseUser.setFAccount(listsObj.getString("jobNo"));
                        baseUser.setFRealname(listsObj.getString("personName"));
                        baseUser.setFQuickquery(pinyinUtil.getUpperStr(listsObj.getString("personName")).toLowerCase());//**
                        baseUser.setFIsadministrator(0);
                        baseUser.setFSortcode(0);
                        baseUser.setFEnabledmark(1);
                        baseUser.setFLastmodifytime(new Date());
                        baseUser.setFOrganizeid(listsObj.getString("orgIndexCode"));
                        baseUserService.updateBaseUser(baseUser.getFId(),baseUser);
                    }else if (baseUser == null){
                        baseUser = new BaseUser();
                        baseUser.setPersonId(listsObj.getString("personId"));
                        baseUser.setFAccount(listsObj.getString("jobNo"));
                        baseUser.setFRealname(listsObj.getString("personName"));
                        baseUser.setFQuickquery(pinyinUtil.getUpperStr(listsObj.getString("personName")).toLowerCase());
                        baseUser.setFRoleid("fb0ee9380aec4b80868d0a14e68fce97");
                        baseUser.setFHeadicon("/api/file/Image/userAvatar/001.png");
                        baseUser.setFGender(Long.valueOf(listsObj.getString("gender")));
                        baseUser.setFEntrydate(simpleDateFormat.parse(listsObj.getString("enterTime")));
                        UUID uuid = UUID.randomUUID();
                        baseUser.setFSecretkey(uuid.toString().toLowerCase());
                        baseUser.setFPassword(md5Util.stringToMD5(md5Util.stringToMD5("123456") + baseUser.getFSecretkey()).toLowerCase());
                        baseUser.setFIsadministrator(0);
                        baseUser.setFSortcode(0);
                        baseUser.setFEnabledmark(1);
                        baseUser.setFCreatortime(new Date());
                        baseUser.setFOrganizeid(listsObj.getString("orgIndexCode"));
                        baseUserService.insertBaseUser(baseUser);
                    }
                }
            }
            List<BaseUser> baseUserList = baseUserService.seletcUserAll();
            for (int j =0; j < baseUserList.size();j++){
                BaseUser baseUser = baseUserList.get(j);
                boolean a = listArray.stream().anyMatch(d -> ((JSONObject)d).getString("personId").equals(baseUser.getPersonId()));
                if(false == a)
                {
                    baseUserService.deleteBaseUser(baseUser.getFId(),baseUser);
                }
            }
            return "成功！";
        }catch (Exception e){
            return "错误 e{" + e + "}";
        }
    }

    @ResponseBody()
    @PostMapping("/SetOrganize")
    public String SetOrganize() {
        //解析第一层JSON
        JSONObject json = JSONObject.fromObject(GetOrgJSON());
        //解析并取出第一层JSON中的data数据
        JSONObject dataObj = json.optJSONObject("data");
        //解析并取出第二层JSON中的list数据，然后进行数据封装
        JSONArray listArray =dataObj.optJSONArray("list");
        PinyinUtil pinyinUtil = new PinyinUtil();
        try {
            //遍历并取出list数据，进行存储数据
            for (int i = 0; i < listArray.size(); i++){
                JSONObject listsObj = listArray.optJSONObject(i);
                //更新部门信息
                BaseOrganize baseOrganize = baseOrganizeService.queryBaseOrganize(listsObj.getString("orgIndexCode"));
                //更新部门信息表
                if (baseOrganize == null){
                    baseOrganize = new BaseOrganize();
                    baseOrganize.setFId(listsObj.getString("orgIndexCode"));
                    baseOrganize.setFEncode(pinyinUtil.getUpperStr(listsObj.getString("orgName")).toUpperCase());
                    baseOrganize.setFOrgIndexCode(listsObj.getString("orgIndexCode"));
                    if (listsObj.getString("orgIndexCode").equals("root000000")){
                        baseOrganize.setFSortcode(Long.valueOf(baseOrganizeService.selectRootBySortCode())+1);
                        baseOrganize.setFParentid("-1");
                        baseOrganize.setFCategory("company");
                    }else {
                        baseOrganize.setFSortcode(Long.valueOf(baseOrganizeService.selectOrganizeBySortCode(listsObj.getString("parentOrgIndexCode"))+1));
                        baseOrganize.setFParentid(listsObj.getString("parentOrgIndexCode"));
                        baseOrganize.setFCategory("department");
                    }
                    baseOrganize.setFFullname(listsObj.getString("orgName"));
                    baseOrganize.setFSortcode(Long.valueOf(i));
                    baseOrganize.setFEnabledmark(Long.valueOf(1));
                    baseOrganize.setFCreatortime(new Date());
                    baseOrganizeService.insertBaseOrganize(baseOrganize);
                }else if (baseOrganize != null){
                    baseOrganize = new BaseOrganize();
                    baseOrganize.setFEncode(pinyinUtil.getUpperStr(listsObj.getString("orgName")).toUpperCase());
                    baseOrganize.setFFullname(listsObj.getString("orgName"));
                    baseOrganize.setFParentid(listsObj.getString("parentOrgIndexCode"));
                    baseOrganize.setFLastmodifytime(new Date());
                    baseOrganizeService.updateBaseOrganize(baseOrganize.getFId(),baseOrganize);
                }
            }

            List<BaseOrganize> baseOrganizeList = baseOrganizeService.seletcOrganizeAll();
            for (int i = 0 ; i < baseOrganizeList.size(); i++){
                BaseOrganize baseOrganize = baseOrganizeList.get(i);
                boolean a = listArray.stream().anyMatch(d -> ((JSONObject)d).getString("orgIndexCode").equals(baseOrganize.getFOrgIndexCode()));
                if (false == a)
                {
                    baseOrganizeService.deleteBaseOrganize(baseOrganize.getFId(),baseOrganize);
                }
            }
            return "成功！";
        }catch (Exception e){
            return "错误 e {" + e + "}";
        }
    }

}
