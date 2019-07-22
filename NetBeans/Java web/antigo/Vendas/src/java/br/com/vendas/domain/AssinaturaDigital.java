package br.com.vendas.domain;


public class AssinaturaDigital {
    
    Empresa empresa;
    String senhaTruststore; //certificação assefaz
    String senhaToqken; //caso a empresa utilize modelo a3
    String idToken; //caso a empresa utilize modelo a3
    String senhaKeyStore; //certificação da empresa emitente caso utilize o modelo a1
    String serie55;   //para impressão de NF-e
    String serie65;   //para impressão de NFC-e
    String cscHomologacao;
    String cscProducao;
}
