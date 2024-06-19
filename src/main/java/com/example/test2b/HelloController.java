package com.example.test2b;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    public TextField uname;
    public TextField pass;
    public Label message;
    public Label fail;
    private int attempts = 0;
    private boolean accountLocked = false;

    @FXML
    private Label welcomeText;

    public void submit(ActionEvent actionEvent) {

       String u= uname.getText();
       String p = pass.getText();




        if (u.isEmpty() || p.isEmpty()) {
            message.setText("Please enter both username and password.");

        }

        String username = "[a-zA-Z]+";
        String password = "[0-9]+";

        if (!u.matches(username)) {
            message.setText("Username must contain only alphabetic characters");
        } else if (!p.matches(password)) {
            message.setText("Password must contain only numeric characters");
        } else {
            message.setText("Success!!!");
            attempts = 0;
        }


        if (!u.matches(username) || !p.matches(password)) {
            attempts++;
        }


        if (attempts >= 5) {
            accountLocked = true;
            message.setText("Sorry, Your Account is Locked!!!");
            uname.setDisable(true);
            pass.setDisable(true);
        } else {
            fail.setText("No of Failed Attempts: " + attempts);
        }
    }
}
