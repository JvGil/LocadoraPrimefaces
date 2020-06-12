package br.com.foursys.locadora.teste;

import br.com.foursys.locadora.bean.Contato;
import br.com.foursys.locadora.bean.Endereco;
import br.com.foursys.locadora.bean.Funcionario;
import br.com.foursys.locadora.controller.FuncionarioController;

public class TesteFuncionario {
	public void salvar() {
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Funcionario 01");
		funcionario.setCpf("123.123.123-12");
		funcionario.setRg("12.123.123-X");
		funcionario.setDataNascimento("20/04/1997");
		funcionario.setIdade(20);
		funcionario.setSexo("M");
		funcionario.setEnderecoCodigo(new Endereco(1));
		funcionario.setContatoCodigo(new Contato(1));
		funcionario.setLogin("admin");
		funcionario.setSenha("admin");
		
		new FuncionarioController().salvar(funcionario);
		System.out.println("Funcionario salvo com sucesso");
		
		System.exit(0);
	}
	
	public void buscarTodos() {
		for (Funcionario funcionario : new FuncionarioController().buscarTodos()) {
			System.out.println("Código: " + funcionario.getCodigo());
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Logradouro: " + funcionario.getEnderecoCodigo().getLogradouro());
			System.out.println("Número: " + funcionario.getEnderecoCodigo().getNumero());
			System.out.println("Complemento: " + funcionario.getEnderecoCodigo().getComplemento());
			System.out.println("Bairro: " + funcionario.getEnderecoCodigo().getBairro());
			System.out.println("Cidade: " + funcionario.getEnderecoCodigo().getCidadeCodigo().getNome());
			System.out.println("Estado: " + funcionario.getEnderecoCodigo().getCidadeCodigo().getEstadoCodigo().getNome() + " - " + funcionario.getEnderecoCodigo().getCidadeCodigo().getEstadoCodigo().getUf());
			System.out.println("CPF: " + funcionario.getCpf());
			System.out.println("RG: " + funcionario.getRg());
			System.out.println("Data nascimento: " + funcionario.getDataNascimento());
			System.out.println("Idade: " + funcionario.getIdade());
			System.out.println("Sexo: " + funcionario.getSexo());
			System.out.println("Celular: " + funcionario.getContatoCodigo().getCelular());
			System.out.println("Email: " + funcionario.getContatoCodigo().getEmail());
			System.out.println("Telefone: " + funcionario.getContatoCodigo().getTelefone());
			System.out.println("\n");
		}
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new TesteFuncionario().buscarTodos();
	}
}
