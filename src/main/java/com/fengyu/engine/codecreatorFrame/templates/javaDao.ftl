package ${config.packagePath}

public interface ${config.className} {

    <#list data.fieldMaps as fieldMap>
        /**
         * ${fieldMap.comment}
         *
         */
    </#list>

}