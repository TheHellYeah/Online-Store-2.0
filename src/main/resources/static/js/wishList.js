
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
     let xhr = new XMLHttpRequest();
        xhr.open('POST', '/user/wishlist/add', true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.responseType = "text";
        xhr.setRequestHeader(header, token);
        xhr.send(`productId=${idProduct}`);

}