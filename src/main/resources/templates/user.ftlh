<#import "components/skeleton.ftlh" as html>
<#import "components/navbar.ftlh" as bootstrap>

<@html.skeleton title="ShoeHub: страница пользователя">
<@bootstrap.navbar/>
<div class="container mt-3">
    <#if missing??>
        <h3>Пользователя не найдено<br><a href="/" style="font-size: 20px;">На главную</a></h3>
    <#else>
        <div class="col-7">
            <label>${user.username}</label>
            <label>${user.balance}</label>
            <label>${user.email}</label>
            <div class="border">
                <label>Имя <input type="text" value="${user.firstName}"></label>
                <label>Фамилия <input type="text" value="${user.secondName}"></label>
                <label>Отчество <input type="text" value="${user.patronymic}"></label>
                <button>Изменить</button>
            </div>
        </div>
    </#if>
</div>
</@html.skeleton>