package com.wz.VisoApp.common.util;

import org.slf4j.MDC;

/**
 * Created by chenwuxiong on 2017/12/1.
 */
public class UserUtil {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private UserUtil(){
    }

    public static String getUserId(){
        return threadLocal.get();
    }

    public static void removeThreadLocal(){
        threadLocal.remove();
    }

    public static void setUserId(String userId){
        threadLocal.set(userId);
        MDC.put("user",userId);
    }

    public static void removeMDC(String key){
        MDC.remove(key);
    }

    public static void clearUserInfo(){
        removeThreadLocal();
        removeMDC("user");
    }
}
