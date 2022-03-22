package estudo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
		List<String> aprovados = Arrays.asList("Ana", "Adriana", "Lucas", "Pedro", "Henrique", "Fil�", "Hilton", "Wellington", "Jorge", "Maria", "Dimas");
		Predicate<String> letra = n -> n.contains("a");
		Function<String, String> contemH = n -> n.contains("H") ? (n+" cont�m a letra H") : (n + " n�o cont�m H");
		Function<String, String> contemE = n -> n.contains("e") ? (n+" e cont�m a letra E") : "E nem cont�m a letra E";
		
		//Imprimindo na ordem alfab�tica usando o method reference
		aprovados.stream() 					//fun��o built stream
			.sorted()     					//fun��o operational stream (algumas podem ser encadeadas)
			.forEach(System.out::println); //fun��o terminal stream (retorna a stream final)
		
		System.out.println("------FILTER--------\n");
		//posso encadear v�rios filter
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
