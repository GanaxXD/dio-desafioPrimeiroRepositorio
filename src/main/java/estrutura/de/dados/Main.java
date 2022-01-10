package estrutura.de.dados;

public class Main {
    public static void main(String[] args) {
        Pilha_Lifo minhaPilha = new Pilha_Lifo();

        minhaPilha.push(new No(1));
        minhaPilha.push(new No(2));
        minhaPilha.push(new No(3));
        minhaPilha.push(new No(4));
        minhaPilha.push(new No(5));
        minhaPilha.push(new No(6));

        Fila minhaFila = new Fila();

        minhaFila.enqueue(new NoFila("primeiro"));
        minhaFila.enqueue(new NoFila("segundo"));
        minhaFila.enqueue(new NoFila("terceiro"));
        minhaFila.enqueue(new NoFila("quarto"));

        /*istaEncadeada minhaLista = new ListaEncadeada();

        minhaLista.add(new NoComGenerics("1"));
        minhaLista.add(new NoComGenerics("4"));
        minhaLista.add(new NoComGenerics("5"));
        minhaLista.add(new NoComGenerics("7"));*/

        System.out.println(minhaPilha);
        System.out.println(minhaFila);
        //System.out.println(minhaLista);
    }
}
