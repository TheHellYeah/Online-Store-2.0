
async function setStatus(status, orderId) {
	let xhr = new XMLHttpRequest();
    xhr.open('POST', `/seller/orders/${orderId}`, true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.responseType = "text";
    xhr.setRequestHeader(header, token);
    xhr.send(`status=${status}`);
    xhr.onload = function() {
        let div = document.createElement("div");
        if(xhr.status != 200) {
            div.className += "alert alert-danger" ;
            div.innerHTML = `<strong>Ошибка!</strong>`;
        } else {
            div.className += "alert alert-success" ;
            div.innerHTML = `<strong>Статус заказа успешно изменен. Пользователь получит уведомление о смене статуса на свой email</strong>`;
            document.querySelector('#order_status').innerHTML = xhr.response;
        }
        document.getElementById("alert").append(div);
        setTimeout(() => div.remove(), 3500);
    }
}