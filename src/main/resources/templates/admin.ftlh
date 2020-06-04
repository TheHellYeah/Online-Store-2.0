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
    <#if users??>
        <div>
            <table class="table table-dark table-hover mt-3">
                <thead>
                    <tr>
                        <th>Логин</th>
                        <th>Почта</th>
                        <th>Баланс</th>
                        <th>Роль</th>
                    </tr>
                </thead>
                <tbody>
                    <#list users as user>
                        <tr>
                            <td><a href="/user/${user.id}">${user.username}</a></td>
                            <td>${user.email}</td>
                            <td>${user.balance}</td>
                            <td>А</td>
                        </tr>
                    </#list>
                </tbody>
            </table>
        </div>
    </#if>
</div>
<script src="/static/js/admin.js"></script>
</@component.skeleton>