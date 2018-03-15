package br.edu.ifpr.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import br.edu.ifpr.entidades.Conta;
import br.edu.ifpr.entidades.Operacao;
import br.edu.ifpr.modelo.servico.ServicoOperacao;

@Named
@ViewScoped
public class BeanOperacao implements Serializable{
	@Inject
	private ServicoOperacao servico;
	private Double valor;
	private Operacao operacao = new Operacao();
	private Conta conta;
	private List<Operacao> lista;
	private Integer idCliente;
	
	@PostConstruct
	public void inicar(){
		//pegar o id do cliente via get
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		idCliente = Integer.parseInt(request.getParameter("id"));
		conta = servico.buscarConta(idCliente);
		lista = servico.consultar(idCliente);
	}
	
	public void creditar(){
		operacao = new Operacao();
		operacao.setConta(conta);
		operacao.setValor(valor);
		conta = servico.creditar(operacao);
		valor = 0d;
		lista = servico.consultar(idCliente);
	}

	
	public void debitar(){
		operacao = new Operacao();
		operacao.setConta(conta);
		operacao.setValor(valor);
		conta = servico.debitar(operacao);
		valor = 0d;
		lista = servico.consultar(idCliente);
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Operacao getOperacao() {
		return operacao;
	}

	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public List<Operacao> getLista() {
		return lista;
	}

	public void setLista(List<Operacao> lista) {
		this.lista = lista;
	}
}
