package DAO;

import java.sql.SQLException;
import java.util.Collection;

import model.Provider;

public interface ProviderDAO {
	public void addProvider(Provider provider) throws SQLException;
	public void updateProvider(Provider provider) throws SQLException;
	public Provider getProviderById(Long id) throws SQLException;
	public Collection<Provider> getAllProviders() throws SQLException;
	public void deleteProvider(Provider provider) throws SQLException;
}