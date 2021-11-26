/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.net.URL;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
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
    StackCalc stack = new StackCalc();
    
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
    
    private LinkedList<Label> labels = new LinkedList<>();
    
    private void handleButtonAction(ActionEvent event) {
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        resetBtn.disableProperty().bind(Bindings.isEmpty(textArea.textProperty()));
        submitBtn.disableProperty().bind(Bindings.isEmpty(textArea.textProperty()));
        currentValue.textProperty().bindBidirectional(textArea.textProperty());
        
        labels.add(value1);
        labels.add(value2);
        labels.add(value3);
        labels.add(value4);
        labels.add(value5);
        labels.add(value6);
        labels.add(value7);
        labels.add(value8);
        labels.add(value9);
        labels.add(value10);
        labels.add(value11);
        labels.add(value12);
        
    }    

    @FXML
    private void submit(ActionEvent event) {
        // valid input -> checks if the input is an operand or an operator 
        // if it's an operand then create a new complex number and push the complex number into stack
        // if it's an operator call the operator manager
        Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid input, please retry.", ButtonType.OK);
        try {
            checkComplex(textArea.getText());
            System.out.println("Insert: "+stack.lastElement());
            System.out.println("size: "+stack.size());
            updateTopLabel();
            textArea.clear();
           
        } catch (NumberFormatException | NullPointerException e) {

            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                textArea.clear();
            }
        }

    }

    @FXML
    private void reset(ActionEvent event) {
        // clear text area
        textArea.clear();
    }
    
    private void updateTopLabel() {
        // if size >=12 --> print first 12 values
        // else if size < 12 --> print first size values
        int i=0;
        for (int j=stack.size()-1; j>=0; j--) {
            if (i==12)
                break;
            labels.get(i).setVisible(true);
            labels.get(i).setText(stack.get(j).toString());
            i++;
        }

    }
    
        /*
    metodo che verifica la correttezza del numero complesso inserito dall'utente
    ritorna il numero complesso 
     */
    public void checkComplex(String numComplex) throws NumberFormatException, NullPointerException {
        String number[], num = "";
        double real, complex;
        numComplex = numComplex.replace("j", "");
        if (numComplex.contains("+")) {
            number = numComplex.split(Pattern.quote("+"));
            real = Double.parseDouble(number[0]);
            complex = Double.parseDouble(number[1]);
        }
        else if (numComplex.contains("-")) {
            if (numComplex.startsWith("-")){
                numComplex = numComplex.substring(1);
                num = "-";
            }
            number = numComplex.split("-");
            real = Double.parseDouble(num.concat(number[0]));
            complex = Double.parseDouble("-".concat(number[1]));
        } else {
            real = Double.parseDouble(numComplex);
            complex = 0;
        }
        stack.add(new Complex(real, complex));
    }
}

