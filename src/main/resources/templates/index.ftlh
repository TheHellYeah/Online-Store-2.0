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
                    <h3>Результаты поиска по запросу: ${searchQuery}</h3>
                </#if>
                <#if filters??>
                    <h3>Фильтры:
                    <#list filters as filter>
                        ${filter}<#sep> /
                    </#list>
                    <a href="/" class="ml-3 mt-2" style="font-size: 18px;">Очистить фильтр</a>
                    </h3>
                 </#if>
            </div>
            <div class="container mt-3 mb-5">
                <#if products.content?has_content>
                    <@section.product_section products.content/>
                    <nav class="float-right mb-3">
                        <ul class="pagination">
                            <li class="page-item disabled"><a class="page-link" href="#">Страницы</a></li>
                            <#list 1..products.getTotalPages() as page>
                                <#if (page - 1) == products.getNumber()>
                                    <li class="page-item active"><a class="page-link" href="#">${page}</a></li>
                                <#else>
                                    <li class="page-item"><a class="page-link" href="/?page=${page - 1}">${page}</a></li>
                                </#if>
                            </#list>
                                    <li class="page-item"><a class="page-link" href="#">Следующая</a></li>
                        </ul>
                    </nav>
                <#else>
                    <h3>К сожалению, по вашему запросу не найдено товаров</h3>
                </#if>
            </div>
        </div>
    </div>
</div>
<script src="/static/js/search.js"></script>
</@html.skeleton>