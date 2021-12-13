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
public class OverCommand implements Command {
    private StackCalc stack;
    
    public OverCommand() {
        stack = StackCalc.getStack();
    }

    //la funzione execute controlla che lo stack abbia almeno due elementi e, nel caso, salva il primo elemento nello stack in una variabile ausiliaria
    //per agevolare il metodo undo e chiama la funzione over
    //lancia un'eccezione se lo stack ha meno di due elementi
    @Override
    public boolean execute(String text) throws LessArgException{
        if(stack.size()>=2){
            stack.insertAux(stack.peek());
            stack.over();
            return true;
        }
        throw new LessArgException("Non ci sono abbastanza valori nello stack");
    }

    @Override
    public void undo(Integer num) {
        if (num != 0) {
            stack.pop();
            stack.pop();
            stack.push(stack.returnAux());
        }
    }
}
