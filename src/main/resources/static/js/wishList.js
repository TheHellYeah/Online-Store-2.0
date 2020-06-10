
async function clearWishlist(){
	 let xhr = new XMLHttpRequest();
            xhr.open('POST', '/user/wishlist/clear', true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.responseType = "text";
            xhr.setRequestHeader(header, token);
            xhr.send();

}

async function delInWishlist(idProduct,obj){
    let xhr = new XMLHttpRequest();
    xhr.open('POST', '/user/wishlist/delete', true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.responseType = "text";
    xhr.setRequestHeader(header, token);
    xhr.send(`productId=${idProduct}`);

	obj.parentNode.parentNode.innerHTML = "";

}

async function addWishlist(idProduct){
    event.stopPropagation();
     let xhr = new XMLHttpRequest();
        xhr.open('POST', '/user/wishlist/add', true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.responseType = "text";
        xhr.setRequestHeader(header, token);
        xhr.send(`productId=${idProduct}`);

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