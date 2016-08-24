package my.app.controllers.dao;

        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;

public class ConnectionFactory {
    /*
    public static final String H2_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/5150";
    public static final String LOGIN = "root";
    public static final String PASSWORD = "root";
    */

    public static final String DB_URL = "jdbc:h2:file:D:/H2/test"; //"jdbc:h2:~/test";
    public static final String LOGIN = "sa";
    public static final String PASSWORD = "";
    public static final String H2_DRIVER = "org.h2.Driver";

    private static ConnectionFactory instance;

    private ConnectionFactory() {
        try {
            Class.forName(H2_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Not found class " + H2_DRIVER, e);
        }
    }

    public static synchronized ConnectionFactory getInstance() {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, LOGIN, PASSWORD);
    }
}