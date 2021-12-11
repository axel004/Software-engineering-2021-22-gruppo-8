/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.TreeMap;

/**
 *
 * @author HP115-CS0026
 */
public class Variable {
    static private Variable instance = null;
    private TreeMap<String, Complex> struct;
    private StackCalc stack;
    
    public static Variable getVariable(StackCalc stack){
        if (instance==null)
            instance = new Variable (stack);
        return instance;
    }
    
    private Variable(StackCalc stack) {
        struct = new TreeMap<>();
        this.stack = stack;
    }
    
    public boolean checkVariable(String key) {
        if (!key.matches("[a-z]{1}"))
            return false;
        return true;
    }
    
    public Complex setVariable(String key, Complex value) {
        // verifico se la variabile è ammissibile
        // deve essere un carattere e deve essere un carattere dell'alfabeto
        if (!checkVariable(key))
            return null;
        // se la variabile è ammissibile ma è già inizializzata lancio un'eccezione per avvisare l'utente
        // se la variabile è ammissibile la assegno o riassegno
        struct.put(key, value);
        return struct.get(key);
    }

    
    public Complex getValue(String key) {
        return struct.get(key);
    }
    
    public StackCalc getStack() {
        return stack;
    }
    
    /*
    questa funzione salva il valore presente in cima allo stack nella variabile scelta dall'utente (key).
    corrisponde al comando ">x"
    */
    public void savingInVariable(String key) {
        this.setVariable(key, stack.pop());
    }
    
    /*
    questa funzione salva il valore presente nella variabile selezionata dall'utente (key) in cima allo stack
    corrisponde al comando "<x"
    */
    public void savingInStack(String key) {
        stack.push(struct.get(key));
        struct.remove(key);
    }
    
    /*
    questa funzione somma il valore presente nella variabile selezionata dall'utente con quello presente in cima allo stack
    e salva il risultato nella variabile stessa
    corrisponde al comando "+x"
    */
    public void sumVariable (String key, Operations op){
        setVariable(key, op.sum(getValue(key), stack.pop()));
    }
    
    /*
    questa funzione sottrae al valore presente nella variabile selezionata dall'utente quello presente in cima allo stack
    e salva il risultato nella variabile stessa
    corrisponde al comando "-x"
     */
    public void diffVariable(String key, Operations op) {
        this.setVariable(key, op.differenza(this.getValue(key), stack.pop()));
    }
}
