/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.Stack;
//import calculator.Complex;

/**
 *
 * @author Alberto
 */
public class StackCalc extends Stack<Complex>{
    
    /*
        Metodo che ritorna un array di elementi, con il primo che è quello in cima allo stack
    */
    public Complex[] visit(){
        Complex[] aux;
        aux = new Complex[this.size()]; 
        Stack s2 = new Stack();
        if(!this.isEmpty()){
            int i=0;
            while(!this.isEmpty()){
                aux[i] = (Complex) this.pop();
                s2.push(aux[i]);
                i++;
            }
            while(!s2.isEmpty()){
                this.push((Complex) s2.pop());
            }
        }
        return aux;
    }
    
    /*
        Metodo che ritorna uno stack svuotato dagli elementi che vi erano prima
    */
    public Stack destroy(){
        Complex aux = null;
        if(!this.isEmpty()){
            while(!this.isEmpty()){
                aux = (Complex) this.pop();
            }
        }
        return this;
    }
    
}
