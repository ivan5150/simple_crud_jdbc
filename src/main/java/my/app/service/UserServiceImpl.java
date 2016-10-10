package my.app.service;


import my.app.dao.ConnectionFactory;
import my.app.dao.UserDao;
import my.app.dao.UserDaoJdbcImpl;
import my.app.domain.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    public static final String DB_URL = "jdbc:h2:file:D:/!R/crud_last/simple_crud_jdbc/db/test";
    public static final String LOGIN = "sa";
    public static final String PASSWORD = "";


    @Override
    public User getById(long id) {
        UserDao userDao = new UserDaoJdbcImpl(ConnectionFactory.getInstance(DB_URL, LOGIN, PASSWORD));
        return userDao.getById(id);
    }

    @Override
    public List<User> getAll() {
        UserDao userDao = new UserDaoJdbcImpl(ConnectionFactory.getInstance(DB_URL, LOGIN, PASSWORD));
        return userDao.getAll();
    }

    @Override
    public void insert(User user) {
        UserDao userDao = new UserDaoJdbcImpl(ConnectionFactory.getInstance(DB_URL, LOGIN, PASSWORD));
        userDao.insert(user);
    }

    @Override
    public void update(User user) {
        UserDao userDao = new UserDaoJdbcImpl(ConnectionFactory.getInstance(DB_URL, LOGIN, PASSWORD));
        userDao.update(user);
    }

    @Override
    public void deleteById(long id) {
        UserDao userDao = new UserDaoJdbcImpl(ConnectionFactory.getInstance(DB_URL, LOGIN, PASSWORD));
        userDao.deleteById(id);
    }
}