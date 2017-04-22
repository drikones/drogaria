package br.com.drogaria.main;

import br.com.drogaria.util.HibernateUtil;

public class GeraTabela {

	public static void main(String[] args) {
		HibernateUtil.getEntityManager();
		HibernateUtil.getEntityManager().close();
		System.exit(0);

	}

}
