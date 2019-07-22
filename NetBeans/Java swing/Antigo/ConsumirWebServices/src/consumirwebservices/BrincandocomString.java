package consumirwebservices;

import java.util.ArrayList;
import java.util.List;


public class BrincandocomString {
    
    public static void main(String[]args){
        BrincandocomString b = new BrincandocomString();
        b.buscarString();
    }
    
    private List<String> retorna(){
        List<String>lista = new ArrayList<>();
        String nome1 = "Lucas Bertoldi Dias";
        String nome2 = "Josenice Adriana Marques de Morais";
        String nome3 = "Juliano Guimaraes";
        String nome4 = "Angelina Jurema Fereira da Silva";
        String nome5 = "Generosa Lucas Alves";
        lista.add(nome1);
        lista.add(nome2);
        lista.add(nome3);
        lista.add(nome4);
        lista.add(nome5);
        return lista;
    }
    
    private void buscarString(){
         List<String>lista = retorna();
         List<String>listaFiltrada = new ArrayList<>();
         String busca = "jul";
         for(String t:lista){
             if(t.toUpperCase().contains(busca.toUpperCase())){
                listaFiltrada.add(t);
             }
         }         
         for(String t:listaFiltrada){
             System.out.println(t);
         }
    }
}
