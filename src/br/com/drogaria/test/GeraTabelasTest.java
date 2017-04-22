package br.com.drogaria.test;

import org.junit.Test;

import br.com.drogaria.util.HibernateUtil;

public class GeraTabelasTest {
	
	
	@Test
	public void gerar(){
		HibernateUtil.getEntityManager();
		HibernateUtil.getEntityManager().close();
	}

}
