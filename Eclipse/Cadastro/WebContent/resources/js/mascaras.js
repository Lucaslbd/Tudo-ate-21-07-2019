function vCampos(el, er) {
	var e = $(el).val().replace(er, '');
	$(el).val(e);
}

function numInt(el) {
	vCampos(el, /[^0-9]/g);
}

function numDouble(el) {
	vCampos(el, /[^0-9\.]/g);
}

function numRS(el) {
	vCampos(el, /[^0-9\.R$ ]/g);
	var e = $(el).val();
	if (e.length < 1) {
		var t = "R$ ";
		$(el).val(t + e);
	}
	if (e.length == 1) {
		$(el).val(e + "$ ");
	}
	if (e.length == 2) {
		$(el).val(e + " ");
	}
}

function maskTel(el) {//são 17 campos
	vCampos(el, /[^0-9\-() ]/g);
	var e = $(el).val();
	if (e.length == 4) {
		$(el).val(e + ') 9 ');
	}
	if (e.length == 12) {
		$(el).val(e + '-');
	}
	if (e.length == 1) {
		var t = "(";
		$(el).val(t + e);
	}
}

function maskCpf(el) {//são 14 campos
	vCampos(el, /[^0-9\.-]/g);
	var e = $(el).val();
	if (e.length == 3) {
		$(el).val(e + '.');
	}
	if (e.length == 7) {
		$(el).val(e + '.');
	}
	if (e.length == 11) {
		$(el).val(e + '-');
	}
}

function maskCnpj(el) {//são 18 campos
	vCampos(el, /[^0-9\./-]/g);
	var e = $(el).val();
	if (e.length == 2) {
		$(el).val(e + '.');
	}
	if (e.length == 6) {
		$(el).val(e + '.');
	}
	if (e.length == 10) {
		$(el).val(e + '/');
	}
	if (e.length == 15) {
		$(el).val(e + '-');
	}
}

function maskData(el){//são 10 caracteres
	vCampos(el, /[^0-9\/]/g);
	var e = $(el).val();
	if (e.length == 2) {
		$(el).val(e + '/');
	}
	if (e.length == 5) {
		$(el).val(e + '/');
	}
}
