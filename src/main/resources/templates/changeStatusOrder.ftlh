<html>
<head></head>
<h3>ShoeHub</h3>
<body>
    <p>Здравствуйте, ${order.getUser().getFirstName()} ${order.getUser().getSecondName()},</p>
    <p>Статус вашего заказа изменен. Новый статус: ${order.orderStatus}</p>

    <#list order.getProducts() as cartItem>
        <p>${cartItem.product.name} - ${cartItem.size}  x ${cartItem.amount}</p>
    </#list>
    <p>Спасибо что вы с нами!</p>

</body>

</html>