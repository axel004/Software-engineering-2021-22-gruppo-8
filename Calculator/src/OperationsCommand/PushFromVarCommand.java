/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OperationsCommand;

import calculator.Command;
import calculator.Complex;
import calculator.StackCalc;
import calculator.Variable;
import calculator.VariableException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP115-CS0026
 */
public class PushFromVarCommand implements Command {
    private StackCalc stack;
    private Variable var;
    private Complex value=null;
    private String [] opval;
    private Integer num;
    
    public PushFromVarCommand() {
        stack = StackCalc.getStack();
        var = Variable.getVariable(stack);
    }
    
    //<x
    @Override
    public boolean execute(String text) throws VariableException {
        opval = text.split("(?!^)");
        if (opval.length != 2 || !var.checkVariable(opval[1])) //controllo se la variabile rientra nell'alfabeto e se l'operatore 
        {
            return false;                                      //è formato da due valori(il tipo di operazione e la variabile)
        }
        if (var.getValue(opval[1]) != null) { //controllo l'esistenza della chiave
            value = var.getValue(opval[1]);
            var.savingInStack(opval[1]);
            return true;
        } else {
            num=0;
            throw new VariableException("La variabile non è stata definita");
        }
    }    

    @Override
    public void undo() {
        if (num != 0) {
            var.savingInVariable(opval[1]);
        }
        num = 1;
    }
}
