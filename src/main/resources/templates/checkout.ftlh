<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>
<#import "/spring.ftl" as spring>
<@component.skeleton title="Оформление заказа">
<@bootstrap.navbar/>

<div class="container">
    <#if message??>
    <#if message=="error">
        <div class="alert alert-danger" role="alert">
            <@spring.message code="check.alert"/>
        </div>
    </#if></#if>
    <form class="mt-3 mb-5" action="/user/order/checkout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <h3><@spring.message code="check.addressee"/></h3>
        <div class="form-group">
            <label for="firstName"><@spring.message code="check.firstname"/></label>
            <input type="text" name="contact" class="form-control" id="firstName" value="${user.firstName}"
                   placeholder='<@spring.message code="check.firstname.placeholder"/>'>
        </div>
        <div class="form-group">
            <label for="secondName"><@spring.message code="check.secondname"/></label>
            <input type="text" name="contact" class="form-control" id="secondName" value="${user.secondName}"
                   placeholder='<@spring.message code="check.secondname.placeholder"/>'>
        </div>
        <div class="form-group">
            <label for="patronymic"><@spring.message code="check.patronymic"/></label>
            <input type="text" name="contact" class="form-control" id="patronymic" value="${user.patronymic}"
                   placeholder='<@spring.message code="check.patronymic.placeholder"/>'>
        </div>
        <div class="form-group">
            <label for="contact"><@spring.message code="order.phone"/></label>
            <input type="text" name="phone" class="form-control" id="contact"
                   placeholder='<@spring.message code="check.prone.placeholder"/>'>
        </div>
        <div class="form-group">
            <label for="address"><@spring.message code="check.address"/></label>
            <input type="text" name="address" class="form-control" id="address"
                   placeholder='<@spring.message code="check.address.placeholder"/>'>
        </div>
        <div class="form-group">
            <label for="payment"><@spring.message code="type.of.payment"/></label>
            <select class="form-control" name="payment" id="payment">
                <option disabled selected><@spring.message code="check.select.type.of.payment"/></option>

                <option value="CASH"><@spring.message code="check.cash"/></option>
                <option value="BALANCE"><@spring.message code="check.balance"/></option>

            </select>
        </div>
        <h3 class="text-white"><@spring.message code="check.total"/>: ${total} ₽</h3>
        <button type="submit" class="btn btn-warning"><@spring.message code="check.button"/></button>
    </form>
</div>
</@component.skeleton>