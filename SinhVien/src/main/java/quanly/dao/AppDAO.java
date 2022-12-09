package quanly.dao;

import quanly.entity.Entity;

import java.util.List;


public interface AppDAO {

	public List<Entity> getAll();

	public void save(Entity theCustomer);

	public Entity getById(int theId);


	public List<Entity> search(String query);

	public void delete(int theId);
}
