package funcoes.lambda;

public class CalculoSoma implements CalculoInterface{
    
    @Override
    public double executar(double a, double b) {
        return a+b;
    }

}
