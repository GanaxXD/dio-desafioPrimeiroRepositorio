package exceptions.customizadas;

//Quero trabalhar com as unchecked exceptions, e como no java
//somente as classes filhas de RunTime e a própria RunTime geram
//unchecked exceptions, vou estender da Runtime
@SuppressWarnings("serial")
public class StringVaziaException extends RuntimeException {
	private String nomeDoAtributo;

	public StringVaziaException(String nomeAtributo) {
		this.nomeDoAtributo = nomeAtributo;
	}

	public String getMessage() {
		return String.format("O atributo %s está vazio", nomeDoAtributo);
	}
}
