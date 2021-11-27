/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import calculator.Complex;

/**
 *
 * @author Alberto
 */
public class Operations {
  
    public Complex reverseSign(Complex value) {
        double real = value.getReal();
        double complex = value.getComplex();
        Complex result = new Complex(0,0);
        if (real != 0)
            result.setReal(real*-1);
        if (complex != 0)
            result.setComplex(complex*-1);       
        return result;
    }
    
    public Complex multiply(Complex a, Complex b){
        try{
            Double A = a.getReal();
            Double C = b.getReal();
            Double B = a.getComplex();
            Double D = b.getComplex();
            
            Complex res = new Complex((A*C) - (B*D), (A*D) + (B*C));
            res.setReal(Math.round(res.getReal()*10000)/10000.0);
            res.setComplex(Math.round(res.getComplex()*10000)/10000.0);
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
        Complex totaldiff = new Complex(val1.getReal()-val2.getReal(),val1.getComplex()-val2.getComplex());  //eseguo la differenza
        totaldiff.setReal(Math.round(totaldiff.getReal()*10000)/10000.0);
        totaldiff.setComplex(Math.round(totaldiff.getComplex()*10000)/10000.0);
        return totaldiff;
     
    }   
    
    
    public Complex radice(Complex val){
        
        if(val.getComplex()==0)     //controllo se il valore è reale
            if(val.getReal()>=0)     //se è maggiore di zero eseguo la radice classica
                val.setReal(Math.sqrt(val.getReal()));
            else{
                val.setComplex(Math.sqrt((-1*val.getReal()))); //se è minore di zero eseguo la radice del valore trasformato in positivo
                val.setReal(0);             //e lo inserisco come valore immaginario e setto la parte reale a 0
            }
        else{
        double abs= Math.sqrt(val.getReal()*val.getReal()+val.getComplex()*val.getComplex());   //calcolo modulo e fase
        double arg = (2*Math.PI + Math.atan2(val.getComplex(),val.getReal())) % (2*Math.PI);
        
        val.setReal(Math.sqrt(abs)*(Math.cos((arg/2))));        //calcolo i valori reali e immaginari e li inserisco nell'oggetto val
        val.setComplex(Math.sqrt(abs)*(Math.sin(arg/2)));
        val.setReal(Math.round(val.getReal()*10000)/10000.0);
        val.setComplex(Math.round(val.getComplex()*10000)/10000.0);
        
        }
      
        return val;

    }
     
}
