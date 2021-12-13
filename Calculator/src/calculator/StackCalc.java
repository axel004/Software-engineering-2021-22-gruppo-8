/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EmptyStackException;
import java.util.Stack;
//import calculator.Complex;

/**
 *
 * @author Alberto
 */
public class StackCalc extends Stack<Complex>{
    static private StackCalc stack = null;
    private Deque<Complex> aux;
    
    public static StackCalc getStack() {
        if (stack == null) {
            stack = new StackCalc();
        }
        return stack;
    }
    private StackCalc() {
        aux = new ArrayDeque<>();
    }
    
   //prende il primo elemento dello stack
    @Override
    public Complex pop(){
        try{
            Complex item = super.pop();
            return item;
        }
        catch(EmptyStackException e){
            System.out.print("Errore stack\n");
            return null;
        }
    }
    
    //inserisce l'elemento nello stack
    @Override
    public Complex push(Complex item) {
        item = super.push(item);
        return item;
    }
    
    
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
            Complex c;
            while(!s2.isEmpty()){
                c = (Complex) s2.pop();
                if(c!=null){
                    this.push(c);
                }
                else{
                    break;
                }
            }
            if(this.isEmpty()){
                this.setSize(0);
            }
            return aux;
        }
        else{
            return null;
        }
        
    }
    
    /*
        Metodo che ritorna uno stack svuotato dagli elementi che vi erano prima
    */
    public StackCalc destroy(){
        Complex aux = null;
        if(!this.isEmpty()){
            while(!this.isEmpty()){
                aux = (Complex) this.pop();
            }
        }
        return this;
    }
    /*
    metodo che elimina l'elemento in cima allo stack
    */
    public void drop(){
        this.pop();
    }
    
    /*
    metodo che prende il primo elemento (senza eliminarlo) nello stack e lo copia nello stack stesso
    */
    public void dup() {
        this.push(this.peek());
    }
    
    //pulisce lo stack
    public void clear() {
        if (this.isEmpty())
            return;
        this.destroy();
    }
    
    //inverte la posizione degli ultimi due elementi dello stack
    public void swap() {
        Complex val1 = this.pop();
        Complex val2 = this.pop();
        this.push(val1);
        this.push(val2);
    }
        
    /*
    metodo che copia il penultimo elemento e lo mette nello stack
    */
    public void over() {
        try {
            Complex ultimo = this.pop();
            Complex penultimo = this.peek();
            this.push(ultimo);
            this.push(penultimo);
        } catch (Exception e) {
            System.out.print("Over error\n");
        }
    }
    
    //metodo ausiliario per il metodo undo. Salva i numeri complessi da ripristinare nello stack in seguito
    public void insertAux(Complex c) {
        aux.addFirst(c);
    }

    //metodo ausiliario per il metodo undo. Rimuove i numeri complessi da ripristinare nello stack in seguito
    public Complex returnAux() {
        return aux.removeFirst();
    }
}
