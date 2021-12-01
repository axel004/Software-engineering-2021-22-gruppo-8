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
public class StackCalcTest {
    
    /**
     * Test of visit method, of class StackCalc.
     */
    @Test
    public void testVisit() {
        System.out.println("visit test\n");
        StackCalc stacc = new StackCalc();
        
        Complex c1 = new Complex(1,2);
        Complex c2 = new Complex(4,2);
        Complex c3 = new Complex(45,5);
        Complex c4 = new Complex(4.6,22);
        
        stacc.push(c1);
        stacc.push(c2);
        stacc.push(c3);
        stacc.push(c4);
        
        Complex c5 = new Complex(-2,11);
        stacc.push(c5);
        Complex c6 = new Complex(5,-1);
        stacc.push(c6);
        Complex c7 = new Complex(-9,-6);
        stacc.push(c7);
        
        Complex c8 = new Complex(0,0);
        stacc.push(c8);
        Complex c9 = new Complex(1,0);
        stacc.push(c9);
        Complex c10 = new Complex(-1,0);
        stacc.push(c10);
        Complex c11 = new Complex(0,-1);
        stacc.push(c11);
        Complex c12 = new Complex(0,1);
        stacc.push(c12);
        
        Complex[] array = stacc.visit();
        Complex[] expResult0 = {c12,c11,c10,c9,c8,c7,c6,c5,c4,c3,c2,c1};
        Assert.assertArrayEquals(expResult0,array);
        
        stacc.pop();
        array = stacc.visit();
        Complex[] expResult1 = {c11,c10,c9,c8,c7,c6,c5,c4,c3,c2,c1};
        Assert.assertArrayEquals(expResult1,array);
        
        stacc.pop();
        array = stacc.visit();
        Complex[] expResult2 = {c10,c9,c8,c7,c6,c5,c4,c3,c2,c1};
        Assert.assertArrayEquals(expResult2,array);
        
        stacc.pop();
        array = stacc.visit();
        Complex[] expResult3 = {c9,c8,c7,c6,c5,c4,c3,c2,c1};
        Assert.assertArrayEquals(expResult3,array);
        
        stacc.pop();
        array = stacc.visit();
        Complex[] expResult4 = {c8,c7,c6,c5,c4,c3,c2,c1};
        Assert.assertArrayEquals(expResult4,array);
        
        stacc.pop();
        array = stacc.visit();
        Complex[] expResult5 = {c7,c6,c5,c4,c3,c2,c1};
        Assert.assertArrayEquals(expResult5,array);
        
        stacc.pop();
        array = stacc.visit();
        Complex[] expResult6 = {c6,c5,c4,c3,c2,c1};
        Assert.assertArrayEquals(expResult6,array);
        
        stacc.pop();
        array = stacc.visit();
        Complex[] expResult7 = {c5,c4,c3,c2,c1};
        Assert.assertArrayEquals(expResult7,array);
        
        stacc.pop();
        array = stacc.visit();
        Complex[] expResult8 = {c4,c3,c2,c1};
        Assert.assertArrayEquals(expResult8,array);
    }

    /**
     * Test of destroy method, of class StackCalc.
     */
    @Test
    public void testDestroy() {
        System.out.println("destroy test\n");
        StackCalc stacc = new StackCalc();
        
        Complex c1 = new Complex(1,2);
        Complex c2 = new Complex(4,2);
        Complex c3 = new Complex(45,5);
        Complex c4 = new Complex(4.6,22);
        
        stacc.push(c1);
        stacc.push(c2);
        stacc.push(c3);
        stacc.push(c4);
        
        Complex c5 = new Complex(-2,11);
        stacc.push(c5);
        Complex c6 = new Complex(5,-1);
        stacc.push(c6);
        Complex c7 = new Complex(-9,-6);
        stacc.push(c7);
        
        Complex c8 = new Complex(0,0);
        stacc.push(c8);
        Complex c9 = new Complex(1,0);
        stacc.push(c9);
        Complex c10 = new Complex(-1,0);
        stacc.push(c10);
        Complex c11 = new Complex(0,-1);
        stacc.push(c11);
        Complex c12 = new Complex(0,1);
        stacc.push(c12);
        
        stacc.destroy();
        Complex[] array = stacc.visit();
        Complex[] expResult0 = null;
        Assert.assertArrayEquals(expResult0,array);
        
        stacc.destroy();
        array = stacc.visit();
        Complex[] expResult1 = null;
        Assert.assertArrayEquals(expResult1,array);
    }
    
