package by.epam.pronovich.util;

import lombok.NoArgsConstructor;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.sql.Connection;
import java.sql.SQLException;


@NoArgsConstructor
public final class ConnectionPool {

    private static final String DRIVER = PropertiesUtil.get("db.driver");
    private static final String URL = PropertiesUtil.get("db.url");
    private static final String USER = PropertiesUtil.get("db.user");
    private static final String PASSWORD = PropertiesUtil.get("db.password");
    private static final String POOL_SIZE = PropertiesUtil.get("db.pool.size");

    private static DataSource DATA_SOURCE;

    static {
        initConnectionPool();
    }

    private static void initConnectionPool() {
        PoolProperties poolProperties = new PoolProperties();
        poolProperties.setDriverClassName(DRIVER);
        poolProperties.setUrl(URL);
        poolProperties.setUsername(USER);
        poolProperties.setPassword(PASSWORD);
        poolProperties.setMaxActive(Integer.parseInt(POOL_SIZE));
        DATA_SOURCE = new DataSource(poolProperties);
    }

    public static Connection getConnection() throws SQLException {
        return DATA_SOURCE.getConnection();
    }
}

