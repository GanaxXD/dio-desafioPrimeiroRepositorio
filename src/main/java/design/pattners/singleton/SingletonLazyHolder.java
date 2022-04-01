package design.pattners.singleton;

//Esse singlton tem uma classe abstrata interna que
//"detém" a posse da instancia do singleton em questão.
//Desta forma para acessar o singleton, só pelo holder.
public class SingletonLazyHolder {
	// classe detentora da instancia do SingletonLazyHolder
	private static class Holder {
		public static SingletonLazyHolder instancia = new SingletonLazyHolder();
	}

	private SingletonLazyHolder() {
		super();
	}

	public static SingletonLazyHolder getInstancia() {
		return Holder.instancia;
	}
}
