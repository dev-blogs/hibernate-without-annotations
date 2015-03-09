package model;

import java.util.HashSet;
import java.util.Set;

public class Item {
	private Long id;
	private String name;
	private Set<Provider> providers = new HashSet<Provider>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Provider> getProviders() {
		return providers;
	}

	public void setProviders(Set<Provider> providers) {
		this.providers = providers;
	}
}