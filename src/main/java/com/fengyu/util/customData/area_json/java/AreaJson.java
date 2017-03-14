package com.fengyu.util.customData.area_json.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 地区文件转json
 * Created by rain on 2016/8/16.
 */
public class AreaJson {

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static List readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        List<Area> areas = new ArrayList<>();
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                Area area = Convert.lineMath(tempString);
                areas.add(area);
                // 显示行号
//                System.out.println("line " + line + ": " + tempString);
//                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return areas;
    }

    public Map<String, Object> readAreaText(){

        return null;
    }

    /**
     * 获取省代码
     * @param id
     * @return
     */
    public static Long sheng(Long id){
        String str = id.toString();
        return Long.parseLong(str.substring(0,2));
    }

    /**
     * 获取市代码
     * @param id
     * @return
     */
    public static Long shi(Long id){
        String str = id.toString();
        return Long.parseLong(str.substring(2,4));
    }

    /**
     * 获取省市代码
     * @param id
     * @return
     */
    public static Long shshi(Long id){
        String str = id.toString();
        return Long.parseLong(str.substring(0,4));
    }


    /**
     * 获取区县代码
     * @param id
     * @return
     */
    public static Long xian(Long id){
        String str = id.toString();
        return Long.parseLong(str.substring(4));
    }

    /**
     * 获取市县代码
     * @param id
     * @return
     */
    public static Long shixi(Long id){
        String str = id.toString();
        return Long.parseLong(str.substring(2));
    }

    public static List<Area> setChilds(List<Area> areas){
        for (Area area1 : areas){
            if (area1 == null){
                continue;
            }
            List<Area> areaList = area1.getChilds();
            if (areaList == null){
                areaList = new ArrayList<>();
            }
            Long sh1 = sheng(area1.getTid());
            Long shi1 = shi(area1.getTid());
            Long xi1 = xian(area1.getTid());
            Long shshi1 = shshi(area1.getTid());
            Long shixi1 = shixi(area1.getTid());
//            System.out.println(area1.getTid()  + ":11:" +area1.getTid().longValue() );
            if (!xi1.equals(0L)){
                continue;
            }
            for (Area area2 : areas){
                if (area2 == null){
                    continue;
                }
                Long sh2 = sheng(area2.getTid());
                Long shi2 = shi(area2.getTid());
                Long xi2 = xian(area2.getTid());
                Long shshi2 = shshi(area2.getTid());
                if (sh1.equals(sh2)){
                    if (shixi1.equals(0L) && shi1<shi2 && xi1.equals(0L) && xi2.equals(0L)){
                        areaList.add(area2);
                        area1.setChilds(areaList);
                    }else if (shshi1.equals(shshi2) && xi1.equals(0L) && xi1<xi2){
                        areaList.add(area2);
                        area1.setChilds(areaList);
                    }
                }
            }
        }
        return areas;
    }

    /**
     * 设置等级划分
     * @param id    根id
     * @return
     */
    public static List<Area> setLevel(List<Area> areas,String id){
        //顶级前缀 + tid
        String prefix = "0_-1_" + Long.parseLong(id);
        for (Area area:areas){
            if (shixi(area.getTid()).equals(0L)){
                //设置省级前缀
                area.setTlvie(prefix);
                area.setTpid(Long.parseLong(id));
                //获取市级前缀
                String sprefix = prefix + "_" + area.getTid().toString();
                if(area.getChilds() == null){
                    continue;
                }
                //遍历市级
                for (Area sArea : area.getChilds()){
                    sArea.setTlvie(sprefix);
                    sArea.setTpid(area.getTid());
                    //获取县级前缀
                    String xprefix = sprefix + "_" + sArea.getTid().toString();
                    if(sArea.getChilds() == null){
                        continue;
                    }
                    for (Area xArea : sArea.getChilds()){
                        xArea.setTpid(sArea.getTid());
                        xArea.setTlvie(xprefix);
                    }
                }
            }
        }
        return areas;
    }

    public static List<Area> createAreaList(){
        String path = "F:\\workSpace\\GitWork\\chihuo\\src\\main\\java\\com\\fengyu\\area_json\\area.txt";
        List<Area> areas = readFileByLines(path);
        List<Area> areas1 =setChilds(areas);
        List<Area> areas2 = setLevel(areas1,"7453706779315408896");
        return areas2;
    }

    public static void main(String[] args) {

        System.out.println();

    }
}
