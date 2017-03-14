package com.fengyu.util.customData.area_json.java;

import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 转换类
 * Created by rain on 2016/8/16.
 */
public class Convert {

    ////  [\u4e00-\u9fa5]
    //  \d+


    /**
     * 转换成Area实体
     * @param id
     * @param name
     * @return
     */
    public static Area toAreaEntity(Long id, String name){
        Area area = new Area();
        area.setTid(id);
        area.setTname(name);
        area.setTtype(10L);
        area.setTpx(1L);
        area.setTdate(new Date());
        area.setTdept(null);
        area.setTuser(null);
        return area;
    }

    /**
     * 正则表达式匹配
     * @param areaLine
     * @param regex
     * @return
     */
    public static String math(String areaLine,String regex){
        // 生成一个Pattern,同时编译一个正则表达式
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(areaLine);
        if (!m.find()){
            return null;
        }
        return m.group();
    }

    public static Area lineMath(String str){
        Long id = Long.parseLong(math(str,"\\d+\\b"));
        String name = math(str,"\\s*[\\u4E00-\\u9FA5]+");

        if (name != null){
            name = name.trim();
        }
        if (id == null || !StringUtils.hasText(name)){
            return null;
        }
        Area area = toAreaEntity(id,name);
        return area;
    }
}
