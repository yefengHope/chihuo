package cn.xingzhiwei.upms.aop;

import cn.xingzhiwei.common.pojo.annotation.log.LoginLog;
import cn.xingzhiwei.common.pojo.annotation.log.ParamsLog;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 登录日志注解拦截
 * Created by HF on 2018/2/6.
 */
@Component
@Aspect
public class LoginLogAspect {

    @Pointcut("@annotation(cn.xingzhiwei.common.pojo.annotation.log.LoginLog)")
    public void loginPointcut() {
    }

    @Before("loginPointcut()")
    public void Before(JoinPoint joinPoint) {
        System.out.println("before"); //2
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LoginLog loginLog = method.getAnnotation(LoginLog.class);
        System.out.println("LoginLogAspect.Before:" + loginLog.name());
        System.out.println();
    }

    @Around("loginPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around1"); // 1
        Object object = joinPoint.proceed();
        System.out.println(object);
        System.out.println("around2"); // 3
        return object;
    }

    @After("loginPointcut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("after");  // 4
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        String[] paramNames = signature.getParameterNames();
        Object[] joinPointArgs = joinPoint.getArgs();
        List<JSONObject> params = new ArrayList<>();

        pas: for (int i = 0; i < parameterAnnotations.length; i++) {
            // 参数映射
            JSONObject json = new JSONObject();
            json.put(paramNames[i], joinPointArgs[i]);
            List<JSONObject> logs = new ArrayList<>();
            json.put("annotations", logs);
            params.add(json);

            for (int i1 = 0; i1 < parameterAnnotations[i].length; i1++) {
                if (ParamsLog.class.isInstance(parameterAnnotations[i][i1])) {
                    ParamsLog annotation = (ParamsLog) parameterAnnotations[i][i1];
                    JSONObject anno = new JSONObject();
                    anno.put("name",annotation.name());
                    anno.put("type",annotation.type());
                    logs.add(anno);
                }
            }
        }

        System.out.println(JSON.toJSONString(params));
        LoginLog loginLog = method.getAnnotation(LoginLog.class);
        System.out.println("LoginLogAspect.after:" + loginLog.name());
    }

}
