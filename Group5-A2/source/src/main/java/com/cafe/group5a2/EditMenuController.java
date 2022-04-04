package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

/**
 * @author Adam Tucker
 * allows the chef to see existing menu items, and delete the item shown with a checkbox tick
 */
public class EditMenuController {

    public Label il1;
    public Label pl1;
    public Label d1;

    public Label il2;
    public Label pl2;
    public Label d2;

    public Label il3;
    public Label pl3;
    public Label d3;

    public Label il4;
    public Label pl4;
    public Label d4;

    public Label il5;
    public Label pl5;
    public Label d5;

    public Label il6;
    public Label pl6;
    public Label d6;

    public Label il7;
    public Label pl7;
    public Label d7;

    public Label il8;
    public Label pl8;
    public Label d8;

    public Label il9;
    public Label pl9;
    public Label d9;

    public Label il10;
    public Label pl10;
    public Label d10;

    public Label il11;
    public Label pl11;
    public Label d11;

    public Label il12;
    public Label pl12;
    public Label d12;

    public Label il13;
    public Label pl13;
    public Label d13;

    public Label il14;
    public Label pl14;
    public Label d14;

    public Label il15;
    public Label pl15;
    public Label d15;

    public Label il16;
    public Label pl16;
    public Label d16;

    public Label il17;
    public Label pl17;
    public Label d17;

    public Label il18;
    public Label pl18;
    public Label d18;

    public Label il19;
    public Label pl19;
    public Label d19;

    public Label il20;
    public Label pl20;
    public Label d20;

    public HBox h20d;
    public HBox h20i;
    public HBox h19d;
    public HBox h19i;
    public HBox h18d;
    public HBox h18i;
    public HBox h17d;
    public HBox h17i;
    public HBox h16d;
    public HBox h16i;
    public HBox h15d;
    public HBox h15i;
    public HBox h14d;
    public HBox h14i;
    public HBox h13d;
    public HBox h13i;
    public HBox h12d;
    public HBox h12i;
    public HBox h11d;
    public HBox h11i;
    public HBox h10d;
    public HBox h10i;
    public HBox h9d;
    public HBox h9i;
    public HBox h8d;
    public HBox h8i;
    public HBox h7d;
    public HBox h7i;
    public HBox h6d;
    public HBox h6i;
    public HBox h5d;
    public HBox h5i;
    public HBox h4d;
    public HBox h4i;
    public HBox h3d;
    public HBox h3i;
    public HBox h2d;
    public HBox h2i;

    public ScrollPane mainPane;
    public Label userHolder;


    public Button goBack;
    public Label Type01;
    public CheckBox Del1;
    public Label Type02;
    public CheckBox Del2;
    public Label Type03;
    public CheckBox Del3;
    public Label Type04;
    public CheckBox Del4;
    public Label Type05;
    public CheckBox Del5;
    public Label Type06;
    public CheckBox Del6;
    public Label Type07;
    public CheckBox Del7;
    public Label Type08;
    public CheckBox Del8;
    public Label Type09;
    public CheckBox Del9;
    public Label Type10;
    public CheckBox Del10;
    public Label Type11;
    public CheckBox Del11;
    public Label Type12;
    public CheckBox Del12;
    public Label Type13;
    public CheckBox Del13;
    public Label Type14;
    public CheckBox Del14;
    public Label Type15;
    public CheckBox Del15;
    public Label Type16;
    public CheckBox Del16;
    public Label Type17;
    public CheckBox Del17;
    public Label Type18;
    public CheckBox Del18;
    public Label Type19;
    public CheckBox Del19;
    public Label Type20;
    public CheckBox Del20;
    public Button addNewButton;
    public Button RefreshBut;
    Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cafedb?user=root&password=");
    private String username;

    /**
     * @throws SQLException default constructor to avoid SQLException on failed JDBC connection
     */
    public EditMenuController() throws SQLException {
    }

    /**
     * @param text username from previous view
     */
    public void setUserText(String text) {
        userHolder.setText(username = text);
    }

