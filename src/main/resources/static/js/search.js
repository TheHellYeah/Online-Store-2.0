let searchForm, dropdown;

document.addEventListener("DOMContentLoaded", function() {

    dropdown = document.querySelector('#search-items')
    searchForm = document.querySelector('#product-search-input');
    searchForm.addEventListener('input', function() {
         setTimeout(filterHandler, 500)
    });
    document.querySelector('.search-group button').addEventListener('click', searchHandler)
});

function filterHandler() {
    if(searchForm.value != '') {
        let xhr = new XMLHttpRequest();
        xhr.open('POST', '/', true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.setRequestHeader(header, token);
        xhr.send("name=" + searchForm.value);

        xhr.onload = function() {
            dropdown.innerHTML = '<div class="text-white ml-3">Результаты поиска:</div>';
            let products = JSON.parse(xhr.response);
            if(products.length != 0) {
                products.forEach(searchResult => {
                    let product = document.createElement('div');
                    product.innerHTML = `<a href="/product/${searchResult.id}" class="dropdown-item">
                    <img src="http://localhost:8080/img/${searchResult.images[0]}" class="product-search-thumbnail">
                    ${searchResult.name}<span class="float-right">${searchResult.price} ₽</span></a>`;

                    dropdown.append(product);
                })
            } else {
                let none = document.createElement('div');
                none.innerHTML = '<div class="text-warning ml-3">Ничего не найдено</div>'
                dropdown.append(none);
            }
        }
    } else {
        dropdown.innerHTML = '<div class="text-white ml-3">Результаты поиска:</div><div class="text-warning ml-3">Ничего не найдено</div>';
    }
}

function searchHandler() {
     window.location.href = URL + `/search?name=${searchForm.value}`
}