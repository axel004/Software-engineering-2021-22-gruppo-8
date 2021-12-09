/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculator;

/**
 *
 * @author paola
 */
public class SquareCommand implements Command{
    private StackCalc stack;
    private Operations op;

    public SquareCommand() {
        stack = StackCalc.getStack();
        op = new Operations();
    }
    
    @Override
    public boolean execute(String text) throws LessArgException {
        if (stack.size() >= 1) {
            Complex val1 = stack.pop();             // ottengo il valore dallo stack
            stack.push(op.radice(val1));        //inserisco nello stack il nuovo valore    
            return true;
        } else {
            throw new LessArgException("Non ci sono abbastanza valori nello stack");
        }
    }
}
