var input = document.querySelector('#images');
var preview = document.querySelector('.preview');

input.style.opacity = 0;

input.addEventListener('change', updateImageDisplay);

function updateImageDisplay() {
  while(preview.firstChild) {
    preview.removeChild(preview.firstChild);
  }
  var curFiles = input.files;
  if(curFiles.length === 0) {
    var para = document.createElement('p');
    para.textContent = 'Файлы не выбраны';
    preview.appendChild(para);
  } else {
    var list = document.createElement('ol');
    preview.appendChild(list);
    for(var i = 0; i < curFiles.length; i++) {
      var listItem = document.createElement('li');
      var para = document.createElement('p');
      if(validFileType(curFiles[i])) {
        para.textContent = 'Имя файла ' + curFiles[i].name + ', размер файла ' + returnFileSize(curFiles[i].size) + '.';
        var image = document.createElement('img');
        image.src = window.URL.createObjectURL(curFiles[i]);
        listItem.appendChild(para);
        listItem.appendChild(image);
      } else {
        para.textContent = 'Имя файла ' + curFiles[i].name + ': Некорректный тип файла';
        input.files = null;
        listItem.appendChild(para);
      }
      list.appendChild(listItem);
    }
  }
}

var fileTypes = [
  'image/jpeg',
  'image/pjpeg',
  'image/png'
]

function validFileType(file) {
  for(var i = 0; i < fileTypes.length; i++) {
    if(file.type === fileTypes[i]) {
      return true;
    }
  }
  return false;
}

function returnFileSize(number) {
  if(number < 1024) {
    return number + 'байт';
  } else if(number > 1024 && number < 1048576) {
    return (number/1024).toFixed(1) + 'КБ';
  } else if(number > 1048576) {
    return (number/1048576).toFixed(1) + 'МБ';
  }
}

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
	 	tbody.innerHTML += `<tr><td name"" value="2"><input class="label"name="sizes" type="text" value="SIZE_`+i+`" readonly></td>
	 	                    <td><input name="amount" type="number" min="0" max="9999" value="0"></td></tr>`;
	 	}
	
}




