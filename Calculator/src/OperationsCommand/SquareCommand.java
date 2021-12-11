/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OperationsCommand;

import calculator.Command;
import calculator.Complex;
import calculator.LessArgException;
import calculator.Operations;
import calculator.StackCalc;

/**
 *
 * @author paola
 */
public class SquareCommand implements Command{
    private StackCalc stack;
    private Operations op;
    private Complex val1;
    private Integer num;

    public SquareCommand(Operations op) {
        stack = StackCalc.getStack();
        this.op = op;
    }
    
    @Override
    public boolean execute(String text) throws LessArgException {
        if (stack.size() >= 1) {
            val1 = stack.pop();             // ottengo il valore dallo stack
            stack.push(op.radice(val1));        //inserisco nello stack il nuovo valore    
            return true;
        } else {
            num = 0;
            throw new LessArgException("Non ci sono abbastanza valori nello stack");
        }
    }

    @Override
    public void undo() {
        if (num != 0) {
            stack.pop();
            stack.push(val1);
        }
        num = 1;
    }
}
