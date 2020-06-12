<html>
<head><h3>ShoeHub</h3></head>
<body>
    <p>${bundle.getString("email.hi")}, ${user.getUsername()}!</p>
    <p>${bundle.getString("email.welcome")} <b>ShoeHub</b></p>
    <p>${bundle.getString("email.activation")}:</p>
    <p><a href="${user.getActivationCode()}">Тут будет рабочая ссылка</a></p>
    <p>${bundle.getString("email.or")}</p>
    <p>${user.getActivationCode()}</p>


    <p>${bundle.getString("email.thanks")}.</p>
</body>

</html>

