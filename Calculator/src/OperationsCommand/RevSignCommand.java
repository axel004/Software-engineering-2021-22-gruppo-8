/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OperationsCommand;

import calculator.Command;
import calculator.Complex;
import Exception.LessArgException;
import calculator.Operations;
import calculator.StackCalc;

/**
 *
 * @author Alberto
 */
public class RevSignCommand implements Command {
    private StackCalc stack;
    private Operations op;
    private Complex val1;
    
    public RevSignCommand(Operations op) {
        stack = StackCalc.getStack();
        this.op = op;
    }
    
    //la funzione execute se ha almeno un elemento allora chiama la funzione reverseDign passandogli il primo elemento dello stack
    //salva il risultato nello stack
    @Override
    public boolean execute(String text) throws LessArgException{
        if(stack.size()>=1){
            val1 = stack.pop();
            stack.insertAux(val1);
            Complex res = op.reverseSign(val1);
            stack.push(res);
            return true;
        }
        throw new LessArgException("Non ci sono abbastanza valori nello stack");
    }

    @Override
    public void undo(Integer num) {
        if (num != 0) {
            stack.pop();
            stack.push(stack.returnAux());
        }
    }
}
