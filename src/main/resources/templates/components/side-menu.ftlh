<#import "form-check.ftlh" as form>
<#macro menu>
<form method="get" action="/" class="mb-5">
    <div class="category mb-2">
        <h3>
            <a data-toggle="collapse" href="#my-collapse-subcategory" aria-expanded="false" aria-controls="my-collapse-subcategory">
                <@spring.message code="category"/>
                <svg class="bi bi-arrow-down-short" width="1em" height="1em" viewBox="0 0 16 16" fill="rgb(255, 193, 7)" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" d="M4.646 7.646a.5.5 0 0 1 .708 0L8 10.293l2.646-2.647a.5.5 0 0 1 .708.708l-3 3a.5.5 0 0 1-.708 0l-3-3a.5.5 0 0 1 0-.708z"/>
                    <path fill-rule="evenodd" d="M8 4.5a.5.5 0 0 1 .5.5v5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5z"/>
                </svg>
            </a>
        </h3>
        <div class="collapse" id="my-collapse-subcategory">
            <#list subcategories as subcategory>
                <@form.checkbox name="subcategory" value=subcategory.name() text=subcategory.toString()/>
            </#list>
        </div>
    </div>

    <div class="price mb-2">
        <h3>
            <a data-toggle="collapse" href="#my-collapse-price" aria-expanded="false" aria-controls="my-collapse-price">
                <@spring.message code="price"/>
                <svg class="bi bi-arrow-down-short" width="1em" height="1em" viewBox="0 0 16 16" fill="rgb(255, 193, 7)" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" d="M4.646 7.646a.5.5 0 0 1 .708 0L8 10.293l2.646-2.647a.5.5 0 0 1 .708.708l-3 3a.5.5 0 0 1-.708 0l-3-3a.5.5 0 0 1 0-.708z"/>
                    <path fill-rule="evenodd" d="M8 4.5a.5.5 0 0 1 .5.5v5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5z"/>
                </svg>
            </a>
        </h3>
        <div class="collapse" id="my-collapse-price">
            <div class="form-group mb-0">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text">от</span>
                    </div>
                    <input type="text" class="form-control" name="minPrice">
                    <input type="text" class="form-control" name="maxPrice">
                    <div class="input-group-append">
                        <span class="input-group-text">до</span>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="size mb-2">
        <h3>
            <a data-toggle="collapse" href="#my-collapse-size" aria-expanded="false" aria-controls="my-collapse-size">
                <@spring.message code="filter.size"/>
                <svg class="bi bi-arrow-down-short" width="1em" height="1em" viewBox="0 0 16 16" fill="rgb(255, 193, 7)" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" d="M4.646 7.646a.5.5 0 0 1 .708 0L8 10.293l2.646-2.647a.5.5 0 0 1 .708.708l-3 3a.5.5 0 0 1-.708 0l-3-3a.5.5 0 0 1 0-.708z"/>
                    <path fill-rule="evenodd" d="M8 4.5a.5.5 0 0 1 .5.5v5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5z"/>
                </svg>
            </a>
        </h3>
        <div class="collapse" id="my-collapse-size">
            <div class="item-size mb-3 ml-1 btn-group-toggle" data-toggle="buttons">
                <#list sizes as size>
                    <label class="btn btn-secondary  m-1">
                        <input type="checkbox" name="size" value="${size.name()}" autocomplete="off">${size}
                    </label>
                </#list>
            </div>
        </div>
    </div>

    <div class="brand mb-2">
        <h3>
            <a data-toggle="collapse" href="#my-collapse-brand" aria-expanded="false" aria-controls="my-collapse-brand">
                <@spring.message code="add.product.brand"/>
                <svg class="bi bi-arrow-down-short" width="1em" height="1em" viewBox="0 0 16 16" fill="rgb(255, 193, 7)" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" d="M4.646 7.646a.5.5 0 0 1 .708 0L8 10.293l2.646-2.647a.5.5 0 0 1 .708.708l-3 3a.5.5 0 0 1-.708 0l-3-3a.5.5 0 0 1 0-.708z"/>
                    <path fill-rule="evenodd" d="M8 4.5a.5.5 0 0 1 .5.5v5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5z"/>
                </svg>
            </a>
        </h3>
        <div class="collapse" id="my-collapse-brand">
            <#list brands as brand>
                 <@form.checkbox name="brand" value=brand.name() text=brand.toString() />
            </#list>
        </div>
    </div>

    <div class="season mb-2">
        <h3>
            <a data-toggle="collapse" href="#my-collapse-season" aria-expanded="false" aria-controls="my-collapse-season">
                <@spring.message code="add.product.season"/>
                <svg class="bi bi-arrow-down-short" width="1em" height="1em" viewBox="0 0 16 16" fill="rgb(255, 193, 7)" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" d="M4.646 7.646a.5.5 0 0 1 .708 0L8 10.293l2.646-2.647a.5.5 0 0 1 .708.708l-3 3a.5.5 0 0 1-.708 0l-3-3a.5.5 0 0 1 0-.708z"/>
                    <path fill-rule="evenodd" d="M8 4.5a.5.5 0 0 1 .5.5v5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5z"/>
                </svg>
            </a>
        </h3>
        <div class="collapse" id="my-collapse-season">
            <#list seasons as season>
                <@form.checkbox name="season" value=season.name() text=season.toString() />
            </#list>
        </div>
    </div>

    <div class="material mb-2">
        <h3>
            <a data-toggle="collapse" href="#my-collapse-material" aria-expanded="false" aria-controls="my-collapse-material">
                <@spring.message code="add.product.material"/>
                <svg class="bi bi-arrow-down-short" width="1em" height="1em" viewBox="0 0 16 16" fill="rgb(255, 193, 7)" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" d="M4.646 7.646a.5.5 0 0 1 .708 0L8 10.293l2.646-2.647a.5.5 0 0 1 .708.708l-3 3a.5.5 0 0 1-.708 0l-3-3a.5.5 0 0 1 0-.708z"/>
                    <path fill-rule="evenodd" d="M8 4.5a.5.5 0 0 1 .5.5v5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5z"/>
                </svg>
            </a>
        </h3>
        <div class="collapse" id="my-collapse-material">
            <#list materials as material>
                <@form.checkbox name="material" value=material.name() text=material.toString() />
            </#list>
         </div>
    </div>

    <div class="sortBy mb-2">
        <h3>
            <a data-toggle="collapse" href="#my-collapse-by" aria-expanded="false" aria-controls="my-collapse-by">
                <@spring.message code="filter.sortby"/>
                <svg class="bi bi-arrow-down-short" width="1em" height="1em" viewBox="0 0 16 16" fill="rgb(255, 193, 7)" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" d="M4.646 7.646a.5.5 0 0 1 .708 0L8 10.293l2.646-2.647a.5.5 0 0 1 .708.708l-3 3a.5.5 0 0 1-.708 0l-3-3a.5.5 0 0 1 0-.708z"/>
                    <path fill-rule="evenodd" d="M8 4.5a.5.5 0 0 1 .5.5v5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5z"/>
                </svg>
            </a>
        </h3>
        <div class="collapse" id="my-collapse-by">
            <div class="custom-control custom-radio">
                <input type="radio" id="byId" name="sortBy" value="id" class="custom-control-input">
                <label class="custom-control-label" for="byId"><@spring.message code="filter.id"/></label>
            </div>
            <div class="custom-control custom-radio">
                <input type="radio" id="byPrice" name="sortBy" value="price" class="custom-control-input">
                <label class="custom-control-label" for="byPrice"><@spring.message code="filter.price"/></label>
            </div>
            <div class="custom-control custom-radio">
                <input type="radio" id="byRating" name="sortBy" value="rating" class="custom-control-input">
                <label class="custom-control-label" for="byRating"><@spring.message code="filter.rating"/></label>
            </div>
        </div>
    </div>

    <div class="sortOrder mb-2">
        <h3>
            <a data-toggle="collapse" href="#my-collapse-order" aria-expanded="false" aria-controls="my-collapse-order">
                <@spring.message code="filter.sortorder"/>
                <svg class="bi bi-arrow-down-short" width="1em" height="1em" viewBox="0 0 16 16" fill="rgb(255, 193, 7)" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" d="M4.646 7.646a.5.5 0 0 1 .708 0L8 10.293l2.646-2.647a.5.5 0 0 1 .708.708l-3 3a.5.5 0 0 1-.708 0l-3-3a.5.5 0 0 1 0-.708z"/>
                    <path fill-rule="evenodd" d="M8 4.5a.5.5 0 0 1 .5.5v5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5z"/>
                </svg>
            </a>
        </h3>
        <div class="collapse" id="my-collapse-order">
            <div class="custom-control custom-radio">
                <input type="radio" id="sortDesc" name="sortOrder" value="DESC" class="custom-control-input">
                <label class="custom-control-label" for="sortDesc"><@spring.message code="filter.desc"/></label>
            </div>
            <div class="custom-control custom-radio">
                <input type="radio" id="sortAsc" name="sortOrder" value="ASC" class="custom-control-input">
                <label class="custom-control-label" for="sortAsc"><@spring.message code="filter.asc"/></label>
            </div>
        </div>
    </div>

    <button type="submit" class="btn btn-warning mt-2"><@spring.message code="filter"/></button>
</form>
</#macro>