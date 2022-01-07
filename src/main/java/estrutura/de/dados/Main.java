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

        minhaPilha.toString();
    }
}
