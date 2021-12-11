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
 * @author HP115-CS0026
 */
public class SumCommand implements Command {
    private StackCalc stack;
    private Operations op;
    private Complex val1, val2;
    private Integer num;
    
    public SumCommand(Operations op) {
        stack = StackCalc.getStack();
        this.op = op;
    }

    //la funzione execute prende in ingresso text che equivale all'operazione richiesta
    // ritorna (?)
    //controlla che lo stack abbia almeno due elementi e, nel caso, rimuove i primi due elementi e chiama la funzione sum
    //inserisce il risultato nello stack
    //lancia un'eccezione se lo stack ha meno di due elementi
    @Override
    public boolean execute(String text) throws LessArgException {
        if (stack.size() >= 2) {
            val2 = stack.pop();
            val1 = stack.pop();
            
            Complex res = op.sum(val1, val2);
            stack.push(res);
            return true;
        }
        num = 0; //variabile flag per il funzionamento di undo
        throw new LessArgException("Non ci sono abbastanza valori nello stack");
    }

    //viene chiamata se l'operazione custom non va a buon fine
    //riporta lo stack allo stato iniziale prima di eseguire la execute
    @Override
    public void undo() {
        if (num != 0){
            stack.pop();
            stack.push(val1);
            stack.push(val2);
        }
        num = 1;
    }
    
    
}
