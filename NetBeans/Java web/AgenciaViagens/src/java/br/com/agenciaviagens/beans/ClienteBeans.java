package br.com.agenciaviagens.beans;

import br.com.agenciaviagens.dao.ClienteDao;
import br.com.agenciaviagens.dao.VendaDao;
import br.com.agenciaviagens.domain.Cliente;
import br.com.agenciaviagens.domain.Venda;
import br.com.agenciaviagens.util.JSFUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@ManagedBean(name = "MBCliente")
@ViewScoped
public class ClienteBeans {

    private boolean email;
    private int codigo;
    private int acao;
    private Cliente cliente;
    private ArrayList<Cliente> lista;
    private ArrayList<Cliente> listaFiltrada;
    private String mensagem;
    private String assunto;
    private ArrayList<Venda> listaVenda;
    @ManagedProperty(value = "#{MBAutenticacao}")
    private MBAutenticacao MBAutenticacao;

    public MBAutenticacao getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(MBAutenticacao MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
    }

    public ArrayList<Venda> getListaVenda() {
        return listaVenda;
    }

    public void setListaVenda(ArrayList<Venda> listaVenda) {
        this.listaVenda = listaVenda;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public ArrayList<Cliente> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Cliente> lista) {
        this.lista = lista;
    }

    public ArrayList<Cliente> getListaFiltrada() {
        return listaFiltrada;
    }

    public void setListaFiltrada(ArrayList<Cliente> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getAcao() {
        return acao;
    }

    public void setAcao(int acao) {
        this.acao = acao;
    }

    public boolean isEmail() {
        return email;
    }

    public void setEmail(boolean email) {
        this.email = email;
    }

    /*----------------------------------Codigo--------------------------------------------------------------------*/
    public void salvar() {
        ClienteDao dao = new ClienteDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            if (email) {
                cliente.setEmail("Não tem email");
            }
            dao.Salvar(cliente);
            JSFUtil.mensagemSucesso("Cliente registrado com sucesso");
            FacesContext.getCurrentInstance().getExternalContext().redirect("clientes.xhtml");
        } catch (SQLException | IOException ex) {
            JSFUtil.mensagemSucesso("Erro ao registrar cliente" + ex);
        }finally{
            dao = null;
        }
    }

    public void alterar() {
        ClienteDao dao = new ClienteDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            if (email) {
                cliente.setEmail("Não tem email");
            }
            dao.Alterar(cliente);
            JSFUtil.mensagemSucesso("Cliente alterado com sucesso");
            FacesContext.getCurrentInstance().getExternalContext().redirect("clientes.xhtml");
        } catch (SQLException | IOException ex) {
            JSFUtil.mensagemErro("Erro ao alterar cliente" + ex);
        }finally{
            dao = null;
        }
    }

    public void excluir(int c) {
        ClienteDao dao = new ClienteDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            dao.excluir(c);
            listar();
            JSFUtil.mensagemSucesso("Cliente excluido com sucesso");           
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar clientes" + ex);
        }finally{
            dao = null;
        }
    }

    public void listar() {
        ClienteDao dao = new ClienteDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            lista = dao.Listar();
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar clientes" + ex);
        }
    }

    public void carregarCadastro() {
        ClienteDao dao = new ClienteDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            if (acao == 1) {
                cliente = new Cliente();
            } else {
                cliente = dao.buscarPorCodigo(codigo);
            }
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao buscar cliente por codigo " + ex);
        }
    }

    public void enviaEmail() {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MBAutenticacao.getEmpresa().getEmail(), MBAutenticacao.getEmpresa().getSenha());
            }
        });
        session.setDebug(true);
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(MBAutenticacao.getEmpresa().getEmail())); //Remetente
            Address[] toUser = InternetAddress //Destinatário(s)
                    .parse(cliente.getEmail());//"lucas100colorado@hotmail.com, lucasbertoldidias@gmail.com"
            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(assunto);//Assunto
            message.setText(mensagem);
            Transport.send(message);
            assunto = "";
            mensagem = "";
            JSFUtil.mensagemSucesso("Email enviado com sucesso");
        } catch (MessagingException e) {
            JSFUtil.mensagemErro("Erro ao enviar email" + e);
        }
    }

    public void buscarVendas(int codigo) {
        VendaDao daov = new VendaDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            listaVenda = daov.buscarCliente(codigo);
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao buscar compras do cliente " + ex);
        }
    }
}
