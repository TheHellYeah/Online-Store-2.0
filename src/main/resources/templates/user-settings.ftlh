<#import "components/skeleton.ftlh" as html>
<#import "components/navbar.ftlh" as bootstrap>

<@html.skeleton title="Настройки пользователя">
<@bootstrap.navbar/>

<div class="container">
    <form class="mt-3 mb-5 ml-5" action="/user/settings" method="post">
        <h3><@spring.message code="user.settings.header"/> <a href="/user/${user.id}" style="font-size: 18px;">
            <@spring.message code="user.settings.back"/></a></h3>

        <input type="hidden" name="_csrf" value="${_csrf.token}">

        <div class="form-group w-50">
            <label for="avatar"><@spring.message code="user.settings.avatar"/></label>
            <div class="form-group">
                <div class="custom-file">
                    <input type="file" name="avatar" class="custom-file-input form-control-file" id="avatar" accept="image">
                    <label class="custom-file-label" for="avatar"><@spring.message code="user.settings.avatar.select"/></label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label><@spring.message code="user.settings.wishlist"/></label>
            <p class="text-white"><@spring.message code="user.settings.wishlist.description"/></p>
            <div class="btn-group btn-group-toggle wish-list-access" data-toggle="buttons">
                <#if user.isWishListPublic()>
                    <label class="btn btn-secondary active">
                        <input type="radio" name="access" value="PUBLIC" autocomplete="off" checked>
                        <@spring.message code="user.settings.wishlist.public"/>
                    </label>
                    <label class="btn btn-secondary">
                        <input type="radio" name="access" value="PRIVATE" autocomplete="off">
                        <@spring.message code="user.settings.wishlist.private"/>
                    </label>
                <#else>
                    <label class="btn btn-secondary">
                        <input type="radio" name="access" value="PUBLIC" autocomplete="off">
                        <@spring.message code="user.settings.wishlist.public"/>
                    </label>
                    <label class="btn btn-secondary active">
                        <input type="radio" name="access" value="PRIVATE" autocomplete="off" checked>
                        <@spring.message code="user.settings.wishlist.private"/>
                    </label>
                </#if>
            </div>
        </div>
        <button type="submit" class="btn btn-warning"><@spring.message code="user.settings.save"/></button>
    </form>
</div>
</@html.skeleton>