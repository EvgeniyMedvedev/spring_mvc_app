package spring.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transaction;
import java.awt.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

@SuppressWarnings("ALL")
@Repository
public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

//    @Autowired
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User getById(int id) {
        return Optional.ofNullable(entityManager.find(User.class, id)).orElseGet(() -> new User());
    }

    @Override
    public List<User> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM User e");
        return query.getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(int id, String name,String login,String password) {
        Query query = entityManager.createQuery("update User set name =: name,login =: login,password =: password where id =: id");
        query.setParameter("name",name).setParameter("login",login).setParameter("password",password).setParameter("id",id);
        query.executeUpdate();

    }

    @Override
    public void delete(int id) {
        Query query = entityManager.createQuery("DELETE FROM User WHERE id = :id");
        query.setParameter("id",id).executeUpdate();
    }

//    @Override
//    public List<User> getAll() {
//        Session session = sessionFactory.openSession();
//        return session.createQuery("from User").list();
//    }
//
//    @Override
//    public void add(User t) {
//        Session session = sessionFactory.getCurrentSession();
//        session.persist(t);
//    }
//
//    @Override
//    public User getById(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        return session.get(User.class,id);
//    }
//
//    @Override
//    public void delete(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        session.delete(getById(id));
//    }
//
//    @Override
//    public void updateUser(int idUser, String name,String login,String password) {
//        Session session = sessionFactory.getCurrentSession();
//        User user = getById(idUser);
//        user.setName(name);
//        user.setLogin(login);
//        user.setPassword(password);
//        session.update(user);
//    }

}
