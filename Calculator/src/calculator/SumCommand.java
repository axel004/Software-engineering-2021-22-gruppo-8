/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author HP115-CS0026
 */
public class SumCommand implements Command {
    private StackCalc stack;
    private Operations op;
    
    public SumCommand() {
        stack = StackCalc.getStack();
        op = new Operations();
    }

    @Override
    public boolean execute(String text) throws LessArgException {
        if (stack.size() >= 2) {
            Complex val2 = stack.pop();
            Complex val1 = stack.pop();
            
            Complex res = op.sum(val1, val2);
            stack.push(res);
            return true;
        }
        throw new LessArgException("Non ci sono abbastanza valori nello stack");
    }
    
    
}
