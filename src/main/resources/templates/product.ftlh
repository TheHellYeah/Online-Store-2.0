<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>
<#import "components/review.ftlh" as r>
<#import "components/size-bar.ftlh" as sizebar>
<#import "components/product-slider.ftlh" as slider>

<@component.skeleton title="${product.name}">
<@bootstrap.navbar/>

<div class="container row mt-4">
    <div class="col-7">
        <@slider.productslider product.images/>
    </div>
    <div class="col">
        <#if product??>
            <div class="">
                <h1 class="item-name text-primary ">${product.name}</h1>
                <a class="item-reviews mb-4">Отзывы(0)</a>

                <h3 class="item-price mb-4">${product.price} ₽</h3>

                    <@sizebar.sizes product.sizes />
                </div>
                <div class="item-add-cart">
                    <button class="btn-warning btn-lg" onclick="inCart(${product.id})">В корзину</button>
                    <button  class="btn-warning btn-lg" onclick="addWishlist(${product.id})">♥</button>
                </div>
            </div>
        <#else>
            <div class="container">
                <h1>К сожалению, товара не найдено</h1>
            </div>
        </#if>

    </div>
</div>
<div class="mt-5">
    <div class="col-9   m-auto">
        <div class="m-auto">

            <ul class="nav nav-tabs">
                <li class="active border border-warning bg-warning mr-2 p-2"><a class="text-dark" data-toggle="tab" href="#home">Описание</a></li>
                <li class="border border-warning bg-warning p-2"><a class="text-dark" data-toggle="tab" href="#menu1">Отзывы</a></li>
            </ul>

            <div class="tab-content">
                <div id="home" class="tab-pane fade in active">
                    <h3>Описание</h3>
                    <div class="infof">

                        <p class="text-white">Категория: ${product.category}</p>
                        <p class="text-white">Вид: ${product.subcategory}</p>
                        <p class="text-white">Сезон: ${product.season}</p>
                        <p class="text-white">Материал: ${product.material}</p>
                    </div>
                    <p class="text-white">${product.description}</p>
                </div>
                <div id="menu1" class="tab-pane fade">
                    <h3>Отзывы</h3>
                    <#if reviews??>
                        <#list reviews as review>
                            <@r.rev review/>
                        </#list>
                        <#else>
                            <div class="border">Отзывов пока никто не оставил, будь первым!</div>
                    </#if>

            <button type="button" class="btn btn-warning m-auto" data-toggle="modal" data-target="#myModal">Добавить отзыв</button>
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
                <h4 class="modal-title">Новый отзыв</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <form action="/review/create" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="hidden" name="productId" value="${product.id}">
                    <div class="form-group" >оценка<input class="form-control" name="mark" type="number" min="1" max="5" placeholder="От 1 до 5"></div>
                    <div class="form-group" >Отзыв:<br>
                        <textarea class="form-control" name="description" rows="5" placeholder="Введите сообщение"></textarea>
                    </div>
                    <button class="btn-warning">Добавить отзыв</button>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
         </div>
    </div>
</div>
<div class="col-2" id ="alert"style="position:fixed;right: 0;bottom:10px;">

</div>

</@component.skeleton>