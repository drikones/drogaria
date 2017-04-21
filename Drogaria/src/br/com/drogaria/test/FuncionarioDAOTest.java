package br.com.drogaria.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FuncionarioDAO;
import br.com.drogaria.domain.Funcionario;

public class FuncionarioDAOTest {
	
	FuncionarioDAO fdao = new FuncionarioDAO();
	
	@Test
	@Ignore
	public void salvar(){
		Funcionario f = new Funcionario();
		f.setCpf("111.111.111-11");
		f.setFuncao("Pedreiro");
		f.setNome("Joao da Silva");
		f.setSenha("1234");
		
		fdao.salvar(f);
		
	}
	
	@Test
	@Ignore
	public void atualizar(){
		Funcionario f = fdao.funcionario(1L);
		f.setFuncao("Analista de Sistemas Trainee");
		fdao.atualiza(f);
	}
	
	@Test
	@Ignore
	public void deleta(){
		Funcionario f = new Funcionario();
		f.setCodigo(2L);
		
		fdao.deleta(f);
	}
	
	
	@Test
	@Ignore
	public void listar()
	{
		List<Funcionario> funcionarios = fdao.funcionarios();
		for(Funcionario f: funcionarios)
			System.out.println(f);
	}
	
	@Test
	public void retornaFuncionario(){
		Funcionario f = fdao.funcionario(1L);
		System.out.println(f);
	}
	
	
	

}
