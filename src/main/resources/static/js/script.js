URL = `http://localhost:8080`

// WISH LIST ----------------------
async function clearWishlist(){
	response = await fetch(URL+`/api/clearwishlist`);

}

async function delInWishlist(idProduct,obj){
	response = await fetch(URL+`/api/delinwishlist?id=` + idProduct);
	obj.parentNode.parentNode.innerHTML = "";

}

async function addWishlist(idProduct){
    response = await fetch(URL+`/api/addwishlist?id=` + idProduct);

}
// --------------------------------


// CART -----------------------------
async function clearCart(){
	response = await fetch(URL+`/api/clearcart`);

}

async function delInCart(idProduct, obj){
	response = await fetch(URL+`/api/delincart?id=` + idProduct);
	obj.parentNode.parentNode.innerHTML = "";

}

async function inCart(id){
    let count = document.getElementById("count").value;
    response = await fetch(URL+`/api/addtocart?id=`+id+`&count=` + count);

}
// ----------------------------------