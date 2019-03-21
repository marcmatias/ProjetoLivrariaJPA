package br.com.aula.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private int qtdePaginas;
	
	public Livro() {
		
	}
	
	public Livro(String titulo, int qtdePaginas) {
		super();
		this.titulo = titulo;
		this.qtdePaginas = qtdePaginas;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getQtdePaginas() {
		return qtdePaginas;
	}
	public void setQtdePaginas(int qtdePaginas) {
		this.qtdePaginas = qtdePaginas;
	}

	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + "]";
	}
}
