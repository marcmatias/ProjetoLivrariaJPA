package br.com.aula.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.aula.dao.LivroDAO;
import br.com.aula.model.Livro;

public class TesteBiblioteca {
	
	public static void main(String[] args) {
		
		//Livro livro = new Livro("Senhor dos Aneis", 1000);
		
		/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca-mysql");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(livro);
		em.getTransaction().commit();
		
		em.close();
		emf.close();*/
		
		LivroDAO livroDao = new LivroDAO();
		
		
		//Livro livro = livroDao.buscarPorId(2);
		//System.out.println(livro.getTitulo());
		
		//livroDao.remover(2);

		Livro livro = new Livro("Senhor dos Aneis - Volume 2", 10000);
		livro.setId(3);
		livroDao.salvar(livro);
		livroDao.buscarPorId(0);
	}

}
