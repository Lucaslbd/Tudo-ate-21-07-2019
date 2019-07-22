package br.com.agenciaviagens.beans;

import br.com.agenciaviagens.dao.ClienteDao;
import br.com.agenciaviagens.dao.GrupoDao;
import br.com.agenciaviagens.dao.PassageiroDao;
import br.com.agenciaviagens.domain.Cliente;
import br.com.agenciaviagens.domain.Grupo;
import br.com.agenciaviagens.domain.Passageiro;
import br.com.agenciaviagens.ralatorio.Contrato;
import br.com.agenciaviagens.ralatorio.ContratoDao;
import br.com.agenciaviagens.ralatorio.Voucher;
import br.com.agenciaviagens.ralatorio.VoucherDao;
import br.com.agenciaviagens.util.JSFUtil;
import br.com.agenciaviagens.util.UtilitarioDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import net.sf.jasperreports.engine.JRException;

@ManagedBean(name = "MBPassageiro")
@ViewScoped
public class PassageiroBeans {

    private int codigo;
    private int acao;
    private Passageiro passageiro;
    private ArrayList<Passageiro> lista;
    private ArrayList<Grupo> listaGrupo;
    @ManagedProperty(value = "#{MBAutenticacao}")
    private MBAutenticacao MBAutenticacao;
    private ArrayList<Cliente> listaCliente;
    private double valor;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public ArrayList<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(ArrayList<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public ArrayList<Passageiro> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Passageiro> lista) {
        this.lista = lista;
    }

    public ArrayList<Grupo> getListaGrupo() {
        return listaGrupo;
    }

    public void setListaGrupo(ArrayList<Grupo> listaGrupo) {
        this.listaGrupo = listaGrupo;
    }

    public MBAutenticacao getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(MBAutenticacao MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
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

    /*----------------------------------Codigo--------------------------------------------------------------------*/
    public void salvar() {
        PassageiroDao dao = new PassageiroDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            dao.Salvar(passageiro);
            JSFUtil.mensagemSucesso("Passageiro registrado com sucesso");
            FacesContext.getCurrentInstance().getExternalContext().redirect("passageiro.xhtml");
        } catch (SQLException | IOException ex) {
            JSFUtil.mensagemSucesso("Erro ao registrar passageiro" + ex);
        }
    }

