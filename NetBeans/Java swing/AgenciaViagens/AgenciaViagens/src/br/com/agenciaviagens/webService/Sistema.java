package br.com.agenciaviagens.webService;

public class Sistema {

    private String nome;
    private int codigo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Sistema{" + "nome=" + nome + '}';
    }

   
}
