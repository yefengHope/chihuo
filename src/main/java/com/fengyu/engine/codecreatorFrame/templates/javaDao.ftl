package ${config.packagePath};

import java.util.List;
import java.util.Map;

public interface ${config.className} { <#--extends BaseMapper<${config.className}>-->


    /**
    * 根据参数查询列表
    * @param map 自定义参数
    * @return {List}
    */
    List<${config.modelName}> findListByParams(Map<String, Object> map);

    /**
    * 根据id查询
    * @param map 自定义参数
    * @return
    */
    ${config.modelName} findById(Map<String, Object> map);

    /**
    * 根据List<Object> id集合in查询
    * @param map 自定义参数
    * @return
    */
    ${config.modelName} findByIds(Map<String,Object> map);

    /**
    * 插入对象
    * @param ${config.modelLowerName} 自定义参数
    * @return
    */
    ${config.modelName} insert(${config.modelName} ${config.modelLowerName});

    /**
    * 插入批量
    * @param ${config.modelLowerName} 自定义参数
    */
    void insertBatch(List<${config.modelName}> ${config.modelLowerName});

    /**
    * 更新
    * @param ${config.modelLowerName} 自定义参数
    */
    void update(${config.modelName} ${config.modelLowerName});

    /**
    * 更新状态 id 集合in更新
    * @param map 自定义参数
    */
    void updateStatus(Map<String,Object> map);

}