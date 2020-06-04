<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>
<#import "components/product-order-card.ftlh" as p>

<@component.skeleton title="Мои заказы">
<@bootstrap.navbar/>

<div class="container">
    <table class="table table-dark table-hover mt-3">
        <thead>
            <tr>
                <th>Заказ</th>
                <th>Товары</th>
                <th>Дата</th>
                <th>Статус</th>
                <th>Стоимость</th>
                <th>че каво</th>
            </tr>
        </thead>
        <tbody>
        <#list orders as order >
            <tr>
                <td>${order.id}</td>
                <td>
                    <@p.product order.products, order.id/>
                </td>
                <td><#if order.date??>${order.date}</#if></td>
                <td>${order.orderStatus}</td>
                <td>${order.total}</td>
                <td><button class="btn-warning">Подкробнее</button></td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
</@component.skeleton>