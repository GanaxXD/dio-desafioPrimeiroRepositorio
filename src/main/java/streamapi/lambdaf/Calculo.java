package streamapi.lambdaf;

//ESSA INTERFACE SÓ PODE TER UMA ASSINATURA abstrata PARA QUE POSSAMOS 
//USAR AS LAMBDAS EXPRESSIONS SEM PROBLEMAS.
//TENDO MAIS DE UMA ASSINATURA, NA HORA DE FAZER A IMPLEMENTAÇÃO
//NA CHAMADA DA INTERFACE, O JAVA NÃO CONSEGUIRÁ ASSOCIAR
//PARA QUAL ASSINATURA EU ESTOU IMPLEMENTANDO O MÉTODO.
//PARA IMPEDIR QUE MINHA INTERFACE POSSUA MAIS DE UMA ASSINATURA
//EU POSSO USA A ASSINATURA DO JAVA.LANG @FunctionalInterface

@FunctionalInterface
public interface Calculo {
	public abstract double executar(double a, double b);
	//public abstract double teste(double c, double d); //erro, pois não posso ter mais de um método abstrato
	
	//Mas posso ter um método default ou static sem problemas numa functional interface
	default String ok() {
		return "Ok!";
	}
	
	//Lembrando: método static só é acessado pela própria classe, e não por instâncias
	static String estatico() {
		return " Não há problemas!";
	}
}
