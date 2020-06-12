package br.com.foursys.locadora.teste;

import br.com.foursys.locadora.bean.Cliente;
import br.com.foursys.locadora.bean.FormaPagamento;
import br.com.foursys.locadora.bean.Funcionario;
import br.com.foursys.locadora.bean.Locacao;
import br.com.foursys.locadora.controller.LocacaoController;

public class TesteLocacao {
	public void salvar() {
		Locacao locacao = new Locacao();
		locacao.setClienteCodigo(new Cliente(1));
		locacao.setDataDevolucao("20/05/2021");
		locacao.setDataLocacao("16/04/2020");
		locacao.setFormaPagamentoCodigo(new FormaPagamento(1));
		locacao.setFuncionarioCodigo(new Funcionario(1));
		locacao.setValor(12.50);
		
		LocacaoController controller = new LocacaoController();
		controller.salvar(locacao);
		
		System.out.println("Locação salva com sucesso!");
		System.exit(0);
	}
	
	public void buscarTodos() {
		for (Locacao locacao : new LocacaoController().buscarTodos()) {
			System.out.println(locacao.getCodigo());
			System.out.println(locacao.getDataLocacao());
			System.out.println(locacao.getDataDevolucao());
			System.out.println(locacao.getValor());
			System.out.println(locacao.getFormaPagamentoCodigo());
			System.out.println(locacao.getFuncionarioCodigo());
			System.out.println(locacao.getClienteCodigo().getNome());
		}
	}
	
	public static void main(String[] args) {
		new TesteLocacao().salvar();
	}
}
