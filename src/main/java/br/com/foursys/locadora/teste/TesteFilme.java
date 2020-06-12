package br.com.foursys.locadora.teste;

import java.util.ArrayList;

import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.bean.Genero;
import br.com.foursys.locadora.dao.FilmeDAO;

public class TesteFilme {

	public void salvar() {

		Genero genero = new Genero(2);
		
		Filme filme = new Filme();

		filme.setNome("Matrix");
		filme.setGeneroCodigo(genero);
		filme.setValor(8.75);
		filme.setDisponivel("SIM");
		filme.setPromocao("SIM");
		filme.setValorPromocao(6.0);

		FilmeDAO dao = new FilmeDAO();
		dao.salvar(filme);
		
		System.out.println("Filme inserido com sucesso!");
		System.exit(0);
	}
	
	public void buscarTodos() throws Exception {
		ArrayList<Filme> filmes = new FilmeDAO().buscarTodos();
		for (Filme filme : filmes) {
			System.out.println(filme.getNome());
		}
		System.exit(0);
	}

	public static void main(String[] args) throws Exception {
		new TesteFilme().salvar();
	}

}
