package estrutura.de.dados;

public class Pilha_Lifo {

    private No refNoEntradaPilha;

    public Pilha_Lifo() {
        this.refNoEntradaPilha = null;
    }

    public No pop(){
        if(!isEmpty()){
            No popped = refNoEntradaPilha;
            refNoEntradaPilha = refNoEntradaPilha.getRefNo();
        }
        return null;
    }

    public void push(No novoNo){
        No refAuxiliar = refNoEntradaPilha;
        refNoEntradaPilha = novoNo;
        refNoEntradaPilha.setRefNo(refAuxiliar);
    }

    public No top(){
        return refNoEntradaPilha;
    }

    public boolean isEmpty(){
        if(this.refNoEntradaPilha == null){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String stringRetorno = "";

        No noAuxiliar = refNoEntradaPilha;
        while(true){
            if(noAuxiliar!=null){
                stringRetorno += "No {dado = " + noAuxiliar.getDado() +" }\n";
                noAuxiliar = noAuxiliar.getRefNo();
            }else{
                break;
            }
        }

        return "String Retorno\n-----------------" +
                "\n" +
                "Pilha_Lifo{" +
                stringRetorno + "-----------------\nFIM!";
    }
}
