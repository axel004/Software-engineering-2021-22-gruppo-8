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

    private TreeMap<String, Complex> struct;
    
    public Variable() {
        struct = new TreeMap<>();
    }
    
    public Complex setVariable(String key, Complex value) {
        // verifico se la variabile è ammissibile
        // deve essere un carattere e deve essere un carattere dell'alfabeto
        if (!key.matches("[a-z]{1}"))
            return null;
        // se la variabile è ammissibile la assegno o riassegno
        struct.put(key, value);
        return struct.get(key);
    }
    
    public Complex getVariable(String key) {
        return struct.get(key);
    }
    
    /*
    questa funzione salva il valore presente in cima allo stack nella variabile scelta dall'utente (key).
    corrisponde al comando ">x"
    */
    public void savingInVariable(String key, StackCalc stack){
        this.setVariable(key, stack.pop());
    }
    
    /*
    questa funzione salva il valore presente nella variabile selezionata dall'utente (key) in cima allo stack
    corrisponde al comando "<x"
     */
    public void savingInStack(String key, StackCalc stack) throws Exception {
        if (!struct.containsKey(key)) {
            throw new Exception("Non è presente la variabile selezionata");
        } else {
            stack.push(struct.get(key));
        }
    }
}
