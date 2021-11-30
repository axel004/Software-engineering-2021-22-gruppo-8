/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import calculator.Complex;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Alberto
 */
public class Operations {
    
    public StackCalc clear(StackCalc stack) {
        if (stack.isEmpty())
            return stack;
        return stack.destroy();
    }
    
    private static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
  
    public Complex reverseSign(Complex value) {
        try{
            double real = value.getReal();
            double complex = value.getComplex();
            Complex result = new Complex(0,0);
            if (real != 0)
                result.setReal(real*-1);
            if (complex != 0)
                result.setComplex(complex*-1);       
            return result;
        }
        catch(Exception e){
            System.out.print("Reverse sign error\n");
            return null;
        }
    }
    
    public Complex multiply(Complex a, Complex b){
        try{
            Double A = a.getReal();
            Double C = b.getReal();
            Double B = a.getComplex();
            Double D = b.getComplex();
            
            Complex res = new Complex((A*C) - (B*D), (A*D) + (B*C));
            res.setReal(this.round(res.getReal(), 4));
            res.setComplex(this.round(res.getComplex(), 4));
            return res;
        }
        catch(Exception e){
            System.out.print("Multiply error\n");
            return null;
        }
    }
    
    public Complex sum(Complex a, Complex b){
        try{
        Complex res = new Complex (a.getReal() + b.getReal(), a.getComplex() + b.getComplex());
        return res;
        }
        catch(Exception e){
            System.out.print("Sum error\n");
            return null;
        }
    }

    public Complex differenza(Complex val1, Complex val2){
        try{
            Complex res = new Complex(val1.getReal()-val2.getReal(),val1.getComplex()-val2.getComplex());  //eseguo la differenza
            res.setReal(this.round(res.getReal(),4));
            res.setComplex(this.round(res.getComplex(),4));
            return res;
        }
        catch(Exception e){
            System.out.print("Diff error\n");
            return null;
        }
     
    }   
    
    
    public Complex radice(Complex val) {
        try {
            if (val.getComplex() == 0) //controllo se il valore è reale
            {
                if (val.getReal() >= 0) //se è maggiore di zero eseguo la radice classica
                {
                    val.setReal(Math.sqrt(val.getReal()));
                    val.setReal(this.round(val.getReal(), 4));
                } else {
                    val.setComplex(Math.sqrt((-1 * val.getReal()))); //se è minore di zero eseguo la radice del valore trasformato in positivo
                    val.setComplex(this.round(val.getComplex(), 4));
                    val.setReal(0);             //e lo inserisco come valore immaginario e setto la parte reale a 0
                }
            } else {
                double abs = Math.sqrt(val.getReal() * val.getReal() + val.getComplex() * val.getComplex());   //calcolo modulo e fase
                double arg = (2 * Math.PI + Math.atan2(val.getComplex(), val.getReal())) % (2 * Math.PI);

                val.setReal(Math.sqrt(abs) * (Math.cos((arg / 2))));        //calcolo i valori reali e immaginari e li inserisco nell'oggetto val
                val.setComplex(Math.sqrt(abs) * (Math.sin(arg / 2)));
                val.setReal(this.round(val.getReal(), 4));
                val.setComplex(this.round(val.getComplex(), 4));
            }

            return val;
        } catch (Exception e) {
            System.out.print("Radice error\n");
            return null;
        }
    }

    public Complex times(Complex x, Complex y) { //questa funzione implementa la formula della divisione, le viene passato il dividendo e il risultato della funzione times seguente
        double reP = this.round(x.getReal() * y.getReal() - x.getComplex() * y.getComplex(),4); //(ac+bd)/(c^2+d^2)
        double imP = this.round(x.getComplex() * y.getReal() + x.getReal() * y.getComplex(), 4); //(bc-ad)/(C^2+d^2)
        return new Complex (reP, imP);
    }

    public Complex times(double a, Complex y) { //a corrisponde al denominatore della forumula. Viene moltiplicato il denominatore della formula per il divisore coniugato
        double reP =  this.round((double) a * y.getReal(),8);
        double imP =  this.round((double) a * y.getComplex(),8);
        return new Complex (reP, imP); //reP=c/(C^2+d^2) imP=-d/(C^2+d^2)
    }

    public double square(Complex y) { //restituisce la somma dei quadrati della parte reale e immaginaria del numero complesso passato
        double reP =  this.round(y.getReal() * y.getReal(), 4);
        double imP = this.round(y.getComplex() * y.getComplex(), 4);
        return reP+imP; //C^2+d^2
    }

    public Complex conjugate(Complex y) { //restituisce il coniugato del numero complesso passato
        return new Complex(y.getReal(), -y.getComplex());
    }

    /*x=a+bj  y=c+dj
    la formula per la divisione è: (ac+bd)/(c^2+d^2)+j(bc-ad)/(c^2+d^2)
    */
    public Complex divisione(Complex x, Complex y){
        try {
            Complex comp = times(1 / square(y), conjugate(y));
            return times(x, comp);
        } catch (Exception e) {
            System.out.print("Div error\n");
            return null;
        }
    }
}
