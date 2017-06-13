<#--传输数据说明 :
 ${config.*} 为配置信息
 ${data.*}为数据库读取信息
 data.fields 为数据区读取字段
 config.packagePath 配置路径
 config.className   配置类名

 字段接收说明 :
 data.fieldModels {List<Map>} 字段集合List
 fildModels.comment 字段注释
 fildModels.type 字段的java类型
 fildModels.name 字段的java名称 小驼峰
 fildModels.Name 字段的java名称 大驼峰

 -->
package ${config.packagePath}

import java.lang.*
import java.math.*

import com.fengyu.system.base.BaseModel

/**
 * ${config.comment}        <#--类注释-->
 * @author ${config.author} <#--作者-->
 * @date ${.now}            <#--获取当前时间-->
 */
public class ${config.className}Model extends BaseModel{

    <#--如果data.fields 存在,则循环写入变量-->
    <#if data.fields??>
        <#list data.fieldModels as fildModels>
            /**
             * ${fildModels.comment}
             */
            private ${fildModels.type} ${fildModels.name} ;
        </#list>
    </#if>

    <#--如果data.fields 存在,则循环写入GET/SET方法-->
    <#if data.fields??>
        <#list data.fieldModels as fildModels>
        /**
        * ${fildModels.comment}
        */
        public ${fildModels.type} get${fildModels.Name} () {
            return this.name;
        }

        /**
        * ${fildModels.comment}
        */
        public void set${fildModels.Name} (${fildModels.type} ${fildModels.name}) {
            this.${fildModels.name} = ${fildModels.name};
        }
        </#list>
    </#if>
}
