package DAO;

import java.sql.SQLException;
import java.util.Collection;

import model.Item;

public interface ItemDAO {
	public void addItem(Item item) throws SQLException;
	public void updateItem(Item item) throws SQLException;
	public Item getItemById(Long id) throws SQLException;
	public Collection<Item> getAllItems() throws SQLException;
	public void deleteItem(Item item) throws SQLException;
}