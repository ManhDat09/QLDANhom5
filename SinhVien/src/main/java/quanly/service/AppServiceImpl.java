package quanly.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import quanly.dao.AppDAO;
import quanly.entity.Entity;

import java.util.List;


@Service
public class AppServiceImpl implements AppService {

	@Autowired
	private AppDAO appDAO;
	
	@Override
	@Transactional
	public List<Entity> getAll() {
		return appDAO.getAll();
	}

	@Override
	public List<Entity> search(String query) {
		return appDAO.search(query);
	}

	@Override
	@Transactional
	public void save(Entity theCustomer) {
		appDAO.save(theCustomer);
	}

	@Override
	@Transactional
	public Entity getById(int theId) {
		return appDAO.getById(theId);
	}

	@Override
	@Transactional
	public void delete(int theId) {
		appDAO.delete(theId);
	}

}
