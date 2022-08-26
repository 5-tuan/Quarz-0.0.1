package com.djpf.personnel.utils;

import lombok.extern.java.Log;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Log
public class DoGetOne {
    public void doGetTestOne() {
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 创建请求
        HttpPost httpPost = new HttpPost("http://localhost:12330/SetOrganize");
        HttpPost httpPost1 = new HttpPost("http://localhost:12330/SetUser");

        // 响应模型
        CloseableHttpResponse response = null;
        CloseableHttpResponse response1 = null;
        try {
            // 由客户端执行(发送)Get请求
            response = httpClient.execute(httpPost);
            response1 = httpClient.execute(httpPost1);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            HttpEntity responseEntity1 = response1.getEntity();
            log.info("######################################");
            log.info("## " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            log.info("## SetOrganize()响应状态:" + response.getStatusLine());
            log.info("## SetUser()响应状态:" + response.getStatusLine());
            if (responseEntity != null) {
                log.info("## SetOrganize()响应内容:" + EntityUtils.toString(responseEntity));
                log.info("## SetUser()响应内容:" + EntityUtils.toString(responseEntity1));
                log.info("######################################");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
                if (response1 != null) {
                    response1.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
