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
     
}
