

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import io.github.carolsimoes.Produto;

public class ProgramaCadastrar {
	
	private static EntityManagerFactory emf;
	
	private static EntityManager getEntityManager() {
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory("produtos");
		}
		return emf.createEntityManager();
	}
	
	public static void main(String args[]) {
		
		Produto produto1 = new Produto();
		produto1.setNome("Computador");
		produto1.setQuantidade(35);
		
		Produto produto2 = new Produto();
		produto2.setNome("Mouse");
		produto2.setQuantidade(100);
		
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.persist(produto1);
		em.persist(produto2);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
