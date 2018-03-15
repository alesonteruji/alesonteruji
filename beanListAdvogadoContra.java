package br.edu.ifpr.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpr.entidades.Advogado;
import br.edu.ifpr.entidades.AdvogadoContra;
import br.edu.ifpr.entidades.Escritorio;
import br.edu.ifpr.modelo.servico.ServicoAdvogadoContra;

@Named
@ViewScoped
public class beanListAdvogadoContra implements Serializable {

	private static final long serialVersionUID = 1L;
	private AdvogadoContra advogadoContra = new AdvogadoContra();
	@Inject
	private ServicoAdvogadoContra servico;
	private List<AdvogadoContra> lista;

	@PostConstruct
	public void carregar() {
		lista = servico.consultar();
	}

	public AdvogadoContra getAdvogadoContra() {
		return advogadoContra;
	}

	public void setAdvogadoContra(AdvogadoContra advogadoContra) {
		this.advogadoContra = advogadoContra;
	}

	public List<AdvogadoContra> getLista() {
		return lista;
	}

	public void setLista(List<AdvogadoContra> lista) {
		this.lista = lista;
	}

	public void excluir() {
		servico.excluir(advogadoContra.getId());
		lista = servico.consultar();
	}

	public void salvar() {
		servico.salvar(advogadoContra);
	}

}
