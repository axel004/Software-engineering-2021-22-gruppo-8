/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OperationsCommand;

import calculator.Command;
import calculator.Complex;
import calculator.LessArgException;
import calculator.Operations;
import calculator.StackCalc;

/**
 *
 * @author Alberto
 */
public class MulCommand implements Command{
    private StackCalc stack;
    private Operations op;
    private Complex val1, val2;
    private Integer num;
    
    public MulCommand(Operations op) {
        stack = StackCalc.getStack();
        this.op = op;
    }
    
    public boolean execute(String text) throws LessArgException{
        if(stack.size()>=2){
            val2 = stack.pop();
            val1 = stack.pop();
            
            Complex res = op.multiply(val1, val2);
            stack.push(res);
            return true;
        }
        num = 0;
        throw new LessArgException("Non ci sono abbastanza valori nello stack");
    }

    @Override
    public void undo() {
        if (num != 0) {
            stack.pop();
            stack.push(val1);
            stack.push(val2);
        }
        num = 1;
    }
}
