package basico;

public class OlaMundo {

	public static void main(String[] args) {		
		String nome =  "Lucas Bertoldi Dias";
		String []nomes = nome.split(" ");
		
		for(String n : nomes) {
			System.out.println(n);
		}
	}
}
