package jpa.hibernate.testes;

import jpa.hibernate.infra.DAO;
import jpa.hibernate.models.muitospramuitos.Sobrinho;
import jpa.hibernate.models.muitospramuitos.Tio;

public class TesteMuitoPraMuitos1 {

	public static void main(String[] args) {
		
		Tio tio1 = new Tio("Maria");
		Tio tio2 = new Tio("José");
		Tio tio3 = new Tio("Jesus");
		
		Sobrinho sobrinho1 = new Sobrinho("Jordan");
		Sobrinho sobrinho2 = new Sobrinho("Marta");
		
		//Definindo os relacionamentos bidirecionais para o JAVA
		tio1.getSobrinhos().add(sobrinho1);
		sobrinho1.getTios().add(tio1);
		
		tio2.getSobrinhos().add(sobrinho1);
		sobrinho1.getTios().add(tio2);
		
		tio3.getSobrinhos().add(sobrinho2);
		sobrinho2.getTios().add(tio3);
		
		
		//persistindo na base
		DAO<Object> dao = new DAO();
		
		dao.abrirTransacao()
			.incluirNoBanco(tio1)
			.incluirNoBanco(tio2)
			.incluirNoBanco(tio3)
			.incluirNoBanco(sobrinho1)
			.incluirNoBanco(sobrinho2)
			.fecharTransacao()
			.fecharConexao();
	}

}
