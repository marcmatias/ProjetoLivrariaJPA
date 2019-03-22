package br.com.aula.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.aula.dao.AutorDAO;
import br.com.aula.model.Autor;

@ManagedBean
public class AutorBean {
	AutorDAO aDao;
	private Autor autor;
	private List<Autor> autores;
	
	public List<Autor> getUsuarios() {
		return autores;
	}
	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	public AutorBean() {
		autor = new Autor();
		aDao = new AutorDAO();
		autores = aDao.listar();
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public void cadastrarAutor() {
		aDao = new AutorDAO();
		aDao.salvar(autor);
		autor = new Autor();
		FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Cadastrado Com Sucesso!"));
	}
	public void buscarPorId() {
		aDao = new AutorDAO();
		Autor uBusca = aDao.buscarPorId(autor.getId());
		autor = uBusca;
		System.out.println(aDao.listar());
		if(uBusca == null) {
			FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Autor não encontrado!"));
		}
	}
	public void removerPorId() {
		aDao = new AutorDAO();
		Autor uBusca = aDao.buscarPorId(autor.getId());
		autor = uBusca;
		if(uBusca == null) {
			FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Autor não Encontrado!"));
		}else {
			aDao.remover(autor.getId());
			FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Autor removido com sucesso!"));
		} 
	}
}
