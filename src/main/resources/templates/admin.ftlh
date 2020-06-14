<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>
<#import "/spring.ftl" as spring>
<@component.skeleton title="Панель администратора">
<@bootstrap.navbar/>
<div class="container mt-3">
    <div  class="col-9 m-auto ">
        <div class="row bg-dark">
<!--            <div class="input-group m-2 ">-->
<!--                <input type="text" class="form-control" placeholder="<@spring.message code="search"/>">-->
<!--                <div class="input-group-append">-->
<!--                    <button class="btn btn-outline-secondary bg-warning" type="button" id="button-addon2">-->
<!--                        <@spring.message code="search"/>-->
<!--                    </button>-->
<!--                </div>-->
<!--                <select class="form-control ml-5">-->
<!--                    <option><@spring.message code="all"/></option>-->
<!--                    <#list roles as role>-->
<!--                    <option value="${role.name()}">${role.toString()}</option>-->
<!--                    </#list>-->


<!--                </select>-->
<!--            </div>-->
        </div>
    </div>
    <#if users?has_content>
        <table id="users" class="table table-dark table-hover mt-3">
            <thead>
                <tr>
                    <th><@spring.message code="login"/></th>
                    <th class="sorting_disabled"><@spring.message code="email"/></th>
                    <th class="sorting_disabled"><@spring.message code="balance"/></th>
                    <th class="sorting_disabled"><@spring.message code="role"/></th>
                    <th class="sorting_disabled"></th>
                </tr>
            </thead>
            <tbody>
                <#list users as user>
                    <tr style="cursor: pointer;">
                        <td><a href="/user/${user.id}">${user.username}</a></td>
                        <td>${user.email}</td>
                        <td class="">
                            <label class="sr-only" for="${user.id}">₽</label>
                            <div class="input-group">

                                <input type="number" class="form-control bg-warning col-3 wr-1 p-0" id="${user.id}" value="${user.balance}" min="0" max="999999" step="50">
                                <div class="input-group-append">
                                    <div class="input-group-text">₽</div>
                                </div>
                                <button class="btn btn-success" onclick="editBalance(${user.id})"><@spring.message code="user.settings.save"/></button>

                            </div>
                        </td>
                        <td>
                            <#list user.roles as role>
                                ${role.toString()}<br>
                            </#list>
                        </td>
                        <td><#if user.isSeller()>
                            <button class="btn btn-danger" onclick="dismiss(${user.id})"><@spring.message code="dismiss"/></button>
                            <#else>
                            <button class="btn btn-success" onclick="appoint(${user.id})"><@spring.message code="appoint"/></button>
                            </#if>


                        </td>
                    </tr>
                </#list>
            </tbody>
        </table>
    </#if>
</div>
<script src="/static/js/admin.js"></script>
</@component.skeleton>