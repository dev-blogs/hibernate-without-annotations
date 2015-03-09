package DAO;

import java.sql.SQLException;
import java.util.Collection;

import model.Warehouse;

public interface WarehouseDAO {
	public void addWarehouse(Warehouse warehouse) throws SQLException;
	public void updateWarehouse(Warehouse warehouse) throws SQLException;
	public Warehouse getWarehouseById(Long id) throws SQLException;
	public Collection<Warehouse> getAllWarehouses() throws SQLException;
	public void deleteWarehouse(Warehouse warehouse) throws SQLException;
}