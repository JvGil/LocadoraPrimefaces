package br.com.foursys.locadora.backingbean;

import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.foursys.locadora.bean.Cliente;
import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.bean.FormaPagamento;
import br.com.foursys.locadora.bean.Funcionario;
import br.com.foursys.locadora.bean.Locacao;
import br.com.foursys.locadora.bean.LocacaoFilme;
import br.com.foursys.locadora.controller.ClienteController;
import br.com.foursys.locadora.controller.FilmeController;
import br.com.foursys.locadora.controller.FormaPagamentoController;
import br.com.foursys.locadora.controller.FuncionarioController;
import br.com.foursys.locadora.controller.LocacaoController;
import br.com.foursys.locadora.controller.LocacaoFilmeController;
import br.com.foursys.locadora.util.JSFUtil;
import br.com.foursys.locadora.util.Mensagem;
import br.com.foursys.locadora.util.Rotulo;
import br.com.foursys.locadora.util.Valida;

@ManagedBean(name = "locacaoBacking")
@SessionScoped
public class LocacaoBacking implements Serializable {
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String funcionario;
	private String cliente;
	private ArrayList<String> filmes;
	private String valor;
	private String formaPagamento;
	private String dataDevolucao;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public ArrayList<String> getFilmes() {
		return filmes;
	}

