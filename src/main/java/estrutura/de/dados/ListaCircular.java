package estrutura.de.dados;

public class ListaCircular {

    No cabeca; //último elemento = indice n
    No cauda; //indice 0 = primeiro elemento
    int tamanhoLista;

    public ListaCircular() {
        this.cauda = null; //primeiro nó
        this.cabeca = null; //último nó
        this.tamanhoLista = 0;
    }

    public int size(){
        return this.tamanhoLista;
    }

    public boolean isEmpty(){
        return this.tamanhoLista == 0 ? true : false;
    }

    public int get(int index){
        return this.getNo(index).getDado();
    }

    private No getNo(int index){
        if(this.isEmpty())
            throw new IndexOutOfBoundsException("A lista circular está vazia");

        if(index==0){
            return this.cauda;
        }

        No noAuxiliar =  this.cauda;
        for (int i = 0 ; (i < index) && (noAuxiliar != null); i++){
            noAuxiliar = noAuxiliar.getRefNo();
        }
        return noAuxiliar;
    }

    public void remove(int index){
        if(index >= this.tamanhoLista)
            throw new IndexOutOfBoundsException("O índice informado não existe");

        No noAuxiliar = this.cauda;
        if(index == 0){
            this.cauda = this.cauda.getRefNo();
            this.cabeca.setRefNo(this.cauda);
        } else if (index == 1){
            this.cauda.setRefNo(this.cauda.getRefNo().getRefNo());
        } else {
            for (int i = 0; i <index-1; i++){
                noAuxiliar = noAuxiliar.getRefNo();
            }
            noAuxiliar.setRefNo(noAuxiliar.getRefNo().getRefNo());
        }
        this.tamanhoLista--;
    }

    //Adiciona no início da lista (na cauda), mas pode
    // ter a sobrecarga de método, isto é, criar um novo método
    //add(int index, No novoNo), passando o lugar ond eo nó será adicionado
    public void add(int conteudo){
        No novoNo = new No(conteudo);
        if(this.tamanhoLista == 0){
            this.cauda = novoNo;
            this.cabeca = novoNo;
            this.cabeca.setRefNo(this.cauda);
        } else {
            novoNo.setRefNo(this.cauda);
            this.cabeca.setRefNo(novoNo);
            this.cauda = novoNo;
        }
        this.tamanhoLista++;
    }

    @Override
    public String toString(){
        String str = "";

        No noAuxiliar =  this.cauda;
        for(int i=0; i< this.tamanhoLista; i++){
            str += "{Nó -> Conteúdo = " + noAuxiliar.getDado() +"} \n";
            noAuxiliar = noAuxiliar.getRefNo();
        }

        str += this.size() != 0 ? "{Retorna à cauda}" : "[]";
        return str;
    }
}
