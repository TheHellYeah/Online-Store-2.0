<#macro card product>
<div class="card text-white bg-dark m-1" style="width: 18rem;" onclick="location.href=`/product/${product.id}`">
    <#if product.images?has_content>
        <img class="card-img-top" src="/img/${product.images[0]}" alt="Card image cap">
    <#else>
        <img class="card-img-top" src="https://toyscat.ru/img/nofoto.png" alt="Card image cap">
    </#if>
    <div class="card-body" >
        <h5 class="card-title">${product.name}</h5>
        <p>
            <a href="/filter?category=${product.category.name()}">${product.category.toString()}</a> /
            <a href="/filter?subcategory=${product.subcategory.name()}">${product.subcategory.toString()}</a> /
            <a href="/filter?season=${product.season.name()}">${product.season.toString()}</a>
        </p>
        <p class="card-text">Цена: ${product.price} ₽</p>
        <button class="btn btn-warning" onclick="addWishlist(${product.id})">♥</button>
    </div>
</div>

</#macro>