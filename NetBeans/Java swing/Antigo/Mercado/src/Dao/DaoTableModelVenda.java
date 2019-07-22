package Dao;

import Beans.BeansPreencheTableVenda;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class DaoTableModelVenda extends AbstractTableModel{

    private List <BeansPreencheTableVenda> dados = new ArrayList<>();
    private String[] colunas = {"Codigo","Descrição","Quantidade","Valor","Fornecedor","Categoria"};
    
    
     @Override
    public String getColumnName(int column) {
        return colunas [column];
        
    }
    
        
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:
                return dados.get(linha).getCodigo();
            case 1:
                return dados.get(linha).getDescricao();
            case 2:
                return dados.get(linha).getQtd();
            case 3:
                return dados.get(linha).getValor();
            case 4:
                return dados.get(linha).getFornecedor();
            case 5:
                return dados.get(linha).getCategoria();
        
        }
        return null;
    }
    
    @Override
    public void setValueAt(Object valor, int linha, int coluna){
        switch(coluna){
            case 0:
                dados.get(linha).setCodigo((String)valor);
                break;
            case 1:
                dados.get(linha).setDescricao((String)valor);
                break;
            case 2:
                dados.get(linha).setQtd(Integer.parseInt((String)valor));
                 break;
            case 3:
                dados.get(linha).setValor(Double.parseDouble((String)valor));
                 break;
            case 4:
                dados.get(linha).setFornecedor((String)valor);
                break;
            case 5:
                dados.get(linha).setCategoria((String)valor);
        }
        this.fireTableCellUpdated(linha, linha);
    }
    
    
    public void addLinha(BeansPreencheTableVenda p){
        this.dados.add(p);
        this.fireTableDataChanged();
     }
    
    public void removeLinha(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    public void removeTudo(int linha){
        this.dados.removeAll(dados);
        this.fireTableRowsDeleted(linha, linha);
    }
    
}