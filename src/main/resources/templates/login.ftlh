<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="Вход в систему">
<@bootstrap.navbar/>
<div class="container col-4 mt-5">
    <#if message??>
        <div class="mb-3 p-2 border justify-content-center border-success">
            ${message}
        </div>
    </#if>
    <form action="/login" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div class="form-group">
            <label for="username">Имя пользователя</label>
            <input type="text" name="username" class="form-control" id="username"
                   placeholder="Введите имя пользователя" required>
        </div>
        <div class="form-group">
            <label for="password">Пароль</label>
            <input type="password" name="password" class="form-control" id="password" placeholder="Введите пароль" required>
        </div>
        <button type="submit" class="btn btn-warning">Войти</button>
        <a href="/registration">Регистрация</a>
    </form>
</div>
</@component.skeleton>