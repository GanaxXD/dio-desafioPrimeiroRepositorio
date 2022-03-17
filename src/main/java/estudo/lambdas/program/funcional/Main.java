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
		//Eu posso usar o polimorfismo, isto �, uma mesma implementa��o
		//Se comportando de formas distintas em diferentes chamadas.
		//Isso porque a vari�vel � do tipo da Interface
		//e neste caso, obedecendo os tipos informados na assinatura
		//do m�todo da interface, eu posso fazer qualquer tipo
		//de calculo, desde que devolva um valor do tipo double
		//e os par�metros de entrada sejam do tipo double, como informei
		//na assinatura executar.
		//Entende-se que a implementa��o dessa interface est� ocorrendo
		//no momento de sua chamada, parecido, quando
		//a associo a uma classe (onde a classe � obrigada a implementar
		//om�todo assinado na interface). A diferen�a � que na chamada
		//da interface, eu posso "polimorfar", trazendo diversos
		//resultados para uma mesma chamada de m�todo (assinatura da interface)
		
		Calculo cal = (x,y) -> {return x + y; };
		System.out.println(cal.executar(5, 9));
		
		//Usando de polimorfismo, dando outra implementa��o para a mesma 
		//assinatura de c�digo (mesmo m�todo)...
		//LMBRANDO QUE EU S� CONSIGO FAZER ISSO PORQUE A INTERFACE CALCULO
		//� UMA INTERFACE FUNCIONAL, ISTO �, TEM APENAS UMA ASSINATURA
		//abstrata DE M�TODO, POSSIBILITANDO A ASSOCIA��O DA IMPLEMENTA��O
		//A �NICA assinatura abstrato EXISTENTE NA INTERFACE. 
		cal = (x, y) -> x - y;
		System.out.println(cal.executar(9, 3));
		
		cal = (a,b) -> a/b;
		System.out.println(cal.executar(12, 2));
		System.out.println("\n"+cal.ok()+Calculo.estatico());
		
		//Neste exemplo acima eu estou usando lambdas expressions para implementar
		//a assinatura do m�todo da Interface Calculo, l� definida.
		//Lembrando que � a mesma coisa do Flutter:
		//fun��o an�nima com par�metros entre par�nteses -> {
		//	... code;
		//	return ...; };
		//Se preferir implementar a fun��o num bloco de c�digo, OU, se 
		//a implementa��o resultar uma �nica linha:
		//fun��o anonima com par�metros entre par�nteses -> ...code;
		
		//**********************************************************
		//USANDO AS INTERFACES FUNCIONAIS DO JAVA.FUNCTION
		
		
		System.out.println("\n****************\nBINARY OPERATOR"
				+ "\n****************\n");
		
		//BINARY OPERATOR: Recebe dois par�metros do mesmo tipo e devolve 
		//resultado do mesmo tipo dos par�metros 
		BinaryOperator<Double> bin = (x, y) -> x*y;
		System.out.println(bin.apply(22.0, 10.0));
		
		bin = (x, y) -> { return Math.pow(x,y);};
		System.out.println(bin.apply(22.0, 2.0));

		System.out.println("\n\nMETHOD REFERENCE"
				+ "\n");
		//Eu posso passar apenas a refer�ncia de um m�todo na chaamda
		//de uma fun��o. Muito �til no trabalho com v�rias
		//informa��es, como listas por exemplo. Para isso, 
		//Basta chamar a classe e indicar o m�todo que se deseja usar
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
		
		Produto produto = new Produto("L�pis", 1.50, 0.02);
		
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
				"Par" : "�mpar";
		System.out.println(parOuImpar.apply(32));
		
		//Usando a compois�o de fun��es para dividir um grande problema
		//em pequenos problemas:
		Function<String, String> oResultado1 = valor -> "O resultado �: "+valor;
		Function<String, String> oResultado2 = valor -> valor+ ". Parab�ns";
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
