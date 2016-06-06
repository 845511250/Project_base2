package com.pro.hjy.project_base2.protocol;

import com.pro.hjy.project_base2.net.XHttpClient;

import java.net.URLEncoder;
import java.util.Map;

import rx.Observable;

/**
 * 测试接口
 */
public class TestProtocol extends BaseProtocol {


    /**
     * Get请求
     */
    public Observable<String> text_Get(String path , Map<String , Object> params) {
        return createObservable(paramsSplicling(path,params), XHttpClient.METHOD_GET, null);   // (1)
    }


    /**
     * Post请求
     */
    public Observable<String> text_Post(String path , Map<String , Object> params) {
        return createObservable(path, XHttpClient.METHOD_POST, params);
    }

    /**
     * Put请求
     */
   /* public Observable<String> text_Put(Map<String , Object> params) {
        return createObservable(BASE_URL, XHttpClient.METHOD_PUT, params);
    }*/

    /**
     * Delete请求
     */
  /*  public Observable<String> text_Delete() {
        String path = "1";
        return createObservable(BASE_URL+path, XHttpClient.METHOD_DELETE, null);
    }*/


    /**
     *get参数拼装
     * @param url
     * @param params
     * @return
     */
    public static String paramsSplicling(String url, Map<String, Object> params) {
        String param = "?";
        if (params != null) {
            for (String key : params.keySet()) {
                param += key + "=";
                Object value = params.get(key);
                param += URLEncoder.encode(value + "") + "&";
            }
            param = param.substring(0, param.length() - 1);
        }
        if (param.length() > 1) {
            url += param;
        }
        return url;
    }

}
