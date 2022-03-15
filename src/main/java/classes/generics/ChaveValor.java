package classes.generics;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class ChaveValor<C extends Number, V> {
    private final Set<GenericComChaveValor<C, V>> itens = new HashSet<>();
    
    public void adicionar(C chave, V valor){
        //Essa chamada de return apenas sai do método.
        if(chave == null) return;
        
        GenericComChaveValor<C,V> novo = new GenericComChaveValor<C,V>(chave, valor);
        
        //Verificando se o item já está na lista. Se sim, eu atualizo a lista
        if(itens.contains(novo)){
            itens.remove(novo);
        }
        
        itens.add(new GenericComChaveValor<C, V>(chave, valor));
    }
}
