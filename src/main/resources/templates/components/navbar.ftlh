<#macro navbar>
<#include "security.ftlh">
<nav class="navbar navbar-expand-lg navbar-light bg-dark">
    <a class="navbar-brand" href="/"><span class="text-white">Shoe</span><span class="text-dark bg-warning rounded">Hub</span></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link text-white" href="/man">Мужчинам<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="/woman">Женщинам</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="/children">Детям</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="/product/add">Добавить продукт</a>
            </li>
            <li  class="nav-item">
                <a class="nav-link text-white" href="/admin">Админка</a>
            </li>

        </ul>
        <form class="form-inline my-2 my-lg-0">
        <#if !known>
            <button class="btn btn-warning  my-2 my-sm-0 mr-2"><a class="text-dark" href="/login" >Войти</a></button>
            <button class="btn btn-warning  my-2 my-sm-0"><a class="text-dark" href="/registration">Pегистрация</a></button>
            <#else>
                <div class="btn-group mr-2">
                    <button class="btn btn-warning dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        ${name}
                    </button>

                    <div class="dropdown-menu dropdown-menu-right">
                        <a class="dropdown-item" href="/user/${userId}">Личный </a>
                        <a class="dropdown-item" href="/user/cart">Корзина</a>

                        <a class="dropdown-item" href="/user/orders">Мои заказы</a>
                        <a class="dropdown-item" href="/logout">Выйти</a>
                    </div>
                </div>
<!--                 <form action="/logout" method="post">-->
<!--                    <input type="submit" value="Выйти"/>-->
<!--                 </form>-->

        </#if>


        </form>
    </div>
</nav>
</#macro>