package aula.com.bean;

import javax.faces.bean.ManagedBean;

import br.com.aula.dao.LivroDAO;
import br.com.aula.model.Livro;

@ManagedBean
public class CadastroLivrosBean {
	
	private LivroDAO livroDao = new LivroDAO();
	private Livro livro = new Livro();
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Livro buscarPorId(Integer id) {
		return livroDao.buscarPorId(id);
	}

	public void adicionarLivro() {
		livroDao.salvar(this.livro);
	}
	public void editarLivro(String titulo, int qtdePaginas) {
		livroDao.salvar(this.livro);
	}
	public void removerLivro(Integer id) {
		livroDao.remover(id);
	}

}
