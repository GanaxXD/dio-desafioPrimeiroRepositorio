package collections.de.java;

import java.util.*;

public class ExemploList {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        
        //Adiciona no próximo índice livre da lista
        nomes.add("Pedro");
        nomes.add("Luis");
        nomes.add("Maria");
        nomes.add("Aline");
        nomes.add("Julia");
    
        System.out.println(nomes);
        
        //Adiciona um elemento na lista num índice indicado, excluindo
        //o elemento que está no índice passado, se houver
        nomes.set(0, "Dimas");
        
        System.out.println(nomes);
        
        //Ordenando por ordem alfabética utilizando a classe Collection
        Collections.sort(nomes);
    
        //NOTA: ESSA ORDENAÇÃO TROCA A ORDEM DOS ELEMENTOS DA LISTA REAL
        //E SEUS ÍNDICES SÃO TROCADOS TAMBÉM
        System.out.println(nomes);
        
        //Passando em cada elemento da lista (iterar):
        //Usando Foreach
        for (String elemento :
             nomes ) {
            System.out.println(elemento);
        }
        //Usando o método Iterator: cria um objeto do tipo iterator
        //que aponta do primeiro elemento ao ultimo, podendo ser feito
        //algumas operações na lista usando ele. O next() retorna o elemento
        //que está sendo iterado.
        Iterator<String> iterator = nomes.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().intern());
        }
    
        System.out.println("--- VETOR ---\n\n");
        List<String> vetor = new Vector<>();
        
        vetor.add("Abacate");
        vetor.add("Juçara");
        vetor.add("Coco");
        vetor.add("Limão");
        vetor.add("Framboeza");
    
        System.out.println(vetor);
        
    }
}
