<#macro form>
<div class="container mt-3">
    <div class="row bg-dark">
        <div class="input-group m-2 search-group">
            <input type="text" class="form-control" placeholder="Поиск" id="search">
            <div class="input-group-append">
                <button class="btn btn-outline-secondary text-dark bg-warning" type="button" id="button-addon2">
                    Поиск
                </button>
            </div>
            <select class="form-control ml-5">
                <option value="">По умолчанию</option>
                <option value="">По позрастанию цены</option>
                <option value="">По убыванию цены</option>
            </select>
        </div>
    </div>
</div>
</#macro>