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
public class ClearCommand implements Command {
    private StackCalc stack;
    
    public ClearCommand() {
        stack = StackCalc.getStack();
    }
    
    public boolean execute(String text){
            stack.clear();
            return true;  
    }
}
