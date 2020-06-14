$(document).ready(function () {
    $('#storage').DataTable({
        "language": {
            "url": "/getLangDataTable"
        },"aoColumnDefs": [{
            "bSortable": false,
             "aTargets": ["sorting_disabled"]
          }]
    });
    $('.dataTables_length').addClass('bs-select');
});


function editWindow(productId,oldName){
    document.querySelector('#oldName').innerHTML = oldName;
    document.getElementsByName('productId')[0].value = productId;
    document.getElementsByName('newName')[0].value = "";
}

function modalEditPrice(productId,oldPrice){
    document.querySelector('#oldPrice').innerHTML = oldPrice;
    document.getElementsByName('productId')[0].value = productId;
    document.getElementsByName('newPrice')[0].value = "";
}


async function editName(){
   newName= document.getElementsByName('newName')[0].value;
   productId= document.getElementsByName('productId')[0].value;
    let xhr = new XMLHttpRequest();
        xhr.open('POST', '/seller/product/edit/name', true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.responseType = "text";
        xhr.setRequestHeader(header, token);
        xhr.send(`productId=`+productId+`&newName=`+newName);

    xhr.onload = function() {
            let div = document.createElement("div");
            if(xhr.status != 200) {
                div.className += "alert alert-danger" ;
                div.innerHTML = `<strong>Ошибка!</strong>`;
            } else {
                div.className += "alert alert-success" ;
                document.getElementById(productId).text = newName;
                div.innerHTML = `<strong>${xhr.response}</strong>`;
            }
            document.getElementById("alert").append(div);
            setTimeout(() => div.remove(), 1500);
        }
}


async function editPrice(){
   newPrice= document.getElementsByName('newPrice')[0].value;
   productId= document.getElementsByName('productId')[0].value;
   let xhr = new XMLHttpRequest();
       xhr.open('POST', '/seller/product/edit/price', true);
       xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
       xhr.responseType = "text";
       xhr.setRequestHeader(header, token);
       xhr.send(`productId=`+productId+`&newPrice=`+newPrice);

   xhr.onload = function() {
       let div = document.createElement("div");
       if(xhr.status != 200) {
           div.className += "alert alert-danger" ;
           div.innerHTML = `<strong>Ошибка!</strong>`;
       } else {
           div.className += "alert alert-success" ;
           document.getElementsByClassName(productId)[0].textContent = newPrice;
           div.innerHTML = `<strong>${xhr.response}</strong>`;
       }
       document.getElementById("alert").append(div);
       setTimeout(() => div.remove(), 1500);
   }
}





async function f(obj){
	let row = obj.previousElementSibling.tBodies[0].rows[0].cells
	alert(obj.previousElementSibling.tBodies[0].rows[0].cells[0].innerHTML);
	const myMap = new Map();
	for (var i = 0; i < row.length; i++) {
      let input = row[i].children[0] ;
      myMap.set(input.name, input.value);

    }
    console.log(myMap);

    let xhr = new XMLHttpRequest();
        xhr.open('POST', '/storage/addsize', true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.responseType = "text";
        xhr.setRequestHeader(header, token);
        xhr.send(myMap.size);
    //ОТПРАВИТЬ как то его
}

	