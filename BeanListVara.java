package br.edu.ifpr.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpr.entidades.Vara;
import br.edu.ifpr.modelo.servico.ServicoVara;

@Named
@ViewScoped
public class BeanListVara implements Serializable {
	private static final long serialVersionUID = 1L;

	private Vara vara = new Vara();
	@Inject
	private ServicoVara servico;
	private List<Vara> lista;

	@PostConstruct
	public void carregar() {
		lista = servico.consultar();
	}

	public Vara getVara() {
		return vara;
	}

	public void setVara(Vara vara) {
		this.vara = vara;
	}

	public List<Vara> getLista() {
		return lista;
	}

	public void setLista(List<Vara> lista) {
		this.lista = lista;
	}

	public void excluir() {
		// System.out.println(profissao.getId());
		servico.excluir(vara.getId());
		lista = servico.consultar();
	}

	public void salvar() {
		servico.salvar(vara);
	}

}
