package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.DAO.UserDAO;
import spring.DAO.UserDAOArrayImpl;
import spring.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO dao;

    @Autowired
    public UserServiceImpl(UserDAO dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public List<User> getAll() {
        return dao.getAll();
    }

    @Override
    @Transactional
    public void add(User t) {
        dao.add(t);
    }

    @Override
    @Transactional
    public User getById(int id) {
        return dao.getById(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    @Transactional
    public void updateUser(int idUser, String name,String login,String password) {
        dao.updateUser(idUser,name,login,password);
    }
}
