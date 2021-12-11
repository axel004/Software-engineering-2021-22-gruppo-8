/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.util.regex.Pattern;

/**
 *
 * @author HP115-CS0026
 */
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
    }
    
    public Map<String, Command> getOperationMap() {
        return operationMap;
    }
    
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
