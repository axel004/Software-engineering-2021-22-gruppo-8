/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.lang.reflect.Executable;
import java.util.Stack;
import org.junit.*;
import static org.junit.Assert.*;


/**
 *
 * @author Alberto
 */
public class StackCalcTest {
    
    public StackCalcTest() {
        System.out.print("Test stack initiated\n");
        this.testVisit();
        this.testDestroy();
    }

    /**
     * Test of visit method, of class StackCalc.
     */
    @Test
    public void testVisit() {
        System.out.println("visit");
        StackCalc instance = new StackCalc();
        Complex[] expResult = null;
        Complex[] result = instance.visit();
        
        //test vuoto
        assertArrayEquals(expResult, result);
        //test un elemento
        Complex c1 = new Complex(1,2);
        instance.push(c1);
        result = instance.visit();
        expResult[0] = c1;
        assertArrayEquals(expResult, result);
        //test più di un elemento
        Complex c2 = new Complex(4,2);
        Complex c3 = new Complex(45,5);
        Complex c4 = new Complex(4.6,22);
        instance.push(c2);
        instance.push(c3);
        instance.push(c4);
        expResult[0] = c4;
        expResult[1] = c3;
        expResult[2] = c2;
        expResult[3] = c1;
        result = instance.visit();
        assertArrayEquals(expResult, result);
        
        fail("Test visit failed.");
        System.out.print("Test visit ended");
    }

    /**
     * Test of destroy method, of class StackCalc.
     */
    @Test
    public void testDestroy() {
        System.out.println("destroy");
        StackCalc instance = new StackCalc();
        Stack expResult = null;
        //test vuoto
        Stack result = instance.destroy();
        assertEquals(expResult, result);
        //test non vuoto
        Complex c1 = new Complex(1,2);
        Complex c2 = new Complex(4,2);
        Complex c3 = new Complex(45,5);
        Complex c4 = new Complex(4.6,22);
        instance.push(c1);
        instance.push(c2);
        instance.push(c3);
        instance.push(c4);
        expResult.push(c1);
        expResult.push(c2);
        expResult.push(c3);
        expResult.push(c4);
        result = instance.destroy();
        assertEquals(expResult, result);
        
        fail("Test destroy failed.");
        System.out.print("Test destroy ended");
    }
    
}
