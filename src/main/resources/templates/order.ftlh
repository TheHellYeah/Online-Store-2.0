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
        <#list order.products as CartItem>
            <label><img src=""><a href="/product/${CartItem.product.id}">${CartItem.product.name}</a> ${CartItem.size} - x ${CartItem.amount}</label>
        </#list>
        <br>
        Стоимость заказа:
        <label>${order.total}</label><br>
        Оплата:
        <label>${order.orderPayment.toString()}</label><br>
        Статус:
        <label>${order.orderStatus.toString()}</label>

    </div>



    <div class="row">
        <div>
            <a class="text-warning" href="/seller/orders">Назад</a>
        </div>
    </div>

</div>


<script src="/static/js/seller.js"></script>
</@component.skeleton>