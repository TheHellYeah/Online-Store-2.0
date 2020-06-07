    <#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>
<#import "components/product-order-card.ftlh" as p>

<@component.skeleton title="Страница продавца">
<@bootstrap.navbar/>
<div class="container">
    <form action="/seller/orders" method="get" class="mt-3">
        <select name="status" id="inputID" class="form-control">
            <option value="ALL" selected >Все</option>
            <option value="PENDING">Выполняются</option>
            <option value="IN_TRANSIT">Доставка</option>
            <option value="DELIVERED">Доставлено</option>
        </select>
        <button class="btn-warning text-dark">Показать</button>
    </form>
    <table class="table table-dark table-hover mt-3">
        <thead>
        <tr>
            <th>Номер заказа</th>
            <th>Товар</th>
            <th>дата</th>
            <th>Пользователь</th>
            <th>Статус</th>
            <th>Стоимость</th>
            <th>Оплата</th>
            <th>Подбробнее</th>
            <th>пум</th>
        </tr>
        </thead>
        <tbody>
        <#list orders as order>
        <tr>
            <td>${order.id}</td>
            <td>
                <@p.product order.products, order.id/>
            </td>
            <td>${order.date}</td>
<!--            тут будет ссылка на профиль юзера, продумать как и стоит ли это делать-->
            <td><a href="/user/${order.user.id}">${order.user.username}</a></td>
            <td>${order.orderStatus}</td>
            <td>${order.total}</td>
            <td>${order.orderPayment.toString()}</td>
            <td><button class="btn-warning"><a class="text-dark" href="/seller/order/${order.id}">Подробнее</a></button></td>
            <td>
                <#if order.inTransit()>
                    <button class="" onclick="setStatus(${order.id},`DELIVERED`)">Доставлен</button>
                </#if>

                <#if order.inPending()>
                    <button class="" onclick="setStatus(${order.id},`IN_TRANSIT`)">Передано доставке</button>
                </#if>
                <#if order.isDelivered()>
                     <label class="text-white p-1">Выполнен</label>
                 </#if>
            </td>
        </tr>
        </#list>
        </tbody>
    </table>

</div>

    <script src="/static/js/seller.js"></script>
</@component.skeleton>