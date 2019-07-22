package modeloConection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexaoBD {
   public Statement stm; //faz a pesquisa no banco de dados
   public ResultSet rs;  //armazena o resultado da pesquisa
   private String driver="org.postgresql.Driver"; // identifica o serviço é o padrao do postgre
   private String caminho ="jdbc:postgresql://localhost:5432/progetoclinica"; //diz o caminho do banco de dados
   private String usuario ="postgres"; //usuario do banco de dados
   private String senha ="14811409lbd"; // senha do banco de dados
   public Connection con; // faz a conexao
   

public void Conexao(){ //metodo de conexao
        try {
            System.setProperty("jdbc.drivers", driver);
           con =DriverManager.getConnection(caminho, usuario, senha);
           //JOptionPane.showMessageDialog(null,"Deu certo");
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao se conectar\n" + ex.getMessage());
   }
}
public void executaSql (String sql){
       try {
           stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
           rs = stm.executeQuery(sql);
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao executar sql\n" + ex.getMessage());
       }
}


public void Desconecta(){ //metodo de desconexao
       try {
           con.close();
            //JOptionPane.showMessageDialog(null,"Desconectou com sucesso");
       } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao desconectar\n"+ex.getMessage());
       }
    
}
}


    


   
       
    
    


