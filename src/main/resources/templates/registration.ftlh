<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="Регистрация">
<@bootstrap.navbar/>
<div class="container">
    <form class="mt-5" action="/registration" method="post">
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
        <div class="form-group">
            <label for="passwordConfirmation">Повторите пароль</label>
            <input type="password" name="passwordConfirmation" class="form-control" id="passwordConfirmation"
                   placeholder="Повторите пароль" required>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" name="email" class="form-control" id="email"
                   placeholder="Введите адрес электронной почты" required>
        </div>
        <div class="form-group">
            <label for="firstName">Имя</label>
            <input type="text" name="firstName" class="form-control" id="firstName"
                   placeholder="Введите ваше имя" required>
        </div>
        <div class="form-group">
            <label for="secondName">Фамилия</label>
            <input type="text" name="secondName" class="form-control" id="secondName"
                   placeholder="Введите вашу фамилию" required>
        </div>
        <div class="form-group">
            <label for="patronymic">Отчество</label>
            <input type="text" name="patronymic" class="form-control" id="patronymic"
                   placeholder="Введите ваше отчество">
        </div>
        <button type="submit" class="btn btn-primary">Регистрация</button>
        <a href="/">На главную</a>
    </form>
</div>
</@component.skeleton>