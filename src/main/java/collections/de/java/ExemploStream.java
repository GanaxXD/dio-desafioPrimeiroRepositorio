package collections.de.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ExemploStream {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
    
        //Adiciona no próximo índice livre da lista
        nomes.add("Pedro");
        nomes.add("Luis");
        nomes.add("Maria");
        nomes.add("Aline");
        nomes.add("Duglas");
        nomes.add("Alisson");
        nomes.add("Gil");
        nomes.add("Morena");
        nomes.add("Aline");
        nomes.add("André");
        nomes.add("Sérgio");
        nomes.add("Priscilla");
        nomes.add("Mariane");
        nomes.add("Marilene");
        nomes.add("Gilvanne");
        nomes.add("Geoconda");
        nomes.add("Jéssica");
        nomes.add("Kelliane");
        nomes.add("Arthur");
        nomes.add("Eduarda");
        nomes.add("Victor");
        
        System.out.println("Número de nomes: "+ nomes.stream().count());
    
        //Trás o nome com o maior/menor número de letras
        System.out.println("Número de nomes: "+ nomes.stream().max(Comparator.comparingInt(String::length)));
        System.out.println("Número de nomes: "+ nomes.stream().min(Comparator.comparingInt(String::length)));
    
        /*
        Filter: passo na função lambida a base de dados que estou estudando (a collection) ->
        Faço um teste que retorna um true ou false. Se for true, ele cria uma nova stream
        trazendo os dados que foram filtrados de acordo com a regra passada.
        
        Neste exemplo, verificarei quais nomes contém a letra "r". Os que possuírem
        serão exibidos em uma lista (java.util) por utilizar-mos o Collectors.toList().
         */
        System.out.println("Nomes que contém a letra \"R\": " +
            nomes.stream().filter(
                (nome)->
                    nome.toLowerCase(Locale.ROOT).contains("r"))
                    .collect(Collectors.toList())
        );
    
        /*
        Map: retorna uma coleção com o mesmo tamanho da original.
        Parece com o map do Dart. A ideia é criar uma nova colleção,
        com o mesmo número de elementos do obtido na base, só que transformando-o
        em alguma coisa (tipo, uma coleção do tipo Map(K,V) em um Objeto PEssoa,
        por exemplo.
        
        Neste exemplo eu vou transformar o elementos da coleção original
        adicionando na cópia, a quantidade de letras em cada nome
         */
        System.out.println(nomes.stream().map(
                (nome) -> nome.concat(" - ").concat(""+nome.length())
            ).collect(Collectors.toList())
        );
    
        //Limita o retorno ao número informado
        System.out.println(nomes.stream().limit(3).collect(Collectors.toList()));
    
        //Recebe uma função e a executa para cada elemento da lista retornado em uma coleção nova
        System.out.println(nomes.stream().peek(System.out::println).collect(Collectors.toList()));
    
        //Executa uma fnção em cada elemento da base SEM RETORNAR UMA COLEÇÃO
        nomes.stream().forEach(System.out::print);
    
        //Executa uma função e verifica se TODOS os elementos da lista
        //se enquadram na regra passada. Se sim, retorna TRUE, se não, se pelo
        //menos um elemento for false à regra passada, é retornado false.
        System.out.println("Todos os nomes possuem a letra X ? "+
            nomes.stream().allMatch((nome)-> nome.toLowerCase(Locale.ROOT).contains("w"))
        );
    
        //Parecido com o Allmatch, só que se pelo menos um elemento
        //se enquadrar na regra, ele retorna true
        System.out.println("Tem pelo menos um nome na lista com a letra \"Y\"? " +
            nomes.stream().anyMatch(
                    (nome) -> nome.toLowerCase(Locale.ROOT).contains("y")
            )
        );
    
        //Exemplo de operação encadeada, já que quase todos os métodos
        //de uma stream retorna uma nova stream
        System.out.println();
    
    }
}
