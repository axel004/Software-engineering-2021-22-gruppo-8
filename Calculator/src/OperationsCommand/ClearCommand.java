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
    private Integer n=0;
    
    public ClearCommand() {
        stack = StackCalc.getStack();
        stackLast = new ArrayDeque<>();
    }
    
    //la funzione execute salva lo stack in un array deque al fine di poterlo ripristinare nel caso in cui si verifica un'eccezione
    //chiama la funzione clear per pulire lo stack
    @Override
    public boolean execute(String text) {
        for (Complex s : stack) {
            stack.insertAux(s);
            n++;
        }
        stack.clear();
        return true;
    }


    @Override
    public void undo(Integer num) {
        for (int i = 0; i<n;i++) {
            System.out.println(n);
            stackLast.addFirst(stack.returnAux());
        }
        for (Complex s: stackLast){
            stack.push(s);
        }
    }
}