	public void setFilmes(ArrayList<String> filmes) {
		this.filmes = filmes;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public boolean validaSalvar() {
		if (Valida.vazio(valor)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeFilme);
			return false;
		}
		if (Valida.vazio(funcionario)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeFuncionario);
			return false;
		}
		if (Valida.vazio(cliente)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeCliente);
			return false;
		}
		if (Valida.vazio(dataDevolucao)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio,
					Mensagem.informeDataDevolucao);
			return false;
		}
		if (Valida.dataDevolucao(dataDevolucao)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoInvalido,
					Mensagem.informeDataDevolucaoValida);
			return false;
		}
		if (Valida.vazio(formaPagamento)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio,
					Mensagem.informeFormaPagamento);
			return false;
		}
		return true;
	}

	public String salvar() {
		if (validaSalvar()) {
			Locacao locacao = new Locacao();
			locacao.setClienteCodigo(new Cliente(Integer.parseInt(cliente)));
			locacao.setFuncionarioCodigo(new Funcionario(Integer.parseInt(funcionario)));
			locacao.setDataLocacao(retornaDataAtual());
			locacao.setFormaPagamentoCodigo(new FormaPagamento(Integer.parseInt(formaPagamento)));
			locacao.setValor(retornaValorFormatado());
			locacao.setDataDevolucao(dataDevolucao);
			locacao.setDevolvido("NÃO");

			try {
				new LocacaoController().salvar(locacao);
				salvarLocacaoFilme(locacao);
				JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.sucesso,
						Mensagem.locacaoFilmeSalvoComSucesso);
				limparCampos();
			} catch (Exception e) {
				JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.sucesso, Mensagem.erroSalvarLocacaoFilme);
			}
		}
		return "";
	}

	public void salvarLocacaoFilme(Locacao locacao) throws Exception {
		for (String string : filmes) {
			LocacaoFilme locacaoFilme = new LocacaoFilme();
			Filme filme = new FilmeController().buscarCodigo(string);
			locacaoFilme.setFilmeCodigo(filme);
			locacaoFilme.setLocacaoCodigo(locacao);
			new LocacaoFilmeController().salvar(locacaoFilme);
			filme.setDisponivel("NÃO");
			new FilmeController().salvar(filme);
		}
	}

	public void limparCampos() {
		codigo = null;
		funcionario = null;
		cliente = null;
		filmes = null;
		valor = null;
		formaPagamento = null;
		dataDevolucao = null;
	}

	public boolean validaSalvarDevolucao() {
		if (Valida.vazio(codigo)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeLocacao);
			return false;
		}
		return true;
	}

	public String salvarDevolucao() {
		if (validaSalvarDevolucao()) {
			Locacao locacao = new LocacaoController().buscarCodigo(codigo);
			locacao.setDataDevolucao(retornaDataAtual());
			locacao.setDevolvido("SIM");

			try {
				new LocacaoController().salvar(locacao);
				alterarLocacaoFilme(locacao);
				JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.sucesso, Mensagem.locacaoFilmeDevolvidaComSucesso);
				limparCampos();
			} catch (Exception e) {
				JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.erro, Mensagem.erroSalvarLocacaoFilme);
			}
		}
		return "";
	}

	public void alterarLocacaoFilme(Locacao locacao) throws Exception {
		for (LocacaoFilme locacaoFilme : new LocacaoFilmeController().buscarTodos()) {
			if (locacaoFilme.getLocacaoCodigo().getCodigo() == locacao.getCodigo()) {
				Filme filme = new FilmeController().buscarCodigo(locacaoFilme.getFilmeCodigo().getCodigo() + "");
				filme.setDisponivel("SIM");
				new FilmeController().salvar(filme);
			}
		}
	}

	public String retornaDataAtual() {
		Calendar cal = Calendar.getInstance();
		int anoAtual = cal.get(Calendar.YEAR);
		int mesAtual = cal.get(Calendar.MONTH) + 1;
		int diaAtual = cal.get(Calendar.DAY_OF_MONTH);

		String dataAtual = diaAtual + "/" + (mesAtual <= 9 ? "0" + mesAtual : mesAtual) + "/" + anoAtual;
		return dataAtual;
	}

	public double retornaValorFormatado() {
		double valorFormatado = 0;
		valorFormatado = Double.parseDouble(valor.replace("R$", "").replace(".", "").replace(",", "."));
		return valorFormatado;
	}

	public ArrayList<SelectItem> pesquisarFuncionario() {
		ArrayList<SelectItem> listaRetorno = new ArrayList<SelectItem>();
		for (Funcionario funcionario : new FuncionarioController().buscarTodos()) {
			SelectItem si = new SelectItem();
			si.setLabel(funcionario.getNome());
			si.setValue(funcionario.getCodigo());
			listaRetorno.add(si);
		}
		return listaRetorno;
	}

	public ArrayList<SelectItem> pesquisarCliente() {
		ArrayList<SelectItem> listaRetorno = new ArrayList<SelectItem>();
		for (Cliente cliente : new ClienteController().buscarTodos()) {
			SelectItem si = new SelectItem();
			si.setLabel(cliente.getNome());
			si.setValue(cliente.getCodigo());
			listaRetorno.add(si);
		}
		return listaRetorno;
	}

	public ArrayList<SelectItem> pesquisarFilmes() {
		ArrayList<SelectItem> listaRetorno = new ArrayList<SelectItem>();
		for (Filme filme : new FilmeController().buscarTodos()) {
			if (filme.getDisponivel().equals("SIM")) {
				SelectItem si = new SelectItem();
				si.setLabel(filme.getNome());
				si.setValue(filme.getCodigo());
				listaRetorno.add(si);
			}
		}
		return listaRetorno;
	}

	public ArrayList<SelectItem> pesquisarFormaPagamento() {
		ArrayList<SelectItem> listaRetorno = new ArrayList<SelectItem>();
		for (FormaPagamento formaPagamento : new FormaPagamentoController().buscarTodos()) {
			SelectItem si = new SelectItem();
			si.setLabel(formaPagamento.getDescricao());
			si.setValue(formaPagamento.getCodigo());
			listaRetorno.add(si);
		}
		return listaRetorno;
	}

	public ArrayList<SelectItem> pesquisarLocacoes() {
		ArrayList<SelectItem> listaRetorno = new ArrayList<SelectItem>();
		for (Locacao locacao : new LocacaoController().buscarTodos()) {
			if (locacao.getDevolvido().equals("NÃO")) {
				SelectItem si = new SelectItem();
				si.setLabel(locacao.getClienteCodigo().getNome());
				si.setValue(locacao.getCodigo());
				listaRetorno.add(si);
			}
		}
		return listaRetorno;
	}

	public String atualizaValor() {
		double valorAux = 0;
		for (String string : filmes) {
			Filme aux = new FilmeController().buscarCodigo(string);
			if (aux.getPromocao().equals("SIM")) {
				valorAux += aux.getValorPromocao();
			} else {
				valorAux += aux.getValor();
			}
		}

		valor = new DecimalFormat("R$#,##0.00").format(valorAux);
		return "";
	}

	public String atualizaCampos() {
		Locacao aux = new LocacaoController().buscarCodigo(codigo);
		funcionario = aux.getFuncionarioCodigo().getNome();
		cliente = aux.getClienteCodigo().getCpf();
		valor = new DecimalFormat("R$#,##0.00").format(aux.getValor());
		return "";
	}

	public String sair() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

}
