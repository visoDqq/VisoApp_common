package com.wz.VisoApp.common.aop;

import com.wz.VisoApp.common.beans.ResultBean;
import com.wz.VisoApp.common.exception.CheckException;
import com.wz.VisoApp.common.util.UserUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by chenwuxiong on 2017/12/1.
 */
public class ControllerAop {

    private final Logger logger = LoggerFactory.getLogger(ControllerAop.class);

    public ResultBean<?> handlerControllerMethod(ProceedingJoinPoint pjp){
        ResultBean<?> resultBean = null;
        try {
            System.out.println("==begin==");
            resultBean = (ResultBean<?>) pjp.proceed();
        } catch (Throwable e) {
            resultBean = handlerMethodException(pjp,e);
        }finally {
            //remove threadlocal
            UserUtil.clearUserInfo();
        }
        System.out.println("==end==");
        System.out.println("UserUtil="+UserUtil.getUserId());
        return resultBean;
    }

    private ResultBean<?> handlerMethodException(ProceedingJoinPoint pjp, Throwable e){
        ResultBean<?> resultBean = new ResultBean<>();
        if (e instanceof CheckException){
            resultBean.setMessage(e.getLocalizedMessage());
            resultBean.setCode(ResultBean.FAIL);
            resultBean.setSuccess(ResultBean.FALSE);
        }else{
            logger.error(pjp.getSignature() + ",error:", e);
            resultBean.setMessage(ResultBean.ERROR_MSG);
            resultBean.setCode(ResultBean.FAIL);
            resultBean.setSuccess(ResultBean.FALSE);
            //todo 邮件通知
        }
        return resultBean;
    }
}
