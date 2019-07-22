package br.com.agenciaviagens.domain;

public class Passageiro {

    private int codigo;
    private Grupo grupo = new Grupo();/**/
    private Cliente cliente = new Cliente();/**/
    private double valor;/**/  
    private String localEmbarque;/**/
    private int titular;/**/
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTitular() {
        return titular;
    }

    public void setTitular(int titular) {
        this.titular = titular;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }    

    public String getLocalEmbarque() {
        return localEmbarque;
    }

    public void setLocalEmbarque(String localEmbarque) {
        this.localEmbarque = localEmbarque;
    }

    @Override
    public String toString() {
        return "Passageiro{" + "codigo=" + codigo + ", grupo=" + grupo + ", cliente=" + cliente + ", valor=" + valor + ", localEmbarque=" + localEmbarque + ", titular=" + titular + ", status=" + status + '}';
    }
}
