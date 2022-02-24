package collections.java;

import orientacao.objetos.Cliente;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExemploStream {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        Consumer<Object> print = System.out::println;
        
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
        nomes.add("Aquiles");
        nomes.add("Regianne");
        nomes.add("Adam");
        nomes.add("Arthur");
        nomes.add("Amélia");
        nomes.add("Acácia");
        
    //------------- INTERFACE FUNCTIONAL --------------------
        //Para Facilitar a utilização das streams, vou utilizar as Interfaces Funcionais (não é obrigatório)
        //Criando um Consumer (Interface Funcional que recebe um parâmetro e não retorna nada)
        Consumer<Object> printando = System.out::println;
        //Criando uma Unary Operator (Interface Funcional que recebe um único parâmetro e devolve um valor)
        UnaryOperator<String> maiuscula = m -> m.toUpperCase(Locale.ROOT);
        UnaryOperator<String> primeiraLetra = m->m.substring(0,1);
        
    //------------------- STREAM ------------------
        //Criando uma Stream (uma das formas de criar)
        Stream<String> stream = Stream.of("And,", " Lucca, ", " Josh\n");
        
        //imprimindo
        //stream.forEach(printando);
        
        //Usando Stream Parallel (É a utilização de várias threads internas, dividindo a tarefa
        //passada pra os múltiplos núcleos do processador. Por isso a ordem de saída não é a mesma da de entrada).
        stream.parallel().forEach(printando);
        
        //********* MAP ********************
        List<String> marcas = Arrays.asList("BMW", "Ford", "Tesla", "Cooper");
        marcas.stream()
                .map(maiuscula)
                .map(primeiraLetra)
                .forEach(printando);
        
        //Desafio Usando Maps:
        // 1. Número para string binária (ex 6 -> "110")
        // | 2. Reverter String resultante (ex: "110" -> "011")
        // | 3. Converter de volta para inteiro (ex: "011" -> 3)
        List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7,8,9);
        
        UnaryOperator<String> reverso = (n)->{
            String aux = "";
            for(int i=0; i<n.length(); i++){
                aux += n.substring(n.length()-1);
            }
            return aux;
        };
        Function<String, Integer> binToInt = n -> Integer.parseInt(n, 2);
        
        /*
        numeros.stream()
                .map(Integer::toBinaryString)
                .map(reverso)
                .map(binToInt)
                .forEach(printando);
        
        */
        
        //************ FILTER ***************
        //So entra na nova stream criada se a função ou lambda passada retornar true.
        //Ele Usa Predicates (retornam como true) como parâmetros.
        Cliente c1 = new Cliente();
        Cliente c2 = new Cliente();
        Cliente c3 = new Cliente();
        Cliente c4 = new Cliente();
        Cliente c5 = new Cliente();
        c1.setNome("Andre");
        c2.setNome("Aline");
        c3.setNome("Gustavo");
        c4.setNome("Gorgina");
        c5.setNome("Durval");
        
        List<Cliente> clientes = Arrays.asList(c1, c2, c3, c4, c5);
        
        Predicate<Cliente> nomeMaiorQue = n -> n.getNome().length() > 5;
        
        clientes.stream()
                .filter(c -> c.getNome().contains("a"))
                .filter(nomeMaiorQue)
                .map(n -> n.getNome())
                .forEach(printando);
        
        //********** REDUCE ***************
        //transforma os elementos de uma stream e transforma em outra coisa. É uma função terminadora, como o forEach, isto é, não retorna outra stream.
        //Usa: ... .stream().reduce(acumulador, n) ...
        //acumulador (identity) = (pode ter um valor inicial) valor que é passado para cada iteração da stream anterior, acumulando os resultados das iterações
        //n = elemento atual da stream
        BinaryOperator<Integer> somaTotal = (ac, n) -> ac+n;
        int total = numeros.stream().reduce(somaTotal).get();
        System.out.println(total);
        total = numeros.stream().reduce(100, somaTotal);
        System.out.println(total);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*
        nomes.stream().map(n-> n.toUpperCase(Locale.ROOT)).forEach(print) ;
        
        System.out.println("Número de nomes: "+ nomes.stream().count());
    
        //Trás o nome com o maior/menor número de letras
        System.out.println("Número de nomes: "+ nomes.stream().max(Comparator.comparingInt(String::length)));
        System.out.println("Número de nomes: "+ nomes.stream().min(Comparator.comparingInt(String::length)));
        */
        /*
        Filter: passo na função lambida a base de dados que estou estudando (a collection) ->
        Faço um teste que retorna um true ou false. Se for true, ele cria uma nova stream
        trazendo os dados que foram filtrados de acordo com a regra passada.
        
        Neste exemplo, verificarei quais nomes contém a letra "r". Os que possuírem
        serão exibidos em uma lista (java.util) por utilizar-mos o Collectors.toList().
         */
        /*System.out.println("Nomes que contém a letra \"R\": " +
            nomes.stream().filter(
                (nome)->
                    nome.toLowerCase(Locale.ROOT).contains("r"))
                    .collect(Collectors.toList())
        );*/
    
        /*
        Map: retorna uma coleção com o mesmo tamanho da original.
        Parece com o map do Dart. A ideia é criar uma nova colleção,
        com o mesmo número de elementos do obtido na base, só que transformando-o
        em alguma coisa (tipo, uma coleção do tipo Map(K,V) em um Objeto PEssoa,
        por exemplo.
        
        Neste exemplo eu vou transformar o elementos da coleção original
        adicionando na cópia, a quantidade de letras em cada nome
         */
       /* System.out.println(nomes.stream().map(
                (nome) -> nome.concat(" - ").concat(""+nome.length())
            ).collect(Collectors.toList())
        );*/
    
        /*
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
        
        System.out.println();
        */
    
    }
}
