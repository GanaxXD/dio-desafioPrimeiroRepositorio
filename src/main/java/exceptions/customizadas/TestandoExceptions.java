package exceptions.customizadas;

public class TestandoExceptions {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("André", -10);
        try {
            Validar.pessoa(p1);
            Validar.pessoa(new Pessoa(null, 10));
        }catch (StringVaziaException e){
            System.out.println(e.getMessage());
            
        //Podemos verificar mais de um erro no mesmo catch. Basta por o | (pipe)
        } catch (NumeroNegativoException
                | IllegalArgumentException
                e){
            System.out.println(e.getMessage());
        }
        
    }
}
