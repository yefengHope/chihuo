package ${config.packagePath}

import java.lang.*
import java.math.*

import com.fengyu.system.base.BaseModel

/**
 * ${config.comment}
 * @author hanfeng
 * @date ${.now}
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

