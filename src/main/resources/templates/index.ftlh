<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>


<@component.skeleton title="ShoeHub - интернет магазин обуви для всей семьи!">
<@bootstrap.navbar/>


<#include "components/categories-slider-bar.ftlh" >

<div class="content">
    <div class="container">
        <div class="row">
<!--            Колонка для филтра справа-->
            <div class="col-md-2 col-lg-2 col-sm-3 col-xs-10 mr-3 float-right-style">
                <div class="filter">
                    <h3>Фильтр</h3>
                    <ul>

                        <li>
                            <div class="form-group">
                                <label >Цена</label>
                                <input type="range" min="0" max="100000" class="form-control-range">
                            </div>
                        </li>
                        <li>
                            <div class="form-group">
                                <label >Размер</label>
                                <input type="range" min="0" max="100000" class="form-control-range">
                            </div>
                        </li>
                        <li>
                            <div class="form-group">
                                    <label>Бренд:</label>
                                    <select name="brand">
                                        <option disabled>Выберите бренд</option>
                                        <option value="NIKE">Nike</option>
                                        <option value="ADIDAS">Adidas</option>
                                        <option value="RIEKER">Rieker</option>
                                        <option value="PUMA">Puma</option>
                                        <option value="RALPH_RINGER">Ralph Ringer</option>
                                    </select>
                            </div>
                        </li>
                        <li>
                            <div class="form-group">
                                <label>Категория :</label>
                                <select name="category">
                                    <option disabled></option>
                                    <option value="MALE">Мужская</option>
                                    <option value="FEMALE">Женская</option>
                                    <option value="CHILD">Детская</option>
                                </select>
                            </div>
                        </li>
                        <li>
                            <div class="form-group">
                                <label>Вид обуви:</label>
                                <select name="subcategory">
                                    <option disabled>Выберите вид</option>
                                    <option value="SNEAKERS">Кроссовки</option>
                                    <option value="GYMSHOES">Спортивная обувь</option>
                                    <option value="LOW_SHOES">Полуботинки</option>
                                    <option value="SANDALS">Сандалии</option>
                                    <option value="SLIPPERS">Тапочки</option>
                                </select>
                            </div>
                        </li>
                        <li>
                            <div class="form-group">
                                <label>Сезон:</label>
                                <select name="season">
                                    <option disabled>Выберите сезон</option>
                                    <option value="SUMMER">Лето</option>
                                    <option value="AUTUMN">Осень</option>
                                    <option value="WINTER">Зима</option>
                                    <option value="SPRING">Весна</option>
                                </select>
                            </div>
                        </li>


                    </ul>
                </div>
            </div>
