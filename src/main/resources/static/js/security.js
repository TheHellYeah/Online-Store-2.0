var header, token;
const URL = `http://localhost:8080`

window.onload = function() {
    token = document.head.querySelector("meta[name='_csrf']").content;
    header = document.head.querySelector("meta[name='_csrf_header']").content;
}