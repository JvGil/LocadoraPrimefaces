package br.com.foursys.locadora.teste;

import br.com.foursys.locadora.bean.Cliente;
import br.com.foursys.locadora.bean.Contato;
import br.com.foursys.locadora.bean.Endereco;
import br.com.foursys.locadora.controller.ClienteController;

public class TesteCliente {
	public void salvar() {
		
		Cliente cliente = new Cliente();
		cliente.setNome("Cliente 01");
		cliente.setCpf("123.123.123-12");
		cliente.setRg("12.123.123-X");
		cliente.setDataNascimento("20/04/1997");
		cliente.setIdade(20);
		cliente.setSexo("M");
		cliente.setEnderecoCodigo(new Endereco(1));
		cliente.setContatoCodigo(new Contato(1));
		
		new ClienteController().salvar(cliente);
		System.out.println("Cliente salvo com sucesso");
		
		System.exit(0);
	}
	
	public void buscarTodos() {
		for (Cliente cliente : new ClienteController().buscarTodos()) {
			System.out.println("Código: " + cliente.getCodigo());
			System.out.println("Nome: " + cliente.getNome());
			System.out.println("Logradouro: " + cliente.getEnderecoCodigo().getLogradouro());
			System.out.println("Número: " + cliente.getEnderecoCodigo().getNumero());
			System.out.println("Complemento: " + cliente.getEnderecoCodigo().getComplemento());
			System.out.println("Bairro: " + cliente.getEnderecoCodigo().getBairro());
			System.out.println("Cidade: " + cliente.getEnderecoCodigo().getCidadeCodigo().getNome());
			System.out.println("Estado: " + cliente.getEnderecoCodigo().getCidadeCodigo().getEstadoCodigo().getNome() + " - " + cliente.getEnderecoCodigo().getCidadeCodigo().getEstadoCodigo().getUf());
			System.out.println("CPF: " + cliente.getCpf());
			System.out.println("RG: " + cliente.getRg());
			System.out.println("Data nascimento: " + cliente.getDataNascimento());
			System.out.println("Idade: " + cliente.getIdade());
			System.out.println("Sexo: " + cliente.getSexo());
			System.out.println("Celular: " + cliente.getContatoCodigo().getCelular());
			System.out.println("Email: " + cliente.getContatoCodigo().getEmail());
			System.out.println("Telefone: " + cliente.getContatoCodigo().getTelefone());
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) {
		new TesteCliente().buscarTodos();
	}
}
