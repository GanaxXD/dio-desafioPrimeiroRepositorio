package primeira.bateria.desafios;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class DesafioParOuImpar {

	public static void main(String[] args) throws IOException {
		Scanner leitor = new Scanner(System.in);
		int N = leitor.nextInt();

		/*
		 * if(N<0 || N > 10000) System.out.
		 * println("informe  quantidade de valores a serem testados entre 1 e 10000");
		 */

		int min_val = -107;
		int max_val = 107;
		// ThreadLocalRandom tlr = ThreadLocalRandom.current();

		for (int i = 0; i < N; i++) {
			// complete sua solução aqui.
			// int x = tlr.nextInt(min_val, max_val+1);
			int x = leitor.nextInt();
			if (x == 0)
				System.out.println("NULL");
			else if (x % 2 == 0 && x > 0)
				System.out.println("EVEN POSITIVE");
			else if (x % 2 == 0 && x < 0)
				System.out.println("EVEN NEGATIVE");
			else if (x % 2 != 0 && x > 0)
				System.out.println("ODD POSITIVE");
			else
				System.out.println("ODD NEGATIVE");
		}
	}

}