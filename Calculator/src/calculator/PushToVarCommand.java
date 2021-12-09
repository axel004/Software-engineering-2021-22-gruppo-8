/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP115-CS0026
 */
public class PushToVarCommand implements Command {
    private StackCalc stack;
    private Variable var;
    
    public PushToVarCommand() {
        stack = StackCalc.getStack();
        var = Variable.getVariable(stack);
    }

    @Override
    public boolean execute(String text) throws VariableException {
        String[] opval = text.split("(?!^)");
        if (opval.length != 2 || !var.checkVariable(opval[1])) //controllo se la variabile rientra nell'aòfabeto e se l'operatore 
        {
            return false;                                      //è formato da due valori(il tipo di operazione e la variabile)
        }
        if (var.getStack().size() >= 1) { 
            //controllo che ci sia almeno un valore nello stack
            var.savingInVariable(opval[1]);
            return true;
        } else {
            throw new VariableException("La variabile non è stata definita oppure lo stack è vuoto");
        }
    }
    
}
