<#macro pagination products>
<#assign
    totalPages = products.getTotalPages()
    current = products.getNumber() + 1
>
<nav class="float-right mb-3">
    <ul class="pagination">
         <li class="page-item disabled"><a class="page-link" href="#"><@spring.message code="pages"/></a></li>
    <#if (current - 1) gt 1>
        <li class="page-item" onclick="page(1)"><a class="page-link" style="z-index:1;" href="#">1</a></li>
        <li class="page-item"><a class="page-link" href="">...</a></li>
    </#if>
    <#list (current - 1)..(current + 1) as page>
        <#if page lt 1 || page gt totalPages>
            <#continue>
        </#if>
        <#if (page - 1) == products.getNumber()>
            <li class="page-item active"><a class="page-link">${page}</a></li>
        <#else>
            <li class="page-item" onclick="page(${page - 1})"><a class="page-link" style="z-index:1;" >${page}</a></li>
        </#if>
     </#list>
    <#if (current + 1) lt totalPages>
        <li class="page-item"><a class="page-link" style="z-index:1;" href="#">...</a></li>
        <li class="page-item" onclick="page(${totalPages - 1})"><a class="page-link" >${totalPages}</a></li>
    </#if>
    </ul>
</nav>
</#macro>