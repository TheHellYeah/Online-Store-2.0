<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="Корзина">
<@bootstrap.navbar/>
<div class="site-main container">
    <div class="row">
        <main class="site-content col-xs-12 col-md-12 col-sm-12" itemscope="itemscope" itemprop="mainContentOfPage">
            <div class="page-content entry-content">
                <form class="woocommerce-cart-form" action="" method="post"> //FIXME адрес для оформления заказа
                    <table class="table">
                        <thead>
                        <tr>
                            <th>Обувь</th>
                            <th>Количество</th>
                            <th>Цена</th>
                            <th>Размер</th>
                            <th>Удалить</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#if cart??>
                            <#list cart as product, count>
                                <tr>
                                    <td><a href="/product/${product.id}">${product.name}</a></td>
                                    <td><input type="number" min="1" value="${count}"></td>
                                    <td>${product.price}</td>
                                    <td></td>
                                    <td><button class="btn btn-primary" onclick="delInCart(${product.id}, this)">Удалить из корзины</button></td>
                                </tr>
                            </#list>
                        </#if>
                        </tbody>
                    </table>
                    <div class="row float-right">
                        <span>Тотал:</span>
                        <a href="/user/order/create" class="btn btn-warning ml-5 text-dark" role="button">Перейти к оформлению заказа</a>
                    </div>
                </form>
            </div>
        </main>
    </div>
</div>
</@component.skeleton>