<html>
<head></head>
<h3>ShoeHub</h3>
<body>
    <p>Здравствуйте, ${order.getUser().getFirstName()} ${order.getUser().getSecondName()},</p>
    <p>Вы успешно создали заказ, мы доставим его в течении 5-7 рабочих дней</p>
    <p>Ваш заказ </p>
    <#list order.getProducts() as cartItem>
        <p>${cartItem.product.name} - ${cartItem.size}  x ${cartItem.amount}</p>
    </#list>
    <p>Стоимость ${order.total}</p>
</body>

</html>