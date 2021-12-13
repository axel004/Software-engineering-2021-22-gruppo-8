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

/**
 *
 * @author Alberto
 */
public class DropCommand implements Command {
    private StackCalc stack;
    
    public DropCommand() {
        stack = StackCalc.getStack();
    }
    
    //la funzione execute controlla che lo stack abbia almeno un elemento altrimenti lancia un'eccezione
    //se ha almeno un elemento allora salva il primo valore presente nello stack in una variabile per agevolare la funzione undo e poi chiama la funzione drop
    @Override
    public boolean execute(String text) throws LessArgException{
        if(stack.size()>=1){
            stack.insertAux(stack.peek());
            stack.drop();
            return true;
        }
        throw new LessArgException("Non ci sono abbastanza valori nello stack");
    }

    @Override
    public void undo(Integer num) {
        if (num != 0) {
            stack.push(stack.returnAux());
        }
    }
}
