package br.edu.ifpr.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpr.entidades.Profissao;
import br.edu.ifpr.modelo.servico.ServicoProfissao;

@Named
@RequestScoped
public class BeanProfissao implements Serializable{
	private static final long serialVersionUID = 1L;
	private Profissao profissao = new Profissao(); 
	@Inject 
	private ServicoProfissao servico;
			
	public Profissao getProfissao() {
		return profissao;
	}

	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}
	
	public String salvar(){
		servico.salvar(profissao);
		return "index.xhtml";
	}
	
	


}
