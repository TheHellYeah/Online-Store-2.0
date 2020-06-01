<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="${product.name}">
<@bootstrap.navbar/>

<div class="container row">
    <div class="col-6">
        <div class="image m-1">
            <div class="large-image">
                <img src="">
            </div>
            <div class="other-image">

            </div>
        </div>
    </div>
    <div class="col-6 mt-5">
        <#if product??>
            <div class="item-content">
                <h1 class="item-name text-primary ">${product.name}</h1>
                <a class="item-reviews mb-4">Отзывы(0)</a>

                <h3 class="item-price mb-4">${product.price}</h3>
                <div class="item-text">
                    <p>${product.description}</p>
                </div>

                <div class="row item-size mb-3 ml-4  btn-group-toggle" data-toggle="buttons">
                    <label class="mr-3">Размер: </label>
<!--                    <#if product.category=="MALE">-->
                        <label class="btn  mr-1">
                            <input type="radio" name="size" autocomplete="off" checked> 39
                        </label>
                        <label class="btn  mr-1">
                            <input type="radio" name="size" autocomplete="off" checked> 40
                        </label>
                        <label class="btn  mr-1">
                            <input type="radio" name="size" autocomplete="off" checked> 41
                        </label>
                        <label class="btn  mr-1">
                            <input type="radio" name="size" autocomplete="off" checked> 42
                        </label>
                        <label class="btn  mr-1">
                            <input type="radio" name="size" autocomplete="off" checked> 43
                        </label>
                        <label class="btn mr-1">
                            <input type="radio" name="size" autocomplete="off" checked> 44
                        </label>
                        <label class="btn mr-1">
                            <input type="radio" name="size" autocomplete="off" checked> 45
                        </label>
                        <label class="btn mr-1">
                            <input type="radio" name="size" autocomplete="off" checked> 46
                        </label>
                        <label class="btn mr-1">
                            <input type="radio" name="size" autocomplete="off" checked> 47
                        </label><label class="btn mr-1">
                            <input type="radio" name="size" autocomplete="off" checked> 48
                        </label>
<!--                    </#if>-->
                </div>


                <div class="item-add-cart">
                    <span>Количество</span>
                    <input id="count" type="number" class="" value="1" min="1" max="9999">
                    <button onclick="inCart(${product.id})">Добавить в корзину</button>
                    <button onclick="addWishlist(${product.id})">♥</button>
                </div>



            </div>
        <#else>
            <div class="container">
                <h1>ТОВАР НЕ НАЙДЕН</h1>
            </div>
        </#if>

    </div>
    <div class="col-9  m-auto">
        <div class="row mt-4 justify-content-md-center">
            <div class="border border-warning bg-warning mr-2 p-2">ОПИСАНИЕ</div>
            <div class="border border-warning p-2">ОТЗЫВЫ</div>
        </div>

    </div>
</div>



</@component.skeleton>