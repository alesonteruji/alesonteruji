package br.edu.ifpr.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpr.entidades.Causa;
import br.edu.ifpr.modelo.servico.ServicoCausa;

@Named
@ViewScoped
public class BeanListCausa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Causa causa = new Causa();
	@Inject
	private ServicoCausa servico;
	private List<Causa> lista;
	
	@PostConstruct
	public void carregar(){
		lista = servico.consultar();		
	}

	public Causa getCausa() {
		return causa;
	}

	public void setCausa(Causa causa) {
		this.causa = causa;
	}

	public List<Causa> getLista() {
		return lista;
	}

	public void setLista(List<Causa> lista) {
		this.lista = lista;
	}
	
	public void excluir(){
//		System.out.println(causa.getId());	
		servico.excluir(causa.getId());
		lista = servico.consultar();
	}
	
	public void salvar(){
		servico.salvar(causa);
	}
	
	
	
	

}
