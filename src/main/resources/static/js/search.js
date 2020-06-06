const URL = `http://localhost:8080`
let searchForm;

window.onload = function() {

    searchForm = document.querySelector('#search');

    searchForm.addEventListener('input', function() {
         setTimeout(searchHandler, 500)
    });

    document.querySelector('.search-group button').addEventListener('click', clickHandler)
}

function searchHandler() {

    let select = document.querySelector('#productList');

    let xhr = new XMLHttpRequest();
    xhr.open('POST', '/search', true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.setRequestHeader(header, token);
    xhr.send("name=" + searchForm.value);

    xhr.onload = function() {
        let products = JSON.parse(xhr.response);
//        select.options.length = 0;
//        if(products.length != 0) {
//            products.forEach(product => {
//                let option = document.createElement('option');
//                option.innerHTML = `<a href="/product/${product.id}">${product.name}</a>`;
//                select.append(option);
//            })
//        } else {
//            let option = document.createElement('option');
//            option.innerHTML = 'Товаров не найдено';
//            select.append(option);
//        }
    }
}

function clickHandler() {
     window.location.href = URL + `/search?name=${searchForm.value}`
}