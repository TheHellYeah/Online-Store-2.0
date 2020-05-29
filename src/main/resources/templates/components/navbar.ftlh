<#macro navbar>
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
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <button class="btn btn-outline-success my-2 my-sm-0"><a href="/login">Войти</a></button>
        </form>
    </div>
</nav>
</#macro>