/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author paola
 */
public class Complex {
    private double real;
    private double complex;

    public Complex(double real, double complex) {
        this.real = real;
        this.complex=complex;
    }

    public double getReal() {
        return real;
    }

    public double getComplex() {
        return complex;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setComplex(double complex) {
        this.complex = complex;
    }
    @Override 
    public String toString(){
        if(this.getComplex()>=0){
            String string = new String(this.getReal()+" + "+this.getComplex()+"j"+"\n");
            return string;
        }
        else{
            String string = new String(this.getReal()+" "+this.getComplex()+"j"+"\n");
            return string;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Complex other = (Complex) obj;
        if (Double.doubleToLongBits(this.real) != Double.doubleToLongBits(other.real)) {
            return false;
        }
        if (Double.doubleToLongBits(this.complex) != Double.doubleToLongBits(other.complex)) {
            return false;
        }
        return true;
    }
    
    
}
