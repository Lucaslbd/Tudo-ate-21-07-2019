package br.com.deposito.dao;

import br.com.deposito.conexao.ConexaoBD;
import br.com.deposito.domain.Opniao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;


public class OpniaoDao {
    
    public void Salvar(Opniao opniao) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into opniao(motivo,mensagem,data,deposito) values (?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, opniao.getMotivo());
            comando.setString(2, opniao.getMensagem());
            comando.setTimestamp(3, new Timestamp(opniao.getData().getTime()));     
            comando.setInt(4, opniao.getDeposito().getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }
}
