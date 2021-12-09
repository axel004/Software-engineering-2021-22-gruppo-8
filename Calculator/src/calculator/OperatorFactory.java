/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

/**
 *
 * @author HP115-CS0026
 */
public class OperatorFactory {
    private final Map<String, Command> operationMap = new HashMap<>();
    
    public OperatorFactory() {
        operationMap.put("+", new SumCommand());
        operationMap.put("-", new DiffCommand());
        operationMap.put("+-", new RevSignCommand());
        operationMap.put("*", new MulCommand());
        operationMap.put("/", new DivCommand());
        operationMap.put("sqrt", new SquareCommand());
        operationMap.put("dup", new DupCommand());
        operationMap.put("swap", new SwapCommand());
        operationMap.put("over", new OverCommand());
        operationMap.put("clear", new ClearCommand());
        operationMap.put("drop", new DropCommand());
        operationMap.put(">var", new PushToVarCommand());
        operationMap.put("<var", new PushFromVarCommand());
        operationMap.put("+var", new AddVarCommand());
        operationMap.put("-var", new SubVarCommand());
    }
    
    public Map<String, Command> getOperationMap() {
        return operationMap;
    }
    
    public Command getCommand(String operator) {
        if ((operator.startsWith("+") && operator.length()==2))
            return operationMap.get("+var");
        else if ((operator.startsWith("-") && operator.length()==2))
            return operationMap.get("-var");            
        else if ((operator.startsWith(">") && operator.length()==2))
            return operationMap.get(">var");
        else if ((operator.startsWith("<") && operator.length()==2))
            return operationMap.get("<var");
        return operationMap.get(operator);
    }
}
