<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>
<#import "/spring.ftl" as spring>
<@component.skeleton title="Панель администратора">
<@bootstrap.navbar/>
<div class="container mt-3">
    <div  class="col-9 m-auto ">
        <div class="row bg-dark">
            <div class="input-group m-2 ">
                <input type="text" class="form-control" placeholder="<@spring.message code="search"/>">
                <div class="input-group-append">
                    <button class="btn btn-outline-secondary bg-warning" type="button" id="button-addon2">
                        <@spring.message code="search"/>
                    </button>
                </div>
                <select class="form-control ml-5">
                    <option><@spring.message code="all"/></option>
                    <#list roles as role>
                    <option value="${role.name()}">${role.toString()}</option>
                    </#list>


                </select>
            </div>
        </div>
    </div>
    <#if users?has_content>
        <table class="table table-dark table-hover mt-3">
            <thead>
                <tr>
                    <th><@spring.message code="login"/></th>
                    <th><@spring.message code="email"/></th>
                    <th><@spring.message code="balance"/></th>
                    <th><@spring.message code="role"/></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <#list users as user>
                    <tr style="cursor: pointer;">
                        <td><a href="/user/${user.id}">${user.username}</a></td>
                        <td>${user.email}</td>
                        <td>${user.balance} ₽</td>
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