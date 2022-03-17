package primeira.bateria.desafios;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
public class DesafioPronalts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //sc.useLocale(Locale.ENGLISH);
        //Locale.setDefault(new Locale("en", "US"));

        int produtos = 0, quantidade = 0;
        double res = 0, valor = 0;
        int N = Integer.parseInt(sc.nextLine());

        //Verificando se o número de pedidos é igual ou inferior ao número de produtos do cardápio,
        //já que não se pode repetir o produtos num pedido
		/*
		if (N<1 || N>5)
		  System.out.println("Você informou um número de produtos a serem comprados maior que o cardápio. Por favor, atente-se ao número de produtos disponíveis.");

		*/

        for (int x = 0; x < N; x++) {
            produtos = sc.nextInt();
			/*
			if(produtos>5 || produtos <1)
			  System.out.println("Produto inválido!");
			*/
            quantidade = sc.nextInt();
			/*
			if(quantidade >500 || quantidade <1)
			  System.out.println("Quantidade inválida! O pedido deve variar entre a quantidade de 1 a 500");
			*/
            if (produtos == 1001)
                valor = 1.50;
            else if (produtos == 1002)
                valor = 2.50;
            else if (produtos == 1003)
                valor = 3.50;
            else if (produtos == 1004)                  //complete o código nos espaços em branco
                valor = 4.50;
            else if (produtos == 1005)
                valor = 5.50;

            res += valor * quantidade;
        }
        System.out.printf("%.2f\n", res);
        sc.close();
    }
}