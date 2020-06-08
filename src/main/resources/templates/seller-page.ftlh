    <#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>
<#import "components/product-order-card.ftlh" as p>

<@component.skeleton title="Страница продавца">
<@bootstrap.navbar/>
<div class="container">
    <form action="/seller/orders" method="get" class="mt-3">
        <select name="status" id="inputID" class="form-control">
            <option selected >Все</option>
            <option value="PENDING">Ожидает подтверждения</option>
            <option value="IN_TRANSIT">В пути</option>
            <option value="DELIVERED">Доставлено</option>
        </select>
        <button class="btn-warning text-dark">Показать</button>
    </form>
    <table class="table table-dark table-hover mt-3">
        <thead>
            <tr >
                <th>Заказ №</th>
                <th>Пользователь</th>
                <th>Дата</th>
                <th>Статус</th>
                <th>Сумма</th>
                <th>Вид оплата</th>
            </tr>
        </thead>
        <tbody>
        <#list orders as order>
            <tr onclick="location.href=`/seller/orders/${order.id}`" style="cursor: pointer;">
                <td>${order.id}</td>
                <td><a href="/user/${order.user.id}">${order.user.username}</a></td>
                <td>${order.date}</td>
                <td>${order.orderStatus}</td>
                <td>${order.total} ₽</td>
                <td>${order.orderPayment}</td>
            </tr>
        </#list>
        </tbody>
    </table>
    <p class="text-white">(кликните по заказу для получение детальной информации и изменении статуса заказа)</p>
</div>

    <script src="/static/js/seller.js"></script>
</@component.skeleton>