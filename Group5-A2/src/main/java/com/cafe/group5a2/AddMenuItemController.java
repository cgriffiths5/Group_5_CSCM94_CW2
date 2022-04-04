package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

import static java.lang.Integer.parseInt;

public class AddMenuItemController {
    public Button GoBackButt;
    public TextField ItemName;
    public TextArea ItemDesc;
    public TextField ItemPrice;
    public TextField ItemType;
    public Button SubmitBut;
    public Label hackingMessage;
    private String username;
    private int uID;
    Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cafedb?user=root&password=");

    public AddMenuItemController() throws SQLException {
    }

    public void setUserText(String text) {
        username = text;
        uID = getUserId(text);
    }

    public int getUserId(String username) {
        String query = "SELECT user_ID FROM users WHERE username = '" + username + "'";
        ResultSet rs = null;
        int a = 0;
        try (Statement stmt = con.createStatement()) {
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                a = parseInt(rs.getNString("user_ID"));
                return a;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public void onSubmitButClick(ActionEvent actionEvent) {
        String item = ItemName.getText();
        String desc = ItemDesc.getText();
        String type = ItemType.getText().toLowerCase().trim();
        double price = Double.parseDouble(ItemPrice.getText());
        if ((type.equals("special") || type.equals("drink") || type.equals("food")) && (!item.contains("" + ";") && !desc.contains("" + ";") && !item.contains("" + "'") && !desc.contains("" + "'"))) {
            String q = "INSERT INTO menu (item, description, category, price) VALUES ('" + item + "','" + desc + "','" + type + "'," + price + ");";
            try (Statement stmt = con.createStatement();) {
                stmt.executeQuery(q);
                hackingMessage.setText("New item submitted!");
                hackingMessage.setOpacity(1);
            } catch (SQLException e) {
                e.printStackTrace();
                hackingMessage.setOpacity(1);
            }
        } else {
            hackingMessage.setText("Stop hacking please");
            hackingMessage.setOpacity(1);
        }


    }

    public void onGoBackClick(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) GoBackButt.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("editMenu-view.fxml"));
            Parent newRoot = loader.load();

            EditMenuController eMCont = loader.getController();
            eMCont.setUserText(username);
            eMCont.setItemLabels();
            eMCont.setPriceLabels();
            eMCont.setTypeLabels();
            eMCont.setDescLabels();

            Rectangle2D sBound = Screen.getPrimary().getVisualBounds();

            stage.setTitle("Manage Menu");
            stage.setHeight(1080.0);
            stage.setMaxHeight(2000.0);
            stage.setWidth(850.0);
            stage.setMaxWidth(850.0);
            stage.centerOnScreen();
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
