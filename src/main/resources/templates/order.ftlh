<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>
<#import "components/product-order-card.ftlh" as p>
<#import "spring.ftl" as spring>
<#include "components/security.ftlh">
<@component.skeleton title="Страница заказа">
<@bootstrap.navbar/>

<div class="container mt-3">
    <#if missing??>
            <h1 style="color: white;">${missing}</h1>
            <h3><a href="/user/orders"><@spring.message code="order.list"/></a></h3>
    <#else>
        <div class="container col-9 mt-3">
            <h1 style="color: white;"><@spring.message code="order"/> №${order.id}  ${order.date}</h1>
            <div class="order-details border text-white p-3">
                <label><@spring.message code="order.addressee"/>: ${order.contact}</label><br>
                <label><@spring.message code="order.phone"/>: ${order.phone}</label><br>
                <label><@spring.message code="order.address"/>: ${order.address}</label><br>
                <label><@spring.message code="order.products"/>:<br>
                <#list order.products as item>
                    <img src="http://localhost:8080/img/${item.product.images[0]}" class="product-mini-thumbnail">
                    <a href="/product/${item.product.id}">${item.product.name}</a>,
                    <@spring.message code="price"/>: ${item.product.price} ₽, <@spring.message code="size"/>: ${item.size}, <@spring.message code="count"/>: ${item.amount}
                    <hr class="mt-0"/>
                </#list>
                </label><br>
                <label><@spring.message code="order.total"/>: ${order.total} ₽</label><br>
                <@spring.message code="type.of.payment"/>:
                <label>${order.orderPayment.toString()}</label><br>
                <@spring.message code="status"/>:
                <label id="order_status">${order.orderStatus.toString()}</label>
            </div>
            <#if seller>
            <div class="mt-2">
                <button class="btn btn-warning mt-" value="IN_TRANSIT" onclick="setStatus(this.value, ${order.id})"><@spring.message code="order.button.approve"/></button>
                <button class="btn btn-warning" value="DELIVERED" onclick="setStatus(this.value, ${order.id})"><@spring.message code="order.button.delivered"/></button>
            </div>
            </#if>
            <div>
                <h3><a class="text-warning" href="/seller/orders"><@spring.message code="back"/></a></h3>
            </div>
        </div>
    </#if>
</div>
<script src="/static/js/seller.js"></script>
</@component.skeleton>