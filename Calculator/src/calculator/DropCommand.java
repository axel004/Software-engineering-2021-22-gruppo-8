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
public class DropCommand implements Command {
    private StackCalc stack;
    private Complex val;
    private Integer num;
    
    public DropCommand() {
        stack = StackCalc.getStack();
    }
    
    public boolean execute(String text) throws LessArgException{
        if(stack.size()>=1){
            val = stack.peek();
            stack.drop();
            return true;
        }
        num = 0;
        throw new LessArgException("Non ci sono abbastanza valori nello stack");
    }

    @Override
    public void undo() {
        if (num != 0) {
            stack.push(val);
        }
        num = 1;
    }
}
