package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TableView;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableColumn;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloController {

    @FXML
    private Label welcomeText;

    @FXML
    private TextArea tArea;

    @FXML
    private TableView fxTable;

    @FXML
    private TableRow tRow;

    @FXML
    private TableColumn fxColumn1;

    @FXML
    protected void onHelloButtonClick() {

        try
        {
            Connection conn;
            Class.forName("org.sqlite.JDBC");

            conn = DriverManager.getConnection("jdbc:sqlite:demo_database.db");
            System.out.println("Connection sucessful!" + "\n");

            Statement stm = conn.createStatement();
            ResultSet resset = stm.executeQuery("select * from Elements");
            System.out.println("Query sucessful!" + "\n");




            //ObservableList<Map<String, Object>> items = FXCollections.<Map<String, Object>>observableArrayList();
            List<String> firstItems = new ArrayList<>();



            while (resset.next())
            {
                String name = resset.getString("name");
                //String phone = resset.getString("phone");

                System.out.println("name: " + name);

                this.tArea.appendText("\n" + name);

                //tableRow = new TableRow<>();
                //this.fxTable.getItems().add(name);


                //Map<String, Object> item1 = new HashMap();
                //item1.put("fxColumn1", name);

                //items.add(item1);




                firstItems.add(name);







            }


            //fxTable.getItems().addAll(items);
            fxTable.setItems(FXCollections.observableArrayList(firstItems));










        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}