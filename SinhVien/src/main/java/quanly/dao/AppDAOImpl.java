package quanly.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import quanly.entity.Entity;


@Repository  //đánh dấu một class là tầng repository, phục vụ truy xuất dữ liệu
public class AppDAOImpl implements AppDAO {
    //kế thừa AppDAOImpl và đánh dấu @Repository
    SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Entity.class).buildSessionFactory();


    public List<Entity> getAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();

        Query<Entity> theQuery = currentSession.createQuery("from Entity order by Madt", Entity.class);

        List<Entity> customers = theQuery.getResultList();

        currentSession.close();

        return customers;
    }


    @Override
    public void save(Entity entity) {
        //get current hibernate session (nhận...)
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();

        //save or update
        currentSession.saveOrUpdate("Dienthoai", entity);


        currentSession.getTransaction().commit();
        currentSession.close();
    }


    @Override
    public Entity getById(int theId) {
        // TODO Auto-generated method stub

        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();

        //now retrieve/read from database using the primary key
        // truy xuất/đọc từ cơ sở dữ liệu bằng cách sự dụng khóa
        Entity theCustomer = currentSession.get(Entity.class, theId);

        currentSession.close();

        return theCustomer;
    }

    @Override
    public List<Entity> search(String query) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();


        //crateQuery order by ten
        Query<Entity> theQuery = currentSession.createQuery("from Entity where Tendt like '%" + query + "%'", Entity.class);

        List<Entity> entities = theQuery.getResultList();

        currentSession.close();

        return entities;
    }


    @Override
    public void delete(int theId) {
        // TODO Auto-generated method stub

        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();

        Query theQuery = currentSession.createQuery("delete from Entity where Madt= :dienthoaiId ");

        theQuery.setParameter("dienthoaiId", theId);

        theQuery.executeUpdate();
        currentSession.close();
    }

}
