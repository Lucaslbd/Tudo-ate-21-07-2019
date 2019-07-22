package br.com.loja.tabelas;

import br.com.loja.conexaoBD.ConexaoBD;
import br.com.loja.domain.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tabelas {

    public void IniciaPrograma() {
        Tabelas tabela = new Tabelas();
        tabela.TabelaFornecedor();
        tabela.TabelaProduto();
        tabela.TabelaFuncionario();
        tabela.TabelaVenda();
        tabela.TabelaItens();
        tabela.TabelaPagamento();
        tabela.TabelaSalario();
        tabela.TabelaHoras();
        tabela.TabelaDespesas();
        tabela.TabelaSangria();
        tabela.TabelaEmpresa();
        tabela.TabelaCerificadoDigital();
        tabela.TabelaCliente();
        tabela.TabelaCrediario();
        tabela.TabelaListaChegada();
        tabela.ChegadaMercadoria();
        tabela.baixa();
        tabela.Compra_cliente();
        tabela.InseriPrimeiraEmpresa();
        tabela.InseriPrimeiroUsuario();
        TabelaInss();
        TabelaIrrf();
     
    }

    public void TabelaFornecedor() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table fornecedor (codigo_fornecedor serial not null PRIMARY KEY, nome character varying(60) not null, email character varying(60) not null, telefone character varying(20) not null, cnpj character varying(20) not null unique)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de fornecedor criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de fornecedor" + ex.getMessage());
        }
    }

    public void TabelaProduto() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table produto(codigo_produto character varying(60) not null PRIMARY KEY, descricao character varying(60) not null, estoque integer not null, preco double precision not null, preco_custo double precision not null, fornecedor integer not null, FOREIGN KEY (fornecedor) REFERENCES fornecedor(codigo_fornecedor) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de produto criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de produto" + ex.getMessage());
        }
    }

    public void TabelaFuncionario() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table funcionario(codigo_funcionario serial not null PRIMARY KEY, nome character varying(60) not null, funcao character varying(60) not null, telefone character varying(20) not null, cpf character varying(20) not null unique, senha character varying(20) not null, salario double precision not null, situacao character varying(20) not null,fgts integer not null)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de funcionario criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de funcionario" + ex.getMessage());
        }
    }

    public void TabelaVenda() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table venda(codigo_venda serial not null PRIMARY KEY, data timestamp with time zone not null, valor_venda double precision not null,lucro double precision not null, funcionario integer not null, FOREIGN KEY (funcionario) REFERENCES funcionario(codigo_funcionario) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de venda criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de venda" + ex.getMessage());
        }
    }

    public void TabelaItens() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table item(codigo_item serial not null PRIMARY KEY, quantidade integer not null, valor_total double precision not null, valor_custo double precision not null,valor_unitario double precision not null, produto character varying(60) not null, venda integer not null, FOREIGN KEY (produto) REFERENCES produto(codigo_produto) ON UPDATE CASCADE ON DELETE CASCADE, FOREIGN KEY (venda) REFERENCES venda(codigo_venda) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de itens criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de itens" + ex.getMessage());
        }
    }

    public void TabelaPagamento() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table pagamento(codigo_pagamento serial  not null PRIMARY KEY, forma_pagamento character varying(60) not null, valor_pagamento double precision not null, venda integer not null, FOREIGN KEY (venda) REFERENCES venda(codigo_venda) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de pagamento criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de pagamento" + ex.getMessage());
        }
    }

    public void TabelaSalario() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table folha_pagamento(codigo_salario serial not null PRIMARY KEY, valor_salario double precision not null, data character varying(10) not null, descricao character varying(60), funcionario integer not null, FOREIGN KEY (funcionario) REFERENCES funcionario(codigo_funcionario) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de salario criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de salario" + ex.getMessage());
        }
    }

    public void TabelaHoras() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table ponto(codigo_hora serial not null PRIMARY KEY, data_hora timestamp with time zone not null, descricao character varying(60) not null, funcionario integer not null, FOREIGN KEY (funcionario) REFERENCES funcionario(codigo_funcionario) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de ponto criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de ponto" + ex.getMessage());
        }
    }

    public void TabelaDespesas() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table despesa(codigo_despesa serial not null PRIMARY KEY, data date not null, descricao character varying(60) not null, valor double precision not null)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de despesas criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de despesas" + ex.getMessage());
        }
    }

    public void TabelaSangria() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table sangria(codigo serial not null PRIMARY KEY, data_hora timestamp with time zone not null, natureza character varying(60) not null, valor double precision not null, desricao character varying(60))");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de sangria criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de sangria" + ex.getMessage());
        }
    }

    public void TabelaEmpresa() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table empresa(codigo_empresa serial not null PRIMARY KEY, cnpj character varying(20) not null, inscricao_estadual character varying(60) not null, crt character varying(60) not null, razao_social character varying(60), nome_fantasia character varying(60), cep character varying(15), cidade character varying(60) , bairro character varying(60), rua character varying(60), numero character varying(10),email character varying(100) not null,senha character varying(100) not null)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de empresa criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de empresa" + ex.getMessage());
        }
    }

    public void TabelaCerificadoDigital() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table certificado_digital(codigo_certificado serial  not null PRIMARY KEY, senha_truststore character varying(60) not null, senha_keystore character varying(60) not null, csc_homologacao character varying(100) not null, csc_producao character varying(60) not null, empresa integer not null, FOREIGN KEY (empresa) REFERENCES empresa(codigo_empresa))");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de certidicado digital criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de certificado" + ex.getMessage());
        }
    }

    public void TabelaCliente() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table cliente(codigo_cliente serial not null PRIMARY KEY, nome character varying(60) not null, rg character varying(60) not null, cpf character varying(20) not null, cidade character varying(60), bairro character varying(60), rua character varying(60), numero character varying(20), telefone character varying(60), email character varying(60))");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de cliente criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de cliente" + ex.getMessage());
        }
    }

    public void TabelaCrediario() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table crediario(codigo_crediario serial  not null PRIMARY KEY, cliente integer not null, venda integer not null, FOREIGN KEY (cliente) REFERENCES cliente(codigo_cliente) ON UPDATE CASCADE ON DELETE CASCADE, FOREIGN KEY (venda) REFERENCES venda(codigo_venda) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de crediario criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de crediario" + ex.getMessage());
        }
    }

    public void TabelaListaChegada() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table lista(codigo_lista serial not null PRIMARY KEY, produto character varying(60) not null, qtd_chegada integer not null, FOREIGN KEY (produto) REFERENCES produto(codigo_produto) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela lista de chegada criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela  lista de chegada" + ex.getMessage());
        }
    }

    public void ChegadaMercadoria() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table chegada_mercadoria(codigo_chegada serial not null PRIMARY KEY, data date not null, descricao character varying(60) not null, lista integer not null, FOREIGN KEY (lista) REFERENCES lista(codigo_lista) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de chegada de mercadoria criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de chegada de mercadoria" + ex.getMessage());
        }
    }

    public void baixa() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table baixa(codigo_baixa serial not null PRIMARY KEY, data date not null, motivo character varying(60) not null, produto character varying(60) not null, custo double precision not null, custo_para character varying(60) not null, FOREIGN KEY (produto) REFERENCES produto(codigo_produto) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de baixa criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de baixa" + ex.getMessage());
        }
    }
    public void Compra_cliente() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table compra_cliente(codigo_compra serial not null PRIMARY KEY, cliente integer not null, venda integer not null, FOREIGN KEY (cliente) REFERENCES cliente(codigo_cliente) ON UPDATE CASCADE ON DELETE CASCADE, FOREIGN KEY (venda) REFERENCES venda(codigo_venda) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela compra cliente criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela compra cliente" + ex.getMessage());
        }
    }
    public void TabelaImpostoCliente() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table imposto_funcionario(descricao character varying(10) NOT NULL PRIMARY KEY,valor_inicial double precision NOT NULL,valor_final double precision NOT NULL, porcentagem integer NOT NULL,deducao double precision NOT NULL))");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de imposto criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de imposto" + ex.getMessage());
        }
    }
    public void TabelaInss() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table inss(codigo serial not null PRIMARY KEY, valor_inicial double precision NOT NULL, valor_final double precision NOT NULL, porcentagem double precision NOT NULL)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de inss criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de inss" + ex.getMessage());
        }
    }
    public void TabelaIrrf() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table irrf(codigo serial not null PRIMARY KEY, valor_inicial double precision NOT NULL, valor_final double precision NOT NULL, porcentagem double precision NOT NULL, devolver double precision NOT NULL)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de irrf criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de irrf" + ex.getMessage());
        }
    }

    public void InseriPrimeiraEmpresa() {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into empresa(codigo_empresa, cnpj, inscricao_estadual, crt, razao_social, nome_fantasia, cidade, bairro, rua, numero, cep, email,senha) values (1,'00.000.000/0000-00','0000000000','00','razaão social','fantasia','cidade','bairro','rua','N°','00000-000','Email','1234')");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("empresa adicionada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao adicionar empresa" + ex.getMessage());
        }
    }    

    public void InseriPrimeiroUsuario() {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into funcionario(nome, funcao, telefone, cpf, senha, salario, situacao,fgts) values ('admin','admin','000 0 0000-0000','000.000.000-00','admin',0,'admitido',0)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("funcionario adicionado com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao adicionar funcionario" + ex.getMessage());
        }
    }    

    public Empresa Verifica() {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from empresa ");
        Connection conexao;
        try {
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            Empresa empresa = null;
            if (resultado.next()) {
                empresa = new Empresa();
                empresa.setCodigo(resultado.getInt("codigo_empresa"));
                empresa.setCnpj(resultado.getString("cnpj"));
                empresa.setInscricaoEstadual(resultado.getString("inscricao_estadual"));
                empresa.setCrt(resultado.getString("crt"));
                empresa.setRazaoSocial(resultado.getString("razao_social"));
                empresa.setNomeFantasia(resultado.getString("nome_fantasia"));
                empresa.setCep(resultado.getString("cep"));
                empresa.setCidade(resultado.getString("cidade"));
                empresa.setBairro(resultado.getString("bairro"));
                empresa.setRua(resultado.getString("rua"));
                empresa.setNumero(resultado.getString("numero"));
                empresa.setEmail(resultado.getString("email"));
                empresa.setSenha(resultado.getString("senha"));
                return empresa;
            }
        } catch (SQLException ex) {
           
        }
        return null;
    }
}
