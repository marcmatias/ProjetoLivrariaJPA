package br.com.aula.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.aula.model.Autor;
import br.com.aula.util.JPAUtil;

public class AutorDAO implements GenericDAO<Autor> {

	@Override
	public void salvar(Autor entidade) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			if(entidade.getId() == null) {
				em.persist(entidade);
			}else {
				em.merge(entidade);
			}
			em.getTransaction().commit();
		}finally {
			em.close();
		}		
	}

	@Override
	public void remover(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			
			Autor autor = em.find(Autor.class, id);
			
			em.remove(autor);
			
			em.getTransaction().commit();
		}finally {
			em.close();
		}		
	}

	@Override
	public Autor buscarPorId(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			return em.find(Autor.class, id);
		}finally {
			em.close();
		}
	}

	@Override
	public List<Autor> listar() {
		List<Autor> autores = new ArrayList<Autor>();
		EntityManager em = JPAUtil.getEntityManager();
		try {
			autores = em.createQuery("from " + Autor.class.getSimpleName(), Autor.class).getResultList();
			return autores;
		}finally {
			em.close();
		}
	}

}
