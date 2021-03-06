package spring.service;

import spring.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll() ;

    void add(User t);

    User getById(int id) ;

    void delete(int id);

    void updateUser(int idUser, String name,String login,String password);
}
