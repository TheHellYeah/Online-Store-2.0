<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>
<#import "components/validation-error.ftlh" as v>

<@component.skeleton title="form.registration">
<@bootstrap.navbar/>
<div class="container">
    <form class="mt-5 mb-5" action="/registration" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div class="form-group">
            <label for="username"><@spring.message code="login.name"/></label>
            <input type="text" name="username" class="form-control" id="username"
                   placeholder='<@spring.message code="login.name.placeholder"/>'>
            <@v.validation usernameError! />
        </div>
        <div class="form-group">
            <label for="password"><@spring.message code="login.password"/></label>
            <input type="password" name="password" class="form-control" id="password" placeholder='<@spring.message code="login.password.placeholder"/>'>
            <@v.validation passwordError! />
        </div>
        <div class="form-group">
            <label for="passwordConfirmation"><@spring.message code="reg.password.confirm"/></label>
            <input type="password" name="passwordConfirmation" class="form-control" id="passwordConfirmation"
                   placeholder='<@spring.message code="reg.password.confirm"/>'>
            <@v.validation passwordConfirmationError! />
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" name="email" class="form-control" id="email"
                   placeholder='<@spring.message code="reg.email.placeholder"/>'>
            <@v.validation emailError! />
        </div>
        <div class="form-group">
            <label for="firstName"><@spring.message code="reg.firstname"/></label>
            <input type="text" name="firstName" class="form-control" id="firstName"
                   placeholder='<@spring.message code="reg.firstname.placeholder"/>'>
            <@v.validation firstNameError! />
        </div>
        <div class="form-group">
            <label for="secondName"><@spring.message code="reg.secondname"/></label>
            <input type="text" name="secondName" class="form-control" id="secondName"
                   placeholder='<@spring.message code="reg.secondname.placeholder"/>'>
            <@v.validation secondNameError! />
        </div>
        <div class="form-group">
            <label for="patronymic"><@spring.message code="reg.patronymic"/></label>
            <input type="text" name="patronymic" class="form-control" id="patronymic"
                   placeholder='<@spring.message code="reg.patronymic.placeholder"/>'>
            <@v.validation patronymicError! />
        </div>
        <div class="form-group">
            <label for="date"><@spring.message code="reg.birthday"/></label>
            <input type="date" name="birthday" class="form-control" id="date">
            <@v.validation birthdayError! />
        </div>
        <button type="submit" class="btn btn-warning"><@spring.message code="login.href.registration"/></button>
        <a href="/"><@spring.message code="home"/></a>
    </form>
</div>
</@component.skeleton>