package streamapi.lambdaf;

//ESSA INTERFACE S� PODE TER UMA ASSINATURA abstrata PARA QUE POSSAMOS 
//USAR AS LAMBDAS EXPRESSIONS SEM PROBLEMAS.
//TENDO MAIS DE UMA ASSINATURA, NA HORA DE FAZER A IMPLEMENTA��O
//NA CHAMADA DA INTERFACE, O JAVA N�O CONSEGUIR� ASSOCIAR
//PARA QUAL ASSINATURA EU ESTOU IMPLEMENTANDO O M�TODO.
//PARA IMPEDIR QUE MINHA INTERFACE POSSUA MAIS DE UMA ASSINATURA
//EU POSSO USA A ASSINATURA DO JAVA.LANG @FunctionalInterface

@FunctionalInterface
public interface Calculo {
	public abstract double executar(double a, double b);
	//public abstract double teste(double c, double d); //erro, pois n�o posso ter mais de um m�todo abstrato
	
	//Mas posso ter um m�todo default ou static sem problemas numa functional interface
	default String ok() {
		return "Ok!";
	}
	
	//Lembrando: m�todo static s� � acessado pela pr�pria classe, e n�o por inst�ncias
	static String estatico() {
		return " N�o h� problemas!";
	}
}
