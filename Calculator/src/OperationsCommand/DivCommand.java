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
public class DivCommand implements Command{
    private StackCalc stack;
    private Operations op;
    private Complex val1, val2;
    
    public DivCommand(Operations op){
        stack = StackCalc.getStack();
        this.op = op;
    }

    //la funzione execute controlla che lo stack abbia almeno due elementi e, nel caso, controlla che il divisore sia diverso da zero oppure lancia l'eccezione
    //rimuove i primi due elementi e chiama la funzione division e inserisce il risultato nello stack
    //lancia un'eccezione se lo stack ha meno di due elementi
    @Override
    public boolean execute(String text) throws LessArgException, IllegalArgumentException{
        if(stack.size()>=2){
            if (stack.peek().equals(new Complex(0,0))) {
                throw new IllegalArgumentException("Il divisore non può essere nullo");
            }
            val2 = stack.pop();
            val1 = stack.pop();
            stack.insertAux(val2);
            stack.insertAux(val1);
            Complex res = op.division(val1, val2);
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
            stack.push(stack.returnAux());
        }
    }
}
