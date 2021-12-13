/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OperationsCommand;

import calculator.Command;
import calculator.Complex;
import calculator.Operations;
import calculator.StackCalc;
import calculator.Variable;
import Exception.VariableException;

/**
 *
 * @author paola
 */
public class SubVarCommand implements Command {
    private StackCalc stack;
    private Variable var;
    private Operations op;
    private String[] opval;
    
    public SubVarCommand(Operations op) {
        stack = StackCalc.getStack();
        var = Variable.getVariable(stack);
        this.op = op;
    }

    //la funzione execute controlla che l'operazione richiesta dall'utente sia corretta e quindi chiama la funzione diffVariable
    //lancia un'eccezione se l'operazione inserita non è corretta
    @Override
    public boolean execute(String text) throws VariableException {
        opval = text.split("(?!^)");
        if (opval.length != 2 || !var.checkVariable(opval[1])) //controllo se la variabile rientra nell'alfabeto e se l'operatore 
        {
            throw new VariableException("La variabile non è stata definita correttamente");                                      //è formato da due valori(il tipo di operazione e la variabile)
        }
        if (var.getValue(opval[1]) != null && stack.size() >= 1) { //controllo l'esistenza della chiave e l'esistenza di almeno un valore nello stack
            stack.insertAux(var.getValue(opval[1])); //metodo ausiliario per il metodo undo che prende il valore presente nella variabile
            stack.insertAux(stack.peek()); //metodo ausiliario per il metodo undo che prende il primo valore dello stack
            var.insertAux(opval[1]); //salva la variabile che poi viene richiamata nel caso in cui viene chiamato il metodo undo
            var.diffVariable(opval[1], op);
            return true;
        } else {
            throw new VariableException("La variabile non è stata definita oppure lo stack è vuoto");
        }
    }   

    @Override
    public void undo(Integer num) {
        if (num != 0) {
            stack.push(stack.returnAux());
            var.setVariable(var.returnAux(), stack.returnAux());
        }
    }
}
