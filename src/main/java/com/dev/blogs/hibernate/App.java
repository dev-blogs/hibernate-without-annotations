package com.dev.blogs.hibernate;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import model.Item;
import model.Provider;
import model.Warehouse;

/**
 * hiberante
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			Collection<Warehouse> warehouses = Factory.getInstance().getWarehouseDAO().getAllWarehouses();
			Iterator<Warehouse> warehouseIterator = warehouses.iterator();
			System.out.println("list of warehouses:");
			while (warehouseIterator.hasNext()) {
				Warehouse warehouse = (Warehouse) warehouseIterator.next();
				System.out.println("warehouse number " + warehouse.getId() + ", address is " + warehouse.getAddress());
				Collection<Item> items = warehouse.getItems();
				Iterator<Item> itemIterator = items.iterator();
				while (itemIterator.hasNext()) {
					Item item = (Item) itemIterator.next();
					System.out.println("    has " + item.getName() + ", id of this item is " + item.getId());
					Set<Provider> providers = item.getProviders();
					Iterator<Provider> providerIterator = providers.iterator();
					while (providerIterator.hasNext()) {
						Provider provider = (Provider) providerIterator.next();
						System.out.println("         which is provided by " + provider.getName() + ", id of this provider is " + provider.getId());
					}
				}
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}