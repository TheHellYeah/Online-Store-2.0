<#include "rating-mini.ftlh">
<#macro product_section products>
<#assign auth = Session.SPRING_SECURITY_CONTEXT??>

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
                <p><@ratingmini product.rating /></p>
                <h3>${product.price} ₽</h3>
                <#if auth>
                    <button class="btn btn-lg btn-warning" style="position:absolute;right:25px;bottom:25px;z-index:10ж" onclick="addWishlist(${product.id})">
                        <svg class="bi bi-heart-fill" width="1em" height="1em" viewBox="0 0 16 16" fill="rgb(52, 58, 64)" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"/>
                        </svg>
                    </button>
                </#if>
            </div>
        </div>
    </#list>
</div>
</#macro>