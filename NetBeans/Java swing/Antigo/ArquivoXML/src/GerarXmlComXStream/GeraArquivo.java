package GerarXmlComXStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class GeraArquivo {

    public static void main(String[] args) {
        GeraArquivo t = new GeraArquivo();
        t.criaFamilia2();
    }

    public void criaXmlPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setDeficiencia(false);
        pessoa.setIdade(25);
        pessoa.setNome("Lucas Bertoldi Dias");
        pessoa.setId(1);

        XStream xtream = new XStream(new DomDriver());
        xtream.autodetectAnnotations(true);
        System.out.println(xtream.toXML(pessoa));
    }

    public void criaXmlFamilia() {
        List<String> filhos = new ArrayList<>();
        filhos.add("Lucas");
        filhos.add("Felipe");
        Familia familia = new Familia();
        familia.setPai("Leandro");
        familia.setMae("Veronica");
        familia.setFilho(filhos);
        XStream xtream = new XStream(new DomDriver());
        xtream.autodetectAnnotations(true);
        Path caminho = Paths.get("xmls/familia.xml");
        byte[] textoEMByte = xtream.toXML(familia).getBytes();
        try {
            Files.write(caminho, textoEMByte);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum numero na lista");
        }
    }

    public void criaFamilia2() {
        Parente parente1 = new Parente();
        parente1.setGrau("Mãe");
        parente1.setIdade(53);
        parente1.setNome("Veronica");
        parente1.setId(1);
        Parente parente2 = new Parente();
        parente2.setGrau("Pai");
        parente2.setIdade(53);
        parente2.setNome("Leandro");
        parente2.setId(2);
        Parente parente3 = new Parente();
        parente3.setGrau("Irmão");
        parente3.setIdade(18);
        parente3.setNome("Felipe");
        parente3.setId(3);
        Parente parente4 = new Parente();
        parente4.setGrau("Primo");
        parente4.setIdade(38);
        parente4.setNome("Juliano");
        parente4.setId(4);
        Familia2 familia = new Familia2();
        familia.getParentes().add(parente1);
        familia.getParentes().add(parente2);
        familia.getParentes().add(parente3);
        familia.getParentes().add(parente4);
        XStream xtream = new XStream(new DomDriver());
        xtream.autodetectAnnotations(true);
        Path caminho = Paths.get("xmls/familia.xml");
        byte[] textoEMByte = xtream.toXML(familia).getBytes();
        try {
            Files.write(caminho, textoEMByte);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum numero na lista");
        }
    }

    public void criandoVetor() {
        String[] vetor = new String[10];
        vetor[0] = "Lucas";
        vetor[1] = "Felipe";
        for (String nome : vetor) {
            if (nome != null) {
                System.out.println(nome);
            }
        }
    }
}
