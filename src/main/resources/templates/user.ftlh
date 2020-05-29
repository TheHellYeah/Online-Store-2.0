<#import "components/skeleton.ftlh" as html>
<#import "components/navbar.ftlh" as bootstrap>

<@html.skeleton title="ShoeHub: страница пользователя ${user.firstName}">
<@bootstrap.navbar/>
<div class="container">
    <h2>${user.firstName}</h2>
    <h2>${user.secondName}</h2>
    <h2>${user.patronymic}</h2>
</div>
</@html.skeleton>