<!--Колонка для товара и поиска-->
            <div class="col-md-9 col-lg-9 col-sm-8 col-xs-12 float-left-style">
                <!--Поиск и сортировка-->
                <div class="container">
                    <div class="row bg-dark">
                        <div class="input-group m-2 ">
                            <input type="text" class="form-control" placeholder="Поиск">
                            <div class="input-group-append">
                                <button class="btn btn-outline-secondary bg-warning" type="button" id="button-addon2">Поиск</button>
                            </div>

                            <select class="form-control ml-5">
                                <option value="">По умолчанию</option>
                                <option value="">По позрастанию цены</option>
                                <option value="">По убыванию цены</option>
                            </select>

                        </div>


                    </div>
                </div>
                <!--    Продукты-->
                <div class="container mt-3">
                    <div class="row">
                        <!--    Один продукт-->
                        <div class="col-lg-3 col-md-6 mb-4 bg-dark">
                            <div class="single-product">
                                <img class="img-fluid" src="https://sun9-34.userapi.com/c851036/v851036212/59f1/WdiW5od8Iy4.jpg" alt="">
                                <div class="product-details">
                                    <!--                        Тут будет id товара, что бы удобнее добавлять в корзинуи виш-->
                                    <input type="hidden" value="id-product">

                                    <h6 class="name-product" > <a class="text-white" href="">addidas futer</a></h6>
                                    <h6 class="price-product text-white">10 000</h6>
                                    <div class="prd-bottom">
                                        <button class="btn-warning" onclick="">В корзину</button>
                                        <button class="btn-info" onclick="">В избранное</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--            -->
                        <div class="col-lg-3 col-md-6 mb-4 bg-dark">
                            <div class="single-product">
                                <img class="img-fluid" src="https://sun9-34.userapi.com/c851036/v851036212/59f1/WdiW5od8Iy4.jpg" alt="">
                                <div class="product-details">
                                    <!--                        Тут будет id товара, что бы удобнее добавлять в корзинуи виш-->
                                    <input type="hidden" value="id-product">

                                    <h6 class="name-product" > <a class="text-white" href="">addidas futer</a></h6>
                                    <h6 class="price-product text-white">10 000</h6>
                                    <div class="prd-bottom">
                                        <button class="btn-warning" onclick="">В корзину</button>
                                        <button class="btn-info" onclick="">В избранное</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--            -->
                        <div class="col-lg-3 col-md-6 mb-4 bg-dark">
                            <div class="single-product">
                                <img class="img-fluid" src="https://sun9-34.userapi.com/c851036/v851036212/59f1/WdiW5od8Iy4.jpg" alt="">
                                <div class="product-details">
                                    <!--                        Тут будет id товара, что бы удобнее добавлять в корзинуи виш-->
                                    <input type="hidden" value="id-product">

                                    <h6 class="name-product" > <a class="text-white" href="">addidas futer</a></h6>
                                    <h6 class="price-product text-white">10 000</h6>
                                    <div class="prd-bottom">
                                        <button class="btn-warning" onclick="">В корзину</button>
                                        <button class="btn-info" onclick="">В избранное</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--            -->
                        <div class="col-lg-3 col-md-6 mb-4 bg-dark">
                            <div class="single-product">
                                <img class="img-fluid" src="https://sun9-34.userapi.com/c851036/v851036212/59f1/WdiW5od8Iy4.jpg" alt="">
                                <div class="product-details">
                                    <!--                        Тут будет id товара, что бы удобнее добавлять в корзинуи виш-->
                                    <input type="hidden" value="id-product">

                                    <h6 class="name-product" > <a class="text-white" href="">addidas futer</a></h6>
                                    <h6 class="price-product text-white">10 000</h6>
                                    <div class="prd-bottom">
                                        <button class="btn-warning" onclick="">В корзину</button>
                                        <button class="btn-info" onclick="">В избранное</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--            -->
                        <div class="col-lg-3 col-md-6 mb-4 bg-dark">
                            <div class="single-product">
                                <img class="img-fluid" src="https://sun9-34.userapi.com/c851036/v851036212/59f1/WdiW5od8Iy4.jpg" alt="">
                                <div class="product-details">
                                    <!--                        Тут будет id товара, что бы удобнее добавлять в корзинуи виш-->
                                    <input type="hidden" value="id-product">

                                    <h6 class="name-product" > <a class="text-white" href="">addidas futer</a></h6>
                                    <h6 class="price-product text-white">10 000</h6>
                                    <div class="prd-bottom">
                                        <button class="btn-warning" onclick="">В корзину</button>
                                        <button class="btn-info" onclick="">В избранное</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--            -->
                        <div class="col-lg-3 col-md-6 mb-4 bg-dark">
                            <div class="single-product">
                                <img class="img-fluid" src="https://sun9-34.userapi.com/c851036/v851036212/59f1/WdiW5od8Iy4.jpg" alt="">
                                <div class="product-details">
                                    <!--                        Тут будет id товара, что бы удобнее добавлять в корзинуи виш-->
                                    <input type="hidden" value="id-product">

                                    <h6 class="name-product" > <a class="text-white" href="">addidas futer</a></h6>
                                    <h6 class="price-product text-white">10 000</h6>
                                    <div class="prd-bottom">
                                        <button class="btn-warning" onclick="">В корзину</button>
                                        <button class="btn-info" onclick="">В избранное</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--            -->
                        <div class="col-lg-3 col-md-6 mb-4 bg-dark">
                            <div class="single-product">
                                <img class="img-fluid" src="https://sun9-34.userapi.com/c851036/v851036212/59f1/WdiW5od8Iy4.jpg" alt="">
                                <div class="product-details">
                                    <!--                        Тут будет id товара, что бы удобнее добавлять в корзинуи виш-->
                                    <input type="hidden" value="id-product">

                                    <h6 class="name-product" > <a class="text-white" href="">addidas futer</a></h6>
                                    <h6 class="price-product text-white">10 000</h6>
                                    <div class="prd-bottom">
                                        <button class="btn-warning" onclick="">В корзину</button>
                                        <button class="btn-info" onclick="">В избранное</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--            -->
            </div>

















        </div>

    </div>

</div>

<form action="/logout" method="post">
    <input type="submit" value="Выйти из аккаунта"/>
</form>
</@component.skeleton>