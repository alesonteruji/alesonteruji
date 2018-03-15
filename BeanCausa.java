package br.edu.ifpr.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpr.entidades.Causa;
import br.edu.ifpr.modelo.servico.ServicoCausa;


@Named
@RequestScoped
public class BeanCausa implements Serializable{
	private static final long serialVersionUID = 1L;
	private Causa causa = new Causa();
	@Inject 
	private ServicoCausa servico;
	



	public Causa getCausa() {
		return causa;
	}


	public void setCausa(Causa causa) {
		this.causa = causa;
	}

	public String salvar() {
		servico.salvar(causa);
		return "index.xhtml";		
	}
	
}
