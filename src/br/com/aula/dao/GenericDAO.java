package br.com.aula.dao;

import java.util.List;

public interface GenericDAO<T> {

	public void salvar(T entidade);
	public void remover(int id);
	public T buscarPorId(int id);
	public List<T> listar();
}
