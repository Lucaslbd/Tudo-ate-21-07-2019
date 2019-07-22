
package modeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modeloBeans.BeansAgenda;
import modeloConection.ConexaoBD;


public class DaoAgenda {
    BeansAgenda agenda = new BeansAgenda();
    ConexaoBD conex = new ConexaoBD();
     ConexaoBD conexPaciente = new ConexaoBD();
     ConexaoBD conexMedico = new ConexaoBD();
     int codMed;
     int codPac;
     
     public void Salvar(BeansAgenda agenda){
         BuscaMedico(agenda.getNomeMed());
         BuscaPaciente(agenda.getNomePac());
         conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into agenda(agenda_codpac,agenda_codmedico,agenda_motivo,agenda_turno,agenda_data,agenda_status)values(?,?,?,?,?,?)");
        pst.setInt(1, codPac);
        pst.setInt(2, codMed);
        pst.setString(3,agenda.getMotivo());
        pst.setString(4,agenda.getTurno());
        pst.setDate(5,new java.sql.Date(agenda.getData().getTime()));
        pst.setString(6,agenda.getStatus());
        pst.execute();
         JOptionPane.showMessageDialog(null,"Agendamento marcado com sucesso");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Erro ao inserir agendamento" + ex.getMessage());
        }
         conex.Desconecta();
         
         
     }
     public void BuscaMedico(String nomeMedico){
         conexMedico.Conexao();
         conexMedico.executaSql("select * from medicos where nome_medico='"+nomeMedico+"'");
        try {
            conexMedico.rs.first();
            codMed = conexMedico.rs.getInt("cod_medico");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Medico não encontrado" + ex.getMessage());
        }
         
     }
      public int BuscaCodMedico(String nomeMedico){
         conexMedico.Conexao();
         conexMedico.executaSql("select * from medicos where nome_medico='"+nomeMedico+"'");
        try {
            conexMedico.rs.first();
            codMed = conexMedico.rs.getInt("cod_medico");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Medico não encontrado" + ex.getMessage());
        }
        return codMed;
      }
      public void BuscaPaciente(String nomePaciente){
           conexPaciente.Conexao();
         conexPaciente.executaSql("select * from pacientes where pac_nome='"+nomePaciente+"'");
        try {
            conexPaciente.rs.first();
            codPac = conexPaciente.rs.getInt("pac_cod");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Paciente não encontrado" + ex.getMessage());
        }
          
      }
      public void alterar(BeansAgenda agenda){
      conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update agenda set agenda_status=? where agenda_cod=?");
            pst.setString(1,agenda.getStatus());
            pst.setInt(2,agenda.getAgendaCod());
           pst.execute();
            JOptionPane.showMessageDialog(null,"Em atendimento");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao alterar dados\n" + ex.getMessage());
        }
        conex.Desconecta();
    }
    
}
