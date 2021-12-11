/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

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
    
    public boolean execute(String text){
        for (Complex s : stack) {
            stackLast.add(s);
        }
        stack.clear();
        return true;  
    }

    @Override
    public void undo() {
        for (int i =stackLast.size(); i>0;i--) {
            stack.push(stackLast.poll());
        }
    }
}
