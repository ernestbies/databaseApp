/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernestbies.databaseapp;
import java.io.Serializable;

/**
 *
 * @author Ernest Bieś, PWSZ Tarnów 2019
 */
public class DatabaseData implements Serializable {
    private String host;
    private String dbname;
    private String user;
    private String port;
    private String pass;
    
    public DatabaseData(String dbname, String host, String port, String user, String pass){
        this.dbname = dbname;
        this.host = host;
        this.port = port;
        this.user = user;
        this.pass = pass;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
    
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
}
