package ${config.packagePath};

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.Map;

@Service("${config.className?uncap_first}")
public class ${config.className}  <#if config.serviceClassName??> extends ${config.serviceClassName}</#if>{ <#--extends BaseMapper<${config.className}>-->

    <#assign modelName>
        <#if config.modelName??>${modelName?trim}<#else>Object</#if>
    </#assign>
    <#assign modelLowerName>
        <#if config.modelName??>${config.modelName?uncap_first}<#else>map</#if>
    </#assign>

    <#assign mapperClassName>
        <#if config.mapperClassName??>${config.mapperClassName?uncap_first}<#else>// todo \n Object</#if>
    </#assign>
    <#assign mapperClassLowerName>
        <#if config.mapperClassName??>${config.mapperClassName?uncap_first}<#else>map</#if>
    </#assign>

    @Resource
    private ${mapperClassName?trim} ${mapperClassLowerName?trim};

    /**
    * 分页查询
    * @param map 自定义参数
    */
    PageInfo<${modelName?trim}> findPageByParams(Map<String,Object> map){
        return null;
    }

    /**
    * 根据参数查询列表
    * @param map 自定义参数
    * @return {List}
    */
    List<${modelName?trim}> findListByParams(Map<String, Object> map){
        return null;
    }

    /**
    * 根据id查询
    * @param map 自定义参数
    * @return
    */
    ${modelName?trim} findById(Map<String, Object> map){
        return null;
    }

    /**
    * 根据List<Object> id集合in查询
    * @param map 自定义参数
    * @return
    */
    ${modelName?trim} findByIds(Map<String,Object> map){
        return null;
    }

    /**
    * 插入对象
    * @param ${modelLowerName?trim} 自定义参数
    * @return
    */
    ${modelName?trim} insert(${modelName?trim} ${modelLowerName?trim}){
        return null;
    }

    /**
    * 插入批量
    * @param ${modelLowerName?trim} 自定义参数
    */
    void insertBatch(List<${modelName?trim}> ${modelLowerName?trim}){
        return;
    }

    /**
    * 更新
    * @param ${modelLowerName?trim} 自定义参数
    */
    void update(${modelName?trim} ${modelLowerName?trim}){
        return;
    }

    /**
    * 更新状态 id 集合in更新
    * @param map 自定义参数
    */
    void updateStatus(Map<String,Object> map){
        return;
    }

}