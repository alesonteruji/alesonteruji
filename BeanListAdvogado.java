package br.edu.ifpr.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpr.entidades.Advogado;
import br.edu.ifpr.entidades.Escritorio;
import br.edu.ifpr.modelo.servico.ServicoAdvogado;
import br.edu.ifpr.modelo.servico.ServicoEscritorio;

@Named
@ViewScoped
public class BeanListAdvogado implements Serializable {

	private static final long serialVersionUID = 1L;
	private Advogado advogado = new Advogado();
	@Inject
	private ServicoAdvogado servico;
	@Inject
	private ServicoEscritorio servicoEsc;
	private List<Advogado> lista;

	@PostConstruct
	public void carregar(){
		lista = servico.consultar();
	}
	

	public List<Escritorio> getlistaEscritorio() {
		return servicoEsc.consultar();
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
	
	public void excluir(){
		servico.excluir(advogado.getId());
		lista = servico.consultar();
	}
	
	public void salvar(){
		servico.salvar(advogado);
	}


}
