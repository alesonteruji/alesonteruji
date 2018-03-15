package br.edu.ifpr.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpr.entidades.Profissao;
import br.edu.ifpr.modelo.servico.ServicoProfissao;

@Named
@ViewScoped
public class BeanListProfissao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Profissao profissao = new Profissao();
	@Inject
	private ServicoProfissao servico;
	private List<Profissao> lista;
	
	@PostConstruct
	public void carregar(){
		lista = servico.consultar();		
	}

	public Profissao getProfissao() {
		return profissao;
	}

	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}
	
	public List<Profissao> getLista() {
		return lista;
	}

	public void setLista(List<Profissao> lista) {
		this.lista = lista;
	}
	
	public void excluir(){
		System.out.println(profissao.getId());	
		servico.excluir(profissao.getId());
		lista = servico.consultar();
	}
	
	public void salvar(){
		servico.salvar(profissao);
	}
	
	
	

}
