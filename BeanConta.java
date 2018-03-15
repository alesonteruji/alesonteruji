package br.edu.ifpr.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpr.entidades.Cliente;
import br.edu.ifpr.entidades.Conta;
import br.edu.ifpr.modelo.servico.ServicoCliente;
import br.edu.ifpr.modelo.servico.ServicoConta;

@Named
@RequestScoped
public class BeanConta implements Serializable{
	private static final long serialVersionUID = 1L;
	private Conta conta = new Conta();
	@Inject
	private ServicoConta servico;
	@Inject
	private ServicoCliente servicoCli;
	private List<Conta> lista;
	
	
	public String savlar(){
		servico.salvar(conta);
		lista = servico.consultar();
		return "listaConta";
	}
	
	public List<Cliente> getClientes2() {
        return servicoCli.consultar();
    }
	
	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public List<Conta> getLista() {
		return lista;
	}

	public void setLista(List<Conta> lista) {
		this.lista = lista;
	}
	
	
}
