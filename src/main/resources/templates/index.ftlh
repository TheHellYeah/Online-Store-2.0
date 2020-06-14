<#import "components/skeleton.ftlh" as html>
<#import "components/navbar.ftlh" as bootstrap>
<#import "components/side-menu.ftlh" as side>
<#import "components/slider.ftlh" as slider>
<#import "components/search.ftlh" as search>
<#import "components/product-section.ftlh" as section>

<@html.skeleton title="ShoeHub - интернет магазин обуви для всей семьи">
<@bootstrap.navbar/>

<div class="container-fluid mt-3">
    <div class="row">
        <div class="col-md-2 col-lg-2 col-sm-4 col-xs-12 float-right-style">
            <@side.menu/>
        </div>
        <div class="col-md-10 col-lg-10 col-sm-8 col-xs-12 mt-2">
            <@slider.slider/>
            <@search.form/>
            <div class="row">
                <#if searchQuery??>
                    <h3><@spring.message code="filter.search"/> ${searchQuery}</h3>
                </#if>
                <#if filters??>
                    <h3><@spring.message code="filters"/>
                    <#list filters as filter>
                        ${filter}<#sep> /
                    </#list>
                    <a href="/" class="ml-3 mt-2" style="font-size: 18px;"><@spring.message code="filter.clear"/></a>
                    </h3>
                </#if>
            </div>
            <div class="container mt-3 mb-5">
                <#if products??>
                    <@section.product_section products.content/>
                <#else>
                    <h3><@spring.message code="index.not.found"/></h3>
                </#if>
                <nav class="float-right mb-3">
                    <ul class="pagination">
                        <li class="page-item disabled"><a class="page-link" href="#"><@spring.message code="pages"/></a></li>
                        <#list 1..products.getTotalPages() as page>
                            <#if (page - 1) == products.getNumber()>
                                <li class="page-item active"><a class="page-link" href="#">${page}</a></li>
                            <#else>
                                <li class="page-item"><a class="page-link" style="z-index:1;" href="/?page=${page - 1}">${page}</a></li>
                             </#if>
                        </#list>
                         <li class="page-item"><a class="page-link" href="#"><@spring.message code="next"/></a></li>
                     </ul>
                </nav>
            </div>
        </div>
    </div>
</div>
</div>
<#include "/components/footer.ftlh">
<script src="/static/js/search.js"></script>
</@html.skeleton>