package jpa.hibernate.infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

//O DATA ACCESS OBJECT servirá como a classe responsável
//Por criar as conexões com o banco de dados, facilitando o projeto
//e criando uma nova camada no sistema: a de infraestrutura.
public class DAO<E> {
	
	//Ele será usado para criar várias conexões, então puis estático, e não será fechado até a aplicação ser encerrada
	private static EntityManagerFactory emf;
	private EntityManager em; //precisa ser fechado para não ocupar memória
	private Class<E> classe;
	
	//Para iniciar elementos estáticos, podemos iniciar
	//um bloco de código static, que sempre 
	//será executado no início da criaçãod esta classe
	static {
		try {
			emf = Persistence.createEntityManagerFactory("jpahibernate");
		} catch (Exception e) {
			System.out.println("Ocorreu um erro: "+e.getMessage()+ "\n\nCausa: "+ e.getCause());
		}
	}
	
	public DAO() {}
	
	public DAO(Class<E> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
	}
	
	//Abrir uma transação
	public DAO<E> abrirTransacao(){
		em.getTransaction().begin();
		return this;
	}
	
	//Fechando uma transação
	public DAO<E> fecharTransacao(){
		em.getTransaction().commit();
		return this;
	}
	
	//Persistir um dado
	public DAO<E> incluirNoBanco(E entidade){
		em.persist(entidade);
		return this;
	}
	
	//Ciclo completo de uma transação: inicia, persiste, fecha
	public DAO<E> persistirAtomico(E entidade){
		return this.abrirTransacao().incluirNoBanco(entidade).fecharTransacao();
	}
	
	//Obter quantidade de dados do banco
	public List<E> ObterDados(int qtd, int deslocamento){
		//Será usado jpql.
		if(classe == null) {
			throw new UnsupportedOperationException("A Classe está nula");
		}
		
		String jpql = "select e from " + classe.getName() + "e";
		TypedQuery<E> query = em.createQuery(jpql, classe);
		query.setMaxResults(qtd);
		query.setFirstResult(deslocamento);
		return query.getResultList();
	}
	
	public void fecharConexao() {
		em.close();
	}
}
