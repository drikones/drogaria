package br.com.drogaria.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;

public class ProdutoDAOTest {
	
	FabricanteDAO fdao = new FabricanteDAO();
	ProdutoDAO pdao = new ProdutoDAO();
	
	@Test
	@Ignore
	public void gravar(){
		Produto p = new Produto();
		Fabricante f = fdao.fabricante(1L);
		
		p.setDescricao("Amaciante de Roupas");
		p.setFabricante(f);
		p.setPreco(new BigDecimal(12.90));
		p.setQuantidade(3);
		
		pdao.salvar(p);
		
	}
	
	@Test
	public void deletar(){
		
		Produto p = pdao.produto(2L);
		pdao.deleta(p);
	}
	
	@Test
	@Ignore
	public void atualizar(){
		Produto p = pdao.produto(2L);
		p.setDescricao("Teste");
		
		pdao.atualiza(p);
	}
	
	@Test
	@Ignore
	public void listar(){
		List<Produto> produtos = pdao.produtos();
		for(Produto p: produtos)
			System.out.println(p+"\n");
	}
	
	
	@Test
	@Ignore
	public void retornarProduto(){
		Produto p = pdao.produto(2L);
		System.out.println(p);
	}

}
