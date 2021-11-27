/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;



import java.lang.reflect.Executable;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Alberto
 */
public class OperationsTest {
    
    /**
     * Test of sum method, of class Operations.
     */
    @Test
    public void testSum() {
         System.out.println("sum test\n");
        
        // TODO review the generated test code and remove the default call to fail
        
        Operations operation = new Operations();
        StackCalc stacc = new StackCalc();
        
        Complex c1 = new Complex(1,2);
        Complex c2 = new Complex(4,2);
        Complex c3 = new Complex(45,5);
        Complex c4 = new Complex(4.6,22);
        stacc.push(c1);
        stacc.push(c2);
        stacc.push(c3);
        stacc.push(c4);
        
        Complex num2 = null;
        Complex num1 = null;
        Complex expResult;
        
       
        
        num2 = stacc.pop();
        if(num2!=null){
            num1 = stacc.pop();
            if(num1!=null){
                stacc.push(operation.sum(num1, num2));
                expResult = new Complex(49.6,27);
                assertEquals(expResult, operation.sum(num1, num2));
            }
            else{
                stacc.push(num2);
            }
        }
        
        num2 = stacc.pop();
        if(num2!=null){
            num1 = stacc.pop();
            if(num1!=null){
                stacc.push(operation.sum(num1, num2));
                expResult = new Complex(53.6,29);
                assertEquals(expResult, operation.sum(num1, num2));
            }
            else{
                stacc.push(num2);
            }
        }
        
        num2 = stacc.pop();
        if(num2!=null){
            num1 = stacc.pop();
            if(num1!=null){
                stacc.push(operation.sum(num1, num2));
                expResult = new Complex(54.6,31);
                assertEquals(expResult, operation.sum(num1, num2));
            }
            else{
                stacc.push(num2);
            }
        }
        
        num2 = stacc.pop();
        if(num2!=null){
            num1 = stacc.pop();
            if(num1!=null){
                stacc.push(operation.sum(num1, num2));
                expResult = new Complex(54.6,31);
                assertEquals(expResult, operation.sum(num1, num2));
            }
            else{
                stacc.push(num2);
            }
        }
        
        c1 = new Complex(-2,11);
        stacc.push(c1);
        c1 = new Complex(5,-1);
        stacc.push(c1);
        c1 = new Complex(-9,-6);
        stacc.push(c1);
        
        c1 = new Complex(0,0);
        stacc.push(c1);
        c1 = new Complex(1,0);
        stacc.push(c1);
        c1 = new Complex(-1,0);
        stacc.push(c1);
        c1 = new Complex(0,-1);
        stacc.push(c1);
        c1 = new Complex(0,1);
        stacc.push(c1);
        
        num2 = stacc.pop();
        if(num2!=null){
            num1 = stacc.pop();
            if(num1!=null){
                stacc.push(operation.sum(num1, num2));
                expResult = new Complex(0,0);
                assertEquals(expResult, operation.sum(num1, num2));
            }
            else{
                stacc.push(num2);
            }
        }
        
        num2 = stacc.pop();
        if(num2!=null){
            num1 = stacc.pop();
            if(num1!=null){
                stacc.push(operation.sum(num1, num2));
                expResult = new Complex(-1,0);
                assertEquals(expResult, operation.sum(num1, num2));
            }
            else{
                stacc.push(num2);
            }
        }
        
        num2 = stacc.pop();
        if(num2!=null){
            num1 = stacc.pop();
            if(num1!=null){
                stacc.push(operation.sum(num1, num2));
                expResult = new Complex(0,0);
                assertEquals(expResult, operation.sum(num1, num2));
            }
            else{
                stacc.push(num2);
            }
        }
        
        num2 = stacc.pop();
        if(num2!=null){
            num1 = stacc.pop();
            if(num1!=null){
                stacc.push(operation.sum(num1, num2));
                expResult = new Complex(0,0);
                assertEquals(expResult, operation.sum(num1, num2));
            }
            else{
                stacc.push(num2);
            }
        }
        
        num2 = stacc.pop();
        if(num2!=null){
            num1 = stacc.pop();
            if(num1!=null){
                stacc.push(operation.sum(num1, num2));
                expResult = new Complex(-9,-6);
                assertEquals(expResult, operation.sum(num1, num2));
            }
            else{
                stacc.push(num2);
            }
        }
        
        num2 = stacc.pop();
        if(num2!=null){
            num1 = stacc.pop();
            if(num1!=null){
                stacc.push(operation.sum(num1, num2));
                expResult = new Complex(-4,-7);
                assertEquals(expResult, operation.sum(num1, num2));
            }
            else{
                stacc.push(num2);
            }
        }
        
        num2 = stacc.pop();
        if(num2!=null){
            num1 = stacc.pop();
            if(num1!=null){
                stacc.push(operation.sum(num1, num2));
                expResult = new Complex(-6,4);
                assertEquals(expResult, operation.sum(num1, num2));
            }
            else{
                stacc.push(num2);
            }
        }
        
        num2 = stacc.pop();
        if(num2!=null){
            num1 = stacc.pop();
            if(num1!=null){
                stacc.push(operation.sum(num1, num2));
                expResult = new Complex(48.6,35);
                assertEquals(expResult, operation.sum(num1, num2));
            }
            else{
                stacc.push(num2);
            }
        }
        
        c1 = new Complex(4.6,-7.1);
        stacc.push(c1);
        c1 = new Complex(1.5,6.6);
        stacc.push(c1);
        num2 = stacc.pop();
        if(num2!=null){
            num1 = stacc.pop();
            if(num1!=null){
                stacc.push(operation.sum(num1, num2));
                expResult = new Complex(6.1,-0.5);
                assertEquals(expResult, operation.sum(num1, num2));
            }
            else{
                stacc.push(num2);
            }
        }        
    }
    
