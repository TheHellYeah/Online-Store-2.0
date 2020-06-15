<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="Корзина">
<@bootstrap.navbar/>
<div class="container mt-3">
    <#if !(cart?has_content)>
        <h1><@spring.message code="cart.empty"/></h1>
        <h3><@spring.message code="cart.empty.info"/></h3>
    <#else>
        <table class="table table-dark table-hover mt-3">
            <thead>
                <tr>
                    <th><@spring.message code="product"/></th>
                    <th><@spring.message code="count"/></th>
                    <th><@spring.message code="price"/></th>
                    <th><@spring.message code="size"/></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <#list cart as cartItem>
                    <tr>
                        <td><a href="/product/${cartItem.getProductId()}">${cartItem.product.name}</a></td>
                        <td><input class="cart-size-input" type="number" min="1" max=${cartItem.maxItemsAmount()} onchange="updateTotal(${cartItem.id}, this)" value="${cartItem.amount}"></td>
                        <td class="cart-price">${cartItem.product.price} ₽</td>
                        <td>${cartItem.size.toString()}</td>
                        <td><button class="btn btn-primary" onclick="delInCart(${cartItem.id}, this)"><@spring.message code="cart.button.delete"/></button></td>
                    </tr>
                </#list>
            </tbody>
        </table>
    <h3 class="text-white"><@spring.message code="cart.total"/>: <strong id="total1">${total}</strong> ₽</h3>
        <button type="button" class="btn btn-danger" onclick="clearCart()"><@spring.message code="cart.button.clear"/></button>
         <a href="/user/order/checkout" class="btn btn-warning text-dark" role="button"><@spring.message code="cart.button.create"/></a>
    </#if>
</div>

</@component.skeleton>