    /**
     * @param num allows getting the item that is the "num"th item shown on the view
     * @return the string item from the menu table in the database
     */
    public String getItem(int num) {
        String val = "";
        String query = "SELECT * FROM menu ORDER BY category DESC";
        ResultSet rs = null;
        try (Statement stmt = con.createStatement()) {
            rs = stmt.executeQuery(query);
            int i = 0;
            while (rs.next()) {
                val = rs.getString("item");
                i++;
                if (i == num) {
                    return val;
                }
            }
            return "";

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }

    /**
     * @param num allows getting the item category that is the "num"th item shown on the view
     * @return the string category from the menu table in the database
     */
    public String getType(int num) {
        String val = "";
        String query = "SELECT * FROM menu ORDER BY category DESC";
        ResultSet rs = null;
        try (Statement stmt = con.createStatement()) {
            rs = stmt.executeQuery(query);
            int i = 0;
            while (rs.next()) {
                val = rs.getString("category");
                i++;
                if (i == num) {
                    return val;
                }
            }
            return "";

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }

    /**
     * @throws SQLException there may not be 20 menu rows in the table
     */
    public void setTypeLabels() throws SQLException {
        Type01.setText(getType(1));
        Type02.setText(getType(2));
        Type03.setText(getType(3));
        Type04.setText(getType(4));
        Type05.setText(getType(5));
        Type06.setText(getType(6));
        Type07.setText(getType(7));
        Type08.setText(getType(8));
        Type09.setText(getType(9));
        Type10.setText(getType(10));
        Type11.setText(getType(11));
        Type12.setText(getType(12));
        Type13.setText(getType(13));
        Type14.setText(getType(14));
        Type15.setText(getType(15));
        Type16.setText(getType(16));
        Type17.setText(getType(17));
        Type18.setText(getType(18));
        Type19.setText(getType(19));
        Type20.setText(getType(20));
    }

    /**
     * @throws SQLException there may not be 20 menu items in the table
     */
    public void setItemLabels() throws SQLException {
        il1.setText(getItem(1));
        il2.setText(getItem(2));
        il3.setText(getItem(3));
        il4.setText(getItem(4));
        il5.setText(getItem(5));
        il6.setText(getItem(6));
        il7.setText(getItem(7));
        il8.setText(getItem(8));
        il9.setText(getItem(9));
        il10.setText(getItem(10));
        il11.setText(getItem(11));
        il12.setText(getItem(12));
        il13.setText(getItem(13));
        il14.setText(getItem(14));
        il15.setText(getItem(15));
        il16.setText(getItem(16));
        il17.setText(getItem(17));
        il18.setText(getItem(18));
        il19.setText(getItem(19));
        il20.setText(getItem(20));
    }

    /**
     * @param num allows getting the price of the item that is the "num"th item shown on the view
     * @return the string price from the menu table in the database
     */
    public String getPrice(int num) {
        String val = "";
        String query = "SELECT * FROM menu ORDER BY category DESC";
        ResultSet rs = null;
        try (Statement stmt = con.createStatement()) {
            rs = stmt.executeQuery(query);
            int i = 0;
            while (rs.next()) {
                val = rs.getString("price");
                i++;
                if (i == num) {
                    return val;
                }
            }
            return "";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }

    /**
     * @throws SQLException there may not be 20 rows in the menu table
     */
    public void setPriceLabels() throws SQLException {
        pl1.setText(getPrice(1));
        pl2.setText(getPrice(2));
        pl3.setText(getPrice(3));
        pl4.setText(getPrice(4));
        pl5.setText(getPrice(5));
        pl6.setText(getPrice(6));
        pl7.setText(getPrice(7));
        pl8.setText(getPrice(8));
        pl9.setText(getPrice(9));
        pl10.setText(getPrice(10));
        pl11.setText(getPrice(11));
        pl12.setText(getPrice(12));
        pl13.setText(getPrice(13));
        pl14.setText(getPrice(14));
        pl15.setText(getPrice(15));
        pl16.setText(getPrice(16));
        pl17.setText(getPrice(17));
        pl18.setText(getPrice(18));
        pl19.setText(getPrice(19));
        pl20.setText(getPrice(20));
    }

    /**
     * @param num allows getting the description for the item that is the "num"th item shown on the view
     * @return the string description from the menu table in the database
     */
    public String getDesc(int num) {
        String val = "";
        String query = "SELECT * FROM menu ORDER BY category DESC";
        ResultSet rs = null;
        try (Statement stmt = con.createStatement()) {
            rs = stmt.executeQuery(query);
            int i = 0;
            while (rs.next()) {
                val = rs.getString("description");
                i++;
                if (i == num) {
                    return val;
                }
            }
            return "";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }

    /**
     * @throws SQLException there may not be 20 rows in the menu table
     */
    public void setDescLabels() throws SQLException {
        d1.setText(getDesc(1));
        d2.setText(getDesc(2));
        d3.setText(getDesc(3));
        d4.setText(getDesc(4));
        d5.setText(getDesc(5));
        d6.setText(getDesc(6));
        d7.setText(getDesc(7));
        d8.setText(getDesc(8));
        d9.setText(getDesc(9));
        d10.setText(getDesc(10));
        d11.setText(getDesc(11));
        d12.setText(getDesc(12));
        d13.setText(getDesc(13));
        d14.setText(getDesc(14));
        d15.setText(getDesc(15));
        d16.setText(getDesc(16));
        d17.setText(getDesc(17));
        d18.setText(getDesc(18));
        d19.setText(getDesc(19));
        d20.setText(getDesc(20));
        if (d1.getText().equals("")) {
            Del1.setOpacity(0.0);
        }
        if (d2.getText().equals("")) {
            Del2.setOpacity(0.0);
            h2d.setMaxHeight(0.1);
            h2i.setMaxHeight(0.1);
        }
        if (d3.getText().equals("")) {
            Del3.setOpacity(0.0);
            h3d.setMaxHeight(0.1);
            h3i.setMaxHeight(0.1);

        }
        if (d4.getText().equals("")) {
            Del4.setOpacity(0.0);
            h4d.setMaxHeight(0.1);
            h4i.setMaxHeight(0.1);

        }
        if (d5.getText().equals("")) {
            Del5.setOpacity(0.0);
            h5d.setMaxHeight(0.1);
            h5i.setMaxHeight(0.1);

        }
        if (d6.getText().equals("")) {
            Del6.setOpacity(0.0);
            h6d.setMaxHeight(0.1);
            h6i.setMaxHeight(0.1);

        }
        if (d7.getText().equals("")) {
            Del7.setOpacity(0.0);
            h7d.setMaxHeight(0.1);
            h7i.setMaxHeight(0.1);

        }
        if (d8.getText().equals("")) {
            Del8.setOpacity(0.0);
            h8d.setMaxHeight(0.1);
            h8i.setMaxHeight(0.1);

        }
        if (d9.getText().equals("")) {
            Del9.setOpacity(0.0);
            h9d.setMaxHeight(0.1);
            h9i.setMaxHeight(0.1);

        }
        if (d10.getText().equals("")) {
            Del10.setOpacity(0.0);
            h10d.setMaxHeight(0.1);
            h10i.setMaxHeight(0.1);

        }
        if (d11.getText().equals("")) {
            Del11.setOpacity(0.0);
            h11d.setMaxHeight(0.1);
            h11i.setMaxHeight(0.1);

        }
        if (d12.getText().equals("")) {
            Del12.setOpacity(0.0);
            h12d.setMaxHeight(0.1);
            h12i.setMaxHeight(0.1);

        }
        if (d13.getText().equals("")) {
            Del13.setOpacity(0.0);
            h13d.setMaxHeight(0.1);
            h13i.setMaxHeight(0.1);

        }
        if (d14.getText().equals("")) {
            Del14.setOpacity(0.0);
            h14d.setMaxHeight(0.1);
            h14i.setMaxHeight(0.1);

        }
        if (d15.getText().equals("")) {
            Del15.setOpacity(0.0);
            h15d.setMaxHeight(0.1);
            h15i.setMaxHeight(0.1);

        }
        if (d16.getText().equals("")) {
            Del16.setOpacity(0.0);
            h16d.setMaxHeight(0.1);
            h16i.setMaxHeight(0.1);

        }
        if (d17.getText().equals("")) {
            Del17.setOpacity(0.0);
            h17d.setMaxHeight(0.1);
            h17i.setMaxHeight(0.1);

        }
        if (d18.getText().equals("")) {
            Del18.setOpacity(0.0);
            h18d.setMaxHeight(0.1);
            h18i.setMaxHeight(0.1);

        }
        if (d19.getText().equals("")) {
            Del19.setOpacity(0.0);
            h19d.setMaxHeight(0.1);
            h19i.setMaxHeight(0.1);

        }
        if (d20.getText().equals("")) {
            Del20.setOpacity(0.0);
            h20d.setMaxHeight(0.1);
            h20i.setMaxHeight(0.1);

        }
    }

    /**
     * @param actionEvent when go back is clicked, show the previous page
     */
    public void onClickGoBack(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) goBack.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("chef-view.fxml"));
            Parent newRoot = loader.load();
            ChefController cCont = loader.getController();
            cCont.setUserText(username);
            stage.setTitle("Chef Homepage");
            stage.centerOnScreen();
            stage.setHeight(534);
            stage.setMaxHeight(534);
            stage.setWidth(616);
            stage.setMaxWidth(616);
            stage.getScene().setRoot(newRoot);

        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * @param s delete the row where the item in the menu table group by category as shown on the view is equal to s
     */
    public void deleteItem(String s) {
        String q = "DELETE FROM menu WHERE item = '" + s + "'";
        try (Statement stmt = con.createStatement();) {
            stmt.executeQuery(q);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param actionEvent delete the first item in the menu table group by category as shown on the view
     */
    public void onDel1Click(ActionEvent actionEvent) {
        deleteItem(il1.getText());
    }

    /**
     * @param actionEvent delete the second item in the menu table group by category as shown on the view
     */
    public void onDel2Click(ActionEvent actionEvent) {
        deleteItem(il2.getText());
    }

    /**
     * @param actionEvent delete the third item in the menu table group by category as shown on the view
     */
    public void onDel3Click(ActionEvent actionEvent) {
        deleteItem(il3.getText());
    }

    /**
     * @param actionEvent delete the fourth item in the menu table group by category as shown on the view
     */
    public void onDel4Click(ActionEvent actionEvent) {
        deleteItem(il4.getText());
    }

    /**
     * @param actionEvent delete the fifth item in the menu table group by category as shown on the view
     */
    public void onDel5Click(ActionEvent actionEvent) {
        deleteItem(il5.getText());
    }

    /**
     * @param actionEvent delete the sixth item in the menu table group by category as shown on the view
     */
    public void onDel6Click(ActionEvent actionEvent) {
        deleteItem(il6.getText());
    }

    /**
     * @param actionEvent delete the seventh item in the menu table group by category as shown on the view
     */
    public void onDel7Click(ActionEvent actionEvent) {
        deleteItem(il7.getText());
    }

    /**
     * @param actionEvent delete the eighth item in the menu table group by category as shown on the view
     */
    public void onDel8Click(ActionEvent actionEvent) {
        deleteItem(il8.getText());
    }

    /**
     * @param actionEvent delete the ninth item in the menu table group by category as shown on the view
     */
    public void onDel9Click(ActionEvent actionEvent) {
        deleteItem(il9.getText());
    }

    /**
     * @param actionEvent delete the tenth item in the menu table group by category as shown on the view
     */
    public void onDel10Click(ActionEvent actionEvent) {
        deleteItem(il10.getText());
    }

    /**
     * @param actionEvent delete the eleventh item in the menu table group by category as shown on the view
     */
    public void onDel11Click(ActionEvent actionEvent) {
        deleteItem(il11.getText());
    }

    /**
     * @param actionEvent delete the twelfth item in the menu table group by category as shown on the view
     */
    public void onDel12Click(ActionEvent actionEvent) {
        deleteItem(il12.getText());
    }

    /**
     * @param actionEvent delete the thirteenth item in the menu table group by category as shown on the view
     */
    public void onDel13Click(ActionEvent actionEvent) {
        deleteItem(il13.getText());
    }

    /**
     * @param actionEvent delete the fourteenth item in the menu table group by category as shown on the view
     */
    public void onDel14Click(ActionEvent actionEvent) {
        deleteItem(il14.getText());
    }

    /**
     * @param actionEvent delete the fifteenth item in the menu table group by category as shown on the view
     */
    public void onDel15Click(ActionEvent actionEvent) {
        deleteItem(il15.getText());
    }

    /**
     * @param actionEvent delete the sixteenth item in the menu table group by category as shown on the view
     */
    public void onDel16Click(ActionEvent actionEvent) {
        deleteItem(il16.getText());
    }

    /**
     * @param actionEvent delete the seventeenth item in the menu table group by category as shown on the view
     */
    public void onDel17Click(ActionEvent actionEvent) {
        deleteItem(il17.getText());
    }

    /**
     * @param actionEvent delete the eighteenth item in the menu table group by category as shown on the view
     */
    public void onDel18Click(ActionEvent actionEvent) {
        deleteItem(il18.getText());
    }

    /**
     * @param actionEvent delete the nineteenth item in the menu table group by category as shown on the view
     */
    public void onDel19Click(ActionEvent actionEvent) {
        deleteItem(il19.getText());
    }

    /**
     * @param actionEvent delete the twentieth item in the menu table group by category as shown on the view
     */
    public void onDel20Click(ActionEvent actionEvent) {
        deleteItem(il20.getText());
    }

    /**
     * @param actionEvent when the button is clicked, go to the addMenuItem view
     */
    public void onAddNewButtonClick(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) addNewButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("addMenuItem-view.fxml"));
            Parent newRoot = loader.load();

            AddMenuItemController aMICont = loader.getController();
            aMICont.setUserText(username);
            stage.centerOnScreen();
            stage.setTitle("New Menu Item");
            stage.setHeight(624.0);
            stage.setMaxHeight(624.0);
            stage.setWidth(680.0);
            stage.setMaxWidth(680.0);
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * @param actionEvent refresh is clicked, refresh the page and update the data shown
     */
    public void onClickRefresh(ActionEvent actionEvent) {
        refresh();
    }

    /**
     * refresh the page and update the data shown on the page
     */
    public void refresh() {
        try {
            Stage stage = (Stage) RefreshBut.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("editMenu-view.fxml"));
            Parent newRoot = loader.load();
            EditMenuController eMCont = loader.getController();
            eMCont.setUserText(username);
            eMCont.setItemLabels();
            eMCont.setPriceLabels();
            eMCont.setTypeLabels();
            eMCont.setDescLabels();
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
