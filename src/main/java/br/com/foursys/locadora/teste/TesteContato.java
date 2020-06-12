package br.com.foursys.locadora.teste;

import br.com.foursys.locadora.bean.Contato;
import br.com.foursys.locadora.controller.ContatoController;

public class TesteContato {
	public void salvar() {
		
		Contato contato = new Contato();
		contato.setCelular("(11) 95157-5911");
		contato.setTelefone("(11) 4002-8922");
		contato.setEmail("teste@teste.com.br");
		
		new ContatoController().salvar(contato);
		
		System.out.println("Contato inserido com sucesso");
		
		System.exit(0);
	}
	
	public void buscarTodos() {
		for (Contato contato : new ContatoController().buscarTodos()) {
			System.out.println("Código: " + contato.getCodigo());
			System.out.println("Celular: " + contato.getCelular());
			System.out.println("Telefone: " + contato.getTelefone());
			System.out.println("Email: " + contato.getEmail());
		}
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new TesteContato().buscarTodos();
	}
}
