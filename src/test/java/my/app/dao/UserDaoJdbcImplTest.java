package my.app.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class UserDaoJdbcImplTest {

    private UserDao userDao = new UserDaoJdbcImpl(ConnectionFactory.getInstance());

    @Before
    public void setUp() throws Exception{
        System.out.println("Before");
    }

    @After
    public void tearDown() throws Exception{
        System.out.println("After");
    }

    @Test
    public void testGetById() throws Exception {
        System.out.println("testGetById");
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