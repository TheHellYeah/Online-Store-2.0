<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="Добавление продукта">
<@bootstrap.navbar/>

<div class="container">
    <form class="mt-3 mb-5" action="/product/add" method="post" enctype="multipart/form-data">
        <h3>Данные о товаре</h3>
        <input type="hidden" name="_csrf" value="${_csrf.token}">

        <div class="form-group">
            <label for="name">Название</label>
            <input type="text" name="name" class="form-control" id="name"
                   placeholder="Введите название товара">
        </div>

        <div class="form-group">
            <label for="description">Описание</label>
            <textarea name="description" class="form-control" id="description"
                      placeholder="Введите описание товара"></textarea>
        </div>

        <div class="form-group">
            <label for="price">Цена</label>
            <input type="number" name="price" class="form-control" id="price"
                      placeholder="Введите цену товара">
        </div>

        <div class="form-group">
            <label for="images">Фотографии</label>
            <div class="form-group">
                <div class="custom-file">
                    <input type="file" name="images" multiple="multiple" class="custom-file-input form-control-file" id="images" accept="image">
                    <label class="custom-file-label" for="images">Выберите файлы</label>
                </div>
                <div class="preview p-2 bg-white">
                    <p>Файлы для загрузки не выбраны</p>
                </div>
            </div>
        </div>
        <style>img {height: 64px;}</style>
        <div class="form-group">
            <label for="category">Категория обуви:</label>
            <select class="form-control" name="category" id="category" onchange="getValue(this.value);">
                <option disabled selected>Выберите категорию</option>
                <#list categories as category>
                    <option value=${category.name()}>${category.toString()}</option>
                </#list>
            </select>
        </div>

        <div class="form-group">
            <label for="brand">Бренд:</label>
            <select class="form-control" name="brand" id="brand">
                <option disabled selected>Выберите бренд</option>
                <#list brands as brand>
                    <option value=${brand.name()}>${brand.toString()}</option>
                </#list>
            </select>
        </div>

        <div class="form-group">
            <label for="subcategory">Вид обуви:</label>
            <select class="form-control" name="subcategory" id="subcategory">
                <option disabled selected>Выберите вид</option>
                <#list subcategories as subcategory>
                    <option value=${subcategory.name()}>${subcategory.toString()}</option>
                </#list>
            </select>
        </div>

        <div class="form-group">
            <label for="season">Сезон:</label>
            <select class="form-control" name="season" id="season">
                <option disabled selected>Выберите сезон</option>
                <#list seasons as season>
                    <option value=${season.name()}>${season.toString()}</option>
                </#list>
            </select>
        </div>

        <div class="form-group">
            <label for="material">Материал:</label>
            <select class="form-control" name="material" id="material">
                <option disabled selected>Выберите материал</option>
                <#list materials as material>
                    <option value=${material.name()}>${material.toString()}</option>
                </#list>
            </select>
        </div>

        <div class="form-group">
            <label>Количество товара на вашем складе:</label>
            <table>
                <thead>
                <tr>
                    <th>Размер</th>
                    <th>Количество</th>
                </tr>
                </thead>
                <tbody id="size">

                </tbody>
            </table>
        </div>
        <button type="submit" class="btn btn-warning">Добавить товар</button>
    </form>
</div>
<script src="/static/js/size.js"></script>
</@component.skeleton>