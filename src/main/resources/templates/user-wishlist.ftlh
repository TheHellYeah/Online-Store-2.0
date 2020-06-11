<#import "components/skeleton.ftlh" as html>
<#import "components/navbar.ftlh" as bootstrap>

<#import "spring.ftl" as spring>

<@html.skeleton title= "">
<@bootstrap.navbar/>
<div class="container mt-3">
    <#if currentUser??>
        <h3><@spring.message code="wishlist.info"/></h3>
    <#else>
        <#if public??>
            <h3><@spring.message code="wishlist.user.info"/> ${username}</h3>
        <#else>
            <h3>${username}<@spring.message code="wishlist.user.close"/></h3>
        </#if>
    </#if>
    <#if currentUser?? || public??>
    <#if !(wishlist?has_content)>
        <h3><@spring.message code="wishlist.user.empty"/></h3>
    <#else>
            <table class="table table-dark table-hover mt-3">
                <thead>
                    <tr>
                        <th><@spring.message code="wishlist.tovar"/></th>
                        <th><@spring.message code="price"/></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                <#if wishlist??>
                    <#list wishlist as product>
                    <tr>
                        <td><a href="/product/${product.id}">${product.name}</a></td>
                        <td>${product.price}</td>
                        <td><button class="btn btn-primary" onclick="delInWishlist(${product.id},this)"><@spring.message code="wishlist.button"/></button></td>
                    </tr>
                    </#list>
                </#if>
                </tbody>
            </table>
    </#if>
    </#if>
</div>
</@html.skeleton>