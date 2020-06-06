const URL = `http://localhost:8080`

async function clearCart(){
	response = await fetch(URL+`/user/cart/clear`);

}

async function delInCart(idProduct, obj){
	response = await fetch(URL+"/user/cart/delete?productId=" + idProduct);
	obj.parentNode.parentNode.innerHTML = "";

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