<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>
<#import "components/product-order-card.ftlh" as p>
<#import "spring.ftl" as spring>

<@component.skeleton title="Мои заказы">
<@bootstrap.navbar/>

<div class="container">
    <table class="table table-dark table-hover mt-3" style="font-size: 18px;">
        <thead>
            <tr>
                <th><@spring.message code="order"/> №</th>
                <th><@spring.message code="date"/></th>
                <th><@spring.message code="status"/></th>
                <th><@spring.message code="summa"/></th>
                <th><@spring.message code="type.of.payment"/></th>
            </tr>
        </thead>
        <tbody>
        <#list orders as order >
            <tr onclick="location.href=`/user/orders/${order.id}`" style="cursor: pointer;">
                <td>${order.id}</td>
                <td><#if order.date??>${order.date}</#if></td>
                <td>${order.orderStatus.toString()}</td>
                <td>${order.total} ₽</td>
                <td>${order.orderPayment.toString()}</td>
            </tr>
        </#list>
        </tbody>
    </table>
    <p class="text-white">(<@spring.message code="user.orders.info"/>)</p>
</div>
</@component.skeleton>