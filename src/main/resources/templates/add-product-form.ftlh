<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>


<@component.skeleton title="ShoeHub - интернет магазин обуви для всей семьи!">
<@bootstrap.navbar/>
<div class="container">
    <div class="form-group mt-5">
        <form action="/product/add" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <div class="form-group">
                <label>Наименование товара:</label>
                <input name="name" type="text">
            </div>
            <div class="form-group">
                <label>Описание товара: </label>
                <textarea name="description"></textarea>
            </div>
            <div class="form-group">
                <label>Стоимость товара: </label>
                <input name="price" type="number" min="0" max="100000">
            </div>
            <div class="form-group">
                <label>Бренд:</label>
                <select name="brand">
                    <option disabled>Выберите бренд</option>
                    <option value="NIKE">Nike</option>
                    <option value="ADIDAS">Adidas</option>
                    <option value="RIEKER">Rieker</option>
                    <option value="PUMA">Puma</option>
                    <option value="RALPH_RINGER">Ralph Ringer</option>
                </select>
            </div>
            <div class="form-group">
                <label>Категория обуви:</label>
                <select name="category">
                    <option disabled>Выберите категорию</option>
                    <option value="MALE">Мужская</option>
                    <option value="FEMALE">Женская</option>
                    <option value="CHILD">Детская</option>
                </select>
            </div>
            <div class="form-group">
                <label>Вид обуви:</label>
                <select name="subcategory">
                    <option disabled>Выберите вид</option>
                    <option value="SNEAKERS">Кроссовки</option>
                    <option value="GYMSHOES">Спортивная обувь</option>
                    <option value="LOW_SHOES">Полуботинки</option>
                    <option value="SANDALS">Сандалии</option>
                    <option value="SLIPPERS">Тапочки</option>
                </select>
            </div>
            <div class="form-group">
                <label>Сезон:</label>
                <select name="season">
                    <option disabled>Выберите сезон</option>
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
            <button type="submit" class="btn btn-primary mb-2">Добавить товар</button>
        </form>
    </div>
</div>
</@component.skeleton>