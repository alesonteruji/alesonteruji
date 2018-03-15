package br.edu.ifpr.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpr.entidades.Cidade;
import br.edu.ifpr.entidades.Cliente;
import br.edu.ifpr.entidades.Profissao;
import br.edu.ifpr.modelo.servico.ServicoCidade;
import br.edu.ifpr.modelo.servico.ServicoCliente;
import br.edu.ifpr.modelo.servico.ServicoProfissao;

@Named
@RequestScoped
public class BeanCliente implements Serializable {
	private static final long serialVersionUID = 1L;
	private Cliente cliente = new Cliente();
	@Inject
	private ServicoCliente servico;
	@Inject
	private ServicoProfissao servProfissao;
	@Inject	
	private ServicoCidade servicoCid;
	private List<Cliente> lista;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getLista() {
		return lista;
	}

	public void setLista(List<Cliente> lista) {
		this.lista = lista;
	}

	public List<Profissao> getListaProf() {
		return servProfissao.consultar();
	}

	
	public List<Cidade> getListaCidade() {
		return servicoCid.consultar();
	}

	public String salvar() {
		servico.salvar(cliente);
		return "index.xhtml";

	}
}
