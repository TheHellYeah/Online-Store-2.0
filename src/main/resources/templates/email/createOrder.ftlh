<html>
<head></head>
<h3>ShoeHub</h3>
<body>
    <p>${bundle.getString("email.hi")}, ${order.getUser().getUsername()}!</p>
    <p>${bundle.getString("email.create")}.</p>
    <p>${bundle.getString("email.your.order")}:</p>
    <#list order.getProducts() as cartItem>
        <p>${cartItem.product.name} - ${cartItem.size}  x ${cartItem.amount}</p>
    </#list>
    <p>${bundle.getString("email.total")}: ${order.total}</p>
</body>

</html>