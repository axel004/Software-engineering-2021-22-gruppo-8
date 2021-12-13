/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import OperationsCommand.PushFromVarCommand;
import OperationsCommand.PushToVarCommand;
import OperationsCommand.RevSignCommand;
import OperationsCommand.RestoreCommand;
import OperationsCommand.SaveCommand;
import OperationsCommand.SquareCommand;
import OperationsCommand.SubVarCommand;
import OperationsCommand.SumCommand;
import OperationsCommand.SwapCommand;
import OperationsCommand.OverCommand;
import OperationsCommand.MulCommand;
import OperationsCommand.DivCommand;
import OperationsCommand.DropCommand;
import OperationsCommand.DupCommand;
import OperationsCommand.DiffCommand;
import OperationsCommand.ClearCommand;
import OperationsCommand.AddVarCommand;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.util.regex.Pattern;

/**
 *
 * @author HP115-CS0026
 */

//factory method
public class OperatorFactory {
    private final Map<String, Command> operationMap = new HashMap<>();
    private Operations op = new Operations();
    
    public OperatorFactory() {
        operationMap.put("+", new SumCommand(op));
        operationMap.put("-", new DiffCommand(op));
        operationMap.put("+-", new RevSignCommand(op));
        operationMap.put("*", new MulCommand(op));
        operationMap.put("/", new DivCommand(op));
        operationMap.put("sqrt", new SquareCommand(op));
        operationMap.put("dup", new DupCommand());
        operationMap.put("swap", new SwapCommand());
        operationMap.put("over", new OverCommand());
        operationMap.put("clear", new ClearCommand());
        operationMap.put("drop", new DropCommand());
        operationMap.put(">var", new PushToVarCommand());
        operationMap.put("<var", new PushFromVarCommand());
        operationMap.put("+var", new AddVarCommand(op));
        operationMap.put("-var", new SubVarCommand(op));
        operationMap.put("save", new SaveCommand());
        operationMap.put("restore", new RestoreCommand());
    }
    
    //restiruisce la mappa contenente la lista delle operazioni
    public Map<String, Command> getOperationMap() {
        return operationMap;
    }
    
    //chiama le operazioni richieste dall'utente
    //restituisce null se l'operazione non è presente
    public Command getCommand(String operator) {
        String[] splot = operator.split("(?!^)");
        if (splot[0].matches(Pattern.quote("+")) && operator.length() == 2) {
            if (splot[1].matches("[a-z]{1}")) {
                return operationMap.get("+var");
            }
        }else if (splot[0].matches(Pattern.quote("-")) && operator.length()==2){
            if (splot[1].matches("[a-z]{1}")) {
                return operationMap.get("-var");
            }
        }else if(splot[0].matches(Pattern.quote(">")) && operator.length()==2){
            if (splot[1].matches("[a-z]{1}")) {
                return operationMap.get(">var");
            }
        } else if (splot[0].matches(Pattern.quote("<")) && operator.length() == 2) {
            if (splot[1].matches("[a-z]{1}")) {
                return operationMap.get("<var");
            }
        }
        return operationMap.get(operator);
    }
}
