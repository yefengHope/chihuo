package com.fengyu.system.util.remote;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sun.org.apache.xerces.internal.parsers.XMLParser;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.StringWriter;
import java.util.Map;

/**
 * <p>@Title 解析流XML文件 </p>
 * <p>@Description 解析流XML文件</p>
 * <p>@author hanfeng</p>
 * <p>@date 2016/12/8 19:16 创建日期</p>
 */
public class ParseStreamXML {
    Resource rs = new FileSystemResource("D:/software/tomcat/webapps/springWebDemo/WEB-INF/classes/beanConfig.xml");
    BeanFactory factory = new XmlBeanFactory(rs);

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static XmlMapper xmlMapper = new XmlMapper();

    /**
     * xml string convert to json string
     */
    public static String xml2json(String xml)throws Exception{
        StringWriter w = new StringWriter();
        JsonParser jp = xmlMapper.getFactory().createParser(xml);
        JsonGenerator jg = objectMapper.getFactory().createGenerator(w);
        while (jp.nextToken() != null) {
            jg.copyCurrentEvent(jp);
        }
        jp.close();
        jg.close();
        return w.toString();
    }
    // public static String test() {
    //     String resdata = "";
    //     Map map = XMLParser.getMapFromXML(resdata);
    // }
}
