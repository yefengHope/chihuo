package com.fengyu.system.controller.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Map;

/**
 * <p>@Title 类标题描述 </p>
 * <p>@Description 类功能描述（功能，作用）,描述过多时可以换行</p>
 * <p>@Version 1.0.0 版本号</p>
 * <p>@author hanfeng</p>
 * <p>@date 2017/7/13 9:33 创建日期</p>
 * <p>hanfeng@dgg.com 作者的公司邮箱</p>
 * <p>Copyright © dgg group.All Rights Reserved. 版权信息</p>
 */
// @Controller
public class GetRequestMappingController {

    // @RequestMapping(value = "getUrlMapping")
    public ModelAndView getUrlMapping(HttpServletRequest request) {
        WebApplicationContext wc = getWebApplicationContext(request.getSession().getServletContext());
        RequestMappingHandlerMapping rmhp = (RequestMappingHandlerMapping)wc.getBean("org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping#0");
        Map<RequestMappingInfo, HandlerMethod> map = rmhp.getHandlerMethods(); for (Iterator<RequestMappingInfo> iterator = map.keySet().iterator(); iterator
                .hasNext();) {
            RequestMappingInfo info = iterator.next();
            System.out.print(info.getConsumesCondition());
            System.out.print(info.getCustomCondition());
            System.out.print(info.getHeadersCondition());
            System.out.print(info.getMethodsCondition());
            System.out.print(info.getParamsCondition());
            System.out.print(info.getPatternsCondition());
            System.out.print(info.getProducesCondition());

            System.out.print("===");

            HandlerMethod method = map.get(info);
            System.out.print(method.getMethod().getName() + "--");
            System.out.print(method.getMethodAnnotation(RequestMapping.class).params()[0]);
            System.out.println();
        } return null;
    }

    public WebApplicationContext getWebApplicationContext(ServletContext sc) {
        return WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
    }
}
