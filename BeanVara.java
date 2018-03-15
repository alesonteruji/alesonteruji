package br.edu.ifpr.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpr.entidades.Cidade;
import br.edu.ifpr.entidades.Vara;
import br.edu.ifpr.modelo.servico.ServicoCidade;
import br.edu.ifpr.modelo.servico.ServicoVara;

@Named
@RequestScoped
public class BeanVara implements Serializable {
	private static final long serialVersionUID = 1L;
	private Vara vara = new Vara();
	@Inject
	private ServicoVara servico;
	@Inject
	private ServicoCidade servicoCid;

	public Vara getVara() {
		return vara;
	}
	
	public List<Cidade> getListaCidade() {
		return servicoCid.consultar();
	}

	public void setVara(Vara vara) {
		this.vara = vara;
	}

	public String salvar() {
		servico.salvar(vara);
		return "index.xhtml";
	}

}
