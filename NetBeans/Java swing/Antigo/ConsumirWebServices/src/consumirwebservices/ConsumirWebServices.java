package consumirwebservices;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ConsumirWebServices {

    private final String USER_AGENT = "Mozilla/5.0";

  /*  public static void main(String[] args) {
        ConsumirWebServices teste = new ConsumirWebServices();
        teste.SalvarViaWS();
    }*/

    public void buscarViaWS(String login,String senha) {
        ConsumirWebServices http = new ConsumirWebServices();
        String chamadaWS = "http://localhost:8080/AppContatos//webresources/generic/Usuario/get/"+login+"/"+senha+"";
        try {
            String json = http.sendGet(chamadaWS, "GET");
            Gson g = new Gson();
            Contatos u;
            Type user = new TypeToken<Contatos>() {
            }.getType();
            u = g.fromJson(json, user);
            System.out.println(u.toString());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void listarViaWS() {
        ConsumirWebServices http = new ConsumirWebServices();
        String chamadaWS = "http://www.jlsistemasdegestao.com.br/AppContatos/webresources/generic/Contatos/list";
        try {
            String json = http.sendGet(chamadaWS, "GET");
            Gson g = new Gson();
            ArrayList<Contatos> u;
            Type user = new TypeToken<ArrayList<Contatos>>() {
            }.getType();
            u = g.fromJson(json, user);
            System.out.println(u.toString());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void SalvarViaWS() {
        ConsumirWebServices http = new ConsumirWebServices();
        try {
            Gson g = new Gson();
            Contatos u = new Contatos();
            Type user = new TypeToken<Contatos>() {
            }.getType();
            u.setCodigo(0);
            u.setEmail("teste");
            u.setNome("teste");
            u.setTelefone("tetse");            
            String gson = g.toJson(u, user);
            String url = "http://www.jlsistemasdegestao.com.br/AppContatos//webresources/generic/Contatos/inserir";
            String retorno = http.sendPost(url, gson, "POST");
            System.out.println(retorno);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void AlterarViaWS() {    
        try {
            Gson g = new Gson();
            Contatos u = new Contatos();
            Type user = new TypeToken<Contatos>() {
            }.getType();
            u.setCodigo(6);
            u.setEmail("Lucas Bertoldi dias");
            u.setNome("teste");
            u.setTelefone("tetse");     
            String gson = g.toJson(u, user);
            String url = "http://www.jlsistemasdegestao.com.br/AppContatos//webresources/generic/Contatos/alterar";
            String retorno = sendPost(url, gson, "PUT");
            System.out.println(retorno);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void ExcluirViaWS(int codigo) {
        ConsumirWebServices http = new ConsumirWebServices();
        String chamadaWS = "http://www.jlsistemasdegestao.com.br/AppContatos//webresources/generic/Contatos/excluir/"+codigo;
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