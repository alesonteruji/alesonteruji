package br.edu.ifpr.bean;

import java.io.Serializable;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpr.entidades.Cidade;
import br.edu.ifpr.entidades.Estado;
import br.edu.ifpr.modelo.servico.ServicoCidade;
import br.edu.ifpr.modelo.servico.ServicoEstado;

@Named
@RequestScoped
public class BeanCidade implements Serializable {
	private static final long serialVersionUID = 1L;
	private Cidade cidade = new Cidade();
	@Inject
	private ServicoCidade servico;
	@Inject
	private ServicoEstado servicoEst;
	private List<Cidade> lista;

	public String salvar() {
		servico.salvar(cidade);
//		lista = servico.consultar();
		return "index.xhtml";
//		 return "listaCidade";
	}

	public List<Estado> getEstado2() {
		return servicoEst.consultar();
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getLista() {
		return lista;
	}

	public void setLista(List<Cidade> lista) {
		this.lista = lista;
	}

}
