<#assign
    known = Session.SPRING_SECURITY_CONTEXT??
>
<#if known>
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal.getUser()
        name = user.getUsername()
        userId = user.getId()
        admin = user.isAdmin()
        seller = user.isSeller()
>
</#if>