    public void alterar() {
        PassageiroDao dao = new PassageiroDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            dao.Alterar(passageiro);
            JSFUtil.mensagemSucesso("Passageiro alterado com sucesso");
            FacesContext.getCurrentInstance().getExternalContext().redirect("passageiro.xhtml");
        } catch (SQLException | IOException ex) {
            JSFUtil.mensagemSucesso("Erro ao alterar passageiro " + ex);
        }
    }

    public void excluir(int c) {
        PassageiroDao dao = new PassageiroDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            dao.excluir(c);
            listar();
            JSFUtil.mensagemSucesso("Passageiro removido com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemSucesso("Erro ao excluir passageiro " + ex);
        }
    }

    public void listar() {
        PassageiroDao dao = new PassageiroDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            lista = dao.Listar(codigo);
            valor = 0;
            for (Passageiro p : lista) {
                valor += p.getValor();
            }
            JSFUtil.mensagemSucesso("Foram encontrados " + lista.size() + " passageiros");
        } catch (SQLException ex) {
            JSFUtil.mensagemSucesso("Erro ao listar fornecedor" + ex);
        }
    }

    public void carregarCadastro() {
        PassageiroDao dao = new PassageiroDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        buscarGrupos2();
        try {
            if (acao == 1) {
                passageiro = new Passageiro();
            } else {
                passageiro = dao.buscarPorCodigo(codigo);
            }
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao buscar fornecedor por codigo " + ex);
        }
    }

    public void buscarGrupos() {
        GrupoDao daov = new GrupoDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            listaGrupo = daov.ListarEmAndamento();
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao buscar compras do cliente " + ex);
        }
    }

    public void buscarGrupos2() {
        GrupoDao daov = new GrupoDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        ClienteDao daoc = new ClienteDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            listaCliente = daoc.Listar();
            listaGrupo = daov.ListarEmAndamento();
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao buscar compras do cliente " + ex);
        }
    }

    public void imprimirContrato(int c) {
        UtilitarioDao util = new UtilitarioDao();
        PassageiroDao dao = new PassageiroDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            Passageiro pax = dao.buscarPorCodigo(c);
            Contrato contrato = new Contrato();
            String acompanhantes = pax.getCliente().getNome();
            int num = 1;
            double valor = pax.getValor();
            for (Passageiro p : lista) {
                if (pax.getCliente().getCodigo() == p.getTitular() && pax.getCliente().getCodigo() != p.getCliente().getCodigo()) {
                    acompanhantes += ", " + p.getCliente().getNome();
                    valor += p.getValor();
                    num++;
                }
            }
            String ter = " o(a) qual terá";
            if (num > 1) {
                ter = "os quais terão";
            }
            contrato.setContratado("A empresa " + MBAutenticacao.getEmpresa().getNomeEmpresa()
                    + " portadora do CNPJ: " + MBAutenticacao.getEmpresa().getCnpj() + " estará realizando"
                    + " na data " + util.dateXstring(pax.getGrupo().getData())
                    + " o passeio denominado " + pax.getGrupo().getNome_grupo()
                    + " com valor de " + util.DecimalFormat(valor)
                    + " referênte ao numero de " + num + " passageiro(s) (" + acompanhantes + ") "
                    + ter + " embarque realizado na seguinte localidade: " + pax.getLocalEmbarque());
            contrato.setContratente("Eu " + pax.getCliente().getNome()
                    + " portador(a) do CPF: " + pax.getCliente().getCpf()
                    + " e RG: " + pax.getCliente().getRg() + " me declaro titular da reserva e confirmo a compra do serviço acima citado estando ciente de todas as cláusulas contidas neste contrato.");
            contrato.setAtividades(pax.getGrupo().getAtividades());
            ArrayList<Contrato> listaContrato = new ArrayList<>();
            listaContrato.add(contrato);
            ContratoDao d = new ContratoDao();
            d.Imprimir(listaContrato);
        } catch (JRException | IOException | SQLException ex) {
            JSFUtil.mensagemErro("Erro ao buscar compras do cliente " + ex);
        }
    }

    public void imprimirVoucher(int c) {
        UtilitarioDao util = new UtilitarioDao();
        PassageiroDao dao = new PassageiroDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            Passageiro pax = dao.buscarPorCodigo(c);
            String acompanhantes = "(";
            int num = 1;
            for (Passageiro p : lista) {
                if (pax.getCliente().getCodigo() == p.getTitular() && pax.getCliente().getCodigo() != p.getCliente().getCodigo()) {
                    acompanhantes += " " + p.getCliente().getNome() + ",";
                    num++;
                }
            }
            acompanhantes += ")";
            Voucher voucher = new Voucher();
            voucher.setCnpj("CNPJ: " + MBAutenticacao.getEmpresa().getCnpj());
            voucher.setData("Data do passeio: "+util.dateXstring(pax.getGrupo().getData()));
            voucher.setEmpresa(MBAutenticacao.getEmpresa().getNomeEmpresa());
            voucher.setPasseio("Descrição: "+pax.getGrupo().getNome_grupo());
            voucher.setPassageiro("Titular da reserva: "+pax.getCliente().getNome());
            voucher.setTelefone("Telefone da enpresa: "+MBAutenticacao.getEmpresa().getTelefone());
            voucher.setAtividades(pax.getGrupo().getAtividades());
            switch (num) {
                case 0:
                    voucher.setTexto("Este documento permite ao passageiro " + pax.getCliente().getNome() + " acesso a viagem permitindo assim acesso a todas as atividades declaradas em contrato.");
                    break;
                case 1:
                    voucher.setTexto("Este documento permite ao passageiro titular " + pax.getCliente().getNome() + " e seu dependente " + acompanhantes + " acesso a viagem permitindo assim acesso a todas as atividades declaradas em contrato.");
                    break;
                default:
                    voucher.setTexto("Este documento permite ao passageiro titular " + pax.getCliente().getNome() + " e seus dependentes " + acompanhantes + " acesso a viagem permitindo assim acesso a todas as atividades declaradas em contrato.");
                    break;
            }
            ArrayList<Voucher> listaVocher = new ArrayList<>();
            listaVocher.add(voucher);
            VoucherDao d = new VoucherDao();
            d.Imprimir(listaVocher);
        } catch (JRException | IOException | SQLException ex) {
            JSFUtil.mensagemErro("Erro ao buscar compras do cliente " + ex);
        }
    }
}
