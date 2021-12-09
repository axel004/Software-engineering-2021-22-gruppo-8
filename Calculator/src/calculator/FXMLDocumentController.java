/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.io.File;
import java.net.URL;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.AccessibleRole;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 *
 * @author HP115-CS0026
 */
public class FXMLDocumentController implements Initializable {
    StackCalc stack = StackCalc.getStack();
    Variable var = Variable.getVariable(stack);
    
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
    @FXML
    private Label SelectedFileLbl;
    @FXML
    private Button loadFileBtn;
    @FXML
    private Button StoreFileBtn;
    
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
    // Data la stringa in input, verifica se è un valore valido (operatore o operando). 
    // Nel caso in cui la stringa non sia valida, avvisa l'utente con un Alert.
    private void submit(ActionEvent event) {
        // just for test
        Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid input, please retry.", ButtonType.OK);
        Alert alert2 = new Alert(Alert.AlertType.ERROR, "Please insert at least one other value ", ButtonType.OK);
        Alert alert3 = new Alert(Alert.AlertType.ERROR, "Impossible to divide ", ButtonType.OK);
        Alert alert4 = new Alert(Alert.AlertType.ERROR, "Invalid variable operation, please retry ", ButtonType.OK);
        
        OperatorFactory of = new OperatorFactory();
        String text = textArea.getText();
        
        try {
            Command c = of.getCommand(text);
            try { 
                c.execute(text);
            } catch(LessArgException lessArgEx) {
                alert2.showAndWait();
                if (alert2.getResult() == ButtonType.OK) {
                    textArea.clear();
                }
            } catch(VariableException varEx) {
                alert4.showAndWait();
                if (alert4.getResult() == ButtonType.OK) {
                    textArea.clear();
                }
            }
            textArea.clear();
            updateTopLabel();
        } catch (Exception ex) {
            
            try {
                // if it's an operand then create a new complex number and push the complex number into stack
                checkComplex(textArea.getText());
                updateTopLabel();
                textArea.clear();
            } catch (NumberFormatException exNumb) {
                alert.showAndWait();
                if (alert.getResult() == ButtonType.OK) {
                    textArea.clear();
                }
            }
            
        }
        
        

        
        
        /*
        Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid input, please retry.", ButtonType.OK);
        Alert alert2 = new Alert(Alert.AlertType.ERROR, "Please insert at least one other value ", ButtonType.OK);
        Alert alert3 = new Alert(Alert.AlertType.ERROR, "Impossible to divide ", ButtonType.OK);
        Alert alert4 = new Alert(Alert.AlertType.ERROR, "Invalid variable operation, please retry ", ButtonType.OK);
        try {
            // verifica se è un operatore
            String text = textArea.getText();
            
            
            
            
            if (op.isOperator(text, stack) || op.isStackOperator(text, stack) || op.isVariableOperator(text, var)) {
                updateTopLabel();
                textArea.clear();
            }
            // altrimenti verifica se è un operando
            else {
                try {
                    // if it's an operand then create a new complex number and push the complex number into stack
                    checkComplex(textArea.getText());
                    updateTopLabel();
                    textArea.clear();
                } catch (NumberFormatException e) {
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.OK) {
                        textArea.clear();
                    }
                }
            }
        } catch (VariableException e0) {
            alert4.showAndWait();
            if (alert4.getResult() == ButtonType.OK) {
                textArea.clear();
            }
        }catch (IllegalArgumentException e2){
            alert3.showAndWait();
            if (alert3.getResult() == ButtonType.OK) {
                textArea.clear();
            }
        } catch (Exception ex) {
            alert2.showAndWait();
            if (alert2.getResult() == ButtonType.OK) {
                textArea.clear();
            }
        }*/
    }

    @FXML
    // Pulisci la text area
    private void reset(ActionEvent event) {
        textArea.clear();
    }
    
    // aggiorna la vista delle label che visualizzano i top 12 valori nello stack
    private void updateTopLabel() {
        // if size >=12 --> print first 12 values
        // else if size < 12 --> print first size values
        for (Label l : labels)
            l.setVisible(false);
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
    public void checkComplex(String numComplex) throws NumberFormatException {
        String number[], num = "";
        double real, complex;
        if (numComplex.contains("+")) { //verifico se il numero complesso contiene il +
            numComplex = numComplex.replace("j", ""); //se è presente la j la rimuovo
            number = numComplex.split(Pattern.quote("+"));
            real = Double.parseDouble(number[0]);
            complex = Double.parseDouble(number[1]);
        } else if (numComplex.contains("-")) { //verifico se il numero complesso o il numero reale contiene un meno
            if (numComplex.startsWith("-")) { //verifico se il valore inizia con - 
                numComplex = numComplex.substring(1); //prendo solo la sottostringa senza il -
                num = "-";
            }
            if (!numComplex.contains("-")) {//verifico se il numero complesso presenta un ulteriore -
                if (numComplex.contains("j")) {//se non c'è il -, verifico se il numero è complesso (contiene j)
                    numComplex = numComplex.replace("j", "");//tolgo la j
                    real = 0;
                    complex = Double.parseDouble(num.concat(numComplex));//concateno il valore con num in modo tale che se il numero era negativo allora rimetto il - altrimenti concateno con uno spazio vuoto
                } else {//altrimenti il numero è un numero reale negativo
                    real = Double.parseDouble(num.concat(numComplex));
                    complex = 0;
                }
            } else {//è un numero complesso con parte immaginaria negativa
                numComplex = numComplex.replace("j", "");
                number = numComplex.split("-");
                real = Double.parseDouble(num.concat(number[0]));
                complex = Double.parseDouble("-".concat(number[1]));
            }
        } else if (numComplex.contains("j")) { //verifico se il numero inserito contiene j, in questo caso ho un numero complesso senza parte reale
            numComplex = numComplex.replace("j", "");
            real = 0;
            complex = Double.parseDouble(numComplex);
        } else {//verifico che il valore sia un numero reale senza parte immaginaria
            real = Double.parseDouble(numComplex);
            complex = 0;
        }
        stack.add(new Complex(real, complex));
    }

    private File selectFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load from file");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
        
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {  
            SelectedFileLbl.setText(selectedFile.toString());
            return selectedFile;
        }
        return null;
    }
    
    @FXML
    private void loadFromFile(ActionEvent event) {
        File file = selectFile();
        System.out.println("load from a file must be implemented");
    }

    @FXML
    private void storeOnFile(ActionEvent event) {
        File file = selectFile();
        System.out.println("store on file must be implemented");
    }
    
}

