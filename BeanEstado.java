package br.edu.ifpr.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpr.entidades.Estado;
import br.edu.ifpr.modelo.servico.ServicoEstado;

@Named
@RequestScoped
public class BeanEstado  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Estado estado = new Estado();
	@Inject
	private ServicoEstado servico;
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public String salvar(){
		servico.salvar(estado);
		return "index.xhtml";
	}

}
