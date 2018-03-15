package br.edu.ifpr.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpr.entidades.Gerente;
import br.edu.ifpr.modelo.servico.ServicoGerente;

@Named
@ViewScoped
public class BeanListGerente implements Serializable{
	@Inject
	private ServicoGerente servico;
	private List<Gerente> lista;
	private Gerente gerente = new Gerente();
	

	public BeanListGerente() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void iniciar(){
		lista = servico.consultar();
	}

	public List<Gerente> getLista() {
		return lista;
	}

	public void setLista(List<Gerente> lista) {
		this.lista = lista;
	}

}
