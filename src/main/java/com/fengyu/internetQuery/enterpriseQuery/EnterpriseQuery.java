package com.fengyu.internetQuery.enterpriseQuery;

/**
 * <p>@Title 类标题描述 </p>
 * <p>@Description 类功能描述（功能，作用）,描述过多时可以换行</p>
 * <p>@Version 1.0.0 版本号</p>
 * <p>@author hanfeng</p>
 * <p>@date 2017/4/27 14:30 创建日期</p>
 * <p>hanfeng@dgg.com 作者的公司邮箱</p>
 * <p>Copyright © dgg group.All Rights Reserved. 版权信息</p>
 */
public interface EnterpriseQuery {

    /**
     * 获取省份列表
     * 请求方式  get
     * @param   dtype : 返回数据格式,json或xml,默认json
     * @return
     * {
     *  ID String 系统内部id
     *  Code String 城市代码
     *  ProvinceName String 城市名称
     *  PinYin String 城市名称拼音
     *  MinSearchLen String 最少搜索关键字长度
     *  Status String 登记状态
     *  RegionId String 地区ID
     * }
     * @demo {
     *  url : http://i.yjapi.com/ECI/Provinces?key=ApiKey
     *  {
     *      "Status": "200",
     *      "Message": "查询成功",
     *      "Result": [
     *          {
     *              "ID": "10",
     *              "Code": "CN",
     *              "ProvinceName": "总局",
     *              "PinYin": "Zongju",
     *              "MinSearchLen": "2",
     *              "Status": "1",
     *              "RegionId": "9"
     *          }
     *      ]
     *  }
     * }
     */
    String queryProvinces(String dtype);


    /**
     * 获取城市代码
     * 接口地址：http://i.yjapi.com/ECI/GetCityList
     * 请求方式：GET
     * 请求示例：http://i.yjapi.com/ECI/GetCityList?key=ApiKey
     *
     * @param   dtype : 返回数据格式,json或xml,默认json
     * @return
     * {
     *      Province	    String	省份名称
     *      City	        String	城市名称
     *      ProvinceCode    String	省份代码
     *      CityCode	    String	城市代码
     * }
     */
    String queryCityList(String dtype);
}
