<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>
<#import "spring.ftl" as spring>

<@component.skeleton title="Склад товаров">
<@bootstrap.navbar/>
<input id="_csrf" type="hidden" name="_csrf" value="${_csrf.token}">
<div>
    <table class="table table-bordered table-hover">
        <thead>
        <tr>
            <th class="text-white">ID</th>
            <th class="text-white"><@spring.message code="name"/></th>
            <th class="text-white"><@spring.message code="price"/></th>
            <th class="text-white"><@spring.message code="rating"/></th>
            <th class="text-white"><@spring.message code="category"/></th>
            <th class="text-white"><@spring.message code="kind"/></th>
            <th class="text-white"><@spring.message code="presence"/></th>
            <th> </th>
        </tr>
        </thead>
        <tbody>
            <#list products as product>
                <tr>
                    <td class="text-white" >${product.id}</td>
                    <td>
                        <a class="text-warning" href="/product/${product.id}">${product.name}
                            <svg class="bi bi-box-arrow-down-left" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd" d="M13 1.5A1.5 1.5 0 0 1 14.5 3v8a1.5 1.5 0 0 1-1.5 1.5H9a.5.5 0 0 1 0-1h4a.5.5 0 0 0 .5-.5V3a.5.5 0 0 0-.5-.5H5a.5.5 0 0 0-.5.5v4a.5.5 0 0 1-1 0V3A1.5 1.5 0 0 1 5 1.5h8zm-11 7a.5.5 0 0 0-.5.5v5a.5.5 0 0 0 .5.5h5a.5.5 0 0 0 0-1H2.5V9a.5.5 0 0 0-.5-.5z"/>
                                <path fill-rule="evenodd" d="M1.646 14.354a.5.5 0 0 0 .708 0l8-8a.5.5 0 0 0-.708-.708l-8 8a.5.5 0 0 0 0 .708z"/>
                            </svg>
                        </a>
                    </td>
                    <td class="text-white">${product.price} ₽</td>
                    <td class="text-white">${product.rating}</td>
                    <td class="text-white">${product.category}</td>
                    <td class="text-white">${product.subcategory}</td>
                    <td>
                        <form action="/storage/addsize" method="post" >
                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                            <input type="hidden" name="id" value="${product.id}">
                            <table class="table table-hover mb-0">
                                <thead>
                                <tr>
                                    <#list product.sizes as size,count>
                                    <th  class="bg-dark text-white pt-1 pb-1">${size}</th>
                                    </#list>
                                </tr>
                                </thead>
                                <tbody>
                                <tr class="update-size">
                                    <#list product.sizes as size,count>
                                    <#if count gt 0>
                                        <#if count gt 15>
                                            <td class="p-0"><input class="bg-success text-dark" name="SIZE_${size}" type="number" min="0" max="9999" value="${count}"></td>
                                        <#else>
                                            <td class="p-0"><input class="bg-warning text-dark" name="SIZE_${size}" type="number" min="0" max="9999" value="${count}"></td>
                                        </#if>
                                    <#else>
                                        <td class="p-0"><input class="bg-danger text-dark" name="SIZE_${size}" type="number" min="0" max="9999" value="${count}"></td>
                                    </#if>
                                    </#list>
                                </tr>
                                </tbody>
                            </table>
                                    <button class=" mt-3 p-1 btn btn-success  btn-block"><@spring.message code="save"/></button>
                     </form>
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