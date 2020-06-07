<#macro ratingmini mark>
<div class="rating-mini">
    <#list 1..5 as x>
        <#if mark-x gte 0>
            <span class="active"></span>
        <#else>
            <span></span>
        </#if>

    </#list>
</div>


<style>
.rating-mini {
    display: inline-block;
    font-size: 0;
}
.rating-mini span {
    padding: 0;
    font-size: 20px;
    line-height: 1;
    color: lightgrey;
}
.rating-mini > span:before {
    content: '★';
}
.rating-mini > span.active {
    color: gold;
}
</style>

</#macro>