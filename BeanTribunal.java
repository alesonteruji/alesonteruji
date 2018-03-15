package br.edu.ifpr.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpr.entidades.Cidade;
import br.edu.ifpr.entidades.Tribunal;
import br.edu.ifpr.modelo.servico.ServicoCidade;
import br.edu.ifpr.modelo.servico.ServicoTribunal;


@Named
@RequestScoped	
public class BeanTribunal implements Serializable {
	private static final long serialVersionUID = 1L;
	private Tribunal tribunal = new Tribunal();
	@Inject
	private ServicoTribunal servico;
	@Inject
	private ServicoCidade servicoCid;

	public Tribunal getTribunal() {
		return tribunal;
	}

	public void setTribunal(Tribunal tribunal) {
		this.tribunal = tribunal;
	}
	
	public List<Cidade> getListaCidade() {
		return servicoCid.consultar();
	}

	public String salvar() {
		servico.salvar(tribunal);
		return "index.xhtml";

	}
}
