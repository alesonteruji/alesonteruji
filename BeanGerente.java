package br.edu.ifpr.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpr.entidades.Gerente;
import br.edu.ifpr.entidades.Usuario;
import br.edu.ifpr.modelo.servico.ServicoGerente;

@Named
@RequestScoped
public class BeanGerente implements Serializable{
	private Gerente gerente = new Gerente();
	private Usuario usuario = new Usuario();
	@Inject
	private ServicoGerente servico;
	
	public Gerente getGerente() {
		return gerente;
	}
	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String salvar(){
		servico.salvar(gerente, usuario);
		return "listaGerente";
	}
}
