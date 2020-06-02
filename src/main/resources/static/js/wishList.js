URL = `http://localhost:8080`


async function clearWishlist(){
	response = await fetch(URL+`/user/wishlist/clear`);

}

async function delInWishlist(idProduct,obj){
	response = await fetch(URL+`/user/wishlist/delete?productId=` + idProduct);
	obj.parentNode.parentNode.innerHTML = "";

}

async function addWishlist(idProduct){
    response = await fetch(URL+`/user/wishlist/add?productId=` + idProduct);

}