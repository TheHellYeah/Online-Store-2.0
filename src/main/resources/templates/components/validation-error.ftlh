<#macro validation error>
    <#if error??>
        <div class="invalid-feedback">
            ${error}
        </div>
    </#if>
</#macro>