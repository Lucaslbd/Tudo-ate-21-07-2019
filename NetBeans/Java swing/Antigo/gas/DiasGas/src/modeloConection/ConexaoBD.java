package modeloConection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class ConexaoBD {
   public Statement stm; //faz a pesquisa no banco de dados
   public ResultSet rs;  //armazena o resultado da pesquisa
   private final String driver="org.postgresql.Driver"; // identifica o serviço é o padrao do postgre  
   private final String caminho ="jdbc:postgresql://pgsql.jlsistemasdegestao.com.br:5432/jlsistemasdegestao1";
   private final String usuario ="jlsistemasdegestao1"; 
   private final String senha ="14811409lbd"; // senha do banco de dados
   public Connection con; // faz a conexao
   //pgsql.jlsistemasdegestao.com.br:5432/jlsistemasdegestao1

public void Conexao(){ //metodo de conexao
        try {
            System.setProperty("jdbc.drivers", driver);
           con =DriverManager.getConnection(caminho, usuario, senha);
           //JOptionPane.showMessageDialog(null,"Deu certo");
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Houve algum erro ao tentar se comunicar com o banco de dados tente novamente mais tarde\n" + ex.getMessage());
           System.exit(0);
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
//private String usuario ="postgres"; 
//private String caminho ="jdbc:postgresql://localhost:5432/progetogas";
//
//
//
//                  
 

