
$(document).ready(function () {
    $('#users').DataTable({
        "language": {
            "url": "/getLangDataTable"
        },
        "aoColumnDefs": [
                   {
                       "bSortable": false,
                       "aTargets": ["sorting_disabled"]
                   }
    ]});
    $('.dataTables_length').addClass('bs-select');
});

window.onload = function() {
    document.querySelector('select').addEventListener('change', roleFilterHandler);
    token = document.head.querySelector("meta[name='_csrf']").content;
    header = document.head.querySelector("meta[name='_csrf_header']").content;
}

function editBalance(id){
    balance = document.getElementById(id).value;

    let xhr = new XMLHttpRequest();
                xhr.open('POST', '/admin/edit/balance', true);
                xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                xhr.responseType = "text";
                xhr.setRequestHeader(header, token);
                xhr.send(`id=`+id+`&balance=`+balance);
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
