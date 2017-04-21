package br.com.drogaria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.HibernateUtil;

public class FabricanteDAO {

	public void salvar(Fabricante fabricante) {
		try {
			EntityManager em = HibernateUtil.getEntityManager();
			EntityTransaction et = em.getTransaction();

			et.begin();
			em.persist(fabricante);
			et.commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleta(Fabricante fabricante) {
		try {
			EntityManager em = HibernateUtil.getEntityManager();
			
			EntityTransaction et = em.getTransaction();
			et.begin();
			
			Object obj = em.merge(fabricante);
			em.remove(obj);
			
			et.commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualiza(Fabricante fabricante) {
		try {
			/*String JPQL = "UPDATE Fabricante f SET f.descricao=:novadescricao WHERE f.codigo=:codigo";*/
			EntityManager em = HibernateUtil.getEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();

			/*Query q = em.createQuery(JPQL, Fabricante.class);
			q.setParameter(1, fabricante.getDescricao());
			q.setParameter(2, fabricante.getCodigo());
			q.executeUpdate();*/
			
			em.merge(fabricante);

			et.commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Fabricante> fabricantes() {
		try {
			EntityManager em = HibernateUtil.getEntityManager();
			Query query = em.createQuery("SELECT f FROM Fabricante f", Fabricante.class);
			List<Fabricante> fabricantes = query.getResultList();
			em.close();
			return fabricantes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Fabricante fabricante(Long codigo){
		try {
			EntityManager em = HibernateUtil.getEntityManager();
			Query query = em.createNamedQuery("Fabricante.buscarPorCodigo");
			query.setParameter("codigo", codigo);
			Fabricante fabricante = (Fabricante) query.getSingleResult();
			em.close();
			return fabricante;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
