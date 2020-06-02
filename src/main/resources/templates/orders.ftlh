<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="Мои заказы">
<@bootstrap.navbar/>

<div>
    <table>
        <thead>
            <tr>
                <th>Заказ</th>
                <th>Товары</th>
                <th>Дата</th>
                <th>Статус</th>
                <th>Cтоимость</th>
                <th>че каво</th>
            </tr>
        </thead>
        <tbody>
        <#list orders as order >
        <tr>
            <td>${order.id} ТУТ ССЫЛКА НА ЗАКАЗ, ШАБЛОН ОРДЕР</td>
            <td>
                ?????????????????ВЫТАЩИТЬ ПРОДУКТЫ ИЗ КАЖДОГО ЗАКАЗА НО МОГУЦЦЫВФ
            </td>
            <td><#if order.contact??>${order.contact}</#if></td>
            <td>${order.orderStatus}</td>
            <td></td>
            <td><button class="btn-warning">Подкробнее</button></td>


        </tr>
        </#list>

        </tbody>
    </table>
</div>


</@component.skeleton>