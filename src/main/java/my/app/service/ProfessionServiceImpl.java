package my.app.service;


import my.app.domain.Profession;
import my.app.dao.ConnectionFactory;
import my.app.dao.ProfessionDao;
import my.app.dao.ProfessionDaoJdbcImpl;


import java.util.List;

public class ProfessionServiceImpl implements ProfessionService{
    @Override
    public Profession getById(long id) {
        ProfessionDao userDao = new ProfessionDaoJdbcImpl(ConnectionFactory.getInstance());
        return userDao.getById(id);
    }

    @Override
    public List<Profession> getAll() {
        ProfessionDao userDao = new ProfessionDaoJdbcImpl(ConnectionFactory.getInstance());
        return userDao.getAll();
    }

    @Override
    public void insert(Profession profession) {
        ProfessionDao userDao = new ProfessionDaoJdbcImpl(ConnectionFactory.getInstance());
        userDao.insert(profession);
    }

    @Override
    public void update(Profession profession) {
        ProfessionDao userDao = new ProfessionDaoJdbcImpl(ConnectionFactory.getInstance());
        userDao.update(profession);
    }

    @Override
    public void deleteById(long id) {
        ProfessionDao userDao = new ProfessionDaoJdbcImpl(ConnectionFactory.getInstance());
        userDao.deleteById(id);
    }
}
