package br.edu.ifpr.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpr.entidades.Escritorio;
import br.edu.ifpr.modelo.servico.ServicoEscritorio;

@Named
@ViewScoped
public class BeanListEscritorio implements Serializable {
	private static final long serialVersionUID = 1L;

	private Escritorio escritorio = new Escritorio();
	@Inject
	private ServicoEscritorio servico;
	private List<Escritorio> lista;

	@PostConstruct
	public void carregar() {
		lista = servico.consultar();
	}

	public Escritorio getEscritorio() {
		return escritorio;
	}

	public void setEscritorio(Escritorio escritorio) {
		this.escritorio = escritorio;
	}

	public List<Escritorio> getLista() {
		return lista;
	}

	public void setLista(List<Escritorio> lista) {
		this.lista = lista;
	}

	public void excluir() {
		// System.out.println(profissao.getId());
		servico.excluir(escritorio.getId());
		lista = servico.consultar();
	}

	public void salvar() {
		servico.salvar(escritorio);
	}

}
