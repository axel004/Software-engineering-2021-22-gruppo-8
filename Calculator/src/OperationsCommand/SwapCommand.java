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
public class SwapCommand implements Command {
    private StackCalc stack;
    private Complex val1;
    
    public SwapCommand() {
        stack = StackCalc.getStack();
    }
    

    //controlla che lo stack abbia almeno due elementi e, nel caso, chiama la funzione swap
    //lancia un'eccezione se lo stack ha meno di due elementi
    @Override
    public boolean execute(String text) throws LessArgException{
        if(stack.size()>=2){
            stack.swap();
            return true;
        }
        throw new LessArgException("Non ci sono abbastanza valori nello stack");
    }

    @Override
    public void undo(Integer num) {
        if (num != 0) {
            stack.swap();
        }
    }
}
