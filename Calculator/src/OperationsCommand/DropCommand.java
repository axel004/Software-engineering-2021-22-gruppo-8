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
public class DropCommand implements Command {
    private StackCalc stack;
    private Complex val;
    private Integer num;
    
    public DropCommand() {
        stack = StackCalc.getStack();
    }
    
    //la funzione execute prende in ingresso text che equivale all'operazione richiesta
    // ritorna (?)
    //controlla che lo stack abbia almeno un elemento altrimenti lancia un'eccezione
    //se ha almeno un elemento allora salva il primo valore presente nello stack in una variabile per agevolare la funzione undo e poi chiama la funzione drop
    @Override
    public boolean execute(String text) throws LessArgException{
        if(stack.size()>=1){
            val = stack.peek();
            stack.drop();
            return true;
        }
        num = 0; //variabile flag per il funzionamento di undo
        throw new LessArgException("Non ci sono abbastanza valori nello stack");
    }

    //viene chiamata se l'operazione custom non va a buon fine
    //riporta lo stack allo stato iniziale prima di eseguire la execute inserendo il valore rimosso dalla drop
    @Override
    public void undo() {
        if (num != 0) {
            stack.push(val);
        }
        num = 1;
    }
}
