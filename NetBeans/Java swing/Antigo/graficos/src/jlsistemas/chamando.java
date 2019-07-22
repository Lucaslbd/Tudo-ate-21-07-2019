package jlsistemas;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.lang.reflect.Type;


public class chamando {
    
    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {
        chamando teste = new chamando();
        teste.buscarViaWS();
    }

    public void buscarViaWS() {
        chamando http = new chamando();
        String chamadaWS = "http://localhost:8080/jlsistemas/webresources/meuws/Empresa/get/jlviagens.turis@gmail.com/1481";
        try {        
            String json = http.sendGet(chamadaWS, "GET");
            Gson g = new Gson();
            Empresa u;
            Type user = new TypeToken<Empresa>() {
            }.getType();
            u = g.fromJson(json, user);
            System.out.println(u.getNome());
        } catch (Exception ex) {
            System.out.println("erro"+ex);
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
