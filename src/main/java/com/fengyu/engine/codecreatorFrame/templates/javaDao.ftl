package ${config.packagePath};

import java.util.List;
import java.util.Map;

public interface ${config.className} { <#--extends BaseMapper<${config.className}>-->
    <#assign modelName>
        <#if config.modelName??>${config.modelName}<#else>Object</#if>
    </#assign>
    <#assign modelLowerName>
        <#if config.modelName??>${config.modelName?uncap_first}<#else>map</#if>
    </#assign>

    /**
    * 根据参数查询列表
    * @param map 自定义参数
    * @return {List}
    */
    List<${modelName?trim}> findListByParams(Map<String, Object> map);

    /**
    * 根据id查询
    * @param map 自定义参数
    * @return
    */
    ${modelName?trim} findById(Map<String, Object> map);

    /**
    * 根据List<Object> id集合in查询
    * @param map 自定义参数
    * @return
    */
    List<${modelName?trim}> findByIds(Map<String,Object> map);

    /**
    * 插入对象
    * @param ${modelLowerName?trim} 自定义参数
    * @return
    */
    ${modelName?trim} insert(${modelName?trim} ${modelLowerName?trim});

    /**
    * 插入批量
    * @param ${modelLowerName?trim} 自定义参数
    */
    void insertBatch(List<${modelName?trim}> ${modelLowerName?trim});

    /**
    * 更新
    * @param ${modelLowerName?trim} 自定义参数
    */
    void update(${modelName?trim} ${modelLowerName?trim});

    /**
    * 更新状态 id 集合in更新
    * @param map 自定义参数
    */
    void updateStatus(Map<String,Object> map);

}