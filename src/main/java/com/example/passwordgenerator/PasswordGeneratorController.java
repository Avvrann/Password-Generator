package com.example.passwordgenerator;

import Domain.KeyGenerator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class PasswordGeneratorController implements Initializable {
    public TextArea areaDeTexto;
    KeyGenerator password = new KeyGenerator();

    @FXML
    protected void btnUpper(ActionEvent event) {
        password.setUPPER();
    }

    @FXML
    protected void btnGenerar(ActionEvent event) {
        areaDeTexto.clear();
        areaDeTexto.setText(password.generatePassword());
    }
    @FXML
    protected void btnMinusculas(ActionEvent event) {
        password.setLOWER();
    }
    @FXML
    protected void btnDigitos(ActionEvent event) {
        password.setDIGITS();
    }

    @FXML
    protected void btnCaracteresEspeciales(ActionEvent event) {
        password.setSPECIALS();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}