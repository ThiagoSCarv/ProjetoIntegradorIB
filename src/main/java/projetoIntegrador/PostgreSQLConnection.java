package projetoIntegrador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class PostgreSQLConnection {
    private static Connection connection;
    public static void connect() {
        try {
            if (connection==null){
                String url = "jdbc:postgresql://localhost:5432/postgres?user=postgres";
                Properties props = new Properties();
                props.setProperty("user", "postgres");
                props.setProperty("password", "postgres");

                connection = DriverManager.getConnection(url, props);
                System.out.println("Conexão realizada com sucesso");
            }
        } catch (Exception ex){
           ex.printStackTrace();
        }
    };
    public Connection getConnection() {
        return connection;
    }
}
