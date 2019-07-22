function pesquisar(n){
	var form = document.getElementById(n);
	form.submit();
}

function focar(n){
	var inp = document.getElementById(n);
	inp.focus();
	var tamanho = inp.value.length;
	inp.setSelectionRange(tamanho, tamanho);
}

