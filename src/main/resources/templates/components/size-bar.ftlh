<#macro bar hashmap>
<h3>Таблица размеров:</h3>
<div class="row item-size mb-3 ml-1 btn-group-toggle" data-toggle="buttons">
    <#list hashmap as size,count>
        <#if count gt 0>
            <label class="btn btn-warning  m-1">
                <input type="radio" name="size" value="${size.name()}" autocomplete="off"> ${size}
            </label>
        <#else>
            <label class="btn btn-secondary  m-1">
                <input type="radio" name="size" value=${size.name()} autocomplete="off" disabled> ${size}
            </label>
        </#if>
    </#list>
</div>
</#macro>