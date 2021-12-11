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
    
    //la funzione execute prende in ingresso text che equivale all'operazione richiesta
    // ritorna (?)
    //controlla che l'operazione richiesta dall'utente sia corretta e quindi chiama la funzione savingInStack passandole la variabile scelta dall'utente
    //lancia un'eccezione se l'operazione inserita non è corretta
    @Override
    public boolean execute(String text) throws VariableException {
        opval = text.split("(?!^)");
        if (opval.length != 2 || !var.checkVariable(opval[1])) //controllo se la variabile rientra nell'alfabeto e se l'operatore 
        {
            throw new VariableException("La variabile non è stata definita"); //è formato da due valori(il tipo di operazione e la variabile)
        }
        if (var.getValue(opval[1]) != null) { //controllo l'esistenza della chiave
            value = var.getValue(opval[1]); //variabile ausilaria per il metodo undo che conserva il valore presente nella variabile scelta dall'utente
            var.savingInStack(opval[1]); //<x
            return true;
        } else {
            num=0; //variabile flag per il funzionamento di undo
            throw new VariableException("La variabile non è stata definita");
        }
    }    

    //viene chiamata se l'operazione custom non va a buon fine
    //riporta la variabile e lo stack allo stato iniziale prima di eseguire la execute
    @Override
    public void undo() {
        if (num != 0) {
            var.savingInVariable(opval[1]);
        }
        num = 1;
    }
}
