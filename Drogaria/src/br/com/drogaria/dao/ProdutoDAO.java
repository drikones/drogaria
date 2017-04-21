package br.com.drogaria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.HibernateUtil;

public class ProdutoDAO {
	
	public void salvar(Produto produto) {
		try {
			EntityManager em = HibernateUtil.getEntityManager();
			EntityTransaction et = em.getTransaction();
			
			
			et.begin();
			em.persist(produto);
			
			et.commit();
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleta(Produto produto) {
		try {
			EntityManager em = HibernateUtil.getEntityManager();
			
			EntityTransaction et = em.getTransaction();
			et.begin();
			
			Object obj = em.merge(produto);
			em.remove(obj);
			
			et.commit();
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualiza(Produto produto) {
		try {
			/*String JPQL = "UPDATE Fabricante f SET f.descricao=:novadescricao WHERE f.codigo=:codigo";*/
			EntityManager em = HibernateUtil.getEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();

			/*Query q = em.createQuery(JPQL, Fabricante.class);
			q.setParameter(1, fabricante.getDescricao());
			q.setParameter(2, fabricante.getCodigo());
			q.executeUpdate();*/
			
			
			 em.merge(produto);
			 
			 
			et.commit();
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Produto> produtos() {
		try {
			
			EntityManager em = HibernateUtil.getEntityManager();
			Query query = em.createQuery("SELECT p FROM Produto p", Produto.class);
			List<Produto> produtos = query.getResultList();
			em.close();
			return produtos;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Produto produto(Long codigo){
		try {
			EntityManager em = HibernateUtil.getEntityManager();
			Query query = em.createNamedQuery("Produto.buscarPorCodigo");
			query.setParameter("codigo", codigo);
			Produto produto = (Produto) query.getSingleResult();
			em.close();
			return produto;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
