package br.com.aula.dao;

public interface GenericDAO<T> {

	public void salvar(T entidade);
	public void remover(int id);
	public T buscarPorId(int id);
	
}
