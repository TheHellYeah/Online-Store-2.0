<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>
<#import "spring.ftl" as spring>

<@component.skeleton title= "2">
<@bootstrap.navbar/>
<div class="container mt-4">
<!--    <form action="/seller/orders" method="get" class="mt-3">-->
<!--        <select name="status" id="inputID" class="form-control">-->
<!--            <option selected value=""><@spring.message code="all"/></option>-->
<!--            <#list ordersStatus as status>-->
<!--            <option value=${status.name()}>${status.toString()}</option>-->
<!--            </#list>-->

<!--        </select>-->
<!--        <button class="btn-warning text-dark"><@spring.message code="show"/></button>-->
<!--    </form>-->
    <table id="orders" class="table table-dark table-hover mt-3">
        <thead>
            <tr >
                <th><@spring.message code="order"/> №</th>
                <th><@spring.message code="user"/></th>
                <th><@spring.message code="date"/></th>
                <th><@spring.message code="status"/></th>
                <th><@spring.message code="summa"/></th>
                <th class="sorting_disabled"><@spring.message code="type.of.payment"/></th>
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
    <p class="text-white">(<@spring.message code="seller.orders.info"/>)</p>
</div>

    <script src="/static/js/seller.js"></script>
</@component.skeleton>