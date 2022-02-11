package collections.java;

import java.util.Locale;
import java.util.Scanner;

public class ConversorDeTemperatura {
    public static void main(String[] args) {
        //Converter fahrenheit para Celcius = (ºF - 32) 8 5/9 = ºC
        System.out.println("------ DESAFIO CONVERSÃO: ------\n");
        final int REDUTOR = 32;
        final double DIVISOR = 5/9.0;
        double fahrenheit = 33.9;
        //System.out.println("Bom dia".toLowerCase(Locale.ROOT).charAt(2));
    
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite a temperatura que se deseja converter: ");
        //fahrenheit = leitor.nextDouble();
        //leitor.close();
        System.out.printf("A temperatura em Celcius é %.2f", (fahrenheit - REDUTOR) * DIVISOR);
        //18
        long l = 18222365998L;
        Long n = 159865598782l;
    
        //Desafio: converter 3 salários de String para numérico e mostrar a média
        System.out.println("\n\n------ DESAFIO STRING PARA NUMÉRICO: ------\n");
        System.out.printf("Digite o primeiro salário: ");
        String salario1 = leitor.nextLine().replace(',', '.');
        System.out.printf("Digite o segundo salário: ");
        String salario2 = leitor.nextLine().replace(',', '.');
        System.out.printf("Digite o terceiro salário: ");
        String salario3 = leitor.nextLine().replace(',', '.');
        
        double media = (Double.parseDouble(salario1) +
                Double.parseDouble(salario2) +
                Double.parseDouble(salario3)) /3;
        System.out.println("A média dos salários é: "+ media);
        
    }
    
}
