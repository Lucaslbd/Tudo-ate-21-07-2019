package basico;

public class SalaAula {

	private static String professor;
	private String aluno;
	
	public static String getProfessor() {
		return professor;
	}
	public static void setProfessor(String professor) {
		SalaAula.professor = professor;
	}
	public String getAluno() {
		return aluno;
	}
	public void setAluno(String aluno) {
		this.aluno = aluno;
	}
	@Override
	public String toString() {
		return "Aluno: " + this.aluno + "\nProfessor: " + SalaAula.professor;
	}
	
	
}
