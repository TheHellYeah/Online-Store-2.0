
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
    let div = document.createElement("div");
    
    if(response.status == "200"){
    
    div.className += "alert alert-success" ;
    div.innerHTML = `<strong>Добавлено</strong>`;
	}else{
		div.className += "alert alert-danger" ;
    	div.innerHTML = `<strong>Ошибка!</strong>`;
	}
    document.getElementById("alert").append(div);
    setTimeout(() => div.remove(), 1500);


}