function getValue(value) {
	setTable(value);
}

function setTable(value) {
	 if (value== "CHILD") {
	 	start = 30;
	 	end = 38;
	 }
	 if (value== "WOMAN") {
	 	start = 35;
	 	end = 41;
	 }
	 if (value== "MAN") {
	 	start=39;
	 	end=47;
	 }
	 let tbody = document.getElementById("size");
	 tbody.innerHTML= "";
	 for (var i = start; i <= end; i++) {
	 	tbody.innerHTML += `<tr><td name"" value="2"><input class="label"name="size" type="text" value="SIZE_`+i+`" readonly></td>
	 	                    <td><input name="count" type="number" min="0" max="9999" value="0"></td></tr>`;
	 	}
	
}