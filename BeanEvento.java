package br.edu.ifpr.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpr.entidades.Evento;
import br.edu.ifpr.modelo.servico.ServicoEvento;

@Named
@RequestScoped
public class BeanEvento implements Serializable {
	private static final long serialVersionUID = 1L;

	private Evento evento = new Evento();
	@Inject
	private ServicoEvento servico;

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public String salvar() {
		servico.salvar(evento);
		return "index.xhtml";
	}

}
