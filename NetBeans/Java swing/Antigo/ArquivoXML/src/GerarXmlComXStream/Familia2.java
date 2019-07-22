package GerarXmlComXStream;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.ArrayList;
import java.util.List;

@XStreamAlias(value = "Familia")
public class Familia2 {
    
   private List <Parente> parentes = new ArrayList<>();

    public List<Parente> getParentes() {
        return parentes;
    }

    public void setParentes(List<Parente> parentes) {
        this.parentes = parentes;
    }
}