    @Test
    public void testDrop() {
        System.out.println("drop test\n");
        StackCalc stacc = new StackCalc();
        
        Complex c1 = new Complex(1,2);
        Complex c2 = new Complex(4,2);
        Complex c3 = new Complex(45,5);
        Complex c4 = new Complex(4.6,22);
        
        stacc.push(c1);
        stacc.push(c2);
        stacc.push(c3);
        stacc.push(c4);
        
        Complex c5 = new Complex(-2,11);
        stacc.push(c5);
        Complex c6 = new Complex(5,-1);
        stacc.push(c6);
        Complex c7 = new Complex(-9,-6);
        stacc.push(c7);
        
        Complex c8 = new Complex(0,0);
        stacc.push(c8);
        Complex c9 = new Complex(1,0);
        stacc.push(c9);
        Complex c10 = new Complex(-1,0);
        stacc.push(c10);
        Complex c11 = new Complex(0,-1);
        stacc.push(c11);
        Complex c12 = new Complex(0,1);
        stacc.push(c12);
        
        stacc.drop();
        //System.out.print(stacc.toString());
        String string = "[1.0 + 2.0j\n" +
                        ", 4.0 + 2.0j\n" +
                        ", 45.0 + 5.0j\n" +
                        ", 4.6 + 22.0j\n" +
                        ", -2.0 + 11.0j\n" +
                        ", 5.0 -1.0j\n" +
                        ", -9.0 -6.0j\n" +
                        ", 0.0 + 0.0j\n" +
                        ", 1.0 + 0.0j\n" +
                        ", -1.0 + 0.0j\n" +
                        ", 0.0 -1.0j\n" +
                        "]";
        Assert.assertEquals(string,stacc.toString());
        
        stacc.drop();
        //System.out.print(stacc.toString());
        string = "[1.0 + 2.0j\n" +
                        ", 4.0 + 2.0j\n" +
                        ", 45.0 + 5.0j\n" +
                        ", 4.6 + 22.0j\n" +
                        ", -2.0 + 11.0j\n" +
                        ", 5.0 -1.0j\n" +
                        ", -9.0 -6.0j\n" +
                        ", 0.0 + 0.0j\n" +
                        ", 1.0 + 0.0j\n" +
                        ", -1.0 + 0.0j\n" +
                        "]";
        Assert.assertEquals(string,stacc.toString());
        
        stacc.drop();
        //System.out.print(stacc.toString());
        string = "[1.0 + 2.0j\n" +
                        ", 4.0 + 2.0j\n" +
                        ", 45.0 + 5.0j\n" +
                        ", 4.6 + 22.0j\n" +
                        ", -2.0 + 11.0j\n" +
                        ", 5.0 -1.0j\n" +
                        ", -9.0 -6.0j\n" +
                        ", 0.0 + 0.0j\n" +
                        ", 1.0 + 0.0j\n" +
                        "]";
        Assert.assertEquals(string,stacc.toString());
        
        stacc.drop();
        //System.out.print(stacc.toString());
        string = "[1.0 + 2.0j\n" +
                        ", 4.0 + 2.0j\n" +
                        ", 45.0 + 5.0j\n" +
                        ", 4.6 + 22.0j\n" +
                        ", -2.0 + 11.0j\n" +
                        ", 5.0 -1.0j\n" +
                        ", -9.0 -6.0j\n" +
                        ", 0.0 + 0.0j\n" +
                        "]";
        Assert.assertEquals(string,stacc.toString());
        
        stacc.drop();
        //System.out.print(stacc.toString());
        string = "[1.0 + 2.0j\n" +
                        ", 4.0 + 2.0j\n" +
                        ", 45.0 + 5.0j\n" +
                        ", 4.6 + 22.0j\n" +
                        ", -2.0 + 11.0j\n" +
                        ", 5.0 -1.0j\n" +
                        ", -9.0 -6.0j\n" +
                        "]";
        Assert.assertEquals(string,stacc.toString());
        
        stacc.drop();
        //System.out.print(stacc.toString());
        string = "[1.0 + 2.0j\n" +
                        ", 4.0 + 2.0j\n" +
                        ", 45.0 + 5.0j\n" +
                        ", 4.6 + 22.0j\n" +
                        ", -2.0 + 11.0j\n" +
                        ", 5.0 -1.0j\n" +
                        "]";
        Assert.assertEquals(string,stacc.toString());
        
        stacc.drop();
        //System.out.print(stacc.toString());
        string = "[1.0 + 2.0j\n" +
                        ", 4.0 + 2.0j\n" +
                        ", 45.0 + 5.0j\n" +
                        ", 4.6 + 22.0j\n" +
                        ", -2.0 + 11.0j\n" +
                        "]";
        Assert.assertEquals(string,stacc.toString());
        
        stacc.drop();
        //System.out.print(stacc.toString());
        string = "[1.0 + 2.0j\n" +
                        ", 4.0 + 2.0j\n" +
                        ", 45.0 + 5.0j\n" +
                        ", 4.6 + 22.0j\n" +
                        "]";
        Assert.assertEquals(string,stacc.toString());
        
        stacc.drop();
        //System.out.print(stacc.toString());
        string = "[1.0 + 2.0j\n" +
                        ", 4.0 + 2.0j\n" +
                        ", 45.0 + 5.0j\n" +
                        "]";
        Assert.assertEquals(string,stacc.toString());
        
        stacc.drop();
        //System.out.print(stacc.toString());
        string = "[1.0 + 2.0j\n" +
                        ", 4.0 + 2.0j\n" +
                        "]";
        Assert.assertEquals(string,stacc.toString());
        
        
        stacc.drop();
        //System.out.print(stacc.toString());
        string = "[1.0 + 2.0j\n" +
                        "]";
        Assert.assertEquals(string,stacc.toString());
        
        stacc.drop();
        //System.out.print(stacc.toString());
        string = "[" +
                        "]";
        Assert.assertEquals(string,stacc.toString());
        
        stacc.drop();
        //System.out.print(stacc.toString());
        string = "[" +
                        "]";
        Assert.assertEquals(string,stacc.toString());
    }
    
    /*
    * Test of dup method, of class StackCalc.
     */
    @Test
    public void testDup() {
        System.out.println("*** TEST dup() ***");
        StackCalc stack = new StackCalc();
        Complex value = new Complex(0, -7.2);
        Complex value2 = new Complex(3, 9);
        stack.push(value);
        stack.push(value2);
        stack.dup();
        assertEquals(3, stack.size()); //verifico che il metodo dup inserisca un nuovo elemento nello stack senza rimuoverne altri
        assertEquals(new Complex(3, 9), stack.peek()); //verifico che il nuovo elemento inserito in cima allo stack corrisponde all'ultimo elemento inserito prima di quello nuovo
    }
    
    @Test
    public void testClear() {
        System.out.println("*** TEST clear() ***");
        StackCalc stack = new StackCalc();
        Complex value = new Complex(18,32);
        Complex value2 = new Complex(3,43);
        // test con stack vuoto
        stack.clear();
        assertEquals(0,stack.size());
        // test con stack non vuoto
        stack.push(value);
        stack.push(value2);
        stack.clear();
        assertEquals(0,stack.size());
    }
    
}
