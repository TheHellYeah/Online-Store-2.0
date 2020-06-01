<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="Избранное">
<@bootstrap.navbar/>
<div class="container mt-5">
    <div  class="col-9 m-auto ">
        <div class="row bg-dark">
            <div class="input-group m-2 ">
                <input type="text" class="form-control" placeholder="Поиск">
                <div class="input-group-append">
                    <button class="btn btn-outline-secondary bg-warning" type="button" id="button-addon2">
                        Поиск
                    </button>
                </div>
                <select class="form-control ml-5">
                    <option value="">Все</option>
                    <option value="">Покупатели</option>
                    <option value="">Продавцы</option>
                    <option value="">Администраторы</option>
                </select>
            </div>
        </div>
    </div>
    <div>
        <table>
            <thead>
                <tr>
                    <th>Логин</th>
                    <th>ФИ</th>
                    <th>Почта</th>
                    <th>Баланс</th>
                    <th>Роль</th>
                    <th>Удалить</th>
                </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>

</div>





</@component.skeleton>