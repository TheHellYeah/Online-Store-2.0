<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>



<@component.skeleton title="ShoeHub - интернет магазин обуви для всей семьи!">
<@bootstrap.navbar/>

<div class="form-group">
  <form action="/add" method="get"> <!--  Поменять на пост и добавить добавление размеров и колличесв-->
        <div class="form-group">
            <label>Наименование товара:</label>
            <input name="name" type="text">
        </div>
        <div class="form-group">
            <label>Описание товара: </label>
            <input name="description" type="text">
        </div>
        <div class="form-group">
            <label>Стоимость товара: </label>
            <input name="price" type="number" min="0" max="100000">
        </div>
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
        <div class="form-group">
            <label>Категория обуви:</label>
            <select name="category">
                <option disabled>Выберите категорию</option>
                <option value="MALE">Мужская</option>
                <option value="FEMALE">Женская</option>
                <option value="CHILD">Детская</option>
            </select>
        </div>
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


<!--        <div class="form-group">-->
<!--            <label>Количество товара на вашем складе:</label>-->
<!--            <input name="amount" type="number" min="0">-->
<!--        </div>-->




        <button type="submit" class="btn btn-primary mb-2" >Добавить товар</button>
    </form>

</div>






</@component.skeleton>