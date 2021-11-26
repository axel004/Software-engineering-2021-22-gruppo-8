/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author HP115-CS0026
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label currentValue;
    @FXML
    private TextField textArea;
    @FXML
    private Button submitBtn;
    @FXML
    private Button resetBtn;
    @FXML
    private Label value1;
    @FXML
    private Label value2;
    @FXML
    private Label value3;
    @FXML
    private Label value4;
    @FXML
    private Label value5;
    @FXML
    private Label value6;
    @FXML
    private Label value7;
    @FXML
    private Label value8;
    @FXML
    private Label value9;
    @FXML
    private Label value10;
    @FXML
    private Label value11;
    @FXML
    private Label value12;
    
    
    private void handleButtonAction(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        resetBtn.disableProperty().bind(Bindings.isEmpty(textArea.textProperty()));
        submitBtn.disableProperty().bind(Bindings.isEmpty(textArea.textProperty()));
        currentValue.textProperty().bindBidirectional(textArea.textProperty());
    }    

    @FXML
    private void submit(ActionEvent event) {
        // invalid input -> notify the user and clear textArea
        Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid input. Please retry", ButtonType.OK);
        alert.showAndWait();
        
        if(alert.getResult() == ButtonType.OK) {
            textArea.clear();
        }
        // valid input -> checks if the input is an operand or an operator 
            // if it's an operand then create a new complex number and push the complex number into stack
            // if it's an operator call the operator manager
        System.out.println("click on submitBtn, do something..");

    }

    @FXML
    private void reset(ActionEvent event) {
        // clear text area
        textArea.clear();
    }
    
}
