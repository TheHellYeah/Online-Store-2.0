<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>
<#import "components/validation-error.ftlh" as v>

<@component.skeleton title="form.add.poduct">
<@bootstrap.navbar/>

<div class="container">
    <form class="mt-3 mb-5" action="/product/add" method="post" enctype="multipart/form-data">
        <h3><@spring.message code="add.product.details"/></h3>
        <input type="hidden" name="_csrf" value="${_csrf.token}">

        <div class="form-group">
            <label for="name"><@spring.message code="add.product.name"/></label>
            <input type="text" name="name" class="form-control" id="name"
                   placeholder="Введите название товара">
            <@v.validation nameError! />
        </div>

        <div class="form-group">
            <label for="description"><@spring.message code="add.product.description"/></label>
            <textarea name="description" class="form-control" id="description"
                      placeholder="Введите описание товара"></textarea>
            <@v.validation descriptionError! />
        </div>

        <div class="form-group">
            <label for="price"><@spring.message code="price"/></label>
            <input type="number" name="price" class="form-control" id="price"
                      placeholder="Введите цену товара">
            <@v.validation priceError! />
        </div>

        <div class="form-group">
            <label for="images"><@spring.message code="add.product.photos"/></label>
            <div class="form-group">
                <div class="custom-file">
                    <input type="file" name="images" multiple="multiple" class="custom-file-input form-control-file" id="images" accept="image">
                    <label class="custom-file-label" for="images"><@spring.message code="add.product.image.select"/></label>
                </div>
                <div class="preview p-2">
                    <p><@spring.message code="add.product.photos.none"/></p>
                </div>
            </div>
        </div>
        <style>img {height: 64px;}</style>
        <div class="form-group">
            <label for="category"><@spring.message code="add.product.shoe.category"/>:</label>
            <select class="form-control" name="category" id="category" onchange="getValue(this.value);">
                <option disabled selected>Выберите категорию</option>
                <#list categories as category>
                    <option value=${category.name()}>${category}</option>
                </#list>
            </select>
            <@v.validation categoryError! />
        </div>

        <div class="form-group">
            <label for="brand"><@spring.message code="add.product.brand"/>:</label>
            <select class="form-control" name="brand" id="brand">
                <option disabled selected>Выберите бренд</option>
                <#list brands as brand>
                    <option value=${brand.name()}>${brand.toString()}</option>
                </#list>
            </select>
            <@v.validation brandError! />
        </div>

        <div class="form-group">
            <label for="subcategory"><@spring.message code="add.product.kind"/>:</label>
            <select class="form-control" name="subcategory" id="subcategory">
                <option disabled selected>Выберите вид</option>
                <#list subcategories as subcategory>
                    <option value=${subcategory.name()}>${subcategory.toString()}</option>
                </#list>
            </select>
            <@v.validation subcategoryError! />
        </div>

        <div class="form-group">
            <label for="season"><@spring.message code="add.product.season"/>:</label>
            <select class="form-control" name="season" id="season">
                <option disabled selected>Выберите сезон</option>
                <#list seasons as season>
                    <option value=${season.name()}>${season.toString()}</option>
                </#list>
            </select>
            <@v.validation seasonError! />
        </div>

        <div class="form-group">
            <label for="material"><@spring.message code="add.product.material"/>:</label>
            <select class="form-control" name="material" id="material">
                <option disabled selected>Выберите материал</option>
                <#list materials as material>
                    <option value=${material.name()}>${material.toString()}</option>
                </#list>
            </select>
            <@v.validation materialError! />
        </div>

        <div class="form-group">
            <label><@spring.message code="add.product.quantity"/>:</label>
            <table>
                <thead>
                <tr>
                    <th><@spring.message code="size"/></th>
                    <th><@spring.message code="count"/></th>
                </tr>
                </thead>
                <tbody id="size">
                </tbody>
            </table>
            <@v.validation sizesError! />
        </div>
        <button type="submit" class="btn btn-warning"><@spring.message code="add.product.button"/></button>
    </form>
</div>
<script src="/static/js/size.js"></script>
</@component.skeleton>