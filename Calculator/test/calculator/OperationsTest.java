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
    
     @Test
    public void DifferenzaTest() {
        System.out.println("differenza");
        Operations instance = new Operations();
        assertEquals(new Complex(-5,5), instance.differenza(new Complex(5,8), new Complex(10,3))); //a+jb - a+jb
        assertEquals(new Complex(16,-23), instance.differenza(new Complex(6,-20), new Complex(-10,3)));//a-jb - -a+jb
        assertEquals(new Complex(-10,-12), instance.differenza(new Complex(0,-9), new Complex(10,3)));//-jb - a+jb
        assertEquals(new Complex(-3,0), instance.differenza(new Complex(-13,8), new Complex(-10,8)));//-a+jb - -a+jb
        assertEquals(new Complex(-13,8), instance.differenza(new Complex(-13,8), new Complex(0,0)));//differenza con numero neutro
        assertEquals(new Complex(-13,0), instance.differenza(new Complex(-13,8), new Complex(0,8)));//-a+jb - jb
        assertEquals(new Complex(0,0), instance.differenza(new Complex(5,8), new Complex(5,8)));//differenza tra due nuemri uguali
        assertEquals(new Complex(-95,-3), instance.differenza(new Complex(5,0), new Complex(100,3)));//a - a+jb
        assertEquals(new Complex(-5,1.0), instance.differenza(new Complex(5.3,0.9), new Complex(10.3,-0.1)));//differenza con valori decimali
        assertEquals(new Complex(-5.117,1.142), instance.differenza(new Complex(5.333,0.985), new Complex(10.45,-0.157)));
        assertEquals(new Complex(0,0), instance.differenza(new Complex(0,0), new Complex(0,0)));//differenza tra zero
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of radice method, of class Operations.
     */
    @Test
    public void RadiceTest() {
        System.out.println("radice");
        Operations instance = new Operations();
        assertEquals(new Complex(2,0), instance.radice(new Complex(4,0)));//rad numero reale
        assertEquals(new Complex(0,2), instance.radice(new Complex(-4,0)));//rad numero reale negativo
        assertEquals(new Complex(0,0), instance.radice(new Complex(0,0)));//rad di zer0
        assertEquals(new Complex(2.6864,1.489), instance.radice(new Complex(5,8)));//rad di un numero complesso
        assertEquals(new Complex(1.28,0.8594), instance.radice(new Complex(0.9,2.2)));//rad di un nnumero complesso decimale
        assertEquals(new Complex(-3.9422,10.2733), instance.radice(new Complex(-90,-81)));//rad di un  numero complesso negativo
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of division method, of class Operations.
     */
    @Test
    public void testDiv(){
        System.out.println("divisione test");
        Operations instance = new Operations();
        assertEquals(new Complex(1,0), instance.divisione(new Complex(2,2), new Complex(2,2)));
        assertEquals(new Complex(-0.7,0.1), instance.divisione(new Complex(-2,1), new Complex(3,-1)));
        assertEquals(new Complex(0,0), instance.divisione(new Complex(0,0), new Complex(2,2)));
        assertEquals(null, instance.divisione(new Complex(0,0), new Complex(0,0))); //forma indeterminata 0/0 --> l'operazione non avviene e ottengo null
        assertEquals(null, instance.divisione(new Complex(-0.5,3.70), new Complex(0,0))); //se il divisore è 0+0j allora l'operazione non avviene e ottengo null
        assertEquals(new Complex(0,1), instance.divisione(new Complex(3,3), new Complex(3,-3)));
    }
    
    @Test
    public void testClear() {
        System.out.println("*** TEST clear() ***");
        Operations op = new Operations();
        StackCalc stack = new StackCalc();
        Complex value = new Complex(18,32);
        Complex value2 = new Complex(3,43);
        // test con stack vuoto
        op.clear(stack);
        assertEquals(0,stack.size());
        // test con stack non vuoto
        stack.push(value);
        stack.push(value2);
        op.clear(stack);
        assertEquals(0,stack.size());
    }
    
}
