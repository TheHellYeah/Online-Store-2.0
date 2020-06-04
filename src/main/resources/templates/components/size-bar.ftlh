<#macro sizes hashmap>
<div class="row item-size mb-3 ml-4  btn-group-toggle" data-toggle="buttons">
    <#list hashmap as size,count>
        <#if count gt 0>
            <label class="btn btn-warning  mr-1">
                <input type="radio" name="${size}" autocomplete="off" checked> ${size}
            </label>
                <#else>
            <label class="btn btn-secondary  m-1">
                <input type="radio" name="${size}" autocomplete="off" checked disabled> ${size}
            </label>
        </#if>
    </#list>
</div>
</#macro>