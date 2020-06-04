<#import "form-check.ftlh" as form>

<#macro menu>
<form method="get" action="/filter">
    <div class="category">
        <h3>Категории</h3>
        <a href="/filter?category=SANDALS">Сандалии</a><br>
        <a href="/filter?category=GUMSHOES">Кеды</a><br>
        <a href="/filter?category=SLIPPERS">Шлёпанцы</a><br>
        <a href="/filter?category=LOW_SHOES">Туфли</a><br>
        <a href="/filter?category=SNEAKERS">Кроссовки</a><br>
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
        <@form.checkbox name="brand" value="NIKE" text="Nike"/>
        <@form.checkbox name="brand" value="ADIDAS" text="Adidas"/>
        <@form.checkbox name="brand" value="RIEKER" text="Rieker"/>
        <@form.checkbox name="brand" value="PUMA" text="Puma"/>
        <@form.checkbox name="brand" value="RALPH_RINGER" text="Ralph Ringer"/>
    </div>

    <div class="season">
        <h3>Сезон</h3>
        <@form.checkbox name="season" value="SUMMER" text="Лето"/>
        <@form.checkbox name="season" value="AUTUMN" text="Осень"/>
        <@form.checkbox name="season" value="WINTER" text="Зима"/>
        <@form.checkbox name="season" value="SPRING" text="Весна"/>
    </div>
    <button type="submit" class="btn btn-warning mt-2">Фильтровать</button>
</form>
</#macro>