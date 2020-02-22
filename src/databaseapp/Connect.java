/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseapp;
import java.sql.*;
/**
 *
 * @author Ernest Bieś, PWSZ Tarnów 2019
 */
public class Connect {
    private final String driver = "org.postgresql.Driver";
    private DatabaseData dbData;
    private String url;
    private Connection connection;
    
    public Connect(DatabaseData dbData) {
        this.dbData = dbData;
        this.url = "jdbc:postgresql://"+dbData.getHost()+":"+dbData.getPort()+"/"+dbData.getDbname();
        this.connection = makeConnection();
    }
        
    public Connection getConnection(){
        return connection;
    }
    
    public void close(){
        try {
            connection.close();
        }catch(SQLException sqle){
            System.err.println("Error while closing connection. " + sqle);
        }
    }
    
    private Connection makeConnection(){
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, dbData.getUser(), dbData.getPass());
            con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            return con;
        }catch(ClassNotFoundException cnfe){
            System.err.println("Error while loading driver. " + cnfe);
            return null;
        }catch(SQLException sqle){
            System.err.println("Error while establishing connection. " + sqle);
            return null;
        }
    }
    
}
