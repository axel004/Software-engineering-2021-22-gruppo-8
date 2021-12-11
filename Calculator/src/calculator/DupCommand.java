/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author Alberto
 */
public class DupCommand implements Command {
    private StackCalc stack;
    
    public DupCommand() {
        stack = StackCalc.getStack();
    }
    
    public boolean execute(String text) throws LessArgException{
        if(stack.size()>=1){
            stack.dup();
            return true;
        }
        throw new LessArgException("Non ci sono abbastanza valori nello stack");
    }

    @Override
    public void undo() {
        stack.pop();
    }
}
