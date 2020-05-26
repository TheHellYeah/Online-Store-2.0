<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="Корзина">
<@bootstrap.navbar/>
<div class="site-main container">
    <div class="row">
        <main class="site-content col-xs-12 col-md-12 col-sm-12" itemscope="itemscope" itemprop="mainContentOfPage">
            <div class="page-content entry-content">
                <form class="woocommerce-cart-form" action="" method="post"> //FIXME адрес для оформления заказа
                    <table class="table">
                        <thead>
                        <tr>
                            <th>Продукт</th>
                            <th>Количество</th>
                            <th>Цена</th>
                            <th>Просмотр</th>
                            <th>Удалить</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>Крутые найки</td>
                            <td><input type="number" min="0" value="12"></td>
                            <td>20000</td>
                            <td><input type="submit" class="btn btn-primary" href="" value="Просмотр"></td>
                            <td><input type="submit" class="btn btn-primary" href="" value="Удалить"></td>
                        </tr>
                        </tbody>
                    </table>
                    <div class="row float-right">
                        <span>Тотал: 9999$</span>
                        <button class="btn btn-primary ml-5 " > Оформить заказ</button>
                    </div>
                </form>
            </div>
        </main>
    </div>
</div>
</@component.skeleton>