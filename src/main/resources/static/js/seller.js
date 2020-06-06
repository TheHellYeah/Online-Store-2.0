
async function orderIsDone(orderId){
	response = await fetch(URL+`/seller/order/isdone?orderId=`+orderId);
}