package br.com.agenciaviagens.beans;

import br.com.agenciaviagens.dao.ClienteDao;
import br.com.agenciaviagens.dao.LembretesDao;
import br.com.agenciaviagens.dao.VendaDao;
import br.com.agenciaviagens.domain.Aviso;
import br.com.agenciaviagens.domain.Cliente;
import br.com.agenciaviagens.domain.Lembretes;
import br.com.agenciaviagens.domain.Venda;
import br.com.agenciaviagens.util.JSFUtil;
import br.com.agenciaviagens.util.UtilitarioDao;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBAviso")
@ViewScoped
public class AvisoBeans {

    private ArrayList<Aviso> lista;
    @ManagedProperty(value = "#{MBAutenticacao}")
    private MBAutenticacao MBAutenticacao;

    public MBAutenticacao getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(MBAutenticacao MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
    }

    public ArrayList<Aviso> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Aviso> lista) {
        this.lista = lista;
    }

    public ArrayList<Aviso> buscaAviso() throws SQLException {
        UtilitarioDao util = new UtilitarioDao();
        ArrayList<Aviso> listaAviso = new ArrayList<>();
        ClienteDao clienteDao = new ClienteDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        VendaDao vendaDao = new VendaDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        LembretesDao lb = new LembretesDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        ArrayList<Cliente> listaAniver = clienteDao.buscaAniversario();
        ArrayList<Venda> listaVenda = vendaDao.buscaCheckin();
        ArrayList<Lembretes> listaLembretes = lb.ListarDoDia();

        //Buscar aniver
        for (Cliente c : listaAniver) {
            Aviso aviso = new Aviso();
            aviso.setTitulo("Aniversário");
            aviso.setTexto(c.getNome());
            aviso.setMotivo("Esta completando " + util.subtrairData(c.getNascimento()) + " anos");
            aviso.setAcao(1);
            listaAviso.add(aviso);
        }

        //buscar checkin
        for (Venda c : listaVenda) {
            Aviso aviso = new Aviso();
            aviso.setTitulo("Checkin as " + c.getHoraCheckin() + " - Ref = " + c.getReferencia());
            aviso.setTexto(c.getCliente().getNome());
            aviso.setMotivo(c.getDescricao());
            aviso.setAcao(2);
            listaAviso.add(aviso);
        }

        //buscar pagamento
        listaVenda = vendaDao.buscarDiaPagamento();
        for (Venda c : listaVenda) {
            Aviso aviso = new Aviso();
            aviso.setTitulo("Pagamento a receber");
            aviso.setTexto(c.getFornecedor().getNome() + " - Ref = " + c.getReferencia());
            aviso.setMotivo(util.DecimalFormat(c.getValorReceber()));
            aviso.setAcao(2);
            listaAviso.add(aviso);
        }

        //buscar lembretes        
        for (Lembretes c : listaLembretes) {
            Aviso aviso = new Aviso();
            aviso.setTitulo("Lembrete");
            aviso.setTexto(c.getTexto());
            aviso.setMotivo("");
            aviso.setAcao(2);
            listaAviso.add(aviso);
        }

        return listaAviso;
    }

    public void avisar() {
        try {
            lista = buscaAviso();
        } catch (SQLException ex) {
            JSFUtil.mensagemSucesso("Erro ao avisar" + ex);
        }
    }
}
