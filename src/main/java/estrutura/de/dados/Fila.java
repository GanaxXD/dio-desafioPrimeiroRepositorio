package estrutura.de.dados;

public class Fila {

    private NoFila refNoEntradaFila;

    public Fila(){
        this.refNoEntradaFila = null;
    }

    public void enqueue(NoFila novoNo){
        novoNo.setRefNo(refNoEntradaFila);
        refNoEntradaFila = novoNo;
    }

    public NoFila dequeue(){
        if(!isEmpty()){
            NoFila primeiroNo = refNoEntradaFila;
            NoFila noAuxiliar = refNoEntradaFila;
            while(true){
                if(primeiroNo.getRefNo() != null){
                    noAuxiliar = primeiroNo;
                    primeiroNo = primeiroNo.getRefNo();
                }else{
                    noAuxiliar.setRefNo(null);
                    break;
                }
            }
            return primeiroNo;
        } else {
            return null;
        }
    }

    public NoFila fist(){
        if(!isEmpty()){
            NoFila primeiroNo = refNoEntradaFila;
            while(true){
                if(primeiroNo.getRefNo() != null){
                    primeiroNo = primeiroNo.getRefNo();
                }else{
                    break;
                }
            }
            return primeiroNo;
        } else {
            return null;
        }
    }

    public boolean isEmpty(){
        return refNoEntradaFila == null ? true : false;
    }

    @Override
    public String toString(){
        String retorno = "";

        NoFila noAuxFila = refNoEntradaFila;

        if(refNoEntradaFila != null){
            while(true){
                retorno += "{No -> Objeto = " + noAuxFila.getObject() + " }\n";
                if(noAuxFila.getRefNo() != null) {
                    noAuxFila = noAuxFila.getRefNo();
                } else {
                    retorno += "null";
                    break;
                }
            }
        } else {
            retorno += "null";
        }

        return retorno;
    }
}
