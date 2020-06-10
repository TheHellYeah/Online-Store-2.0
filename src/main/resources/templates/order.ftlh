<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>
<#import "components/product-order-card.ftlh" as p>

<@component.skeleton title="Страница заказа">
<@bootstrap.navbar/>

<div class="container mt-3">
    <#if missing??>
            <h1 style="color: white;">${missing}</h1>
            <h3><a href="/user/orders">К списку заказов</a></h3>
    <#else>
        <div class="container col-9 mt-3">
            <h1 style="color: white;">Заказ №${order.id} от ${order.date}</h1>
            <div class="order-details border text-white p-3">
                <label>Получатель: ${order.contact}</label><br>
                <label>Номер телефона: ${order.phone}</label><br>
                <label>Адрес доставки: ${order.address}</label><br>
                <label>Список товаров:<br>
                <#list order.products as item>
                    <img src="http://localhost:8080/img/${item.product.images[0]}" class="product-mini-thumbnail">
                    <a href="/product/${item.product.id}">${item.product.name}</a>,
                    цена: ${item.product.price} ₽, размер: ${item.size}, количество: ${item.amount}
                    <hr class="mt-0"/>
                </#list>
                </label><br>
                <label>Общая стоимость заказа: ${order.total} ₽</label><br>
                Оплата:
                <label>${order.orderPayment.toString()}</label><br>
                Статус:
                <label id="order_status">${order.orderStatus.toString()}</label>
            </div>
            <#if seller>
            <div class="mt-2">
                <button class="btn btn-warning mt-" value="IN_TRANSIT" onclick="setStatus(this.value, ${order.id})">Утвердить заказ</button>
                <button class="btn btn-warning" value="DELIVERED" onclick="setStatus(this.value, ${order.id})">Заказ доставлен</button>
            </div>
            </#if>
            <div>
                <h3><a class="text-warning" href="/seller/orders">Назад</a></h3>
            </div>
        </div>
    </#if>
</div>
<script src="/static/js/seller.js"></script>
</@component.skeleton>