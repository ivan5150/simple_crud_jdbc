package my.app.dao;

import my.app.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJdbcImpl implements UserDao {
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String SELECT_BY_ID_QUERY = "SELECT * FROM user WHERE id = ?";
    // public static final String INSERT_USER = "INSERT INTO user (firstName, lastName) VALUES (?, ?)";
    public static final String INSERT_USER = "INSERT INTO user (name) VALUES (?)"; //"INSERT INTO user (id, name) VALUES (?, ?)";
    public static final String SELECT_FROM_ALL_USER = "SELECT * FROM user";
    //public static final String UPDATES_USER = "UPDATE user SET firstName = ?, lastName = ? WHERE id = ?";
    public static final String UPDATES_USER = "UPDATE user SET name = ? WHERE id = ?";
    public static final String DELETE_USER = "DELETE FROM user WHERE id = ?";
    public static final String DELETE_ALL = "DELETE FROM user";


    public static final String KEYWORD_FOR_EXIT = "--stop";
    public static final String KEYWORD_FOR_ALL_MESSAGES = "--all";
    public static final String MESSAGES_BY_AUTHOR_QUERY = "SELECT * FROM messages WHERE author = ?;";
    public static final String ALL_MESSAGES_QUERY = "SELECT * FROM messages;";


    private ConnectionFactory connectionFactory;

    // public void setDataSource(DataSource dataSource) {
    //    this.dataSource = dataSource;
    //}

    public UserDaoJdbcImpl(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public User getById(long id) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY);) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    return new User(resultSet.getLong(COLUMN_ID),
                            resultSet.getString(COLUMN_NAME));

                }
            }
        } catch (Exception e) {
            throw new DaoException(String.format("Method getById(id: '%d') has thrown an exception.", id), e);
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        List<User> user = new ArrayList<>();
        try (Connection connection = connectionFactory.getConnection();
             Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery(SELECT_FROM_ALL_USER);) {
                while (resultSet.next()) {
                    user.add(new User(resultSet.getLong(COLUMN_ID),
                            resultSet.getString(COLUMN_NAME)));
                }
            }
        } catch (Exception e) {
            throw new DaoException(String.format("Method getAll User; has throw an exception."), e);
        }
        return user;
    }

    @Override
    public void insert(User user) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_USER);) {
            //statement.setLong(1, user.getId());
            statement.setString(1, user.getName());
            int i = statement.executeUpdate();
            if (i == 0) {
                throw new DaoException("Table 'user' was not updated", null);
            }
        } catch (Exception e) {
            throw new DaoException(String.format("Method insert(user: '%d') has throw an exception.", user), e);
        }
    }

    @Override
    public void update(User user) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATES_USER);) {
            statement.setString(1, user.getName());
            statement.setLong(2, user.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new DaoException(String.format("Method update(user: '%d') has throw an exception.", user), e);
        }
    }

    @Override
    public void deleteById(long id) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USER);) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            throw new DaoException(String.format("Method deleteById(id: '%d') has throw an exception.", id), e);
        }
    }
        @Override
        public void deleteAll() {
            try (Connection connection = connectionFactory.getConnection();
                 PreparedStatement statement = connection.prepareStatement(DELETE_ALL);) {
                statement.executeUpdate();
            } catch (Exception e) {
                throw new DaoException(String.format("Method deleteAll has throw an exception."), e);
            }
        }
    }