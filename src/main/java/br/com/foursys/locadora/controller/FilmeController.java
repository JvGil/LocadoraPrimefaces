package br.com.foursys.locadora.controller;

import java.util.ArrayList;

import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.dao.FilmeDAO;

public class FilmeController {
	
	public void salvar(Filme filme) {
		FilmeDAO dao = new FilmeDAO();
		try {
			dao.salvar(filme);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(Filme filme) {
		FilmeDAO dao = new FilmeDAO();
		try {
			dao.excluir(filme);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Filme> buscarTodos(){
		ArrayList<Filme> listaRetorno = new ArrayList<Filme>();
		FilmeDAO dao = new FilmeDAO();
		
		try {
			listaRetorno = dao.buscarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
	public ArrayList<Filme> buscarNome(String nome) {
		ArrayList<Filme> listaRetorno = new ArrayList<Filme>();
		FilmeDAO dao = new FilmeDAO();
		
		try {
			listaRetorno = dao.buscarNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
	public Filme buscarCodigo(String codigo) {
		Filme filme = new Filme();
		FilmeDAO dao = new FilmeDAO();
		try {
			filme = dao.buscarPorCodigo(Integer.parseInt(codigo));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filme;
	}

}
