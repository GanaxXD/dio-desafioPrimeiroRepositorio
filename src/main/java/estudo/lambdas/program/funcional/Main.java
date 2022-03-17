package estudo.lambdas.program.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
		
		//UTILIZANDO INTERFACES FUNCIONAIS (APENAS UMA ASSINATURA)
		
		//Ao utilizar classes implementando a mesma interface,
		//Eu posso usar o polimorfismo, isto é, uma mesma implementação
		//Se comportando de formas distintas em diferentes chamadas.
		//Isso porque a variável é do tipo da Interface
		//e neste caso, obedecendo os tipos informados na assinatura
		//do método da interface, eu posso fazer qualquer tipo
		//de calculo, desde que devolva um valor do tipo double
		//e os parâmetros de entrada sejam do tipo double, como informei
		//na assinatura executar.
		//Entende-se que a implementação dessa interface está ocorrendo
		//no momento de sua chamada, parecido, quando
		//a associo a uma classe (onde a classe é obrigada a implementar
		//ométodo assinado na interface). A diferença é que na chamada
		//da interface, eu posso "polimorfar", trazendo diversos
		//resultados para uma mesma chamada de método (assinatura da interface)
		
		Calculo cal = (x,y) -> {return x + y; };
		System.out.println(cal.executar(5, 9));
		
		//Usando de polimorfismo, dando outra implementação para a mesma 
		//assinatura de código (mesmo método)...
		//LMBRANDO QUE EU SÓ CONSIGO FAZER ISSO PORQUE A INTERFACE CALCULO
		//É UMA INTERFACE FUNCIONAL, ISTO É, TEM APENAS UMA ASSINATURA
		//abstrata DE MÉTODO, POSSIBILITANDO A ASSOCIAÇÃO DA IMPLEMENTAÇÃO
		//A ÚNICA assinatura abstrato EXISTENTE NA INTERFACE. 
		cal = (x, y) -> x - y;
		System.out.println(cal.executar(9, 3));
		
		cal = (a,b) -> a/b;
		System.out.println(cal.executar(12, 2));
		System.out.println("\n"+cal.ok()+Calculo.estatico());
		
		//Neste exemplo acima eu estou usando lambdas expressions para implementar
		//a assinatura do método da Interface Calculo, lá definida.
		//Lembrando que é a mesma coisa do Flutter:
		//função anônima com parâmetros entre parênteses -> {
		//	... code;
		//	return ...; };
		//Se preferir implementar a função num bloco de código, OU, se 
		//a implementação resultar uma única linha:
		//função anonima com parâmetros entre parênteses -> ...code;
		
		//**********************************************************
		//USANDO AS INTERFACES FUNCIONAIS DO JAVA.FUNCTION
		
		
		System.out.println("\n****************\nBINARY OPERATOR"
				+ "\n****************\n");
		
		//BINARY OPERATOR: Recebe dois parâmetros do mesmo tipo e devolve 
		//resultado do mesmo tipo dos parâmetros 
		BinaryOperator<Double> bin = (x, y) -> x*y;
		System.out.println(bin.apply(22.0, 10.0));
		
		bin = (x, y) -> { return Math.pow(x,y);};
		System.out.println(bin.apply(22.0, 2.0));

		System.out.println("\n\nMETHOD REFERENCE"
				+ "\n");
		//Eu posso passar apenas a referência de um método na chaamda
		//de uma função. Muito útil no trabalho com várias
		//informações, como listas por exemplo. Para isso, 
		//Basta chamar a classe e indicar o método que se deseja usar
		//depois do operado    ::
		List<String> nomes = Arrays.asList("Lucas", "Maria", "Lina", "Victor");
		nomes.forEach(System.out::println);
		
		//INTERFACES FUNCIONAIS MAIS USADAS DO JAVA.FUNCTIONS:
		//NOTA: T = qualquer coisa (Produto, int, boolean, etc)
		// NOME 		|	ASSINATURA -> RETORNO 	|
		//------------------------------------------|
		// Supplien		|	Nada -> T (Generics)
		// Consumer		|	T -> nada
		// UnaryOperat. |	T -> T
		// BinaryOperat.| 	T,T -> T (tudo do mesmo tipo)
		// Function		|	S (um argumento) -> T (ou seja, recebe de um tipo e pode retornar outro tipo)
		// Predicate	|	T -> boolean
		
		System.out.println("\n\nPREDICATE"
				+ "\n");
		
		Produto produto = new Produto("Lápis", 1.50, 0.02);
		
		//Pega um dado e retorna true/false
		Predicate<Produto> predicado = p-> p.preco>500;
		System.out.println(predicado.test(produto));
		
		System.out.println("\n\nCONSUMER"
				+ "\n");
		Consumer<Produto> imprimir = p -> System.out.println(p);
		imprimir.accept(produto);
		
		System.out.println("\n\nFUNCTION"
				+ "\n");
		Function<Integer, String> parOuImpar = numero -> numero%2==0?
				"Par" : "Ímpar";
		System.out.println(parOuImpar.apply(32));
		
		//Usando a compoisão de funções para dividir um grande problema
		//em pequenos problemas:
		Function<String, String> oResultado1 = valor -> "O resultado é: "+valor;
		Function<String, String> oResultado2 = valor -> valor+ ". Parabéns";
		Function<String, String> oResultado3 = valor -> valor+ " pelo processamento";
		
		System.out.println(
			parOuImpar
				.andThen(oResultado1)
				.andThen(oResultado2)
				.andThen(oResultado3)
				.apply(32)	
		);


	}

}
