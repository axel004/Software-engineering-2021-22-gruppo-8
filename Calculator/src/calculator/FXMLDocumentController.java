/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.net.URL;
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
        Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid input. Please retry", ButtonType.OK);
        
        try {
            checkComplex(textArea.getText());
            System.out.println("Numero complesso inserito correttamente");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please retry");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                textArea.clear();
            }
        } catch (NullPointerException e2) {
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

    /*
    metodo che verifica la correttezza del numero complesso inserito dall'utente
    se il valore inserito dall'utente non è corretto allora genera un'eccezione 
     */
    public void checkComplex(String numComplex) throws NumberFormatException, NullPointerException {
        String number[], num = "";
        double real, complex;
        numComplex = numComplex.replace("j", "");
        if (numComplex.contains("+")) {
            number = numComplex.split(Pattern.quote("+"));
            real = Double.parseDouble(number[0]);
            complex = Double.parseDouble(number[1]);
        } else if (numComplex.contains("-")) {
            if (numComplex.startsWith("-")) {
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
