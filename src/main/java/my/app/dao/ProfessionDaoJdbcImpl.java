package my.app.dao;

import my.app.domain.Profession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProfessionDaoJdbcImpl implements ProfessionDao {
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String SELECT_BY_ID_QUERY = "SELECT * FROM profession WHERE id = ?";
    // public static final String INSERT_USER = "INSERT INTO profession (firstName, lastName) VALUES (?, ?)";
    public static final String INSERT_PROFESSION = "INSERT INTO profession (name) VALUES (?)";
    public static final String SELECT_FROM_ALL_PROFESSIONS = "SELECT * FROM profession";
    //public static final String UPDATES_USER = "UPDATE profession SET firstName = ?, lastName = ? WHERE id = ?";
    public static final String UPDATES_PROFESSION = "UPDATE profession SET name = ? WHERE id = ?";
    public static final String DELETE_PROFESSION = "DELETE FROM profession WHERE id = ?";


    private ConnectionFactory connectionFactory;

    // public void setDataSource(DataSource dataSource) {
    //    this.dataSource = dataSource;
    //}

    public ProfessionDaoJdbcImpl(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public Profession getById(long id) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY);) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    return new Profession(resultSet.getLong(COLUMN_ID),
                            resultSet.getString(COLUMN_NAME));

                }
            }
        } catch (Exception e) {
            throw new DaoException(String.format("Method getById(id: '%d') has thrown an exception.", id), e);
        }
        return null;
    }

    @Override
    public List<Profession> getAll() {
        List<Profession> user = new ArrayList<>();
        try (Connection connection = connectionFactory.getConnection();
             Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery(SELECT_FROM_ALL_PROFESSIONS);) {
                while (resultSet.next()) {
                    user.add(new Profession(resultSet.getLong(COLUMN_ID),
                            resultSet.getString(COLUMN_NAME)));
                }
            }
        } catch (Exception e) {
            throw new DaoException(String.format("Method getAll User; has throw an exception."), e);
        }
        return user;
    }

    @Override
    public void insert(Profession profession) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_PROFESSION);) {
            //statement.setLong(1, profession.getId());
            statement.setString(1, profession.getName());
            int i = statement.executeUpdate();
            if (i == 0) {
                throw new DaoException("Table 'profession' was not updated", null);
            }
        } catch (Exception e) {
            throw new DaoException(String.format("Method insert(user: '%d') has throw an exception.", profession), e);
        }
    }

    @Override
    public void update(Profession profession) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATES_PROFESSION);) {
            statement.setString(1, profession.getName());
            //statement.setLong(2, profession.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new DaoException(String.format("Method update(user: '%d') has throw an exception.", profession), e);
        }
    }

    @Override
    public void deleteById(long id) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PROFESSION);) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            throw new DaoException(String.format("Method deleteById(id: '%d') has throw an exception.", id), e);
        }
    }
}
