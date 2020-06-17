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
        <div class="col-10 ">
            <h3><@spring.message code="user.profile.username"/>
                <span class="text-warning">${user.username}</span> -
                <span>
                    <#list user.roles as role>
                        ${role.toString()}<#sep>,
                    </#list>
                </span>
            </h3>
            <h3>${user.secondName} ${user.firstName} ${user.patronymic!}</h3>
            <#if user.contactInfo??>
                <h3 style="font-size: 22px;">Контактная информация пользователя: ${user.contactInfo}</h3>
            </#if>
            <a href="/user/${user.id}/wishlist" style="font-size: 22px;"><@spring.message code="user.profile.wishlist"/></a><br/>
            <#if currentUser??>
                <a href="/user/settings" style="font-size: 22px;"><@spring.message code="user.profile.settings"/></a>
            </#if>
        </div>
    </div>
    </#if>
</div>
</@html.skeleton>