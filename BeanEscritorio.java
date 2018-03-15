package br.edu.ifpr.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpr.entidades.Cidade;
import br.edu.ifpr.entidades.Escritorio;
import br.edu.ifpr.modelo.servico.ServicoCidade;
import br.edu.ifpr.modelo.servico.ServicoEscritorio;

@Named
@RequestScoped
public class BeanEscritorio implements Serializable {
	private static final long serialVersionUID = 1L;

	private Escritorio escritorio = new Escritorio();
	@Inject
	private ServicoEscritorio servico;
	@Inject	
	private ServicoCidade servicoCid;

	public Escritorio getEscritorio() {
		return escritorio;
	}
	
	public List<Cidade> getListaCidade() {
		return servicoCid.consultar();
	}
	

	public void setEscritorio(Escritorio escritorio) {
		this.escritorio = escritorio;
	}

	public String salvar() {
		servico.salvar(escritorio);
		return "index.xhtml";
	}

}
