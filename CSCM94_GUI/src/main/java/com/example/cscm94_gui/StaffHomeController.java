package com.example.cscm94_gui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Parent;
import java.io.IOException;

public class StaffHomeController {

    @FXML
    public Button ManageStaffButton;

    @FXML
    public void onManageStaffButtonClick(ActionEvent event) {
        try {
            Stage stage = (Stage) LogOutButton.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(getClass().getResource("manageStaff-view.fxml"));
            stage.setTitle("Staff - Manage Staff");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    @FXML
    public Button ManageOrdersButton;

    @FXML
    public void onManageOrdersButtonClick(ActionEvent event) {
        try {
            Stage stage = (Stage) LogOutButton.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(getClass().getResource("manageOrders-view.fxml"));
            stage.setTitle("Staff - Manage Orders");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }

    }

    @FXML
    public Button ManageDeliveryButton;

    @FXML
    public void onManageDeliveryButtonClick(ActionEvent event) {
        try {
            Stage stage = (Stage) LogOutButton.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(getClass().getResource("manageDeliveries-view.fxml"));
            stage.setTitle("Staff - Manage Delivery");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    @FXML
    public Button LogOutButton;

    @FXML
    public void onLogOutButtonClick(ActionEvent event) {
        try {
            Stage stage = (Stage) LogOutButton.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(getClass().getResource("staffLogin-view.fxml"));
            stage.setTitle("Staff");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }


}
