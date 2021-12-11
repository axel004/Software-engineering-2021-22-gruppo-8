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
    private Complex val1;
    private Integer num;
    
    public RevSignCommand(Operations op) {
        stack = StackCalc.getStack();
        this.op = op;
    }
    
    public boolean execute(String text) throws LessArgException{
        if(stack.size()>=1){
            val1 = stack.pop();
 
            Complex res = op.reverseSign(val1);
            stack.push(res);
            return true;
        }
        num = 0;
        throw new LessArgException("Non ci sono abbastanza valori nello stack");
    }

    @Override
    public void undo() {
        if (num != 0) {
            stack.pop();
            stack.push(val1);
        }
        num = 1;
    }
}
