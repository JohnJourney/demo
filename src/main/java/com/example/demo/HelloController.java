package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class HelloController {

    @FXML
    private Label welcomeText;

    @FXML
    private TextArea tArea;

    @FXML
    protected void onHelloButtonClick() {

        //System.out.println("ок");

        try
        {
            Connection conn;
            Class.forName("org.sqlite.JDBC");

            conn = DriverManager.getConnection("jdbc:sqlite:demo_database.db");
            System.out.println("Connection sucessful!" + "\n");

            Statement stm = conn.createStatement();
            ResultSet resset = stm.executeQuery("select * from Elements");
            System.out.println("Query sucessful!" + "\n");


            while (resset.next())
            {
                String name = resset.getString("name");
                //String phone = resset.getString("phone");

                System.out.println("name: " + name);

                this.tArea.appendText("\n" + name);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}