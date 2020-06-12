package br.com.foursys.locadora.controller;

import br.com.foursys.locadora.bean.Funcionario;

public class LoginController {
	public String validaLogin(String login, String senha) {
		for (Funcionario funcionario : new FuncionarioController().buscarTodos()) {
			if (funcionario.getSenha().equals(senha)) {
				return funcionario.getNome();
			}
		}
		return "";
	}
}
