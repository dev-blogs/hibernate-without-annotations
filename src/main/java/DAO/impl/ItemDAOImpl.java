package DAO.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.Item;

import org.hibernate.Session;

import util.HibernateUtil;
import DAO.ItemDAO;

public class ItemDAOImpl implements ItemDAO {

	public Collection<Item> getAllItems() throws SQLException {
		Session session = null;
		List<Item> items = new ArrayList<Item>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			items = session.createCriteria(Item.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return items;
	}

	public void addItem(Item item) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(item);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public void updateItem(Item item) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(item);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public Item getItemById(Long id) throws SQLException {
		Session session = null;
		Item item = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			item = (Item) session.load(Item.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return item;
	}

	public void deleteItem(Item item) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(item);
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