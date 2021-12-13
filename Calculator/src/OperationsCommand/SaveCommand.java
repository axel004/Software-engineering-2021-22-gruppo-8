/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OperationsCommand;

import calculator.Command;
import calculator.Complex;
import Exception.LessArgException;
import calculator.StackCalc;
import calculator.Variable;
import Exception.VariableException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author HP115-CS0026
 */
public class SaveCommand implements Command {
    private Variable var;
    private StackCalc stack;
    private static Stack<String> stackMappeVariabili = new Stack<>();
    private String array;

    public SaveCommand() {
        stack = StackCalc.getStack();
        var = Variable.getVariable(stack);
    }
    
/*
la funzione execute della classe SaveCommand prende le coppie chiave - valore dalla mappa dove sono salvate le variabili,
le trasforma in stringhe e le inserisce dentro uno stack statico. Le stringhe nello stack statico sono poi ripristinabili tramite
il comando restore.
*/
    @Override
    public boolean execute(String text) throws LessArgException, VariableException {
        array = "";
        for(Map.Entry<String,Complex> entry : var.getMap().entrySet()) {  
            String key = entry.getKey();
            Complex value = entry.getValue();
            array += ","+key+":"+value;
        }
        stackMappeVariabili.push(array.substring(1)); 
        
        return true;
    }    
    
    public static Stack<String> getStackMappeVariabili() {
        return stackMappeVariabili;
    }

    @Override
    public void undo(Integer num) {
        if (num != 0) {
            stackMappeVariabili.remove(array.substring(1));
        }
    }
}
