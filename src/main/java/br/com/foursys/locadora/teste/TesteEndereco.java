package br.com.foursys.locadora.teste;

import br.com.foursys.locadora.bean.Cidade;
import br.com.foursys.locadora.bean.Endereco;
import br.com.foursys.locadora.controller.EnderecoController;

public class TesteEndereco {
	public void salvar() {
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua de teste");
		endereco.setNumero(123);
		endereco.setComplemento(null);
		endereco.setBairro("Centro");
		endereco.setCep("12.123-123");
		endereco.setCidadeCodigo(new Cidade(1));
		
		new EnderecoController().salvar(endereco);
		
		System.out.println("Endereço salvo com sucesso!");
		
		System.exit(0);
	}
	
	public void buscarTodos() {
		for(Endereco endereco : new EnderecoController().buscarTodos()) {
			System.out.println("Código: " + endereco.getCodigo());
			System.out.println("Logradouro: " + endereco.getLogradouro());
			System.out.println("Número: " + endereco.getNumero());
			System.out.println("Complemento: " + endereco.getComplemento());
			System.out.println("Bairro: " + endereco.getComplemento());
			System.out.println("CEP: " + endereco.getCep());
			System.out.println("Cidade: " + endereco.getCidadeCodigo().getNome());
			System.out.println("Estado: " + endereco.getCidadeCodigo().getEstadoCodigo().getNome());
		}
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new TesteEndereco().buscarTodos();
	}
}
