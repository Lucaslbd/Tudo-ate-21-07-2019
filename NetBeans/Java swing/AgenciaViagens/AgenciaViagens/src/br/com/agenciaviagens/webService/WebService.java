package br.com.agenciaviagens.webService;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebService {

    private final String USER_AGENT = "Chrome";// Mozilla/5.0 Chrome

    public Empresa buscarViaWS(String login, String senha) throws Exception {//www.jlsistemasdegestao.com.br
        WebService http = new WebService();
        String chamadaWS = "http://www.jlsistemasdegestao.com.br/jlsistemas/webresources/generic/empresa/get/" + login + "/" + senha + "";
        String json = http.sendGet(chamadaWS, "GET");
        Gson g = new Gson();
        Type user = new TypeToken<Empresa>() {
        }.getType();
        Empresa u = g.fromJson(json, user);
        return u;
    }

    public void SalvarViaWS(Empresa empresa) throws Exception {
        WebService http = new WebService();
        Gson g = new Gson();
        Type user = new TypeToken<Empresa>() {
        }.getType();
        String gson = g.toJson(empresa, user);
        String url = "http://www.jlsistemasdegestao.com.br/jlsistemas/webresources/generic/empresa/inserir";
        http.sendPost(url, gson, "POST");
        //http://localhost:8080/jlsistemas/webresources/generic/empresa/inserir
        //http://www.jlsistemasdegestao.com.br/jlsistemas/webresources/generic/empresa/inserir
    }    

    public void AlterarViaWS(Empresa empresa) throws Exception {
        WebService http = new WebService();
        Gson g = new Gson();
        Type user = new TypeToken<Empresa>() {
        }.getType();
        String gson = g.toJson(empresa, user);
        String url = "http://www.jlsistemasdegestao.com.br/jlsistemas/webresources/generic/empresa/alterar";
        http.sendPost(url, gson, "PUT");
    }

    //metodos do webservice--------------------------------------------------------------------------------------
    // HTTP GET request
    private String sendGet(String url, String metodo) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod(metodo);
        con.setRequestProperty("User-Agent", USER_AGENT);
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
    private void sendPost(String url, String urlParameters, String metodo) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod(metodo);
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Content-Type", "application/json;charset=utf-8");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");//
        con.setDoOutput(true);      
        try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
            wr.writeBytes(urlParameters);
            wr.flush();
        }
        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))
        ) {
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        }
    }
}
