/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernestbies.databaseapp;

import gui.DatabaseGUI;

/**
 *
 * @author Ernest Bieś, PWSZ Tarnów 2019
 */
public class DatabaseApp {

    public static void main(String[] args) {
        DatabaseGUI gui = new DatabaseGUI();
        gui.setVisible(true);
        //gui.changeView();
    }
}
