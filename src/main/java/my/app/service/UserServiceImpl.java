package my.app.service;


        import my.app.dao.ConnectionFactory;
        import my.app.dao.UserDao;
        import my.app.dao.UserDaoJdbcImpl;
        import my.app.domain.User;

        import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public User getById(long id) {
        UserDao userDao = new UserDaoJdbcImpl(ConnectionFactory.getInstance());
        return userDao.getById(id);
    }

    @Override
    public List<User> getAll() {
        UserDao userDao = new UserDaoJdbcImpl(ConnectionFactory.getInstance());
        return userDao.getAll();
    }

    @Override
    public void insert(User user) {
        UserDao userDao = new UserDaoJdbcImpl(ConnectionFactory.getInstance());
        userDao.insert(user);
    }

    @Override
    public void update(User user) {
        UserDao userDao = new UserDaoJdbcImpl(ConnectionFactory.getInstance());
        userDao.update(user);
    }

    @Override
    public void deleteById(long id) {
        UserDao userDao = new UserDaoJdbcImpl(ConnectionFactory.getInstance());
        userDao.deleteById(id);
    }
}