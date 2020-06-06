var header, token;

window.onload = function() {
    token = document.head.querySelector("meta[name='_csrf']").content;
    header = document.head.querySelector("meta[name='_csrf_header']").content;
}