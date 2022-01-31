/*
package quinta.bateria.desafios;

import java.util.Scanner;

public class AcimaDaDiagonalPrincipal {
      Scanner leitor = new Scanner(System.in);

      //digite o seu código
      char O = leitor.nextLine().toUpperCase().charAt(0);
      
        double M[][] = new double[12][12];
        for(int i =0; i<12; i++){
          for(int j=0; j<12; j++){
            M[i][j] = leitor.nextDouble();
          }
        }
        
        double soma = 0.0;
        double media = 0.0;
        
        for(int i =0; i<12; i++){
          for(int j=0; j<12; j++){
            if(i != j && j > i){
              soma += M[i][j];
            }
          }
        }
        
        if(O == 'S'){
          System.out.printf("%.1f",soma);
        } else if (O == 'M'){
          media = soma/66;
          System.out.printf("%.1f",media);
        }

    
}
*/
