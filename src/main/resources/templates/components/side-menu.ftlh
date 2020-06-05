<#import "form-check.ftlh" as form>

<#macro menu>
<form method="get" action="/filter" class="mb-5">
    <div class="category">
        <h3>Категории</h3>
        <#list subcategories as subcategory>
            <a href="/filter?subcategory=${subcategory.name()}">${subcategory.toString()}</a><br>
        </#list>
    </div>

    <div class="price">
        <h3>Цена</h3>
        <div class="form-group">
            <div class="input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text">от</span>
                </div>
                <input type="text" class="form-control">
                <input type="text" class="form-control">
                <div class="input-group-append">
                    <span class="input-group-text">до</span>
                </div>
            </div>
        </div>
    </div>

    <div class="size">
        <div class="form-group">
            <label>Размер</label>
            <input type="range" min="0" max="100000" class="form-control-range">
        </div>
    </div>

    <div class="brand">
        <h3>Бренд</h3>
        <#list brands as brand>
            <@form.checkbox name="brand" value=brand.name() text=brand.toString() />
        </#list>
    </div>

    <div class="season">
        <h3>Сезон</h3>
        <#list seasons as season>
            <@form.checkbox name="season" value=season.name() text=season.toString() />
        </#list>
    </div>

    <div class="material">
        <h3>Материал</h3>
        <#list materials as material>
            <@form.checkbox name="material" value=material.name() text=material.toString() />
        </#list>
    </div>
    <button type="submit" class="btn btn-warning mt-2">Фильтровать</button>
</form>
</#macro>