package br.com.loja.domain;


public class FolhaPagamento {
    
    private String data;       
    private double pagamento;
    private double adiantamento;    
    private double inss;
    private double fgts;   
    private String nome;
    private double salario;
    private String funcao;    
    private double total; 
    private double irrf;
    private double porinss;
    private double porfgts; 
    private double porirrf;
    private double basefgts;
    private double baseirrf;
    private double baseinss;

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

   

    public double getIrrf() {
        return irrf;
    }

    public void setIrrf(double irrf) {
        this.irrf = irrf;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }      

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }    

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }   

    public double getPagamento() {
        return pagamento;
    }

    public void setPagamento(double pagamento) {
        this.pagamento = pagamento;
    }

    public double getAdiantamento() {
        return adiantamento;
    }

    public void setAdiantamento(double adiantamento) {
        this.adiantamento = adiantamento;
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
}
