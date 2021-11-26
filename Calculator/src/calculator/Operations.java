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
        return new Complex(value.getReal()*-1, value.getComplex()*-1);
    }
     
}
