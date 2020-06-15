<#import "components/skeleton.ftlh" as html>
<#import "components/navbar.ftlh" as bootstrap>

<@html.skeleton title="user.title">
<@bootstrap.navbar/>
<div class="container mt-3">
    <#if missing??>
        <h3><@spring.message code="user.profile.missing"/><br><a href="/" style="font-size: 20px;"><@spring.message code="user.profile.main"/></a></h3>
    <#else>
    <div class="row">
        <div class="col-2">
            <img src="/avatars/${user.avatar}" class="img-thumbnail">
        </div>
        <div class="col-7 ">
            <h3><@spring.message code="user.profile.username"/> <span class="text-warning">${user.username}</span></h3>
            <h3>${user.secondName} ${user.firstName} ${user.patronymic!}</h3>
            <a href="/user/${user.id}/wishlist"><@spring.message code="user.profile.wishlist"/></a><br/>
            <#if currentUser??>
                <a href="/user/settings"><@spring.message code="user.profile.settings"/></a>
            </#if>
        </div>
    </div>
    </#if>
</div>
</@html.skeleton>