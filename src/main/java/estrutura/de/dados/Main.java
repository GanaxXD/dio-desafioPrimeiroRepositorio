package estrutura.de.dados;

import orientacao.objetos.Conta;
import orientacao.objetos.ContaCorrente;
import orientacao.objetos.ContaPoupanca;

public class Main {
    public static void main(String[] args) {
    
        //Pilha_Lifo minhaPilha = new Pilha_Lifo();
        
        /*minhaPilha.push(new No(1));
        minhaPilha.push(new No(2));
        minhaPilha.push(new No(3));
        minhaPilha.push(new No(4));
        minhaPilha.push(new No(5));
        minhaPilha.push(new No(6));

        Fila minhaFila = new Fila();

        minhaFila.enqueue(new NoFila("primeiro"));
        minhaFila.enqueue(new NoFila("segundo"));
        minhaFila.enqueue(new NoFila("terceiro"));
        minhaFila.enqueue(new NoFila("quarto"));*/

        /*istaEncadeada minhaLista = new ListaEncadeada();

        minhaLista.add(new NoComGenerics("1"));
        minhaLista.add(new NoComGenerics("4"));
        minhaLista.add(new NoComGenerics("5"));
        minhaLista.add(new NoComGenerics("7"));*/

        //System.out.println(minhaPilha);
        //System.out.println(minhaFila);
        //System.out.println(minhaLista);

        /*
        Stack<StackJava> pilhastack = new Stack();

        pilhastack.push(new StackJava("Push: método de inserção (sempre no topo) da pilha"));
        pilhastack.push(new StackJava("Pop: método de remoção (sempre no topo) da pilha"));
        pilhastack.push(new StackJava("Peek: método que mostra o conteúdo do elemento do topo da pilha sem remoção"));

        System.out.println("\n\n-------------PILHA - STACK-------------\n\n");
        System.out.println(pilhastack);
        System.out.println(pilhastack.peek());
        System.out.println(pilhastack.pop());
        System.out.println(pilhastack);
        System.out.println(pilhastack.peek());
        System.out.println(pilhastack.pop());
        System.out.println(pilhastack.empty());

        System.out.println("\n\n\n\n-------------FILA - QUEUE-------------\n\n");

        Queue<Carro> listaCarro = new LinkedList<>();

        listaCarro.add(new Carro("Ford"));
        listaCarro.add(new Carro("Pegeout"));
        listaCarro.add(new Carro("Fiat"));

        System.out.println(listaCarro.add(new Carro("Tesla")));
        System.out.println(listaCarro);
        //offer: retorna false se não conseguir inserir um novo dado
        System.out.println(listaCarro.offer(new Carro("Tesla")));
        System.out.println(listaCarro);
        //peek: pega o primeiro elemento da fila, sem remoção
        System.out.println(listaCarro.peek());
        System.out.println(listaCarro);
        //pull: pega o primeiro elemento da fila removendo-o
        System.out.println(listaCarro.poll());
        System.out.println(listaCarro);

        System.out.println("\n\n\n\n-------------LIST - LISTA-------------\n\n");

        List<Carro> listaCarros = new ArrayList<>();

        listaCarros.add(new Carro("Ford"));
        listaCarros.add(new Carro("Pegeout"));
        listaCarros.add(new Carro("Fiat"));

        System.out.println(listaCarros);
        System.out.println(listaCarros.contains(new Carro("Alfredo")));
        System.out.println(listaCarros.get(2));
        //retorna o indice onde o objeto passado está na lista
        System.out.println(listaCarros.indexOf(new Carro ("Tesla")));
        System.out.println(listaCarros.remove(1));
        System.out.println(listaCarros);


        System.out.println("\n\n\n\n-------------SET - CONJUNTO-------------\n\n");

        //O conjunto (HASHSET) já deixa os dados em ordem crescente
        Set<Carro> conjuntoCarro = new HashSet<>();

        conjuntoCarro.add(new Carro("A"));
        conjuntoCarro.add(new Carro("P"));
        conjuntoCarro.add(new Carro("F"));
        conjuntoCarro.add(new Carro("D"));
        conjuntoCarro.add(new Carro("O"));
        conjuntoCarro.add(new Carro("Z"));
        conjuntoCarro.add(new Carro("H"));


        System.out.println(conjuntoCarro);

        //TreeSet vem de árvore
        Set<Carro> arvoreCarro = new TreeSet<>();
        arvoreCarro.add(new Carro("22"));
        arvoreCarro.add(new Carro("12"));
        arvoreCarro.add(new Carro("44"));
        arvoreCarro.add(new Carro("9"));
        arvoreCarro.add(new Carro("11"));
        arvoreCarro.add(new Carro("99"));
        arvoreCarro.add(new Carro("0"));

        System.out.println(arvoreCarro);



        System.out.println("\n\n\n\n-------------MAP - HASHMAP-------------\n\n");

        //Mapa no formato chave, valor que guarda vários registros
        Map<String, String> aluno = new HashMap<>();

        //put: insere um registro
        aluno.put("Nome", "João");
        aluno.put("Idade", "23");
        aluno.put("Nota", "9.0");
        aluno.put("Média", "S");

        //keyset: retorna as chaves do mapa
        System.out.println(aluno.keySet());

        //values: retorna os valores das chaves do mapa
        System.out.println(aluno.values());

        //É possível criar uma lista de maps: List<Map<String, String>> alunos = new ArrayList<>();

       */
    
        Conta cc = new ContaCorrente();
        Conta cp = new ContaPoupanca();
        
        System.out.println(cc.imprimirExtrato());
        System.out.println(cp.imprimirExtrato());
        
        cc.depositar(2000);
        cp.depositar(100);
    
        System.out.println(cc.imprimirExtrato());
        System.out.println(cp.imprimirExtrato());
        
        cc.transferir(250, cp);
        System.out.println(cc.imprimirExtrato());
        System.out.println(cp.imprimirExtrato());
       
        

    }
}
