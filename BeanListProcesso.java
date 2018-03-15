package br.edu.ifpr.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpr.entidades.Advogado;
import br.edu.ifpr.entidades.AdvogadoContra;
import br.edu.ifpr.entidades.Causa;
import br.edu.ifpr.entidades.Cliente;
import br.edu.ifpr.entidades.Processo;
import br.edu.ifpr.entidades.Tribunal;
import br.edu.ifpr.entidades.Vara;
import br.edu.ifpr.modelo.servico.ServicoAdvogado;
import br.edu.ifpr.modelo.servico.ServicoAdvogadoContra;
import br.edu.ifpr.modelo.servico.ServicoCausa;
import br.edu.ifpr.modelo.servico.ServicoCliente;
import br.edu.ifpr.modelo.servico.ServicoProcesso;
import br.edu.ifpr.modelo.servico.ServicoTribunal;
import br.edu.ifpr.modelo.servico.ServicoVara;;

@Named
@ViewScoped
public class BeanListProcesso implements Serializable {
	private static final long serialVersionUID = 1L;
	private Processo processo = new Processo();

	@Inject
	private ServicoProcesso servico;
	@Inject
	private ServicoCausa servicoCausa;
	@Inject
	private ServicoTribunal servicoTribunal;
	@Inject
	private ServicoVara servicoVara;
	@Inject
	private ServicoAdvogado servicoAdvogado;
	@Inject
	private ServicoAdvogadoContra servicoAdvogadoContra;
	@Inject
	private ServicoCliente servicoCliente;

	private List<Processo> lista;

	@PostConstruct
	public void carregar() {
		lista = servico.consultar();
	}

	public List<Processo> getLista() {
		return lista;
	}

	public void setLista(List<Processo> lista) {
		this.lista = lista;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public List<Causa> getListaCausa() {
		return servicoCausa.consultar();
	}

	public List<Advogado> getListaAdvogado() {
		return servicoAdvogado.consultar();
	}

	public List<AdvogadoContra> getListaAdvogadoContra() {
		return servicoAdvogadoContra.consultar();
	}

	public List<Tribunal> getListaTribunal() {
		return servicoTribunal.consultar();
	}

	public List<Vara> getListaVara() {
		return servicoVara.consultar();
	}

	public List<Cliente> getListaCliente() {
		return servicoCliente.consultar();
	}

	public void excluir() {
		 servico.excluir(processo.getId());
		 lista = servico.consultar();
	}

	public void salvar() {
		servico.salvar(processo);
	}
}
