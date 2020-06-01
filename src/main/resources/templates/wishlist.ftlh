<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="Избранное">
<@bootstrap.navbar/>

<div class="site-main container">
    <div class="row">
        <main class="site-content col-xs-12 col-md-12 col-sm-12" itemscope="itemscope" itemprop="mainContentOfPage">
            <div class="page-content entry-content">

                    <table class="table">
                        <thead>
                        <tr>
                            <th>Товар</th>
                            <th>Цена</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <#if wishlist??>
                            <#list wishlist as product>
                                <tr>
                                    <td><a href="/product/${product.name}">${product.name}</a></td>
                                    <td>${product.price}</td>
                                    <td><button class="btn btn-primary" onclick="delInWishlist(${product.id},this)">Убрать из списка</button></td>
                                </tr>
                            </#list>
                        </#if>
                    </tbody>
                    </table>
                <div class="float-right">

                    <button class="btn btn-primary ml-5" onclick="clearWishlist()">Очистить весь список</button>
                </div>

            </div>
        </main>
    </div>
</div>

</@component.skeleton>