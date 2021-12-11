/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculator;

import java.util.*;

/**
 *
 * @author paola
 */
//Invoker
public class Operator {
    static private Operator instance = null;
    private Deque<Command> stack;
    
    public static Operator getOperator(){
        if (instance == null) {
            instance = new Operator();
        }
        return instance;
    }

    private Operator() {
        stack = new ArrayDeque<>();
    }
    
    public void execute (Command command, String text) throws LessArgException, VariableException{
        stack.addLast(command);
        command.execute(text);
    }
    
    public void undoLast(){
        while(!stack.isEmpty()){
            Command last = stack.removeLast();
            last.undo();
        }
    }
    
    //questo metodo serve per pulire lo stack in modo tale da salvare nello stack solo le operazioni che non sono andate a buon fine
    public void clear(){
        stack.clear();
    }
}
