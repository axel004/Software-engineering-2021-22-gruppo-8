package OperationsCommand;

import OperationsCommand.SaveCommand;
import calculator.Command;
import calculator.Complex;
import calculator.LessArgException;
import calculator.StackCalc;
import calculator.Variable;
import calculator.VariableException;
import static java.lang.Double.parseDouble;
import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Pattern;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP115-CS0026
 */
public class RestoreCommand implements Command {
    private Variable var;
    private StackCalc stack;
    private HashMap<String, Complex> mappaVariabili;

    public RestoreCommand() {
        stack = StackCalc.getStack();
        var = Variable.getVariable(stack);
    }
    
    @Override
    public boolean execute(String text) throws LessArgException, VariableException {
        // pop dallo stack delle variabili
        // itera sulla mappa derivante dalla pop
        // inserisci nella struct delle variabili ogni coppia chiave valore
        Stack<String> stackMappeVariabili = SaveCommand.getStackMappeVariabili();

        String pop = stackMappeVariabili.pop();
        var.getMap().clear();
        String[] fields = pop.split(",");
        for (String s : fields) {
            String variable = s.split(":")[0];
            String value = s.split(":")[1];
            Double real, img;
            if (value.contains("+")) {
                real = Double.parseDouble(value.split(Pattern.quote("+"))[0].trim().replace("j",""));
                img = Double.parseDouble(value.split(Pattern.quote("+"))[1].trim().replace("j",""));
            }
            else {
                real = Double.parseDouble(value.split(Pattern.quote("-"))[0].trim().replace("j",""));
                img = Double.parseDouble(value.split(Pattern.quote("-"))[1].trim().replace("j",""));
            }
            var.getMap().put(variable, new Complex(real,img));

        }

        return true;
    }

    @Override
    public void undo() {
        
    }
    
}
