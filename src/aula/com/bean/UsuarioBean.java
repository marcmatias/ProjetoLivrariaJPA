package aula.com.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.aula.model.Usuario;

@ManagedBean
public class UsuarioBean {
	
	private Usuario usuario = new Usuario();
	
	public UsuarioBean() {
		
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void cadastrarUsuario() {
		System.out.println("Usuario: " + usuario.getNome() + " Cadastrado!");
		usuario = new Usuario();
	}
	
	public void validarCpf(FacesContext context, UIComponent component, Object object)
	throws ValidatorException{
		String cpf = (String) object;
		if(!cpf.startsWith("0")) {
			throw new ValidatorException(new FacesMessage("Inicie o Cpf com zero"));
		}
	}
	
	
}
