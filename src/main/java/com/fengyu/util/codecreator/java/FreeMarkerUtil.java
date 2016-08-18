package com.fengyu.util.codecreator.java;

import com.fengyu.area_json.java.Area;
import com.fengyu.area_json.java.AreaJson;
import com.fengyu.util.codecreator.constants.Constants;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * FreeMarker代码生成器
 *          -- 工具类
 * Created by 韩峰 on 2016/8/12.
 */
public class FreeMarkerUtil {

    private Configuration cfg;

    public void init() throws Exception {

        //-------------- 初始化FreeMarker配置-------------

        // 创建一个Configuration实例
        cfg = new Configuration();

        // 设置FreeMarker的模版文件位置
        cfg.setDirectoryForTemplateLoading(new File(
                "F://workSpace//GitWork//chihuo//src//main//java//com//fengyu//util//codecreator//templates"));
    }

    public void process(FreeMarkerUtil hf) throws Exception {

        /**
         * 模板中需要的配置项map
         */
        Map root = new HashMap();

        String Module = "";
        String model_name = "User";             //生成类名
        String model_name_list = "Users";       //多个生成类名
        String instant = "user";                //实例名, 如:参数名会小写
        String model_name_cn = "用户";         //生成类的中文名
        String author = "张何兵";              //作者
        String link = "<a href=http://www.media999.com.cn>北京华亚美科技有限公司</a>";// 模块开发公司网地址
        Date date = new Date();

        root.put("module", Module);
        root.put("model_name", model_name);
        root.put("model_name_list", model_name_list);
        root.put("instant", instant);
        root.put("model_name_cn", model_name_cn);
        root.put("author", author);
        root.put("link", link);
        root.put("date", date);

        //项目路径
         String projectPath = "F://workSpace//GitWork//chihuo//src//main//java//com//fengyu//util//codecreator//testrusult//";
        //创建模板 1
        String fileName = "I" + model_name + "DAO.java";
        String savePath = "src//com//media//dao//";
        Template template = cfg.getTemplate("IDAO.ftl");
        hf.buildTemplate(root, projectPath, savePath, fileName, template);

       /*
        //创建模板 2
        fileName = model_name + "DAOHibernate.java";
        savePath = "src//com//media//dao//hibernate//";
        template = cfg.getTemplate("DAOHibernate.ftl");
        hf.buildTemplate(root, projectPath, savePath, fileName, template);

        */

    }

    /**
     * <h2>生成模板</h2>
     * @param root              模板中需要的配置项
     * @param projectPath       项目路径
     * @param savePath          模板生成文件保存路径
     * @param fileName          模板生成的文件名
     * @param template          模板
     */
    public void buildTemplate(Map root, String projectPath, String savePath,
                              String fileName, Template template) {
        //真实文件名
        String realFileName = projectPath + savePath + fileName;

        //真实保存地址
        String realSavePath = projectPath + "/" + savePath;

        File newsDir = new File(realSavePath);
        if (!newsDir.exists()) {
            newsDir.mkdirs();
        }

        //------------------------ 输出文件 UTF-8 -----------------------------
        try {
            // SYSTEM_ENCODING = "UTF-8";
            Writer out = new OutputStreamWriter(new FileOutputStream(
                    realFileName), Constants.SYSTEM_ENCODING);
            template.process(root, out);
        } catch (Exception e) {
            e.printStackTrace();
        }

        File f = new File(this.getClass().getResource("").getPath());
        System.out.println("获取当前路径:" + f);

    }

    //        for (Area area : areaList) {
//            Map<String, Object> map = new HashMap<>();
//            map.put("tid",area.getTid());
//            map.put("tpid",area.getTpid());
//            map.put("tname",area.getTname());
//            map.put("ttext",area.getTtext());
//            map.put("ttype",area.getTtype());
//            map.put("tpx",area.getTpx());
//            map.put("tdate",area.getTdate());
//            map.put("tlvie",area.getTlvie());
//        }

    /**
     * main生成模板
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //----------测试生成模板 start---------
        FreeMarkerUtil hf = new FreeMarkerUtil();
        hf.init();
//      hf.process(hf);
        //----------- 测试生成模板 end --------

        /**
         * http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/
         * 上获取的行政区划代码转换成sql语句
         *
         * 首先生成Tree,再使用FreeMarker转换成sql
         * start
         */
        List<Area> areaList = AreaJson.createAreaList();
        Map<String, Object> mapList = new HashMap<>();
        mapList.put("areas",areaList);
        hf.processArea(mapList, hf);
        // --/*结束*/--

    }

    public void processArea(Map map, FreeMarkerUtil freeMarkerUtil) throws Exception {
        String projectPath = "F://workSpace//GitWork//chihuo//src//main//java//com//fengyu//util//codecreator//testrusult//";
        String fileName = "areasql.txt";
        String savePath = "area";
        Template template = freeMarkerUtil.cfg.getTemplate("AreaSql.ftl");
        buildTemplate(map, projectPath, savePath, fileName, template);
    }


}
