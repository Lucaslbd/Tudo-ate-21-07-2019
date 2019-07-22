package br.com.deposito.boletos;

import java.io.InputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean(name = "MBboleto")
@ViewScoped
public class BoletoBean {

    private StreamedContent file;
    private String arquivo;
    private boolean rendered = false;

    public boolean isRendered() {
        return rendered;
    }

    public void setRendered(boolean rendered) {
        this.rendered = rendered;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public StreamedContent getFile() {
        return file;
    }

    public void setFile(StreamedContent file) {
        this.file = file;
    }

    public void rendered() {
        rendered = arquivo != null;
    }

    public void fileDownloadView() {
        rendered();
        InputStream stream = BoletoBean.class.getResourceAsStream(arquivo + ".pdf");
        file = new DefaultStreamedContent(stream, "pdf/pdf", "teste.pdf");
    }
}
