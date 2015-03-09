package DAO.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;
import model.Provider;
import model.Warehouse;
import DAO.WarehouseDAO;

public class WarehouseDAOImpl implements WarehouseDAO {

	public void addWarehouse(Warehouse warehouse) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(warehouse);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public void updateWarehouse(Warehouse warehouse) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(warehouse);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public Warehouse getWarehouseById(Long id) throws SQLException {
		Session session = null;
		Warehouse warehouse = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			warehouse = (Warehouse) session.load(Warehouse.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return warehouse;
	}

	public Collection<Warehouse> getAllWarehouses() throws SQLException {
		Session session = null;
		List<Warehouse> warehouses = new ArrayList<Warehouse>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			warehouses = session.createCriteria(Warehouse.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return warehouses;
	}

	public void deleteWarehouse(Warehouse warehouse) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(warehouse);
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