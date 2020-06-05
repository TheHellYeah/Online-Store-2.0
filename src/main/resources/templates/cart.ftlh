<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="Корзина">
<@bootstrap.navbar/>
<div class="container mt-3">
    <#if !(cart?has_content)>
        <h1>Корзина пуста...</h1>
        <h3>Добавить товар в корзину можно на странице товара</h3>
    <#else>
        <table class="table table-dark table-hover mt-3">
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
                <#list cart as product, count>
                    <tr>
                        <td><a href="/product/${product.id}">${product.name}</a></td>
                        <td><input class="cart-size-input" type="number" min="1" value="${count}"></td>
                        <td>${product.price} ₽</td>
                        <td></td>
                        <td><button class="btn btn-primary" onclick="delInCart(${product.id}, this)">Удалить из корзины</button></td>
                    </tr>
                </#list>
            </tbody>
        </table>
        <h3 class="text-white">Итого: ${total} ₽</h3>
        <#if warning??>
            <a href="/user/order/create" class="btn btn-danger text-white disabled" role="button">Недостаточно средств на счету</a>
        <#else>
            <a href="/user/order/create" class="btn btn-warning text-dark" role="button">Перейти к оформлению заказа</a>
        </#if>
    </#if>
</div>
</@component.skeleton>