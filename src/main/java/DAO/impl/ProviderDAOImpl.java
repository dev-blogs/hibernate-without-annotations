package DAO.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;
import model.Item;
import model.Provider;
import DAO.ProviderDAO;

public class ProviderDAOImpl implements ProviderDAO {

	public void addProvider(Provider provider) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(provider);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public void updateProvider(Provider provider) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(provider);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public Provider getProviderById(Long id) throws SQLException {
		Session session = null;
		Provider provider = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			provider = (Provider) session.load(Provider.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return provider;
		
	}

	public Collection<Provider> getAllProviders() throws SQLException {
		Session session = null;
		List<Provider> providers = new ArrayList<Provider>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			providers = session.createCriteria(Provider.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return providers;
	}

	public void deleteProvider(Provider provider) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(provider);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
}