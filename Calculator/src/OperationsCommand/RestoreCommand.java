package OperationsCommand;

import OperationsCommand.SaveCommand;
import calculator.Command;
import calculator.Complex;
import Exception.LessArgException;
import calculator.StackCalc;
import calculator.Variable;
import Exception.VariableException;
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
    private Stack<String> stackMappeVariabili;
    private String pop;

    public RestoreCommand() {
        stack = StackCalc.getStack();
        var = Variable.getVariable(stack);
    }
    
    //la funzione execute prende in ingresso text che equivale all'operazione richiesta
    // ritorna (?)
    @Override
    public boolean execute(String text) throws LessArgException, VariableException {
        stackMappeVariabili = SaveCommand.getStackMappeVariabili();
        pop = stackMappeVariabili.pop(); // pop dallo stack delle variabili
        var.getMap().clear();
        String[] fields = pop.split(",");
        for (String s : fields) { // itera sulla mappa derivante dalla pop
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
            var.getMap().put(variable, new Complex(real,img)); //inserisce nella struct delle variabili ogni coppia chiave valore

        }

        return true;
    }
    
    //viene chiamata se l'operazione custom non va a buon fine
    //riporta la variabile e lo stack allo stato iniziale prima di eseguire la execute
    @Override
    public void undo() {
        stackMappeVariabili.push(pop);
        var.getMap().clear();
    }
    
}
