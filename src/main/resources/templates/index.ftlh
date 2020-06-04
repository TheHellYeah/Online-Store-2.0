<#import "components/skeleton.ftlh" as html>
<#import "components/navbar.ftlh" as bootstrap>
<#import "components/product-card.ftlh" as p>
<#import "components/side-menu.ftlh" as side>
<#import "components/slider.ftlh" as slider>

<@html.skeleton title="ShoeHub - интернет магазин обуви для всей семьи">
<@bootstrap.navbar/>

<div class="container-fluid mt-3">
    <div class="row">
        <div class="col-md-2 col-lg-2 col-sm-4 col-xs-12 float-right-style">
            <@side.menu/>
        </div>
        <div class="col-md-10 col-lg-10 col-sm-8 col-xs-12 mt-2">
            <@slider.slider/>
            <div class="container mt-3">
                <div class="row bg-dark">
                    <div class="input-group m-2 search-group">
                        <input type="text" class="form-control" placeholder="Поиск" id="search">
                        <div class="input-group-append">
                            <button class="btn btn-outline-secondary text-dark bg-warning" type="button" id="button-addon2">
                                Поиск
                            </button>
                        </div>
                        <select class="form-control ml-5">
                            <option value="">По умолчанию</option>
                            <option value="">По позрастанию цены</option>
                            <option value="">По убыванию цены</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="container mt-3 mb-5">
                <div class="card-columns">
                    <#if products??>
                    <#list products as product>
                    <@p.card product/>
                </#list>
            </#if>
        </div>
    </div>
</div>
</div>
</div>
<script src="/static/js/search.js"></script>
</@html.skeleton>