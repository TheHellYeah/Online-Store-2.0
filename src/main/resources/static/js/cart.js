
async function clearCart(){
	response = await fetch(URL+`/user/cart/clear`);

}

async function delInCart(idProduct, obj){
	response = await fetch(URL+"/user/cart/delete?productId=" + idProduct);
	obj.parentNode.parentNode.innerHTML = "";

}

async function inCart(id){
    let count = document.getElementById("count").value;
    response = await fetch(URL+`/user/cart/add?productId=`+id+`&count=` + count);

}