package Dao;

import Beans.BeansGrupos;
import Conection.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DaoGrupos {

    ConexaoBD conex = new ConexaoBD();
    BeansGrupos grupos = new BeansGrupos();
    
    
    public void NovoGrupo(BeansGrupos grupos) {       
        int necessario;
        conex.Conexao();
        ArrayList<Integer> sequencia = new ArrayList();
        conex.executaSql("SELECT DISTINCT controle,codigo from grupos_excursoes order by codigo");
        try {
            conex.rs.first();
            do {
                sequencia.add(conex.rs.getInt("controle"));
            } while (conex.rs.next());
            
           int numero = sequencia.size()-1;
           necessario = sequencia.get(numero);
           necessario++;
        } catch (SQLException ex) {            
          necessario =0;
        }           
        String nomeGrupo = "grupo_" + String.valueOf(necessario);        
        try {
            PreparedStatement pst = conex.con.prepareStatement("create table " + nomeGrupo + "(codigo serial not null PRIMARY KEY,codigo_cliente integer not null,valor double precision not null, forma_pagamento character varying(20)not null,numero_parcelas integer not null,parcelas_pagas integer not null,valor_pago double precision not null,embarque character varying(100)not null,tipo_passageiro character varying(100)not null,FOREIGN KEY (codigo_cliente) REFERENCES clientes (codigo))");
            pst.execute();
            PreparedStatement ps = conex.con.prepareStatement("insert into grupos_excursoes(nome,controle,valores_fixos,valores_oscilantes,vagas,preco_venda,nomemelhorado) values('"+nomeGrupo+"','"+necessario+"',?,?,?,?,?)");
            ps.setDouble(1,grupos.getValoresFixos());
            ps.setDouble(2,grupos.getValoresOscilantes());
            ps.setInt(3,grupos.getVagas());
            ps.setDouble(4,grupos.getPrecoVenda());
            ps.setString(5, grupos.getNome());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Grupo criado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar grupo\n\n"+ex);
        }
        conex.Desconecta();
    }

    public void Salvar(BeansGrupos grupos, String tabela) {
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into " + tabela + "(codigo_cliente,valor,forma_pagamento,numero_parcelas,parcelas_pagas,valor_pago,embarque,tipo_passageiro) values (?,?,?,?,?,?,?,?)");
            pst.setInt(1, grupos.getCodigo());
            pst.setDouble(2, grupos.getValor());
            pst.setString(3, grupos.getFormaPagamento());
            pst.setInt(4, grupos.getNumeroParcelas());
            pst.setInt(5, grupos.getParcelasPagas());
            pst.setDouble(6, grupos.getValorPago());
            pst.setString(7, grupos.getEmbarque());
            pst.setString(8,grupos.getTipoPassageiro());

            pst.execute();
            JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir clietes\n" + ex);
        }
        conex.Desconecta();
    }

    public void EfetuarPagamento(BeansGrupos grupos, String tabela) {
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update "+ tabela+" set parcelas_pagas=?,valor_pago=? where codigo=?");
            pst.setInt(1, grupos.getParcelasPagas());
            pst.setDouble(2, grupos.getValorPago());
            pst.setInt(3, grupos.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Pagamento efetuado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao efetuar pagamento\n" + ex);
        }

        conex.Desconecta();
    }

    public void Excluir(BeansGrupos grupos, String tabela) {
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from grupos_excursoes where codigo=?");
            pst.setInt(1, grupos.getCodigo());
            pst.execute();
            PreparedStatement ps = conex.con.prepareStatement("DROP TABLE " + tabela + "");
            ps.execute();           
            JOptionPane.showMessageDialog(null, "grupo excluido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir grupo\n" + ex);
        }

        conex.Desconecta();
    }

    public void ExcluirPassageiro(BeansGrupos grupos, String tabela,String tabela2, int codigo, double valor) {
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from " + tabela2 + " where codigo=?");
            pst.setInt(1, grupos.getCodigo());
            pst.execute();
            if(valor >0){
            int resposta = JOptionPane.showConfirmDialog(null,"Deseja armazenar os dados na aréa de devoluções?");
            if(resposta ==JOptionPane.YES_OPTION){
             PreparedStatement ps = conex.con.prepareStatement("insert into devolucoes(codigo_cliente,grupo,valor,situacao) values (" + codigo + ",'" + tabela + "'," + valor + ",'Aberta')");
             ps.execute();
            }
            }
            JOptionPane.showMessageDialog(null, "Passageiro excluido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir grupo\n" + ex);
        }
        conex.Desconecta();
    }
    public void LimparDevolucoes(BeansGrupos grupos){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from devolucoes where codigo=?");
            pst.setInt(1, grupos.getCodigo());
            pst.execute();           
            JOptionPane.showMessageDialog(null, "Devolução excluida com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir grupo\n" + ex);
        }
        conex.Desconecta();
    }
    
    
    public void EditarNomePax(BeansGrupos grupos,String tabela){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update "+ tabela+"  set codigo_cliente=? where codigo=?");
            pst.setInt(1,grupos.getCodigoCliente());
            pst.setInt(2,grupos.getCodigo());
              pst.execute();
              JOptionPane.showMessageDialog(null,"Cliente alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao alterar dados\n" + ex);
        }
        
        conex.Desconecta();
     }
    public void EditarInformacoes(BeansGrupos grupos,String tabela){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update "+ tabela+"  set forma_pagamento=?,valor=?,numero_parcelas=?,parcelas_pagas=?,valor_pago=?,embarque=? where codigo=?");
            pst.setString(1,grupos.getFormaPagamento());
            pst.setDouble(2,grupos.getValor());
            pst.setInt(3,grupos.getNumeroParcelas());
            pst.setInt(4,grupos.getParcelasPagas());
            pst.setDouble(5,grupos.getValorPago());
            pst.setString(6,grupos.getEmbarque());
            pst.setInt(7,grupos.getCodigo());
              pst.execute();
              JOptionPane.showMessageDialog(null,"Informações alteradas com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao alterar dados\n" + ex);
        }
        
        conex.Desconecta();
     }
     public void Editar(BeansGrupos grupos){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update grupos_excursoes  set valores_fixos=?,valores_oscilantes=?,vagas=?,preco_venda=? where codigo=?");
            pst.setDouble(1,grupos.getValoresFixos());
            pst.setDouble(2,grupos.getValoresOscilantes());
            pst.setInt(3,grupos.getVagas());
            pst.setDouble(4,grupos.getPrecoVenda());
            pst.setInt(5,grupos.getCodigo());
              pst.execute();
              JOptionPane.showMessageDialog(null,"Informações alteradas com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao alterar dados\n" + ex);
        }
        
        conex.Desconecta();
     }
     public void Encerrar(BeansGrupos grupos,int codigo){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into lucratividade_grupos(nome,data_fechamento,valor_lucrado) values (?,?,?)");
            pst.setString(1, grupos.getNome());
            pst.setString(2, grupos.getData_fechamento());
            pst.setDouble(3, grupos.getLucro());            
            pst.execute();
            PreparedStatement ps = conex.con.prepareStatement("update grupos_excursoes set situacao='Fechado' where codigo="+codigo+"");
            ps.execute();
            JOptionPane.showMessageDialog(null, "Grupo encerrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao encerrar grupo\n" + ex);
        }
        conex.Desconecta();
    }
     public void RealizarDevolucao(BeansGrupos grupos) {
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update devolucoes set situacao='Fechada' where codigo=?");
            pst.setInt(1, grupos.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Devolução efetuada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao efetuar devolução\n" + ex);
        }

        conex.Desconecta();
    }
     public void ExcluirLucratividade(BeansGrupos grupos) {
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from lucratividade_grupos where codigo=?");
            pst.setInt(1, grupos.getCodigo());
            pst.execute();                    
            JOptionPane.showMessageDialog(null, "Registro excluido com sucesso com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir registro\n" + ex);
        }

        conex.Desconecta();
    }
    
}
