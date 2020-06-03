<#import "components/skeleton.ftlh" as html>
<#import "components/navbar.ftlh" as bootstrap>

<@html.skeleton title="ShoeHub: страница пользователя ${user.firstName}">
<@bootstrap.navbar/>
<div class="container">
    <div class="col-7 mt-4">
        <label>${user.username}</label>
        <label>${user.balance}</label>
        <label>${user.email}</label>
        <div class="border">
            <label>Имя <input type="text" value="${user.firstName}"></label>
            <label>Фамилия <input type="text" value="${user.secondName}"></label>
            <label>Отчество <input type="text" value="${user.patronymic}"></label>
            <button>Изменить</button>
        </div>
    </div>

    <table class="table">
        <thead>
        <tr>
            <th>Товар</th>
            <th>Цена</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#if wishlist??>
        <#list wishlist as product>
        <tr>
            <td><a href="/product/${product.id}">${product.name}</a></td>
            <td>${product.price}</td>
            <td><button class="btn btn-primary" onclick="delInWishlist(${product.id},this)">Убрать из списка</button></td>
        </tr>
        </#list>
    </#if>
    </tbody>
    </table>
</div>
</@html.skeleton>