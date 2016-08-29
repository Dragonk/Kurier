package pl.greywarden.komponenty.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import lombok.*;

public class DatabaseConnector {

    @Getter @Setter private String databaseName;
    @Getter @Setter private String databaseUrl;
    private Connection connection;
    private DatabaseConnector(){
    }
    
    private static DatabaseConnector instance;
    
    public static DatabaseConnector getInstance(){
        return instance == null? instance = new DatabaseConnector(): instance;
    }
    
    public void createConnection(String user, String password) throws SQLException{
        this.connection = DriverManager.getConnection("jdbc:mysql://"+databaseUrl+"/"+databaseName,user,password);
    }
    
    public ResultSet executeQuery(String sql) throws SQLException{
        return connection.createStatement().executeQuery(sql);
    }
    
}