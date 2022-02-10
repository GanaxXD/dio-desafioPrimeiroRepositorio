package funcoes.lambda;

public class TesteCalculo {
    public static void main(String[] args) {
        //usando lambda expression anonimous
        CalculoInterface calculo = (a, b) -> a+b;
        System.out.println(calculo.executar(3, 9));
        calculo = (a,b) -> a*b;
        System.out.println(calculo.executar(3,9));
    
        //Método normal
        CalculoInterface calc = new CalculoSoma();
        System.out.println(calc.executar(2, 9));
    }
}
