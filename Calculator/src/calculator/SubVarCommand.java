/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculator;

/**
 *
 * @author paola
 */
public class SubVarCommand implements Command {
    private StackCalc stack;
    private Variable var;
    private Operations op;
    
    public SubVarCommand() {
        stack = StackCalc.getStack();
        var = Variable.getVariable(stack);
        op = new Operations ();
    }

    @Override
    public boolean execute(String text) throws VariableException {
        String[] opval = text.split("(?!^)");
        if (opval.length != 2 || !var.checkVariable(opval[1])) //controllo se la variabile rientra nell'alfabeto e se l'operatore 
        {
            return false;                                      //è formato da due valori(il tipo di operazione e la variabile)
        }
        if (var.getValue(opval[1]) != null && var.getStack().size() >= 1) { //controllo l'esistenza della chiave e l'esistenza di almeno un valore nello stack
            var.diffVariable(opval[1], op);
            return true;
        } else {
            throw new VariableException("La variabile non è stata definita oppure lo stack è vuoto");
        }
    }   
}
