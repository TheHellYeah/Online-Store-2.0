
window.onload = function() {
    document.querySelector('select').addEventListener('change', roleFilterHandler);
    token = document.head.querySelector("meta[name='_csrf']").content;
    header = document.head.querySelector("meta[name='_csrf_header']").content;
}

function roleFilterHandler() {
     let xhr = new XMLHttpRequest();
     if(this.value != "Все") {
        xhr.open('GET', `/admin?role=${this.value}`, true);
     } else {
        xhr.open('GET', '/admin', true);
     }
     xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
     xhr.setRequestHeader(header, token);
     xhr.send();
}