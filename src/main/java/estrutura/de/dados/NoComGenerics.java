package estrutura.de.dados;

public class NoComGenerics<T> {
    private T conteúdo;
    private No proximoNo;

    public NoComGenerics(T conteúdo, No proximoNo) {
        this.conteúdo = conteúdo;
        this.proximoNo = proximoNo;
    }

    public NoComGenerics(T conteúdo) {
        this.conteúdo = conteúdo;
    }

    public T getConteúdo() {
        return conteúdo;
    }

    public void setConteúdo(T conteúdo) {
        this.conteúdo = conteúdo;
    }

    public No getProximoNo() {
        return proximoNo;
    }

    public void setProximoNo(No proximoNo) {
        this.proximoNo = proximoNo;
    }

    @Override
    public String toString() {
        String str = "No{" +
                "conteúdo=" + conteúdo +
                ", proximoNo=" + proximoNo +
                '}\n';
        if(proximoNo != null){
            str += "->" + proximoNo.toString();
        } else {
            str += "-> null";
        }
        return str;
    }
}
