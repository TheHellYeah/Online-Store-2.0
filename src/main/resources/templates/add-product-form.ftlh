<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="Добавление продукта">
<@bootstrap.navbar/>

<div class="container">
    <form class="mt-3 mb-5" action="/product/add" method="post" enctype="multipart/form-data">
        <h3>Данные о товаре</h3>
        <input type="hidden" name="_csrf" value="${_csrf.token}">

        <div class="form-group">
            <label for="name">Название</label>
            <input type="text" name="name" class="form-control" id="name"
                   placeholder="Введите название товара">
        </div>

        <div class="form-group">
            <label for="description">Описание</label>
            <textarea name="description" class="form-control" id="description"
                      placeholder="Введите описание товара"></textarea>
        </div>

        <div class="form-group">
            <label for="price">Цена</label>
            <input type="number" name="price" class="form-control" id="price"
                      placeholder="Введите цену товара">
        </div>

        <div class="form-group">
            <label for="files">Фотографии</label>
            <div class="form-group">
                <div class="custom-file">
                    <input type="file" multiple="multiple" class="custom-file-input form-control-file" id="files" accept="image">
                    <label class="custom-file-label" for="files">Выберите файлы</label>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label for="brand">Бренд:</label>
            <select class="form-control" name="brand" id="brand">
                <option disabled selected>Выберите бренд</option>
                <option value="NIKE">Nike</option>
                <option value="ADIDAS">Adidas</option>
                <option value="RIEKER">Rieker</option>
                <option value="PUMA">Puma</option>
                <option value="RALPH_RINGER">Ralph Ringer</option>
            </select>
        </div>

        <div class="form-group">
            <label for="category">Категория обуви:</label>
            <select class="form-control" name="category" id="category">
                <option disabled selected>Выберите категорию</option>
                <option value="MALE">Мужская</option>
                <option value="FEMALE">Женская</option>
                <option value="CHILD">Детская</option>
            </select>
        </div>

        <div class="form-group">
            <label for="subcategory">Вид обуви:</label>
            <select class="form-control" name="subcategory" id="subcategory">
                <option disabled selected>Выберите вид</option>
                <option value="SNEAKERS">Кроссовки</option>
                <option value="GYMSHOES">Спортивная обувь</option>
                <option value="LOW_SHOES">Полуботинки</option>
                <option value="SANDALS">Сандалии</option>
                <option value="SLIPPERS">Тапочки</option>
            </select>
        </div>

        <div class="form-group">
            <label for="season">Сезон:</label>
            <select class="form-control" name="season" id="season">
                <option disabled selected>Выберите сезон</option>
                <option value="SUMMER">Лето</option>
                <option value="AUTUMN">Осень</option>
                <option value="WINTER">Зима</option>
                <option value="SPRING">Весна</option>
            </select>
        </div>

        <div class="form-group">
            <label>Количество товара на вашем складе:</label>
            <table>
                <thead>
                <tr>
                    <th>Размер</th>
                    <th>Количество</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>30</td>
                    <td><input name="SIZE" type="number" min="0" max="9999" value="0"></td>
                </tr>
                <tr>
                    <td>31</td>
                    <td><input name="SIZE" type="number" min="0" max="9999" value="0"></td>
                </tr>
                <tr>
                    <td>32</td>
                    <td><input name="SIZE" type="number" min="0" max="9999" value="0"></td>
                </tr>
                <tr>
                    <td>33</td>
                    <td><input name="SIZE" type="number" min="0" max="9999" value="0"></td>
                </tr>
                <tr>
                    <td>34</td>
                    <td><input name="SIZE" type="number" min="0" max="9999" value="0"></td>
                </tr>
                <tr>
                    <td>35</td>
                    <td><input name="SIZE" type="number" min="0" max="9999" value="0"></td>
                </tr>
                <tr>
                    <td>36</td>
                    <td><input name="SIZE" type="number" min="0" max="9999" value="0"></td>
                </tr>
                <tr>
                    <td>37</td>
                    <td><input name="SIZE" type="number" min="0" max="9999" value="0"></td>
                </tr>
                <tr>
                    <td>38</td>
                    <td><input name="SIZE" type="number" min="0" max="9999" value="0"></td>
                </tr>
                <tr>
                    <td>39</td>
                    <td><input name="SIZE" type="number" min="0" max="9999" value="0"></td>
                </tr>
                <tr>
                    <td>40</td>
                    <td><input name="SIZE" type="number" min="0" max="9999" value="0"></td>
                </tr>
                <tr>
                    <td>41</td>
                    <td><input name="SIZE" type="number" min="0" max="9999" value="0"></td>
                </tr>
                <tr>
                    <td>42</td>
                    <td><input name="SIZE" type="number" min="0" max="9999" value="0"></td>
                </tr>
                <tr>
                    <td>43</td>
                    <td><input name="SIZE" type="number" min="0" max="9999" value="0"></td>
                </tr>
                <tr>
                    <td>44</td>
                    <td><input name="SIZE" type="number" min="0" max="9999" value="0"></td>
                </tr>
                <tr>
                    <td>45</td>
                    <td><input name="SIZE" type="number" min="0" max="9999" value="0"></td>
                </tr>
                <tr>
                    <td>46</td>
                    <td><input name="SIZE" type="number" min="0" max="9999" value="0"></td>
                </tr>
                <tr>
                    <td>47</td>
                    <td><input name="SIZE" type="number" min="0" max="9999" value="0"></td>
                </tr>
                </tbody>
            </table>
        </div>
        <button type="submit" class="btn btn-warning">Добавить товар</button>
    </form>
</div>
</@component.skeleton>