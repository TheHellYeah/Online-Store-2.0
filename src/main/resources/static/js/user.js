$(document).ready(function () {
    $('#orders').DataTable({
        "language": {
            "url": "/getLangDataTable"
        },"aoColumnDefs": [{
            "bSortable": false,
            "aTargets": ["sorting_disabled"]
        }]
    });
    $('.dataTables_length').addClass('bs-select');
});