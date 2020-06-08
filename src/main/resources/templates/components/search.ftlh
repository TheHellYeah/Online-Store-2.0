<#macro form>
<div class="container mt-3">
    <div class="row">
        <div class="input-group m-2 search-group">
            <input type="text" class="form-control" placeholder="Поиск" id="search">
            <div class="input-group-append">
                <button class="btn btn-outline-secondary text-dark bg-warning" type="button" id="button-addon2">
                    Поиск
                </button>
            </div> <br/>
            <span style="font-size: 20px;">
                <a href="/?sortOrder=ASC&sortBy=price">По возрастанию цены</a>
                <a href="/?sortOrder=DESC&sortBy=price">По убыванию цены</a>
                <a href="/?sortOrder=DESC&sortBy=rating">По популярности</a>
            </span>
        </div>
    </div>
</div>
</#macro>