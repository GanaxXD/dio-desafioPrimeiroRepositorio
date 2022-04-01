package OLDfuncoes.lambda;

//Interface terá apenas um método para facilitar a utilização
//de funções lâmbdas anônimas em objetos que implementem essa interface
@FunctionalInterface
public interface CalculoInterface {
	double executar(double a, double b);
}
