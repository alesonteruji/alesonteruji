package br.edu.ifpr.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpr.entidades.AdvogadoContra;
import br.edu.ifpr.modelo.servico.ServicoAdvogadoContra;

@Named
@RequestScoped
public class BeanAdvogadoContra implements Serializable {
	private static final long serialVersionUID = 1L;

	private AdvogadoContra advogadoContra = new AdvogadoContra();
	@Inject
	private ServicoAdvogadoContra servico;

	private List<AdvogadoContra> lista;

	public String salvar() {
		servico.salvar(advogadoContra);
		return "index.xhtml";
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


}
