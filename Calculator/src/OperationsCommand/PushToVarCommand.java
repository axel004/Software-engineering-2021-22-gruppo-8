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
    private Integer num;
    
    public PushToVarCommand() {
        stack = StackCalc.getStack();
        var = Variable.getVariable(stack);
    }
    
    //la funzione execute prende in ingresso text che equivale all'operazione richiesta
    // ritorna (?)
    //controlla che l'operazione richiesta dall'utente sia corretta e quindi chiama la funzione savingInStack passandole la variabile scelta dall'utente
    //lancia un'eccezione se l'operazione inserita non è corretta
    @Override
    public boolean execute(String text) throws VariableException {
        opval = text.split("(?!^)");
        if (opval.length != 2 || !var.checkVariable(opval[1])) //controllo se la variabile rientra nell'alfabeto e se l'operatore è formato da due valori(il tipo di operazione e la variabile)
        {
            return false;                                      
        }
        if (var.getStack().size() >= 1) { //controllo che ci sia almeno un valore nello stack
            value=stack.peek(); //variabile ausilaria per il metodo undo che conserva il primo valore presente nello stack
            var.savingInVariable(opval[1]);     //>x
            return true;
        } else {
            num = 0; //variabile flag per il funzionamento di undo
            throw new VariableException("La variabile non è stata definita oppure lo stack è vuoto");
        }
    }

    //viene chiamata se l'operazione custom non va a buon fine
    //riporta la variabile e lo stack allo stato iniziale prima di eseguire la execute
    @Override
    public void undo() {
        if (num != 0) {
            var.savingInStack(opval[1]);
        }
        num = 1;

    }
    
}
