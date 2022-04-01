package estrutura.de.dados;

public class NoFila {
	// Este nó empilha objetos

	private Object object;
	private NoFila refNo;

	public NoFila(Object object) {
		this.object = object;
		this.refNo = null;
	}

	public NoFila() {
	};

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public NoFila getRefNo() {
		return refNo;
	}

	public void setRefNo(NoFila refNo) {
		this.refNo = refNo;
	}

	@Override
	public String toString() {
		return "NoFila{" + "object=" + object + '}';
	}
}
