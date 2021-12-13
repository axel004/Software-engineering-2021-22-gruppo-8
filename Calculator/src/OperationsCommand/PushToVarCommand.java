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
import Exception.VariableException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP115-CS0026
 */
public class PushToVarCommand implements Command {
    private StackCalc stack;
    private Variable var;
    private String[] opval;
    private Complex value;
    private String variable;
    
    public PushToVarCommand() {
        stack = StackCalc.getStack();
        var = Variable.getVariable(stack);
    }

    //la funzione execute controlla che l'operazione richiesta dall'utente sia corretta e quindi chiama la funzione savingInStack passandole la variabile scelta dall'utente
    //lancia un'eccezione se l'operazione inserita non è corretta
    @Override
    public boolean execute(String text) throws VariableException {
        opval = text.split("(?!^)");
        if (opval.length != 2 || !var.checkVariable(opval[1])) //controllo se la variabile rientra nell'alfabeto e se l'operatore è formato da due valori(il tipo di operazione e la variabile)
        {
            throw new VariableException("La variabile non è stata definita correttamente");                                      
        }
        if (stack.size() >= 1) { //controllo che ci sia almeno un valore nello stack
            stack.insertAux(stack.peek()); //metodo ausilario per il metodo undo che conserva il primo valore presente nello stack
            var.insertAux(opval[1]); //salva la variabile che poi viene richiamata nel caso in cui viene chiamato il metodo undo
            var.savingInVariable(opval[1]);//>x
            return true;
        } else {
            throw new VariableException("La variabile non è stata definita oppure lo stack è vuoto");
        }
    }

    @Override
    public void undo(Integer num) {
        if (num != 0) {
            stack.push(stack.returnAux());
            var.getMap().remove(var.returnAux()); 
        }
    }
    
}
