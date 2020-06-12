package br.com.foursys.locadora.backingbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.bean.Genero;
import br.com.foursys.locadora.bean.LocacaoFilme;
import br.com.foursys.locadora.controller.FilmeController;
import br.com.foursys.locadora.controller.GeneroController;
import br.com.foursys.locadora.controller.LocacaoFilmeController;
import br.com.foursys.locadora.util.JSFUtil;
import br.com.foursys.locadora.util.Mensagem;
import br.com.foursys.locadora.util.Rotulo;
import br.com.foursys.locadora.util.Valida;

@ManagedBean(name = "filmeBacking")
@SessionScoped
public class FilmeBacking implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String nome;
	private String valor;
	private String disponivel;
	private String promocao;
	private String valorPromocao;
	private String codigoGenero;

	private Filme filmeUpdate;
	private boolean alterar;

	public Filme getFilmeUpdate() {
		return filmeUpdate;
	}

	public void setFilmeUpdate(Filme filmeUpdate) {
		this.filmeUpdate = filmeUpdate;
	}

	private String pesquisaNome = "";

	private ArrayList<Filme> listaFilmes;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(String disponivel) {
		this.disponivel = disponivel;
	}

	public String getPromocao() {
		return promocao;
	}

	public void setPromocao(String promocao) {
		this.promocao = promocao;
	}

	public String getValorPromocao() {
		return valorPromocao;
	}

	public void setValorPromocao(String valorPromocao) {
		this.valorPromocao = valorPromocao;
	}

	public String getCodigoGenero() {
		return codigoGenero;
	}

	public void setCodigoGenero(String codigoGenero) {
		this.codigoGenero = codigoGenero;
	}

	public String getPesquisaNome() {
		return pesquisaNome;
	}

	public void setPesquisaNome(String pesquisaNome) {
		this.pesquisaNome = pesquisaNome;
	}

	public ArrayList<Filme> getListaFilmes() {
		return listaFilmes;
	}

	public void setListaFilmes(ArrayList<Filme> listaFilmes) {
		this.listaFilmes = listaFilmes;
	}

	public String salvar() {
		if (alterar) {
			if (validaAlterar()) {
				alterar = false;
				new FilmeController().salvar(filmeUpdate);
				JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.sucesso, Mensagem.filmeAlteradoComSucesso);
				return "consultarFilme";
			}
		} else {
			if (validaSalvar()) {
				Filme filme = new Filme();
				filme.setDisponivel(disponivel);
				filme.setGeneroCodigo(new Genero(Integer.parseInt(codigoGenero)));
				filme.setNome(nome);
				filme.setPromocao(promocao);
				filme.setValor(Double.parseDouble(valor));
				filme.setValorPromocao(Double.parseDouble(valorPromocao));

				try {
					new FilmeController().salvar(filme);
					JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.sucesso, Mensagem.filmeSalvoComSucesso);
				} catch (Exception e) {
					JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.erro, Mensagem.erroSalvarFilme);
				}
				limparCampos();
			}
		}
		return "";
	}

	public void limparCampos() {
		nome = null;
		codigoGenero = null;
		valor = null;
		disponivel = null;
		promocao = null;
		valorPromocao = null;
	}

	public boolean validaSalvar() {
		if (Valida.vazio(nome)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeNome);
			return false;
		}
		if (Valida.vazio(codigoGenero)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeGenero);
			return false;
		}
		if (Valida.vazio(valor)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeValor);
			return false;
		}
		if (Valida.vazio(disponivel)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeDisponivel);
			return false;
		}
		if (Valida.vazio(promocao)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informePromocao);
			return false;
		} else if (promocao.equals("SIM")) {
			if (Valida.vazio(valorPromocao)) {
				JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio,
						Mensagem.informeValorPromocao);
				return false;
			}
			if (Valida.numero(Double.parseDouble(valorPromocao))) {
				JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoInvalido,
						Mensagem.informeValorPromocaoValido);
				return false;
			}
		} else {
			if (Valida.vazio(valorPromocao)) {
				valorPromocao = "0";
			}
		}
		return true;
	}
	
	public boolean validaAlterar() {
		if (Valida.vazio(filmeUpdate.getDisponivel())) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeGenero);
			return false;
		}
		if (Valida.numero(filmeUpdate.getValor())) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoInvalido, Mensagem.informeValorValido);
			return false;
		}
		if (Valida.vazio(filmeUpdate.getDisponivel())) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeDisponivel);
			return false;
		}
		if (Valida.vazio(filmeUpdate.getPromocao())) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informePromocao);
			return false;
		} else if (filmeUpdate.getPromocao().equals("SIM")) {
			if (Valida.vazio(valorPromocao)) {
				JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio,
						Mensagem.informeValorPromocao);
				return false;
			}
			if (Valida.numero(filmeUpdate.getValorPromocao())) {
				JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoInvalido,
						Mensagem.informeValorPromocaoValido);
				return false;
			}
		} else {
			valorPromocao = "0";
		}
		return true;
	}

	public ArrayList<Filme> preencherTabela() {
		return new FilmeController().buscarTodos();
	}

	public void pesquisar() {
		listaFilmes = pesquisarFilme();
	}

	public ArrayList<Filme> pesquisarFilme() {
		return new FilmeController().buscarNome(pesquisaNome);
	}

	public ArrayList<SelectItem> pesquisarGenero() {
		ArrayList<SelectItem> listaRetorno = new ArrayList<SelectItem>();
		for (Genero vo : new GeneroController().preencherCombo()) {
			SelectItem si = new SelectItem();
			si.setLabel(vo.getDescricao());
			si.setValue(vo.getCodigo());
			listaRetorno.add(si);
		}
		return listaRetorno;
	}

	public String sair() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public String alterar() {
		alterar = true;
		return "alterarFilme";
	}
	public String excluir() {
		for (LocacaoFilme locacaoFilme : new LocacaoFilmeController().buscarTodos()) {
			if (filmeUpdate.getCodigo() == locacaoFilme.getFilmeCodigo().getCodigo()) {
				JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.erro, Mensagem.erroAoExcluirFilme);
				return "";
			}
		}
		listaFilmes.remove(filmeUpdate);
		new FilmeController().excluir(filmeUpdate);
		return "";
	}
}
