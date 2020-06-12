package br.com.foursys.locadora.backingbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.foursys.locadora.bean.Cidade;
import br.com.foursys.locadora.bean.Contato;
import br.com.foursys.locadora.bean.Endereco;
import br.com.foursys.locadora.bean.Estado;
import br.com.foursys.locadora.bean.Funcionario;
import br.com.foursys.locadora.bean.Locacao;
import br.com.foursys.locadora.controller.CidadeController;
import br.com.foursys.locadora.controller.ContatoController;
import br.com.foursys.locadora.controller.EnderecoController;
import br.com.foursys.locadora.controller.EstadoController;
import br.com.foursys.locadora.controller.FuncionarioController;
import br.com.foursys.locadora.controller.LocacaoController;
import br.com.foursys.locadora.util.JSFUtil;
import br.com.foursys.locadora.util.Mensagem;
import br.com.foursys.locadora.util.Rotulo;
import br.com.foursys.locadora.util.Valida;

@ManagedBean(name = "funcionarioBacking")
@SessionScoped
public class FuncionarioBacking implements Serializable {
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String nome;
	private String cpf;
	private String rg;
	private String dataNascimento;
	private String sexo;
	private String cep;
	private String estado;
	private String cidade;
	private String bairro;
	private String logradouro;
	private String numero;
	private String complemento;
	private String telefone;
	private String celular;
	private String email;
	private String login;
	private String senha;

	private Funcionario funcionarioUpdate;
	private boolean alterar;

	public Funcionario getFuncionarioUpdate() {
		return funcionarioUpdate;
	}

	public void setFuncionarioUpdate(Funcionario funcionarioUpdate) {
		this.funcionarioUpdate = funcionarioUpdate;
	}

	public boolean isAlterar() {
		return alterar;
	}

	public void setAlterar(boolean alterar) {
		this.alterar = alterar;
	}

	private String pesquisaNome = "";

	private ArrayList<Funcionario> listaFuncionarios;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPesquisaNome() {
		return pesquisaNome;
	}

	public void setPesquisaNome(String pesquisaNome) {
		this.pesquisaNome = pesquisaNome;
	}

