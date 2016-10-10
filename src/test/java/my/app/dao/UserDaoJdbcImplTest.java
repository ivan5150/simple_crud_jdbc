package my.app.dao;

import my.app.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class UserDaoJdbcImplTest {
    public static final String DB_URL = "jdbc:h2:file:D:/!R/crud_last/simple_crud_jdbc/db/test";
    public static final String LOGIN = "sa";
    public static final String PASSWORD = "";

    private UserDao userDao = new UserDaoJdbcImpl(ConnectionFactory.getInstance(DB_URL, LOGIN, PASSWORD));

    @Before
    public void setUp() {
        System.out.println("Before");
    }

    @After
    public void tearDown() {
        System.out.println("After");
        userDao.deleteAll();
    }

    @Test
    public void testGetById() throws Exception {
        System.out.println("testGetById");
        User expected = new User();
        expected.setName("Sasha");
        userDao.insert(expected);
        List<User> users = userDao.getAll();
        if(users.isEmpty()){
            fail("User list is empty");
        }

        long id = users.get(0).getId();
        User actual = userDao.getById(id);
        assertEquals(expected.getId(),actual.getId());
        assertEquals(id, actual.getId());
    }

    @Test
    public void testGetAll() throws Exception {
        System.out.println("testGetAll");
    }

    @Test
    public void testInsert() throws Exception {
        System.out.println("testInsert");
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("testUpdate");
    }

    @Test
    public void testDeleteById() throws Exception {
        System.out.println("testDeleteById");
    }
}