URL = `http://localhost:8080`


async function f(obj){
	let row = obj.previousElementSibling.tBodies[0].rows[0].cells
	alert(obj.previousElementSibling.tBodies[0].rows[0].cells[0].innerHTML);
	const myMap = new Map();
	for (var i = 0; i < row.length; i++) {
      let input = row[i].children[0] ;
      myMap.set(input.name, input.value);

    }
    console.log(myMap);

    let xhr = new XMLHttpRequest();
        xhr.open('POST', '/storage/addsize', true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.responseType = "text";
        xhr.setRequestHeader(header, token);
        xhr.send(myMap.size);
    //ОТПРАВИТЬ как то его
}

	