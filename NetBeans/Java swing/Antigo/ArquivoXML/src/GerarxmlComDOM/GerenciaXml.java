package GerarxmlComDOM;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class GerenciaXml {

    public void criaXml() {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document documentXml = documentBuilder.newDocument();

            Element root = documentXml.createElement("root");
            documentXml.appendChild(root);

            Element pessoa = documentXml.createElement("pessoa");
            Attr id = documentXml.createAttribute("id");
            id.setValue("1");
            pessoa.setAttributeNode(id);
            root.appendChild(pessoa);

            Element nome = documentXml.createElement("nome");
            nome.appendChild(documentXml.createTextNode("Lucas"));
            pessoa.appendChild(nome);

            Element idade = documentXml.createElement("idade");
            idade.appendChild(documentXml.createTextNode("26"));
            pessoa.appendChild(idade);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource documentFont = new DOMSource(documentXml);

            StreamResult documentoFinal = new StreamResult(new File("xmls//papaiNoel.xml"));
            transformer.transform(documentFont, documentoFinal);

        } catch (ParserConfigurationException | TransformerException ex) {
            Logger.getLogger(ArquivoXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void leXml() {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document documentXml = documentBuilder.parse("xmls//papaiNoel.xml");
            NodeList listaPessoa = documentXml.getElementsByTagName("pessoa");
            for (int i = 0; i < listaPessoa.getLength(); i++) {
                Node noPessoa = listaPessoa.item(i);
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPessoa = (Element) noPessoa;
                    String id = elementoPessoa.getAttribute("id");
                    System.out.println("ID: " + id);
                    NodeList listaFilhosPessoa = elementoPessoa.getChildNodes();
                    for (int x = 0; x < listaFilhosPessoa.getLength(); x++) {
                        Node noFilho = listaFilhosPessoa.item(x);
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoFilho = (Element) noFilho;
                            switch (elementoFilho.getTagName()) {
                                case "nome":
                                    System.out.println("Nome: " + elementoFilho.getTextContent());
                                    break;
                                case "idade":
                                    System.out.println("Idade: " + elementoFilho.getTextContent());
                                    break;
                            }
                        }
                    }
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException ex) {
            Logger.getLogger(GerenciaXml.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
