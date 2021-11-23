/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_proj;

import java.util.Stack;

/**
 *
 * @author Alberto
 */
public class StackCalc extends Stack<Object>{
    
    /*
        Metodo che ritorna un array di elementi, con il primo che è quello in cima allo stack
    */
    public Object visit(Stack s){
        Object aux [] = null;
        Stack s2 = new Stack();
        for(int i=0;i<s.size();i++){
            aux[i] = s.pop();
            s2.push(aux[i]);
        }
        for(int i=0;i<s2.size();i++){
            s.push(s2.pop());
        }
        return aux;
    }
    
    /*
        Metodo che ritorna uno stack svuotato dagli elementi che vi erano prima
    */
    public Stack destroy(Stack s){
        Object aux = null;
        for(int i=0;i<s.size();i++){
            aux = s.pop();
        }
        return s;
    }
    
    
}
