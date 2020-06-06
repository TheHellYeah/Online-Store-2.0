<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="Избранное">
<@bootstrap.navbar/>
<div class="container mt-3">
    <div  class="col-9 m-auto ">
        <div class="row bg-dark">
            <div class="input-group m-2 ">
                <input type="text" class="form-control" placeholder="Поиск">
                <div class="input-group-append">
                    <button class="btn btn-outline-secondary bg-warning" type="button" id="button-addon2">
                        Поиск
                    </button>
                </div>
                <select class="form-control ml-5">
                    <option>Все</option>
                    <option value="CUSTOMER">Покупатели</option>
                    <option value="SELLER">Продавцы</option>
                    <option value="ADMIN">Администраторы</option>
                </select>
            </div>
        </div>
    </div>
    <#if users?has_content>
        <table class="table table-dark table-hover mt-3">
            <thead>
                <tr>
                    <th>Логин</th>
                    <th>Почта</th>
                    <th>Баланс</th>
                    <th>Роли</th>
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
                            <button class="btn btn-danger" onclick="dismiss(${user.id})">Уволить</button>
                            <#else>
                            <button class="btn btn-success" onclick="appoint(${user.id})">Назначить продацом</button>
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