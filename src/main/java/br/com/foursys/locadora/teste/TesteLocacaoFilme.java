package br.com.foursys.locadora.teste;

import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.bean.Locacao;
import br.com.foursys.locadora.bean.LocacaoFilme;
import br.com.foursys.locadora.controller.LocacaoFilmeController;

public class TesteLocacaoFilme {
	public void salvar() {
		LocacaoFilme locacaoFilme1 = new LocacaoFilme();
		locacaoFilme1.setFilmeCodigo(new Filme(1));
		locacaoFilme1.setLocacaoCodigo(new Locacao(1));
		LocacaoFilme locacaoFilme2 = new LocacaoFilme();
		locacaoFilme2.setFilmeCodigo(new Filme(2));
		locacaoFilme2.setLocacaoCodigo(new Locacao(1));
		LocacaoFilme locacaoFilme3 = new LocacaoFilme();
		locacaoFilme3.setFilmeCodigo(new Filme(3));
		locacaoFilme3.setLocacaoCodigo(new Locacao(1));
		
		LocacaoFilmeController controller = new LocacaoFilmeController();
		controller.salvar(locacaoFilme1);
		controller.salvar(locacaoFilme2);
		controller.salvar(locacaoFilme3);
		
		System.out.println("Filmes inseridos com sucesso!");
	}
	
	public void buscarTodos() {
		for (LocacaoFilme locacaoFilme : new LocacaoFilmeController().buscarTodos()) {
			System.out.println("Código: " + locacaoFilme.getCodigo());
			System.out.println("Código do filme: " + locacaoFilme.getFilmeCodigo().getCodigo());
			System.out.println("Nome: " + locacaoFilme.getFilmeCodigo().getNome());
			System.out.println("Disponível: " + locacaoFilme.getFilmeCodigo().getDisponivel());
			System.out.println("Promoção: " + locacaoFilme.getFilmeCodigo().getPromocao());
			System.out.println("Valor: " + locacaoFilme.getFilmeCodigo().getValor());
			System.out.println("Valor promoção: " + locacaoFilme.getFilmeCodigo().getValorPromocao());
			System.out.println("Código do genero do filme: " + locacaoFilme.getFilmeCodigo().getGeneroCodigo().getCodigo());
			System.out.println("Gênero: " + locacaoFilme.getFilmeCodigo().getGeneroCodigo().getDescricao());
			System.out.println("Código da locação: " + locacaoFilme.getLocacaoCodigo().getCodigo());
			System.out.println("Data da locação: " + locacaoFilme.getLocacaoCodigo().getDataLocacao());
			System.out.println("Data de devolução: " + locacaoFilme.getLocacaoCodigo().getDataDevolucao());
			System.out.println("Código: " + locacaoFilme.getLocacaoCodigo().getValor());
			System.out.println("Código: " + locacaoFilme.getLocacaoCodigo().getClienteCodigo().getNome());
			System.out.println("Código: " + locacaoFilme.getLocacaoCodigo().getClienteCodigo().getContatoCodigo().getTelefone());
			System.out.println("Código: " + locacaoFilme.getLocacaoCodigo().getClienteCodigo().getEnderecoCodigo().getCidadeCodigo().getNome());
			System.out.println("Código: " + locacaoFilme.getLocacaoCodigo().getFuncionarioCodigo().getCpf());
			System.out.println("Código: " + locacaoFilme.getCodigo());
			System.out.println("Código: " + locacaoFilme.getCodigo());
		}
	}
	
	public static void main(String[] args) {
		new TesteLocacaoFilme().buscarTodos();
	}
}
