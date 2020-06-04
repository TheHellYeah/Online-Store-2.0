<#import "components/skeleton.ftlh" as html>
<#import "components/navbar.ftlh" as bootstrap>

<@html.skeleton title="Список желаемого">
<@bootstrap.navbar/>
<div class="container mt-3">
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
</div>
</@html.skeleton>