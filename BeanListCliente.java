package br.edu.ifpr.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpr.entidades.Cliente;
import br.edu.ifpr.entidades.Profissao;
import br.edu.ifpr.modelo.servico.ServicoCliente;
import br.edu.ifpr.modelo.servico.ServicoProfissao;

@Named
@ViewScoped
public class BeanListCliente implements Serializable{
	private static final long serialVersionUID = 1L;
	private Cliente cliente = new Cliente();
	@Inject
	private ServicoCliente servico;
	@Inject
	private ServicoProfissao servProfissao;
	private List<Cliente> lista;
	
	@PostConstruct
	public void carregar(){
		lista = servico.consultar();
	}

	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void alterar(){
		servico.salvar(cliente);
	}
	
	public List<Profissao> getListaProf() {
		return servProfissao.consultar();
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

	public void excluir(){
		servico.excluir(cliente.getId());
		lista = servico.consultar();
	}

	public void salvar(){
		servico.salvar(cliente);
	}
}
