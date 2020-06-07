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
                    <th>Товар</th>
                    <th>Количество</th>
                    <th>Цена</th>
                    <th>Размер</th>
                    <th>Удалить</th>
                </tr>
            </thead>
            <tbody>
                <#list cart as cartItem>
                    <tr>
                        <td><a href="/product/${cartItem.getProductId()}">${cartItem.product.name}</a></td>
                        <td><input class="cart-size-input" type="number" min="1" value="${cartItem.amount}"></td>
                        <td>${cartItem.product.price} ₽</td>
                        <td>${cartItem.size.toString()}</td>
                        <td><button class="btn btn-primary" onclick="delInCart(${cartItem.id}, this)"> Удалить из корзины</button></td>
                    </tr>
                </#list>
            </tbody>
        </table>
        <h3 class="text-white">Итого: ${total} ₽</h3>
        <button type="button" class="btn btn-danger" onclick="clearCart()" id="clear-button">Очистить корзину</button>
         <a href="/user/order/checkout" class="btn btn-warning text-dark" role="button">Перейти к оформлению заказа</a>
    </#if>
</div>
</@component.skeleton>