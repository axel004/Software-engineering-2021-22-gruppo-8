/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OperationsCommand;

import calculator.Command;
import calculator.Complex;
import calculator.StackCalc;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author Alberto
 */
public class ClearCommand implements Command {
    private StackCalc stack;
    private Deque<Complex> stackLast;
    
    public ClearCommand() {
        stack = StackCalc.getStack();
        stackLast = new ArrayDeque<>();
    }
    
    //la funzione execute prende in ingresso text che equivale all'operazione richiesta
    // ritorna (?)
    //Salva lo stack in un array deque al fine di poterlo ripristinare nel caso in cui si verifica un'eccezione
    //chiama la funzione clear per pulire lo stack
    @Override
    public boolean execute(String text) {
        for (Complex s : stack) {
            stackLast.add(s);
        }
        stack.clear();
        return true;
    }

    //viene chiamata se l'operazione custom non va a buon fine
    //ripristina lo stack
    @Override
    public void undo() {
        for (int i =stackLast.size(); i>0;i--) {
            stack.push(stackLast.poll());
        }
    }
}
