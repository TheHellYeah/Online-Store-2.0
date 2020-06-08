<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>
<#import "components/product-order-card.ftlh" as p>

<@component.skeleton title="Мои заказы">
<@bootstrap.navbar/>

<div class="container">
    <table class="table table-dark table-hover mt-3" style="font-size: 18px;">
        <thead>
            <tr>
                <th>Заказ №</th>
                <th>Дата</th>
                <th>Статус</th>
                <th>Сумма</th>
                <th>Вид оплаты</th>
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
    <p class="text-white">(кликните по заказу для получения детальной информации)</p>
</div>
</@component.skeleton>