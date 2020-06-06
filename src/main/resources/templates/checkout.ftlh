<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="Оформление заказа">
<@bootstrap.navbar/>

<div class="container">
    <form class="mt-3 mb-5" action="/user/order/create" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <h3>Введите данные получателя</h3>
        <div class="form-group">
            <label for="firstName">Имя</label>
            <input type="text" name="contact" class="form-control" id="firstName" value="${user.firstName}"
                   placeholder="Введите имя получателя">
        </div>
        <div class="form-group">
            <label for="secondName">Фамилия</label>
            <input type="text" name="contact" class="form-control" id="secondName" value="${user.secondName}"
                   placeholder="Введите фамилию получателя">
        </div>
        <div class="form-group">
            <label for="patronymic">Отчество</label>
            <input type="text" name="contact" class="form-control" id="patronymic" value="${user.patronymic}"
                   placeholder="Введите отчество получателя">
        </div>
        <div class="form-group">
            <label for="contact">Телефон</label>
            <input type="text" name="phone" class="form-control" id="contact"
                   placeholder="Введите номер телефона получателя">
        </div>
        <div class="form-group">
            <label for="address">Адрес</label>
            <input type="text" name="address" class="form-control" id="address"
                   placeholder="Введите полный адрес">
        </div>
        <h3 class="text-white">Итого: ${total} ₽</h3>
        <button type="submit" class="btn btn-warning">Оформить заказ</button>
    </form>
</div>
</@component.skeleton>