	public ArrayList<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}

	public void setListaFuncionarios(ArrayList<Funcionario> listaFuncionarios) {
		this.listaFuncionarios = listaFuncionarios;
	}

	public void limparCampos() {
		codigo = null;
		nome = null;
		cpf = null;
		rg = null;
		dataNascimento = null;
		sexo = null;
		cep = null;
		estado = null;
		cidade = null;
		bairro = null;
		logradouro = null;
		numero = null;
		complemento = null;
		telefone = null;
		celular = null;
		email = null;
		login = null;
		senha = null;
	}

	public boolean validaSalvar() {
		if (Valida.vazio(nome)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeNome);
			return false;
		}
		if (Valida.vazio(cpf)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeCpf);
			return false;
		}
		if (Valida.cpf(cpf)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeCpfValido);
			return false;
		}
		if (Valida.vazio(rg)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeRg);
			return false;
		}
		if (Valida.rg(rg)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeRgValido);
			return false;
		}
		if (Valida.vazio(dataNascimento)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeDataNascimento);
			return false;
		}
		if (Valida.data(dataNascimento)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoInvalido, Mensagem.informeDataNascimentoValida);
			return false;
		}
		if (Valida.vazio(sexo)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeSexo);
			return false;
		}
		if (Valida.vazio(estado)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeEstado);
			return false;
		}
		if (Valida.vazio(cidade)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeCidade);
			return false;
		}
		if (Valida.vazio(cep)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeCep);
			return false;
		}
		if (Valida.vazio(bairro)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeBairro);
			return false;
		}
		if (Valida.vazio(logradouro)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeLogradouro);
			return false;
		}
		if (Valida.vazio(numero)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeNumero);
			return false;
		}
		if (Valida.vazio(login)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeLogin);
			return false;
		}
		if (Valida.vazio(senha)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeSenha);
			return false;
		}
		return true;
	}

	public String salvar() {
		if (alterar) {
			if (validaAlterar()) {
				alterar = false;
				new EnderecoController().salvar(funcionarioUpdate.getEnderecoCodigo());
				new ContatoController().salvar(funcionarioUpdate.getContatoCodigo());
				new FuncionarioController().salvar(funcionarioUpdate);
				JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.sucesso,
						Mensagem.funcionarioAlteradoComSucesso);
				return "consultarFuncionario";
			}
		} else {
			if (validaSalvar()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setNome(nome);
				funcionario.setCpf(cpf);
				funcionario.setRg(rg);
				funcionario.setDataNascimento(dataNascimento);
				funcionario.setIdade(Valida.retornaIdade(dataNascimento));
				funcionario.setSexo(sexo);

				Endereco endereco = new Endereco();
				endereco.setCidadeCodigo(new Cidade(Integer.parseInt(cidade)));
				endereco.setCep(cep);
				endereco.setBairro(bairro);
				endereco.setLogradouro(logradouro);
				endereco.setNumero(Integer.parseInt(numero));
				endereco.setComplemento(complemento);
				funcionario.setEnderecoCodigo(endereco);

				Contato contato = new Contato();
				contato.setCelular(celular);
				contato.setEmail(email);
				contato.setTelefone(telefone);
				funcionario.setContatoCodigo(contato);

				funcionario.setLogin(login);
				funcionario.setSenha(senha);

				try {
					new ContatoController().salvar(contato);
					new EnderecoController().salvar(endereco);
					new FuncionarioController().salvar(funcionario);
					JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.sucesso,
							Mensagem.funcionarioSalvoComSucesso);
				} catch (Exception e) {
					JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.erro,
							Mensagem.erroSalvarFuncionario);
				}
				limparCampos();
			}
		}
		return "";
	}

	public boolean validaAlterar() {
		if (Valida.vazio(funcionarioUpdate.getEnderecoCodigo().getCidadeCodigo().getEstadoCodigo().getNome())) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeEstado);
			return false;
		}
		if (Valida.vazio(funcionarioUpdate.getEnderecoCodigo().getCidadeCodigo().getNome())) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeCidade);
			return false;
		}
		if (Valida.vazio(funcionarioUpdate.getEnderecoCodigo().getCep())) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeCep);
			return false;
		}
		if (Valida.vazio(funcionarioUpdate.getEnderecoCodigo().getBairro())) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeBairro);
			return false;
		}
		if (Valida.vazio(funcionarioUpdate.getEnderecoCodigo().getLogradouro())) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeLogradouro);
			return false;
		}
		if (Valida.vazio(funcionarioUpdate.getEnderecoCodigo().getNumero() + "")) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeNumero);
			return false;
		}
		if (Valida.vazio(funcionarioUpdate.getLogin())) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeLogin);
			return false;
		}
		if (Valida.vazio(funcionarioUpdate.getSenha())) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeSenha);
			return false;
		}
		return true;
	}

	public ArrayList<SelectItem> pesquisarEstado() {
		ArrayList<SelectItem> listaRetorno = new ArrayList<SelectItem>();
		for (Estado estado : new EstadoController().buscarTodos()) {
			SelectItem si = new SelectItem();
			si.setLabel(estado.getNome());
			si.setValue(estado.getCodigo());
			listaRetorno.add(si);
		}
		return listaRetorno;
	}

	public ArrayList<SelectItem> pesquisarCidade() {
		ArrayList<SelectItem> listaRetorno = new ArrayList<SelectItem>();
		for (Cidade cidade : new CidadeController().buscarTodos()) {
			SelectItem si = new SelectItem();
			si.setLabel(cidade.getNome());
			si.setValue(cidade.getCodigo());
			listaRetorno.add(si);
		}
		return listaRetorno;
	}

	public ArrayList<Funcionario> preencherTabela() {
		return new FuncionarioController().buscarTodos();
	}

	public void pesquisar() {
		listaFuncionarios = pesquisarFuncionario();
	}

	public ArrayList<Funcionario> pesquisarFuncionario() {
		return new FuncionarioController().buscarNome(pesquisaNome);
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
		return "alterarFuncionario";
	}

	public String excluir() {
		for (Locacao locacao : new LocacaoController().buscarTodos()) {
			if (funcionarioUpdate.getCodigo() == locacao.getClienteCodigo().getCodigo()) {
				JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.erro, Mensagem.erroAoExcluirFuncionario);
				return "";
			}
		}
		listaFuncionarios.remove(funcionarioUpdate);
		new FuncionarioController().excluir(funcionarioUpdate);
		new ContatoController().excluir(funcionarioUpdate.getContatoCodigo());
		new EnderecoController().excluir(funcionarioUpdate.getEnderecoCodigo());
		return "";
	}
}
