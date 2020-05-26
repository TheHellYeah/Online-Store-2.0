<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="Регистрация">
<@bootstrap.navbar/>
<div class="container">
    <form action="/registration" method="post">
        <div>
            <label> Логин: <input type="text" placeholder="Введите логин"/></label>
        </div>
        <div>
            <label> Пароль: <input type="password" placeholder="Введите пароль"/></label>
        </div>
        <div>
            <label> Повторите пароль: <input type="password" placeholder="Повторите пароль"/></label>
        </div>
        <div>
            <label> Email: <input type="email" placeholder="Введите email"/></label>
        </div>
        <div>
            <label> Имя: <input type="text" placeholder="Введите ваше имя"/></label>
        </div>
        <div>
            <label> Фамилия: <input type="text" placeholder="Введите вашу фамилю"/></label>
        </div>
        <div>
            <label> Отчество: <input type="text" placeholder="Введите ваше отчество"/></label>
        </div>
        <div>
            <label> Дата рождения: <input type="date"/></label>
        </div>
        <div>
            <input type="submit" value="Войти"/>
        </div>
        <a href="/">На главную</a>
    </form>
</div>
</@component.skeleton>