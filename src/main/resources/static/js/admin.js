
window.onload = function() {
    document.querySelector('select').addEventListener('change', roleFilterHandler);
    token = document.head.querySelector("meta[name='_csrf']").content;
    header = document.head.querySelector("meta[name='_csrf_header']").content;
}

function dismiss(id){
     let xhr = new XMLHttpRequest();
            xhr.open('POST', '/admin/dismiss', true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.responseType = "text";
            xhr.setRequestHeader(header, token);
            xhr.send(`id=`+id);
}

function appoint(id){
     let xhr = new XMLHttpRequest();
            xhr.open('POST', '/admin/appoint', true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.responseType = "text";
            xhr.setRequestHeader(header, token);
            xhr.send(`id=`+id);
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