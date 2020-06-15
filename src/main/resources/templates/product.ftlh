<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>
<#import "components/review.ftlh" as r>
<#import "components/size-bar.ftlh" as sizebar>
<#import "components/product-slider.ftlh" as slider>
<#import "components/rating-mini.ftlh" as mini>

<@component.skeleton title="product">
<@bootstrap.navbar/>

<#if product??>
<div class="row mt-4 w-100">
    <div class="col-1"></div>
    <div class="col-4">
        <@slider.productslider product.images/>
    </div>
    <div class="col-7">
        <div>
            <h1 class="item-name text-warning ">${product.name}</h1>
            <span class="text-white" style="">
                <a href="/?category=${product.category.name()}">${product.category}</a> /
                <a href="/?subcategory=${product.subcategory.name()}">${product.subcategory}</a> /
                <a href="/?season=${product.season.name()}">${product.season}</a>
            </span>
            <a class="text-white"><@spring.message code="product.reviews"/> (${product.revSize()})</a><br>
            <a class="text-white"><@spring.message code="rating"/>: <@mini.ratingmini product.rating/></a>
            <h3 class="item-price  ml-4 mb-4">${product.price} ₽</h3>
            <@sizebar.bar sizes />
        </div>
        <div class="item-add-cart">
            <button class="btn-warning btn-lg" onclick="inCart(${product.id})"><@spring.message code="product.button.incart"/></button>
            <button  class="btn-warning btn-lg" onclick="addWishlist(${product.id})">♥</button>
        </div>
    </div>
</div>
<div class="mt-5 mb-5">
    <div class="col-9   m-auto">
        <div class="m-auto">
            <ul class="nav nav-tabs">
                <li class="active border border-warning bg-warning mr-2 p-2"><a class="text-dark active" data-toggle="tab" href="#home"><@spring.message code="add.product.description"/></a></li>
                <li class="border border-warning bg-warning p-2"><a class="text-dark" data-toggle="tab" href="#menu1"><@spring.message code="product.reviews"/></a></li>
            </ul>
            <div class="tab-content">
                <div id="home" class="tab-pane fade in active show">
                    <div class="info">
                        <p class="text-white">${product.description}</p>
                    </div>
                </div>
                <div id="menu1" class="tab-pane fade">
                    <#if reviews??>
                    <#list reviews as review>
                    <@r.rev review/>
                </#list>
                <#else>
                <div class="border"><@spring.message code="product.reviews.empty"/></div>
            </#if>
            <button type="button" class="btn btn-warning m-auto" data-toggle="modal" data-target="#myModal"><@spring.message code="product.reviews.button"/></button>
        </div>
    </div>
</div>
</div>
</div>
<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title"><@spring.message code="product.reviews.new"/></h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <form action="/review/create" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="hidden" name="productId" value="${product.id}">
                    <div class="form-group" ><@spring.message code="product.reviews.mark"/><input class="form-control" name="mark" type="number" min="1" max="5" placeholder="От 1 до 5"></div>
                    <div class="form-group" ><@spring.message code="product.review"/>:<br>
                        <textarea class="form-control" name="description" rows="5" placeholder='<@spring.message code="product.review.placeholder"/>'></textarea>
                    </div>
                    <button class="btn-warning"><@spring.message code="product.reviews.button"/></button>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<#else>
<div class="container mt-4">
    <h3><@spring.message code="product.empty"/></h3>
    <h3 class="float-none"><a href="/"<@spring.message code="home"/></a></h3>
</div>
</#if>
<#include "/components/footer.ftlh">
</@component.skeleton>