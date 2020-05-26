<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="ShoeHub - интернет магазин обуви для все семьи!">
<@bootstrap.navbar/>
<div class="container">
    <ul>
        <h1>Здравствуйте</h1>
            <li>
                <div class="product">
                    <p>Картошка</p>
                    <p>100</p>
                    <p>Адидас</p>
                </div>
            </li>
        <form action="/logout" method="post">
            <input type="submit" value="Выйти из аккаунта"/>
        </form>
    </ul>
</div>
</@component.skeleton>