/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculator;

import Exception.LessArgException;
import Exception.VariableException;
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
    
    //metodo che chiama il metodo execute relativo al comando passatogli
    public void execute (Command command, String text) throws LessArgException, VariableException{
        stack.addLast(command); //inserisce il comando passatogli nello stack. Serve per il corretto funzionamento del metodo undoLast
        command.execute(text); //viene passata al metodo execute la stringa text che equivale all'operazione richiesta dall'utente
    }
    
    //metodo che richiama il metodo undo per annullare tutte le operazioni custom effettuate dall'utente nel caso un cui si verifica un'eccezione
    public void undoLast(Integer num){
        while(!stack.isEmpty()){ //chiama il metodo undo fin quando lo stack non diventa vuoto
            Command last = stack.removeLast();
            last.undo(num);
            num = 1; //variabile flag per il funzionamento di undo
        }
    }
    
    //questo metodo serve per pulire lo stack in modo tale da salvare nello stack solo le operazioni che non sono andate a buon fine
    public void clear(){
        stack.clear();
    }
}
