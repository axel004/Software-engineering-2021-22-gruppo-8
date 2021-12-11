/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OperationsCommand;

import calculator.Command;
import calculator.Complex;
import calculator.LessArgException;
import calculator.StackCalc;

/**
 *
 * @author Alberto
 */
public class OverCommand implements Command {
    private StackCalc stack;
    private Complex val;
    private Integer num;
    
    public OverCommand() {
        stack = StackCalc.getStack();
    }
    
    public boolean execute(String text) throws LessArgException{
        if(stack.size()>=2){
            val = stack.peek();
            stack.over();
            return true;
        }
        num = 0;
        throw new LessArgException("Non ci sono abbastanza valori nello stack");
    }

    @Override
    public void undo() {
        if (num != 0) {
            stack.pop();
            stack.pop();
            stack.push(val);
        }
        num = 1;
    }
}
