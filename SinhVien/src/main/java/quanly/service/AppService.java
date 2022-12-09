package quanly.service;

import quanly.entity.Entity;

import java.util.List;


public interface AppService {

	public List<Entity> getAll();

	public List<Entity> search(String query);


	public void save(Entity theCustomer);

	public Entity getById(int theId);

	public void delete(int theId);
}
