package br.com.drogaria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.drogaria.domain.Funcionario;
import br.com.drogaria.util.HibernateUtil;

public class FuncionarioDAO {
	
	public void salvar(Funcionario funcionario) {
		try {
			EntityManager em = HibernateUtil.getEntityManager();
			EntityTransaction et = em.getTransaction();

			et.begin();
			em.persist(funcionario);
			
			et.commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleta(Funcionario funcionario) {
		try {
			EntityManager em = HibernateUtil.getEntityManager();
			
			EntityTransaction et = em.getTransaction();
			et.begin();
			
			em.remove(funcionario);
			
			et.commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualiza(Funcionario funcionario) {
		try {
			/*String JPQL = "UPDATE Fabricante f SET f.descricao=:novadescricao WHERE f.codigo=:codigo";*/
			EntityManager em = HibernateUtil.getEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();

			/*Query q = em.createQuery(JPQL, Fabricante.class);
			q.setParameter(1, fabricante.getDescricao());
			q.setParameter(2, fabricante.getCodigo());
			q.executeUpdate();*/
			
			
			 em.merge(funcionario);
			 
			 
			et.commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> funcionarios() {
		try {
			EntityManager em = HibernateUtil.getEntityManager();
			Query query = em.createQuery("SELECT f FROM Funcionario f", Funcionario.class);
			List<Funcionario> funcionarios = query.getResultList();
			em.close();
			return funcionarios;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Funcionario funcionario(Long codigo){
		try {
			EntityManager em = HibernateUtil.getEntityManager();
			Query query = em.createNamedQuery("Funcionario.buscarPorCodigo");
			query.setParameter("codigo", codigo);
			Funcionario funcionario = (Funcionario) query.getSingleResult();
			em.close();
			return funcionario;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


}
