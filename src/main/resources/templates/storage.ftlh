<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="Склад товаров">
<@bootstrap.navbar/>
<div>
<!--    <form action="" method="get" class="mt-3">-->
<!--        <select class="form-control" name="brand" id="brand">-->
<!--            <option disabled selected>Выберите бренд</option>-->
<!--            <option value="NIKE">Nike</option>-->
<!--            <option value="ADIDAS">Adidas</option>-->
<!--            <option value="RIEKER">Rieker</option>-->
<!--            <option value="PUMA">Puma</option>-->
<!--            <option value="RALPH_RINGER">Ralph Ringer</option>-->
<!--        </select>-->
<!--        <select class="form-control" name="category" id="category" onchange="getValue(this.value);">-->
<!--            <option disabled selected>Выберите категорию</option>-->
<!--            <option value="MAN">Мужская</option>-->
<!--            <option value="WOMAN">Женская</option>-->
<!--            <option value="CHILD">Детская</option>-->
<!--        </select>-->
<!--        <select class="form-control" name="subcategory" id="subcategory">-->
<!--            <option disabled selected>Выберите вид</option>-->
<!--            <option value="SNEAKERS">Кроссовки</option>-->
<!--            <option value="GUMSHOES">Спортивная обувь</option>-->
<!--            <option value="LOW_SHOES">Полуботинки</option>-->
<!--            <option value="SANDALS">Сандалии</option>-->
<!--            <option value="SLIPPERS">Тапочки</option>-->
<!--        </select>-->
<!--        <select class="form-control" name="season" id="season">-->
<!--            <option disabled selected>Выберите сезон</option>-->
<!--            <option value="SUMMER">Лето</option>-->
<!--            <option value="AUTUMN">Осень</option>-->
<!--            <option value="WINTER">Зима</option>-->
<!--            <option value="SPRING">Весна</option>-->
<!--        </select>-->
<!--        <button class="btn-warning text-dark">Показать</button>-->
<!--    </form>-->
    <table class="table table-bordered table-hover">
        <thead>
        <tr>
            <th >ID</th>
            <th >Наименование</th>
            <th >Стоимость</th>
            <th >Рейтинг</th>
            <th >Категория</th>
            <th >Вид</th>
            <th >Наличие</th>
            <th> </th>
        </tr>
        </thead>
        <tbody>
            <#list products as product>
                <tr>
                    <td>${product.id}</td>
                    <td>
                        <a class="text-warning" href="/product/${product.id}">${product.name}</a>
                    </td>
                    <td>${product.price}</td>
                    <td>${product.rating}</td>
                    <td>${product.category}</td>
                    <td>${product.subcategory}</td>
                    <td>
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <#list product.sizes as size,count>
                                <th  class="bg-secondary text-white">${size}</th>
                                </#list>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <#list product.sizes as size,count>
                                <#if count gt 0>
                                    <#if count gt 15>
                                        <td class="bg-success">${count}</td>
                                    <#else>
                                        <td class="bg-warning">${count}</td>
                                    </#if>
                                <#else>
                                    <td class="bg-danger">${count}</td>
                                </#if>
                                </#list>
                            </tr>
                            </tbody>
                        </table>
                    <input type="button" onclick="f(this)" value="пополнить">
                    </td>
                    <td><button class="btn btn-success btn-lg"><a class="text-dark" href="/product/edit/${product.id}">
                        <svg class="bi bi-pencil" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" d="M11.293 1.293a1 1 0 0 1 1.414 0l2 2a1 1 0 0 1 0 1.414l-9 9a1 1 0 0 1-.39.242l-3 1a1 1 0 0 1-1.266-1.265l1-3a1 1 0 0 1 .242-.391l9-9zM12 2l2 2-9 9-3 1 1-3 9-9z"/>
                            <path fill-rule="evenodd" d="M12.146 6.354l-2.5-2.5.708-.708 2.5 2.5-.707.708zM3 10v.5a.5.5 0 0 0 .5.5H4v.5a.5.5 0 0 0 .5.5H5v.5a.5.5 0 0 0 .5.5H6v-1.5a.5.5 0 0 0-.5-.5H5v-.5a.5.5 0 0 0-.5-.5H3z"/>
                        </svg>
                    </a></button>
                    </td>
                </tr>
            </#list>
        </tbody>
    </table>
</div>

<script src="/static/js/storage.js"></script>
</@component.skeleton>