<#import "components/skeleton.ftlh" as html>
<#import "components/navbar.ftlh" as bootstrap>

<@html.skeleton title="ShoeHub: страница пользователя ${user.firstName}">
<@bootstrap.navbar/>
<div class="container">
    <div class="col-7 mt-4">
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
</div>
</@html.skeleton>