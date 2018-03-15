package br.edu.ifpr.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpr.entidades.Advogado;
import br.edu.ifpr.entidades.Cidade;
import br.edu.ifpr.entidades.Escritorio;
import br.edu.ifpr.modelo.servico.ServicoAdvogado;
import br.edu.ifpr.modelo.servico.ServicoCidade;
import br.edu.ifpr.modelo.servico.ServicoEscritorio;

@Named
@RequestScoped
public class BeanAdvogado implements Serializable {
	private static final long serialVersionUID = 1L;

	private Advogado advogado = new Advogado();
	@Inject
	private ServicoAdvogado servico;
	@Inject
	private ServicoEscritorio servicoEscritorio;
	@Inject
	private ServicoCidade servicoCid;
	private List<Advogado> lista;

	public String salvar() {
		servico.salvar(advogado);
		return "index.xhtml";
	}

	public List<Cidade> getListaCidade() {
		return servicoCid.consultar();
	}

	public Advogado getAdvogado() {
		return advogado;
	}

	public void setAdvogado(Advogado advogado) {
		this.advogado = advogado;
	}

	public List<Advogado> getLista() {
		return lista;
	}

	public void setLista(List<Advogado> lista) {
		this.lista = lista;
	}

	public List<Escritorio> getEscritorioLista() {
		return servicoEscritorio.consultar();
	}

}
