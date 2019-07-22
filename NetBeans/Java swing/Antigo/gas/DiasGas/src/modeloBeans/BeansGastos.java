package modeloBeans;


public class BeansGastos {
    private int codigoGasto;
    private String descricaoGasto;
    private double valorGasto;
    private String dataGasto;
    private String PesquisarGasto;
    private String referencia;

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public int getCodigoGasto() {
        return codigoGasto;
    }

    public void setCodigoGasto(int codigoGasto) {
        this.codigoGasto = codigoGasto;
    }

    public String getDescricaoGasto() {
        return descricaoGasto;
    }

    public void setDescricaoGasto(String descricaoGasto) {
        this.descricaoGasto = descricaoGasto;
    }

    public double getValorGasto() {
        return valorGasto;
    }

    public void setValorGasto(double valorGasto) {
        this.valorGasto = valorGasto;
    }

    public String getDataGasto() {
        return dataGasto;
    }

    public void setDataGasto(String dataGasto) {
        this.dataGasto = dataGasto;
    }

    public String getPesquisarGasto() {
        return PesquisarGasto;
    }

    public void setPesquisarGasto(String PesquisarGasto) {
        this.PesquisarGasto = PesquisarGasto;
    }
    
}
