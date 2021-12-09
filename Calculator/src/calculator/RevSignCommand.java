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
public class RevSignCommand implements Command {
    private StackCalc stack;
    private Operations op;
    
    public RevSignCommand() {
        stack = StackCalc.getStack();
        op = new Operations();
    }
    
    public boolean execute(String text) throws LessArgException{
        if(stack.size()>=1){
            Complex val1 = stack.pop();
 
            Complex res = op.reverseSign(val1);
            stack.push(res);
            return true;
        }
        throw new LessArgException("Non ci sono abbastanza valori nello stack");
    }
}
