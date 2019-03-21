package br.com.aula.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.aula.model.Livro;
import br.com.aula.util.JPAUtil;

public class LivroDAO implements GenericDAO<Livro>{

	@Override
	public void salvar(Livro entidade) {
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
			
			Livro livro = em.find(Livro.class, id);
			
			em.remove(livro);
			
			em.getTransaction().commit();
		}finally {
			em.close();
		}
		
	}

	@Override
	public Livro buscarPorId(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			return em.find(Livro.class, id);
		}finally {
			em.close();
		}
	}

	@Override
	public List<Livro> listar() {
		List<Livro> livros = new ArrayList<Livro>();
		EntityManager em = JPAUtil.getEntityManager();
		try {
			livros = em.createQuery("from " + Livro.class.getSimpleName(), Livro.class).getResultList();
			return livros;
		}finally {
			em.close();
		}
	}
	
	

}
