/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OperationsCommand;

import calculator.Command;
import Exception.LessArgException;
import calculator.StackCalc;

/**
 *
 * @author Alberto
 */
public class DupCommand implements Command {
    private StackCalc stack;
    
    public DupCommand() {
        stack = StackCalc.getStack();
    }
    
    //la funzione execute prende in ingresso text che equivale all'operazione richiesta
    // ritorna (?)
    //controlla che lo stack abbia almeno un elemento altrimenti lancia un'eccezione
    //se ha almeno un elemento chiama la funzione drop
    @Override
    public boolean execute(String text) throws LessArgException{
        if(stack.size()>=1){
            stack.dup();
            return true;
        }
        throw new LessArgException("Non ci sono abbastanza valori nello stack");
    }

    //viene chiamata se l'operazione custom non va a buon fine
    //riporta lo stack allo stato iniziale prima di eseguire la execute
    @Override
    public void undo() {
        stack.pop();
    }
}
