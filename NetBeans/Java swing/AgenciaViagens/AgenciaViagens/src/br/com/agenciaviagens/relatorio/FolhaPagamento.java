package br.com.agenciaviagens.relatorio;

public class FolhaPagamento {

    private String data1;  
    private double pagamento;
    private double comissao;
    private double total;
    private double inss;
    private double fgts;
    private double irrf;
    private String nome;
    private String funcao;
    private double porinss;
    private double porfgts;
    private double porirrf;
    private double basefgts;
    private double baseirrf;
    private double baseinss;
    private String impressao;
    private String empresa;
    private String cnpj;
    private String telefone;

    public String getImpressao() {
        return impressao;
    }

    public void setImpressao(String impressao) {
        this.impressao = impressao;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getPagamento() {
        return pagamento;
    }

    public void setPagamento(double pagamento) {
        this.pagamento = pagamento;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }   

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getInss() {
        return inss;
    }

    public void setInss(double inss) {
        this.inss = inss;
    }

    public double getFgts() {
        return fgts;
    }

    public void setFgts(double fgts) {
        this.fgts = fgts;
    }

    public double getIrrf() {
        return irrf;
    }

    public void setIrrf(double irrf) {
        this.irrf = irrf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public double getPorinss() {
        return porinss;
    }

    public void setPorinss(double porinss) {
        this.porinss = porinss;
    }

    public double getPorfgts() {
        return porfgts;
    }

    public void setPorfgts(double porfgts) {
        this.porfgts = porfgts;
    }

    public double getPorirrf() {
        return porirrf;
    }

    public void setPorirrf(double porirrf) {
        this.porirrf = porirrf;
    }

    public double getBasefgts() {
        return basefgts;
    }

    public void setBasefgts(double basefgts) {
        this.basefgts = basefgts;
    }

    public double getBaseirrf() {
        return baseirrf;
    }

    public void setBaseirrf(double baseirrf) {
        this.baseirrf = baseirrf;
    }

    public double getBaseinss() {
        return baseinss;
    }

    public void setBaseinss(double baseinss) {
        this.baseinss = baseinss;
    }

}
