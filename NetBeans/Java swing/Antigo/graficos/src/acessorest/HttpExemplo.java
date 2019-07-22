package acessorest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpExemplo {

    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {
        HttpExemplo teste = new HttpExemplo();
        teste.SalvarViaWS2();
    }

    public void buscarViaWS() {
        HttpExemplo http = new HttpExemplo();
        String chamadaWS = "http://localhost:8080/FazendaWebService/webresources/fazenda/Usuario/get/Lucas/1481";
        try {
            String json = http.sendGet(chamadaWS, "GET");
            Gson g = new Gson();
            Usuario u;
            Type user = new TypeToken<Usuario>() {
            }.getType();
            u = g.fromJson(json, user);
            System.out.println(u.toString());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void SalvarViaWS() {
        HttpExemplo http = new HttpExemplo();
        try {
            Gson g = new Gson();
            Usuario u = new Usuario();
            Type user = new TypeToken<Usuario>() {
            }.getType();
            u.setCodigo(0);
            u.setEmail("lucas100colorado@hotmail.com");
            u.setLogin("Lucas");
            u.setPerfil("Lucas Dias");
            u.setSenha("1481");
            String gson = g.toJson(u, user);
            String url = "http://localhost:8080/FazendaWebService/webresources/fazenda/Usuario/inserir";
            String retorno = http.sendPost(url, gson, "POST");
            System.out.println(retorno);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public void SalvarViaWS2() {
        HttpExemplo http = new HttpExemplo();
        try {
            Gson g = new Gson();
            Consulta u = new Consulta();
            Type user = new TypeToken<Consulta>() {
            }.getType();          
            u.setPaymentToken("lalalalelele");           
            String gson = g.toJson(u, user);
            String url = "http://www.jlsistemasdegestao.com.br/jlsistemas/webresources/meuws/Consulta/inserir";
            String retorno = http.sendPost(url, gson, "POST");
            System.out.println(retorno);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public void AlterarViaWS() {
        HttpExemplo http = new HttpExemplo();
        try {
            Gson g = new Gson();
            Usuario u = new Usuario();
            Type user = new TypeToken<Usuario>() {
            }.getType();
            u.setCodigo(4);
            u.setEmail("lucasbertoldidias@gmail.com");
            u.setLogin("Lucas");
            u.setPerfil("Lucas Bertoldi Dias");
            u.setSenha("1481");
            String gson = g.toJson(u, user);
            String url = "http://localhost:8080/FazendaWebService/webresources/fazenda/Usuario/alterar";
            String retorno = http.sendPost(url, gson, "PUT");
            System.out.println(retorno);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void ExcluirViaWS() {
        HttpExemplo http = new HttpExemplo();
        String chamadaWS = "http://localhost:8080/FazendaWebService/webresources/fazenda/Usuario/excluir/Lucas/1481";
        try {
            String retorno = http.sendGet(chamadaWS, "DELETE");
            System.out.println(retorno);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    //metodos do webservice--------------------------------------------------------------------------------------
    // HTTP GET request
    private String sendGet(String url, String metodo) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod(metodo);
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    // HTTP POST request
    private String sendPost(String url, String urlParameters, String metodo) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod(metodo);
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
}
