<#macro card product>
<div class="card" style="width: 18rem;">
    <img class="card-img-top" src="..." alt="Card image cap">
    <div class="card-body">
        <h5 class="card-title">${product.name}</h5>
        <p class="card-text">${product.price}</p>
        <a href="#" class="btn btn-primary">В список желаемого</a>
        <a href="#" class="btn btn-primary">В корзину</a>
    </div>
</div>
</#macro>