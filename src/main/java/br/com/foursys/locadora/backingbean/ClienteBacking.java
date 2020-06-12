package br.com.foursys.locadora.backingbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.foursys.locadora.bean.Cidade;
import br.com.foursys.locadora.bean.Cliente;
import br.com.foursys.locadora.bean.Contato;
import br.com.foursys.locadora.bean.Endereco;
import br.com.foursys.locadora.bean.Estado;
import br.com.foursys.locadora.bean.Locacao;
import br.com.foursys.locadora.controller.CidadeController;
import br.com.foursys.locadora.controller.ClienteController;
import br.com.foursys.locadora.controller.ContatoController;
import br.com.foursys.locadora.controller.EnderecoController;
import br.com.foursys.locadora.controller.EstadoController;
import br.com.foursys.locadora.controller.LocacaoController;
import br.com.foursys.locadora.util.JSFUtil;
import br.com.foursys.locadora.util.Mensagem;
import br.com.foursys.locadora.util.Rotulo;
import br.com.foursys.locadora.util.Valida;

@ManagedBean(name = "clienteBacking")
@SessionScoped
public class ClienteBacking implements Serializable {
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

	private Cliente clienteUpdate;
	private boolean alterar;

	public Cliente getClienteUpdate() {
		return clienteUpdate;
	}

	public void setClienteUpdate(Cliente clienteUpdate) {
		this.clienteUpdate = clienteUpdate;
	}

	private String pesquisaNome = "";

	private ArrayList<Cliente> listaClientes;

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

	public String getPesquisaNome() {
		return pesquisaNome;
	}

	public void setPesquisaNome(String pesquisaNome) {
		this.pesquisaNome = pesquisaNome;
	}

	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
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
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoInvalido, Mensagem.informeCpfValido);
			return false;
		}
		if (Valida.vazio(rg)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeRg);
			return false;
		}
		if (Valida.rg(rg)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoInvalido, Mensagem.informeRgValido);
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
		return true;
	}

	public String salvar() {
		if (alterar) {
			if (validaAlterar()) {
				alterar = false;
				new EnderecoController().salvar(clienteUpdate.getEnderecoCodigo());
				new ContatoController().salvar(clienteUpdate.getContatoCodigo());
				new ClienteController().salvar(clienteUpdate);
				JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.sucesso,
						Mensagem.clienteAlteradoComSucesso);
				return "consultarCliente";
			}
		} else {
			if (validaSalvar()) {
				Cliente cliente = new Cliente();
				cliente.setNome(nome);
				cliente.setCpf(cpf);
				cliente.setRg(rg);
				cliente.setDataNascimento(dataNascimento);
				cliente.setIdade(Valida.retornaIdade(dataNascimento));
				cliente.setSexo(sexo);

				Endereco endereco = new Endereco();
				endereco.setCidadeCodigo(new Cidade(Integer.parseInt(cidade)));
				endereco.setCep(cep);
				endereco.setBairro(bairro);
				endereco.setLogradouro(logradouro);
				endereco.setNumero(Integer.parseInt(numero));
				endereco.setComplemento(complemento);
				cliente.setEnderecoCodigo(endereco);

				Contato contato = new Contato();
				contato.setCelular(celular);
				contato.setEmail(email);
				contato.setTelefone(telefone);
				cliente.setContatoCodigo(contato);

				try {
					new ContatoController().salvar(contato);
					new EnderecoController().salvar(endereco);
					new ClienteController().salvar(cliente);
					JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.sucesso,
							Mensagem.clienteSalvoComSucesso);
				} catch (Exception e) {
					JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.erro, Mensagem.erroSalvarCliente);
				}
				limparCampos();
			}
		}
		return "";
	}

	public boolean validaAlterar() {
		if (Valida.vazio(clienteUpdate.getEnderecoCodigo().getCidadeCodigo().getEstadoCodigo().getNome())) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeEstado);
			return false;
		}
		if (Valida.vazio(clienteUpdate.getEnderecoCodigo().getCidadeCodigo().getNome())) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeCidade);
			return false;
		}
		if (Valida.vazio(clienteUpdate.getEnderecoCodigo().getCep())) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeCep);
			return false;
		}
		if (Valida.vazio(clienteUpdate.getEnderecoCodigo().getBairro())) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeBairro);
			return false;
		}
		if (Valida.vazio(clienteUpdate.getEnderecoCodigo().getLogradouro())) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeLogradouro);
			return false;
		}
		if (Valida.vazio(clienteUpdate.getEnderecoCodigo().getNumero() + "")) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeNumero);
			return false;
		}
		return true;
	}

	public ArrayList<Cliente> preencherTabela() {
		return new ClienteController().buscarTodos();
	}

	public void pesquisar() {
		listaClientes = pesquisarCliente();
	}

	public ArrayList<Cliente> pesquisarCliente() {
		return new ClienteController().buscarNome(pesquisaNome);
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
		return "alterarCliente";
	}

	public String excluir() {
		for (Locacao locacao : new LocacaoController().buscarTodos()) {
			if (clienteUpdate.getCodigo() == locacao.getClienteCodigo().getCodigo()) {
				JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.erro, Mensagem.erroAoExcluirCliente);
				return "";
			}
		}
		listaClientes.remove(clienteUpdate);
		new ClienteController().excluir(clienteUpdate);
		new ContatoController().excluir(clienteUpdate.getContatoCodigo());
		new EnderecoController().excluir(clienteUpdate.getEnderecoCodigo());
		JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.sucesso, Mensagem.clienteExcluidoComSucesso);
		return "";
	}
}
