<#import "components/skeleton.ftlh" as html>
<#import "components/navbar.ftlh" as bootstrap>

<@html.skeleton title="Список желаемого">
<@bootstrap.navbar/>
<div class="container mt-3">
    <#if currentUser??>
        <h3>Ваш список желаемого</h3>
    <#else>
        <#if public??>
            <h3>Список желаемого пользователя ${username}</h3>
        <#else>
            <h3>Пользователь ${username} закрыл доступ к своему списку желаемого</h3>
        </#if>
    </#if>
    <#if currentUser?? || public??>
    <#if !(wishlist?has_content)>
        <h3>Пусто...</h3>
    <#else>
            <table class="table table-dark table-hover mt-3">
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
    </#if>
    </#if>
</div>
</@html.skeleton>