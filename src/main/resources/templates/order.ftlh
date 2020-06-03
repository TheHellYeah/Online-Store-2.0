<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>
<#import "components/product-order-card.ftlh" as p>

<@component.skeleton title="заказ ...">
<@bootstrap.navbar/>

<div class="container col-8 border">

    <label>Заказ пользователя ${order.user.username}</label>
    <div class="border text-white">
        ФИО получателя:
        <label>${order.contact}</label><br>
        Телефон получателя:
        <label>${order.phone}</label><br>
        Адрес получателя:
        <label>${order.address}</label><br>
        Товары:<br>
        <#list order.products as product,count>
            <label><img src=""><a class="text=warning" href="/product/${product.id}">${product.name}</a> - count</label>
        </#list>
        <br>
        Стоимость заказа:
        <label>${order.total}</label><br>
        Оплата:
        <label>Наличными курьеру</label>

    </div>



    <div class="row">
        <div><#if order.orderStatus == "PENDING" >
            <button class="btn-warning" onclick="orderIsDone(${order.id})">Заказ доставлен!</button>
            <#else>
            <button class="btn-warning" disabled>Заказ завершен.</button>
            </#if>
            <a class="text-warning" href="/seller/orders">Назад</a>
        </div>
    </div>

</div>


<script src="/static/js/seller.js"></script>
</@component.skeleton>