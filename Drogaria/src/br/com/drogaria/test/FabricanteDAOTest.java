package br.com.drogaria.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

public class FabricanteDAOTest {

	FabricanteDAO fdao = new FabricanteDAO();
	
	@Test
	@Ignore
	public void salvar(){
		Fabricante f1 = new Fabricante();
		f1.setDescricao("DESCRICAOA");
		
		Fabricante f2 = new Fabricante();
		f2.setDescricao("DESCRICAOB");
		
		
		fdao.salvar(f1);
		fdao.salvar(f2);
	}
	
	
	
	@Test
	@Ignore
	public void listar(){
		
		List<Fabricante> fabricantes = fdao.fabricantes();
		for(Fabricante f: fabricantes)
			System.err.println(f.getDescricao()+"\n");
		
	}
	
	@Test
	@Ignore
	public void atualizar(){
		Fabricante f2 = new Fabricante();
		f2.setCodigo(2L);
		f2.setDescricao("DESCRICAOb");
		fdao.atualiza(f2);
	}
	
	@Test
	@Ignore
	public void retornaFabricante(){
		Fabricante f = fdao.fabricante(1L);
		System.out.println(f);
	}
	
	@Test
	public void deletar(){
		Fabricante fab = new Fabricante();
		fab.setCodigo(2L);
		
		fdao.deleta(fab);
	}
	
	
}
