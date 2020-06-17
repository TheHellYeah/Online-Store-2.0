<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="product.storage">
<@bootstrap.navbar/>
<input id="_csrf" type="hidden" name="_csrf" value="${_csrf.token}">
<div class="col-11 mt-4 mx-auto">
    <table id="storage" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th class="th-sm text-white">ID</th>
            <th class="th-sm text-white"><@spring.message code="name"/></th>
            <th class="th-sm text-white"><@spring.message code="price"/></th>
            <th class="th-sm text-white"><@spring.message code="rating"/></th>
            <th class="th-sm text-white sorting_disabled"><@spring.message code="category"/></th>
            <th class="th-sm text-white sorting_disabled"><@spring.message code="kind"/></th>
            <th class="th-sm text-white sorting_disabled"><@spring.message code="presence"/></th>

        </tr>
        </thead>
        <tbody>
            <#list products as product>
                <tr>
                    <td class="text-white" >${product.id}</td>
                    <td>
                        <a class="text-warning" href="/product/${product.id}" id="${product.id}">${product.name}</a>
                        <button class="btn btn-success btn-sm" onclick="editWindow(${product.id},'${product.name}')"  data-toggle="modal" data-target="#editName"><a class="text-dark" >
                            <svg class="bi bi-pencil" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd" d="M11.293 1.293a1 1 0 0 1 1.414 0l2 2a1 1 0 0 1 0 1.414l-9 9a1 1 0 0 1-.39.242l-3 1a1 1 0 0 1-1.266-1.265l1-3a1 1 0 0 1 .242-.391l9-9zM12 2l2 2-9 9-3 1 1-3 9-9z"/>
                                <path fill-rule="evenodd" d="M12.146 6.354l-2.5-2.5.708-.708 2.5 2.5-.707.708zM3 10v.5a.5.5 0 0 0 .5.5H4v.5a.5.5 0 0 0 .5.5H5v.5a.5.5 0 0 0 .5.5H6v-1.5a.5.5 0 0 0-.5-.5H5v-.5a.5.5 0 0 0-.5-.5H3z"/>
                            </svg>
                        </a></button>
                    </td>
                        <td class="text-white"><span class="${product.id}">${product.price}</span>
                        <button class="btn btn-success btn-sm" onclick="modalEditPrice(${product.id},'${product.price}')" data-toggle="modal" data-target="#editPrice">
                            <svg class="bi bi-pencil" width="1em" height="1em" viewBox="0 0 16 16" fill="#333333" xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd" d="M11.293 1.293a1 1 0 0 1 1.414 0l2 2a1 1 0 0 1 0 1.414l-9 9a1 1 0 0 1-.39.242l-3 1a1 1 0 0 1-1.266-1.265l1-3a1 1 0 0 1 .242-.391l9-9zM12 2l2 2-9 9-3 1 1-3 9-9z"/>
                                <path fill-rule="evenodd" d="M12.146 6.354l-2.5-2.5.708-.708 2.5 2.5-.707.708zM3 10v.5a.5.5 0 0 0 .5.5H4v.5a.5.5 0 0 0 .5.5H5v.5a.5.5 0 0 0 .5.5H6v-1.5a.5.5 0 0 0-.5-.5H5v-.5a.5.5 0 0 0-.5-.5H3z"/>
                            </svg>
                        </button>
                    </td>
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

                </tr>
            </#list>
        </tbody>
    </table>
</div>

<div id="editName" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title"><@spring.message code="edit.name.title"/></h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                    <p><@spring.message code="edit.name.old.name"/>:<p id="oldName"></p></p>
                    <input type="hidden" name="productId">
                    <p><@spring.message code="edit.name.new.name"/>:</p>
                    <input type="text" name="newName">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"><br><br><br>
            </div>
            <div class="modal-footer">
                <button class="btn btn-success" onclick="editName()" data-dismiss="modal"><@spring.message code="save"/></button>
                <button class="btn btn-danger" data-dismiss="modal"><@spring.message code="cancel"/></button>
            </div>
        </form>
        </div>
    </div>
</div>


<div id="editPrice" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title"><@spring.message code="edit.price.title"/></h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <p><@spring.message code="edit.price.old.price"/>:<p id="oldPrice"></p></p>
                <input type="hidden" name="productId">
                <p><@spring.message code="edit.price.new.price"/>:</p>
                <input type="number" min="0" max="999999" name="newPrice">
                <input type="hidden" name="_csrf" value="${_csrf.token}"><br><br><br>
            </div>
            <div class="modal-footer">
                <button class="btn btn-success" onclick="editPrice()" data-dismiss="modal"><@spring.message code="save"/></button>
                <button class="btn btn-danger" data-dismiss="modal"><@spring.message code="cancel"/></button>
            </div>
            </form>
        </div>
    </div>
</div>
<script src="/static/js/storage.js"></script>
</@component.skeleton>