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
            
            Complex res = new Complex(A*C - B*D, A*D - B*C);
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
     
}
