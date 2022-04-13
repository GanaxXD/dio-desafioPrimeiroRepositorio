package jpa.hibernate.infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

//O DATA ACCESS OBJECT servir� como a classe respons�vel
//Por criar as conex�es com o banco de dados, facilitando o projeto
//e criando uma nova camada no sistema: a de infraestrutura.
public class DAO<E> {
	
	//Ele ser� usado para criar v�rias conex�es, ent�o puis est�tico, e n�o ser� fechado at� a aplica��o ser encerrada
	private static EntityManagerFactory emf;
	private EntityManager em; //precisa ser fechado para n�o ocupar mem�ria
	private Class<E> classe;
	
	//Para iniciar elementos est�ticos, podemos iniciar
	//um bloco de c�digo static, que sempre 
	//ser� executado no in�cio da cria��od esta classe
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
	
	//Abrir uma transa��o
	public DAO<E> abrirTransacao(){
		em.getTransaction().begin();
		return this;
	}
	
	//Fechando uma transa��o
	public DAO<E> fecharTransacao(){
		em.getTransaction().commit();
		return this;
	}
	
	//Persistir um dado
	public DAO<E> incluirNoBanco(E entidade){
		em.persist(entidade);
		return this;
	}
	
	//Ciclo completo de uma transa��o: inicia, persiste, fecha
	public DAO<E> persistirAtomico(E entidade){
		return this.abrirTransacao().incluirNoBanco(entidade).fecharTransacao();
	}
	
	//Obter quantidade de dados do banco
	public List<E> ObterDados(int qtd, int deslocamento){
		//Ser� usado jpql.
		if(classe == null) {
			throw new UnsupportedOperationException("A Classe est� nula");
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
