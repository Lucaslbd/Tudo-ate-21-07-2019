package br.com.agenciaviagens.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class ModeloComboBox extends AbstractListModel implements ComboBoxModel {

    private List<Object> lista;
    private Object ObjetoSelecionado;

    public ModeloComboBox() {
        this.lista = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public Object getElementAt(int index) {
        return this.lista.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if (anItem instanceof Object) {
            this.ObjetoSelecionado = (Object) anItem;
            fireContentsChanged(this.lista, 0, lista.size());
        }
    }

    @Override
    public Object getSelectedItem() {
        return this.ObjetoSelecionado;
    }

    public void addObject(Object object){
        this.lista.add(object);
    }
    
    public void reset(){
        this.lista.clear();
    }
    
    public void recebeLista(ArrayList<Object>l){
        lista = l;
    }    
}
