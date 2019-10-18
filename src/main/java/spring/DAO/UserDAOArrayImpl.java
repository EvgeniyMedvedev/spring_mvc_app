package spring.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("ALL")
@Repository
public class UserDAOArrayImpl implements UserDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User").list();
    }

    @Override
    public void add(User t) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(t);
    }

    @Override
    public User getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class,id);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getById(id));
    }

    @Override
    public void updateUser(int idUser, String name,String login,String password) {
        Session session = sessionFactory.getCurrentSession();
        User user = getById(idUser);
        user.setName(name);
        session.update(user);
    }

//    private static AtomicInteger id = new AtomicInteger(0);
//    private static Map<Integer,User> map = new HashMap<>();
//    static {
//        User user = new User();
//        User user1 = new User();
//        user.setName("vasya");
//        user.setPassword("1");
//        user.setLogin("1");
//        user.setId(id.getAndIncrement());
//        map.put(user.getId(),user);
//        user1.setName("kolya");
//        user1.setPassword("2");
//        user1.setLogin("2");
//        user1.setId(id.getAndIncrement());
//        map.put(user1.getId(),user1);
//    }
//
//    @Override
//    public List<User> getAll() {
//        return new ArrayList<>(map.values());
//    }
//
//    @Override
//    public void add(User user) {
//        user.setId(id.getAndIncrement());
//        map.put(user.getId(),user);
//    }
//
//    @Override
//    public User getById(long id) {
//        return map.get(id);
//    }
//
//    @Override
//    public void delete(long id) {
//        map.remove(id);
//    }
//
//    @Override
//    public void updateUser(int idUser, String name) {
//        User user = getById(idUser);
//        user.setName(name);
//        map.put(idUser,user);
//    }
}
