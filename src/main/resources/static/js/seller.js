
async function setStatus(orderId,status){
	let xhr = new XMLHttpRequest();
        xhr.open('POST', '/seller/order/setstatus', true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.responseType = "text";
        xhr.setRequestHeader(header, token);
        xhr.send(`orderId=${orderId}&status=${status}`);




}