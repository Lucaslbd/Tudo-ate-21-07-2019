package br.com.agenciaviagens.dao;

import br.com.agenciaviagens.conexao.ConexaoBDAutenticar;
import br.com.agenciaviagens.domain.Empresa;
import br.com.agenciaviagens.util.UtilitarioDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class EmpresaDao {

    public void Salvar(Empresa empresa) throws SQLException {
        UtilitarioDao util = new UtilitarioDao();
        StringBuilder sql = new StringBuilder();
        sql.append("insert into empresa(razao_social,estado,cidade,bairro,rua,numero,email,telefone,cnpj,cep,situacao,mensalidade,senha_empresa,data_cadastro,nome_proprietario,sistema,numero_banco,online) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBDAutenticar.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, empresa.getNomeEmpresa());
            comando.setString(2, empresa.getEstado());
            comando.setString(3, empresa.getCidade());
            comando.setString(4, empresa.getBairro());
            comando.setString(5, empresa.getRua());
            comando.setString(6, empresa.getNumero());
            comando.setString(7, empresa.getEmail());
            comando.setString(8, empresa.getTelefone());
            comando.setString(9, empresa.getCnpj());
            comando.setString(10, empresa.getCep());
            comando.setString(11, "Aguardar");
            comando.setDouble(12, 30);
            comando.setString(13, empresa.getSenha());
            comando.setDate(14, util.dateUtilXsqlDate(new Date()));
            comando.setString(15, empresa.getNomeProprietario());
            comando.setString(16, "Gestour");
            comando.setInt(17, 0);
            comando.setString(18, "Ofline");
            comando.executeUpdate();
            conexao.close();
        }
    }    
}
