const URL = `http://localhost:8080`
let searchForm;

window.onload = function() {
    searchForm = document.querySelector('#search');
    searchForm.addEventListener('input', function() {
         setTimeout(searchHandler, 500)
    });
}

function searchHandler() {

    let token = document.head.querySelector("meta[name='_csrf']").content;
    let header = document.head.querySelector("meta[name='_csrf_header']").content;

    var xhr = new XMLHttpRequest();
    xhr.open('POST', '/search', true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.setRequestHeader(header, token);
    xhr.send("name=" + searchForm.value);

    xhr.onload = function() {
        let products = JSON.parse(xhr.response);
    }
}