package Beans;


public class BeansClientes {
    private int codigo;
    private String nome;
    private String rg;
    private String cpf;
    private String nascimento;
    private String telefone;
    private String pesquisa;

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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    @Override
    public String toString() {
        return "BeansClientes{" + "codigo=" + codigo + ", nome=" + nome + ", rg=" + rg + ", cpf=" + cpf + ", nascimento=" + nascimento + ", telefone=" + telefone + ", pesquisa=" + pesquisa + '}';
    }
            
}
