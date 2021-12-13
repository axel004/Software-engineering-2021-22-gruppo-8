/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OperationsCommand;

import calculator.Command;
import calculator.Complex;
import Exception.LessArgException;
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

    public SquareCommand(Operations op) {
        stack = StackCalc.getStack();
        this.op = op;
    }
    
    //la funzione execute controlla che lo stack abbia almeno un elemento altrimenti lancia un'eccezione
    //se ha almeno un elemento allora chiama la funzione squareRoot e le passa il primo valore dello stack
    @Override
    public boolean execute(String text) throws LessArgException {
        if (stack.size() >= 1) {
            val1 = stack.pop();             // ottengo il valore dallo stack
            stack.insertAux(val1);
            stack.push(op.squareRoot(val1));        //inserisco nello stack il nuovo valore    
            return true;
        } else {
            throw new LessArgException("Non ci sono abbastanza valori nello stack");
        }
    }


    @Override
    public void undo(Integer num) {
        if (num != 0) {
            stack.pop();
            stack.push(stack.returnAux());
        }
    }
}