    @Test
    public void testMultiply() {
        System.out.print("multiply test");
        
        // TODO review the generated test code and remove the default call to fail
        
        Operations operation = new Operations();
        StackCalc stacc = new StackCalc();
        
        Complex c1 = new Complex(1,2);
        Complex c2 = new Complex(4,2);
        Complex c3 = new Complex(45,5);
        Complex c4 = new Complex(4.6,22);
        stacc.push(c1);
        stacc.push(c2);
        stacc.push(c3);
        stacc.push(c4);
        
        Complex num2 = null;
        Complex num1 = null;
        Complex expResult;
        
       
        
        num2 = stacc.pop();
        if(num2!=null){
            num1 = stacc.pop();
            if(num1!=null){
                stacc.push(operation.multiply(num1, num2));
                expResult = new Complex(97,1013);
                assertEquals(expResult, operation.multiply(num1, num2));
            }
            else{
                stacc.push(num2);
            }
        }
        
        num2 = stacc.pop();
        if(num2!=null){
            num1 = stacc.pop();
            if(num1!=null){
                stacc.push(operation.multiply(num1, num2));
                expResult = new Complex(-1638,4246);
                assertEquals(expResult, operation.multiply(num1, num2));
            }
            else{
                stacc.push(num2);
            }
        }
        
        num2 = stacc.pop();
        if(num2!=null){
            num1 = stacc.pop();
            if(num1!=null){
                stacc.push(operation.multiply(num1, num2));
                expResult = new Complex(-10130,970);
                assertEquals(expResult, operation.multiply(num1, num2));
            }
            else{
                stacc.push(num2);
            }
        }
        //va a vuoto per questo
        num2 = stacc.pop();
        if(num2!=null){
            num1 = stacc.pop();
            if(num1!=null){
                stacc.push(operation.multiply(num1, num2));
                expResult = new Complex(54.6,31);
                assertEquals(expResult, operation.multiply(num1, num2));
            }
            else{
                stacc.push(num2);
            }
        }
        
        c1 = new Complex(-2,11);
        stacc.push(c1);
        c1 = new Complex(5,-1);
        stacc.push(c1);
        c1 = new Complex(-9,-6);
        stacc.push(c1);
        
        c1 = new Complex(0,0);
        stacc.push(c1);
        c1 = new Complex(1,0);
        stacc.push(c1);
        c1 = new Complex(-1,0);
        stacc.push(c1);
        c1 = new Complex(0,-1);
        stacc.push(c1);
        c1 = new Complex(0,1);
        stacc.push(c1);
        
        num2 = stacc.pop();
        if(num2!=null){
            num1 = stacc.pop();
            if(num1!=null){
                stacc.push(operation.multiply(num1, num2));
                expResult = new Complex(1,0);
                assertEquals(expResult, operation.multiply(num1, num2));
            }
            else{
                stacc.push(num2);
            }
        }
        
        num2 = stacc.pop();
        if(num2!=null){
            num1 = stacc.pop();
            if(num1!=null){
                stacc.push(operation.multiply(num1, num2));
                expResult = new Complex(-1,0);
                assertEquals(expResult, operation.multiply(num1, num2));
            }
            else{
                stacc.push(num2);
            }
        }
        
        num2 = stacc.pop();
        if(num2!=null){
            num1 = stacc.pop();
            if(num1!=null){
                stacc.push(operation.multiply(num1, num2));
                expResult = new Complex(-1,0);
                assertEquals(expResult, operation.multiply(num1, num2));
            }
            else{
                stacc.push(num2);
            }
        }
        
        num2 = stacc.pop();
        if(num2!=null){
            num1 = stacc.pop();
            if(num1!=null){
                stacc.push(operation.multiply(num1, num2));
                expResult = new Complex(0,0);
                assertEquals(expResult, operation.multiply(num1, num2));
            }
            else{
                stacc.push(num2);
            }
        }
        
        num2 = stacc.pop();
        if(num2!=null){
            num1 = stacc.pop();
            if(num1!=null){
                stacc.push(operation.multiply(num1, num2));
                expResult = new Complex(0,0);
                assertEquals(expResult, operation.multiply(num1, num2));
            }
            else{
                stacc.push(num2);
            }
        }
        ///////////////////////////////////////////////////////////////////////////////////////
        num2 = stacc.pop();
        c1 = new Complex(-9,-6);
        stacc.push(c1);
        
        num2 = stacc.pop();
        if(num2!=null){
            num1 = stacc.pop();
            if(num1!=null){
                stacc.push(operation.multiply(num1, num2));
                expResult = new Complex(-51,-21);
                assertEquals(expResult, operation.multiply(num1, num2));
            }
            else{
                stacc.push(num2);
            }
        }
        
        num2 = stacc.pop();
        if(num2!=null){
            num1 = stacc.pop();
            if(num1!=null){
                stacc.push(operation.multiply(num1, num2));
                expResult = new Complex(333,-519);
                assertEquals(expResult, operation.multiply(num1, num2));
            }
            else{
                stacc.push(num2);
            }
        }
        
        num2 = stacc.pop();
        if(num2!=null){
            num1 = stacc.pop();
            if(num1!=null){
                stacc.push(operation.multiply(num1, num2));
                expResult = new Complex(-2869860,5580480);
                assertEquals(expResult, operation.multiply(num1, num2));
            }
            else{
                stacc.push(num2);
            }
        }
        //test decimali
        
        c1 = new Complex(4.6,-7.1);
        stacc.push(c1);
        c1 = new Complex(1.5,6.6);
        stacc.push(c1);
        num2 = stacc.pop();
        if(num2!=null){
            num1 = stacc.pop();
            if(num1!=null){
                stacc.push(operation.multiply(num1, num2));
                expResult = new Complex(53.76,19.71);
                assertEquals(expResult, operation.multiply(num1, num2));
            }
            else{
                stacc.push(num2);
            }
        }   
        
        c1 = new Complex(1.5,6.6);
        stacc.push(c1);
        num2 = stacc.pop();
        if(num2!=null){
            num1 = stacc.pop();
            if(num1!=null){
                stacc.push(operation.multiply(num1, num2));
                expResult = new Complex(-49.446,384.381);
                assertEquals(expResult, operation.multiply(num1, num2));
            }
            else{
                stacc.push(num2);
            }
        }
        
        c1 = new Complex(1.5,6.6);
        stacc.push(c1);
        num2 = stacc.pop();
        if(num2!=null){
            num1 = stacc.pop();
            if(num1!=null){
                stacc.push(operation.multiply(num1, num2));
                expResult = new Complex(-2611.0836,250.2279);
                assertEquals(expResult, operation.multiply(num1, num2));
            }
            else{
                stacc.push(num2);
            }
        }
    }
    
    @Test
    public void testReverseSign() {
        Operations op = new Operations();
        // a
        assertEquals(new Complex(-2,0),op.reverseSign(new Complex(2,0)));
        // -a
        assertEquals(new Complex(2,0),op.reverseSign(new Complex(-2,0)));
        // a+jb
        assertEquals(new Complex(2,2),op.reverseSign(new Complex(-2,-2)));
        // a-jb
        assertEquals(new Complex(2,-2),op.reverseSign(new Complex(-2,2)));
        // -a+jb
        assertEquals(new Complex(-2,2),op.reverseSign(new Complex(2,-2)));
        // -a-jb
        assertEquals(new Complex(-2,-2),op.reverseSign(new Complex(2,2)));
        // jb
        assertEquals(new Complex(0,2),op.reverseSign(new Complex(0,-2)));
        // -jb
        assertEquals(new Complex(0,-2),op.reverseSign(new Complex(0,2)));
    }
    
}
