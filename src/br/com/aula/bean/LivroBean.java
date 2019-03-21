package br.com.aula.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.aula.dao.LivroDAO;
import br.com.aula.model.Livro;

@ManagedBean
public class LivroBean {
	LivroDAO lDao;
	private Livro livro;
	private List<Livro> livros;
	
	public LivroBean() {
		livro = new Livro();
		lDao = new LivroDAO();
		livros = lDao.listar();
	}
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	public void cadastrarLivro() {
		lDao = new LivroDAO();
		lDao.salvar(livro);
		livro = new Livro();
		FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Cadastrado com Sucesso!"));
	}
	
	public void buscarPorId() {
		lDao = new LivroDAO();
		Livro lBusca = lDao.buscarPorId(livro.getId());
		livro = lBusca;
		if(lBusca == null) {
			FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Livro não Encontrado!"));
		}
	}
	
	public void removerPorId() {
		lDao = new LivroDAO();
		Livro lBusca = lDao.buscarPorId(livro.getId());
		livro = lBusca;
		if(lBusca == null) {
			FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Livro não Encontrado!"));
		}else {
			lDao.remover(livro.getId());
			FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Livro removido com sucesso!"));
		} 
	}
	
}
