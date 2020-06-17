<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="form.login">
<@bootstrap.navbar/>
<div class="container col-4 mt-5">
    <#if message??>
        <div class="mb-3 p-2 border justify-content-center border-white">
            ${message}
        </div>
    </#if>
    <#if RequestParameters.error??>
        <div class="invalid-feedback">
            <@spring.message code="login.error"/>
        </div>
    </#if>
    <form action="/login" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div class="form-group">
            <label for="username"><@spring.message code="login.name"/></label>
            <input type="text" name="username" class="form-control" id="username"
                   placeholder='<@spring.message code="login.name.placeholder"/>' required>
        </div>
        <div class="form-group">
            <label for="password"><@spring.message code="login.password"/></label>
            <input type="password" name="password" class="form-control" id="password" placeholder='<@spring.message code="login.password.placeholder"/>' required>
        </div>
        <div class="form-check mb-1">
            <input type="checkbox" name="remember-me" class="form-check-input" id="remember">
            <label class="form-check-label" for="remember"><@spring.message code="login.remember"/></label>
        </div>
        <button type="submit" class="btn btn-warning mb-1"><@spring.message code="login.button"/></button>
        <p style="color: white;"><@spring.message code="login.acc"/> <a href="/registration"><@spring.message code="login.href.registration"/></a></p>
    </form>
</div>
</@component.skeleton>