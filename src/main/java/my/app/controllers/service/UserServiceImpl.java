package my.app.controllers.service;


        import my.app.controllers.dao.ConnectionFactory;
        import my.app.controllers.dao.UserDao;
        import my.app.controllers.dao.UserDaoJdbcImpl;
        import my.app.controllers.domain.User;

        import java.util.List;

public class UserServiceImpl implements UserService {

    //@Override
    public User getById(long id) {
        UserDao userDao = new UserDaoJdbcImpl(ConnectionFactory.getInstance());
        return userDao.getById(id);
    }

    //@Override
    public List<User> getAll() {
        UserDao userDao = new UserDaoJdbcImpl(ConnectionFactory.getInstance());
        return userDao.getAll();
    }

    //@Override
    public void insert(User user) {
        UserDao userDao = new UserDaoJdbcImpl(ConnectionFactory.getInstance());
        userDao.insert(user);
    }

    //@Override
    public void update(User user) {
        UserDao userDao = new UserDaoJdbcImpl(ConnectionFactory.getInstance());
        userDao.update(user);
    }

    //@Override
    public void deleteById(long id) {
        UserDao userDao = new UserDaoJdbcImpl(ConnectionFactory.getInstance());
        userDao.deleteById(id);
    }
}