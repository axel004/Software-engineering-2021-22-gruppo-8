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
    private Integer num;
    
    public RevSignCommand(Operations op) {
        stack = StackCalc.getStack();
        this.op = op;
    }
    
    //la funzione execute prende in ingresso text che equivale all'operazione richiesta
    // ritorna (?)
    //controlla che lo stack abbia almeno un elemento altrimenti lancia un'eccezione
    //se ha almeno un elemento allora chiama la funzione reverseDign passandogli il primo elemento dello stack
    //salva il risultato nello stack
    @Override
    public boolean execute(String text) throws LessArgException{
        if(stack.size()>=1){
            val1 = stack.pop();
 
            Complex res = op.reverseSign(val1);
            stack.push(res);
            return true;
        }
        num = 0; //variabile flag per il funzionamento di undo
        throw new LessArgException("Non ci sono abbastanza valori nello stack");
    }

    //viene chiamata se l'operazione custom non va a buon fine
    //riporta la variabile e lo stack allo stato iniziale prima di eseguire la execute
    @Override
    public void undo() {
        if (num != 0) {
            stack.pop();
            stack.push(val1);
        }
        num = 1;
    }
}
