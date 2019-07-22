package beans;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PrimeiroBeans {
	
	private String estado;
	private String cidade;
	private String bairro;
	private String rua;

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int calcula(int numero) {
		return numero * 100;
	}
	
	public String dateXstring() {
		Date data =  new Date();
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formatoBrasileiro.format(data);
        return dataFormatada;
    }
}
