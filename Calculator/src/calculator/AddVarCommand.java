/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculator;

/**
 *
 * @author paola
 */
public class AddVarCommand implements Command{
    private StackCalc stack;
    private Variable var;
    private Operations op;
    private Complex value1 = null, value2=null;
    private String opval[];
    private Integer num;
    
    public AddVarCommand(Operations op) {
        stack = StackCalc.getStack();
        var = Variable.getVariable(stack);
        this.op = op;
    }

    @Override
    public boolean execute(String text) throws VariableException {
        opval = text.split("(?!^)");
        if (opval.length != 2 || !var.checkVariable(opval[1])) //controllo se la variabile rientra nell'alfabeto e se l'operatore 
        {
            return false;                                      //è formato da due valori(il tipo di operazione e la variabile)
        }
        if (var.getValue(opval[1]) != null && var.getStack().size() >= 1) { //controllo l'esistenza della chiave e l'esistenza di almeno un valore nello stack
            value1=stack.peek();
            value2 = var.getValue(opval[1]);
            var.sumVariable(opval[1], op);
            return true;
        } else {
            num = 0;
            throw new VariableException("La variabile non è stata definita oppure lo stack è vuoto");
        }
    }

    @Override
    public void undo() {
        if (num != 0) {
            stack.push(value1);
            var.setVariable(opval[1], value2);
        }
        num = 1;
    }
}
