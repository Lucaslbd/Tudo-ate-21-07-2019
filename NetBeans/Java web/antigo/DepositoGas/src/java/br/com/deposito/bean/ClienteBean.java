package br.com.deposito.bean;

import br.com.deposito.dao.ClienteDao;
import br.com.deposito.domain.Cliente;
import br.com.deposito.domain.HistoricoCliente;
import br.com.deposito.util.JSFUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

@ManagedBean(name = "MBCliente")
@ViewScoped
public class ClienteBean {

    private Cliente cliente;
    private ArrayList<Cliente> listaCliente;
    private ArrayList<Cliente> listaClienteFiltrada;
    @ManagedProperty(value = "#{MBAutenticacao}")
    private BeanAutenticar MBAutenticacao;
    private String senha;
    private String assunto;
    private String conteudo;
    private boolean email = false;
    private ArrayList<HistoricoCliente> listaVenda;

    public ArrayList<HistoricoCliente> getListaVenda() {
        return listaVenda;
    }

    public void setListaVenda(ArrayList<HistoricoCliente> listaVenda) {
        this.listaVenda = listaVenda;
    }

    public boolean isEmail() {
        return email;
    }

    public void setEmail(boolean email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(ArrayList<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public ArrayList<Cliente> getListaClienteFiltrada() {
        return listaClienteFiltrada;
    }

    public void setListaClienteFiltrada(ArrayList<Cliente> listaClienteFiltrada) {
        this.listaClienteFiltrada = listaClienteFiltrada;
    }

    public BeanAutenticar getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(BeanAutenticar MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
    }

//aqui começa a implementação-------------------------------------------------------------------------
    public void listar() {
        ClienteDao dao = new ClienteDao();
        try {
            listaCliente = dao.Listar(MBAutenticacao.getUsuario().getDeposito().getCodigo());
           
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar clientes " + ex);
        }
    }

    public void atualizarObjeto() {
        cliente = new Cliente();
    }

    public void salvar() {
        ClienteDao dao = new ClienteDao();
        try {
            if (email == false) {
                cliente.setEmail("Não possui email");
            }
            cliente.setDeposito(MBAutenticacao.getUsuario().getDeposito());
            dao.Salvar(cliente);
            JSFUtil.mensagemSucesso("cliente registrado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao registrar cliente" + ex);
        }
    }

    public void alterar() {
        ClienteDao dao = new ClienteDao();
        try {
            dao.Alterar(cliente);
            JSFUtil.mensagemSucesso("cliente alterado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao alterar cliente " + ex);
        }
    }

    public void excluir() {
        ClienteDao dao = new ClienteDao();
        try {
            dao.excluir(cliente);
            JSFUtil.mensagemSucesso("cliente removido com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao excluir cliente " + ex);
        }
    }

    public void limparEmail() {
        assunto = "";
        conteudo = "";
        senha = "";
    }

    public void enviarEmail() {
        if (listaCliente == null) {
            listaCliente = new ArrayList<>();
        }
        if (listaClienteFiltrada == null) {
            listaClienteFiltrada = new ArrayList<>();
        }
        if (listaCliente.isEmpty()) {
            JSFUtil.mensagemErro("Não existem clientes para enviar email");
        } else {
            if (listaClienteFiltrada.isEmpty()) {
                int i = 0;
                try {
                    for (Cliente g : listaCliente) {
                        if (!"Não possui email".equals(g.getEmail())) {
                            SimpleEmail emai = new SimpleEmail();
                            emai.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail
                            emai.addTo(g.getEmail()); //destinatário
                            emai.setFrom(MBAutenticacao.getUsuario().getDeposito().getEmail()); // remetente
                            emai.setSubject(assunto);  // assunto do e-mail
                            emai.setMsg(conteudo); //conteudo do e-mail
                            emai.setAuthentication(MBAutenticacao.getUsuario().getDeposito().getEmail(), senha);
                            emai.setSmtpPort(587);  //465 ou 587                   
                            emai.setTLS(true);
                            emai.send();
                            i++;
                        }
                    }
                    JSFUtil.mensagemSucesso("Foram enviandos " + i + " emails com sucesso");
                    assunto = "";
                    conteudo = "";
                    senha = "";
                } catch (EmailException ex) {
                    JSFUtil.mensagemErro("Erro ao enviar email " + ex);
                }
            } else {
                int i = 0;
                try {
                    for (Cliente g : listaClienteFiltrada) {
                        if (!"Não possui email".equals(g.getEmail())) {
                            SimpleEmail emai = new SimpleEmail();
                            emai.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail
                            emai.addTo(g.getEmail()); //destinatário
                            emai.setFrom(MBAutenticacao.getUsuario().getDeposito().getEmail()); // remetente
                            emai.setSubject(assunto);  // assunto do e-mail
                            emai.setMsg(conteudo); //conteudo do e-mail
                            emai.setAuthentication(MBAutenticacao.getUsuario().getDeposito().getEmail(), senha);
                            emai.setSmtpPort(587);  //465 ou 587                   
                            emai.setTLS(true);
                            emai.send();
                            i++;
                        }
                    }
                    JSFUtil.mensagemSucesso("Foram enviandos " + i + " emails com sucesso");
                    assunto = "";
                    conteudo = "";
                    senha = "";
                } catch (EmailException ex) {
                    JSFUtil.mensagemErro("Erro ao enviar email " + ex);
                }
            }
        }
    }

    public void listarPorVenda(int codigo) {
        ClienteDao dao = new ClienteDao();
        try {
            listaVenda = dao.ListarHistoricoPorCliente(codigo);
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar itens " + ex);
        }
    }
}
