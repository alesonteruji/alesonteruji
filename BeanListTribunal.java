package br.edu.ifpr.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpr.entidades.Tribunal;
import br.edu.ifpr.modelo.servico.ServicoTribunal;

@Named
@ViewScoped
public class BeanListTribunal implements Serializable {
	private static final long serialVersionUID = 1L;

	private Tribunal tribunal = new Tribunal();
	@Inject
	private ServicoTribunal servico;
	private List<Tribunal> lista;

	@PostConstruct
	public void carregar() {
		lista = servico.consultar();
	}

	public Tribunal getTribunal() {
		return tribunal;
	}

	public void setTribunal(Tribunal tribunal) {
		this.tribunal = tribunal;
	}

	public List<Tribunal> getLista() {
		return lista;
	}

	public void setLista(List<Tribunal> lista) {
		this.lista = lista;
	}

	public void excluir() {
		// System.out.println(tribunal.getId());
		servico.excluir(tribunal.getId());
		lista = servico.consultar();
	}

	public void salvar() {
		servico.salvar(tribunal);
	}

}
