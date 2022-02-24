package exceptions.customizadas;

//Quero trabalhar com as unchecked exceptions, e como no java
//somente as classes filhas de RunTime e a própria RunTime geram
//unchecked exceptions, vou estender da Runtime
@SuppressWarnings("serial")
public class NumeroNegativoException extends RuntimeException{
    private String nomeDoAtributo;
    
    public NumeroNegativoException(String nomeAtributo) {
        this.nomeDoAtributo = nomeAtributo;
    }
    
    public String getMessage(){
        return String.format("O atributo %s está negativo", nomeDoAtributo);
    }
}
