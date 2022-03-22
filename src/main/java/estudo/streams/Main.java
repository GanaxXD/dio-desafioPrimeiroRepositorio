package estudo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
		List<String> aprovados = Arrays.asList("Ana", "Adriana", "Lucas", "Pedro", "Henrique", "Filó", "Hilton", "Wellington", "Jorge", "Maria", "Dimas");
		Predicate<String> letra = n -> n.contains("a");
		Function<String, String> contemH = n -> n.contains("H") ? (n+" contém a letra H") : (n + " não contém H");
		Function<String, String> contemE = n -> n.contains("e") ? (n+" e contém a letra E") : "E nem contém a letra E";
		
		//Imprimindo na ordem alfabética usando o method reference
		aprovados.stream() 					//função built stream
			.sorted()     					//função operational stream (algumas podem ser encadeadas)
			.forEach(System.out::println); //função terminal stream (retorna a stream final)
		
		System.out.println("------FILTER--------\n");
		//posso encadear vários filter
		aprovados.stream()
			.filter(letra)
			.forEach(System.out::println);

		System.out.println("-------MAP-------\n");
		//Posso encadear maps
		aprovados.stream()
			.map(contemH)
			.map(contemE)
			.forEach(System.out::println);
		
		
	}

}
