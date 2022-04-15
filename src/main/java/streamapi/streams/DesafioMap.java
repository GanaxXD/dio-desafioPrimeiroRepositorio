package streamapi.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class DesafioMap {

	public static void main(String[] args) {

		List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7,8,9);
		//1. Número pra string binária = 6 -> "110"
		Function<Integer, String> binario = n -> n.toBinaryString(n);
		//2. Reverter a string = "110" -> "011"
		UnaryOperator<String> reverso = n -> new StringBuilder(n).reverse().toString(); 
		//3. Converter de volta pra número inteiro = "011" -> 3
		Function<String, Integer> paraInt = n -> Integer.parseInt(n, 2);
		
		numeros.stream()
			.map(binario)
			.map(reverso)
			.map(paraInt)
			.forEach(System.out::println);
	}

}
