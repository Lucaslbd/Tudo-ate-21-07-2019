package GerarXmlComXStream;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.List;

@XStreamAlias(value = "Familia")
public class Familia {
    
    private String pai;
    private String mae;
    
    @XStreamImplicit(itemFieldName = "Filho")
    private List<String> filho;

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public List<String> getFilho() {
        return filho;
    }

    public void setFilho(List<String> filho) {
        this.filho = filho;
    }
}
