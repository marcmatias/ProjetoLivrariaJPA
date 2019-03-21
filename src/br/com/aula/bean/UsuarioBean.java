package br.com.aula.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.aula.dao.UsuarioDAO;
import br.com.aula.model.Usuario;

@ManagedBean
public class UsuarioBean {
	UsuarioDAO uDao;
	private Usuario usuario;
	private List<Usuario> usuarios;
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public UsuarioBean() {
		usuario = new Usuario();
		uDao = new UsuarioDAO();
		usuarios = uDao.listar();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void cadastrarUsuario() {
		uDao = new UsuarioDAO();
		uDao.salvar(usuario);
		usuario = new Usuario();
		FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Cadastrado Com Sucesso!"));
	}
	
	public void buscarPorId() {
		uDao = new UsuarioDAO();
		Usuario uBusca = uDao.buscarPorId(usuario.getId());
		usuario = uBusca;
		System.out.println(uDao.listar());
		if(uBusca == null) {
			FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Usuario não encontrado!"));
		}
	}
	
	public void validarCpf(FacesContext context, UIComponent component, Object object)
	throws ValidatorException{
		String cpf = (String) object;
		if(!cpf.startsWith("0")) {
			throw new ValidatorException(new FacesMessage("Inicie o Cpf com zero"));
		}
	}
	
	public void removerPorId() {
		uDao = new UsuarioDAO();
		Usuario uBusca = uDao.buscarPorId(usuario.getId());
		usuario = uBusca;
		if(uBusca == null) {
			FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Usuário não Encontrado!"));
		}else {
			uDao.remover(usuario.getId());
			FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Usuário removido com sucesso!"));
		} 
	}
	
}
