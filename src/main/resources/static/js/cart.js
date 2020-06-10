
function updateTotal(cartId, input){
    let xhr = new XMLHttpRequest();
    xhr.open('POST', '/user/cart/update', true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.responseType = "text";
    xhr.setRequestHeader(header, token);
    xhr.send(`cartId=${cartId}&value=${input.value}`);

    xhr.onload = function() {
        let div = document.createElement("div");
         if(xhr.status != 200) {
             div.className += "alert alert-danger" ;
             div.innerHTML = `<strong>Ошибка! Максимальное количество данного товара в корзине: ${input.max}</strong>`;
             document.getElementById("alert").append(div);
             setTimeout(() => div.remove(), 2500);
             input.value = input.max;
         }
         document.querySelector('#total1').innerHTML = xhr.response;
    }
}

async function clearCart() {
     let xhr = new XMLHttpRequest();
     xhr.open('POST', '/user/cart/clear', true);
     xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
     xhr.responseType = "text";
     xhr.setRequestHeader(header, token);
     xhr.send();

     xhr.onload = function() {
         let div = document.createElement("div");
         if(xhr.status != 200) {
             div.className += "alert alert-danger";
             div.innerHTML = `<strong>Ошибка!</strong>`;
         } else {
             div.className += "alert alert-success" ;
             div.innerHTML = `<strong>${xhr.response}</strong>`;
         }
         document.querySelector(".table").remove();
         updateTotal();
         setTimeout(() => div.remove(), 1500);
     }

}

async function delInCart(cartId, obj){

    let xhr = new XMLHttpRequest();
    xhr.open('POST', '/user/cart/delete', true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.responseType = "text";
    xhr.setRequestHeader(header, token);
    xhr.send(`cartId=${cartId}`);
	obj.parentNode.parentNode.remove();
    updateTotal();
}

async function inCart(id)   {
    let size = document.querySelector('.btn-group-toggle input[name="size"]:checked').value
    let xhr = new XMLHttpRequest();
    xhr.open('POST', '/user/cart/add', true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.responseType = "text";
    xhr.setRequestHeader(header, token);
    xhr.send(`size=${size}&id=${id}`);
    
    xhr.onload = function() {
        let div = document.createElement("div");
        if(xhr.status != 200) {
            div.className += "alert alert-danger" ;
            div.innerHTML = `<strong>Ошибка!</strong>`;
        } else {
            div.className += "alert alert-success" ;
            div.innerHTML = `<strong>${xhr.response}</strong>`;
        }
        document.getElementById("alert").append(div);
        setTimeout(() => div.remove(), 1500);
    }
}