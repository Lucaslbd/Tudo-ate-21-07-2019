package beans;

public class ClasseLogin {

	private String email;
	private String senha;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	//Imprementação-------------------------------------------------------------------------------------------------------------------------
	
	public boolean logar(String email, String senha) {
		if(email.equals("lucasbertoldidias@gmail.com") && senha.equals("14811409lbd")) {
			return true;
		}else {
			return false;
		}
	}
}
