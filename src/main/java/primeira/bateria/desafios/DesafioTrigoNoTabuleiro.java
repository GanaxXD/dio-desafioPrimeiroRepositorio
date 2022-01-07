import java.util.Scanner;
import java.lang.Math;

public class DesafioTrigoNoTabuleiro {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long totalEmKg=0L;
        Long totalEmGrao=0L;
        Long totalEmGramas=0L;

        int n = sc.nextInt();
        for(int i=0 ; i<n ; i++) {
            int x = sc.nextInt();


            //Maiores explicações em https://www.guj.com.br/t/o-que-esta-errado-no-meu-codigo-desafio-do-trigo/422227/2
            for(int j=0; j<x; j++){
                totalEmKg = ((long) Math.pow(2, x - 2)) / 3000;
            }
            System.out.printf(totalEmKg + " kg\n");   //Complete o código aqui.
        }
        sc.close();
    }
}