<#macro product_section products>
<div class="card-columns">
    <#list products as product>
        <div class="card text-white bg-dark m-1 mb-3" style="width: 18rem;"
             onclick="location.href=`/product/${product.id}`">
            <img class="card-img-top" src="/img/${product.images[0]}" alt="ИЗображение товара">
            <div class="card-body">
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
    </#list>
</div>
</#macro>