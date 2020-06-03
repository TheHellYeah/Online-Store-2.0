<#macro product products, idForCollapse>

<div class="accordion " id="accordionExample">
<div class="card">
    <div class="card-header" id="headingThree">
        <h2 class="mb-0">
            <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapse${idForCollapse}" aria-expanded="false" aria-controls="collapseThree">
               Товары
            </button>
        </h2>
    </div>
    <div id="collapse${idForCollapse}" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
        <div class="card-body">
            <#list products as product, count>
                <label class="label w-100">
                    <a href="/product/${product.id}">${product.name}</a> - x ${count}
                </label>
        </#list>
        </div>
    </div>
</div>
</div>
</#macro>