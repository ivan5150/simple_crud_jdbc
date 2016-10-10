package my.app.service;


import my.app.dao.ConnectionFactory;
import my.app.dao.ProfessionDao;
import my.app.dao.ProfessionDaoJdbcImpl;
import my.app.domain.Profession;

import java.util.List;

public class ProfessionServiceImpl implements ProfessionService {
    public static final String DB_URL = "jdbc:h2:file:D:/!R/crud_last/simple_crud_jdbc/db/test";
    public static final String LOGIN = "sa";
    public static final String PASSWORD = "";

    @Override
    public Profession getById(long id) {
        ProfessionDao professionDao = new ProfessionDaoJdbcImpl(ConnectionFactory.getInstance(DB_URL, LOGIN, PASSWORD));
        return professionDao.getById(id);
    }

    @Override
    public List<Profession> getAll() {
        ProfessionDao professionDao = new ProfessionDaoJdbcImpl(ConnectionFactory.getInstance(DB_URL, LOGIN, PASSWORD));
        return professionDao.getAll();
    }

    @Override
    public void insert(Profession profession) {
        ProfessionDao professionDao = new ProfessionDaoJdbcImpl(ConnectionFactory.getInstance(DB_URL, LOGIN, PASSWORD));
        professionDao.insert(profession);
    }

    @Override
    public void update(Profession profession) {
        ProfessionDao professionDao = new ProfessionDaoJdbcImpl(ConnectionFactory.getInstance(DB_URL, LOGIN, PASSWORD));
        professionDao.update(profession);
    }

    @Override
    public void deleteById(long id) {
        ProfessionDao professionDao = new ProfessionDaoJdbcImpl(ConnectionFactory.getInstance(DB_URL, LOGIN, PASSWORD));
        professionDao.deleteById(id);
    }
}
