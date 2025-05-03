package com.example.passwordgenerator;

import Domain.KeyGenerator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class PasswordGeneratorController implements Initializable {

    @FXML
    TextArea areaInt = new TextArea();
    @FXML
    public TextArea areaDeTexto;

    KeyGenerator password = new KeyGenerator();

    @FXML
    private CheckBox setUpperCase;
    @FXML
    private CheckBox setLowerCase;
    @FXML
    private CheckBox setSpecials;
    @FXML
    private CheckBox setDigits;

    //Botones para setear los caracteres a usar en la contrasena.

    @FXML
    protected void btnGenerar(ActionEvent event) {
        areaDeTexto.clear();
        areaDeTexto.setText(password.generatePassword());
        System.out.println(password.generatePassword());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        setUpperCase.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
            if (!isNowSelected) {
                KeyGenerator.disableUPPER();

                System.out.println("Se desabilitan las mayusculas");
            }else {
                KeyGenerator.setUPPER();
            }
        });
        setSpecials.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
            if (!isNowSelected) {
                KeyGenerator.disableSPECIALS();
                isNowSelected = false;
                System.out.println("se desabilitan los catacteres especiales");
            }else {KeyGenerator.setSPECIALS();}

        });
        setLowerCase.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
            if (!isNowSelected) {
                KeyGenerator.disableLOWER();

                System.out.println("se desabilitan las minusculas");
            }else {
                KeyGenerator.setLOWER();
            }
        });
        setDigits.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
            if (!isNowSelected) {
                KeyGenerator.disableDIGITS();
                System.out.println("se desabilitan los digitos");
            }else {KeyGenerator.setDIGITS();}
        });
    }

    public void btnAceptar(ActionEvent event) {
        int cantiadDigitos = Integer.parseInt(areaInt.getText());
        password.setLenghtPasswordP(cantiadDigitos);
    }
}