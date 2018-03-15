package br.edu.ifpr.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpr.entidades.Evento;
import br.edu.ifpr.modelo.servico.ServicoEvento;

@Named
@ViewScoped
public class BeanListEvento implements Serializable {
	private static final long serialVersionUID = 1L;

	private Evento evento = new Evento();
	@Inject
	private ServicoEvento servico;
	private List<Evento> lista;

	@PostConstruct
	public void carregar() {
		lista = servico.consultar();
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public List<Evento> getLista() {
		return lista;
	}

	public void setLista(List<Evento> lista) {
		this.lista = lista;
	}

	public void excluir() {
		// System.out.println(profissao.getId());
		servico.excluir(evento.getId());
		lista = servico.consultar();
	}

	public void salvar() {
		servico.salvar(evento);
	}

}
