<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="Оформление заказа">
<@bootstrap.navbar/>

<div>
    <form class="" action="/user/order/create" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div>ФИО получателя:
            <label>Фамилия<input name="contact" type="text" value="${user.firstName}"></label>
            <label>Имя<input name="contact" type="text" value="${user.secondName}"></label>
            <label>отчество<input name="contact" type="text" value="${user.patronymic}"></label>
        </div>

        <div>Телефон получателя:
           <input name="contact" type="text" value="">
        </div>
        <div>Адрес получателя:
            <label><textarea name="contact" ></textarea></label>
        </div>

        <div>Товары:
            <table>
                <thead>
                    <tr>
                        <th>Товар</th>
                        <th>Размер</th>
                        <th>Стоимость</th>
                        <th>Количество</th>
                    </tr>
                </thead>
                <tbody>
                <#list cart as product, amount>
                    <tr>
                        <th>${product.name}</th>
                        <th>${product.name}</th>
                        <th>${product.price}</th>
                        <th>${amount}</th>
                    </tr>
                </#list>
                </tbody>
            </table>
            <div>
                Итоговая стоимость: <p id="price"></p>
            </div>
        </div>





        <button>ОФОРМИТЬ</button>
    </form>
</div>


</@component.skeleton>