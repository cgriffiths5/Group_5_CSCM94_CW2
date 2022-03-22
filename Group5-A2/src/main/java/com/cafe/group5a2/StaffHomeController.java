package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class StaffHomeController {

    @FXML
    public Button ManageStaffButton;
    @FXML
    public Button ManageOrdersButton;
    @FXML
    public Button ManageDeliveryButton;
    @FXML
    public Button LogOutButton;

    @FXML
    public void onManageStaffButtonClick(ActionEvent event) {
        try {
            Stage stage = (Stage) LogOutButton.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("manageStaff-view.fxml")));
            stage.setTitle("Staff - Manage Staff");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    @FXML
    public void onManageOrdersButtonClick(ActionEvent event) {
        try {
            Stage stage = (Stage) LogOutButton.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("manageOrders-view.fxml")));
            stage.setTitle("Staff - Manage Orders");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }

    }

    @FXML
    public void onManageDeliveryButtonClick(ActionEvent event) {
        try {
            Stage stage = (Stage) LogOutButton.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("manageDeliveries-view.fxml")));
            stage.setTitle("Staff - Manage Delivery");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    @FXML
    public void onLogOutButtonClick(ActionEvent event) {
        try {
            Stage stage = (Stage) LogOutButton.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home-view.fxml")));
            stage.setTitle("Staff");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }


}
