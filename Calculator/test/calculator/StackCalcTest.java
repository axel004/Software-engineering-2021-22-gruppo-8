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
    StackCalc stack = StackCalc.getStack();
    
    //prima di eseguire qualsiasi metodo, ripristina lo stack
    @Before
    public void setUp() {
        stack.clear();
    }
    /**
     * Test of visit method, of class StackCalc.
     */
    @Test
    public void testVisit() {
        System.out.println("visit test\n");
        
        Complex c1 = new Complex(1,2);
        Complex c2 = new Complex(4,2);
        Complex c3 = new Complex(45,5);
        Complex c4 = new Complex(4.6,22);
        
        stack.push(c1);
        stack.push(c2);
        stack.push(c3);
        stack.push(c4);
        
        Complex c5 = new Complex(-2,11);
        stack.push(c5);
        Complex c6 = new Complex(5,-1);
        stack.push(c6);
        Complex c7 = new Complex(-9,-6);
        stack.push(c7);
        
        Complex c8 = new Complex(0,0);
        stack.push(c8);
        Complex c9 = new Complex(1,0);
        stack.push(c9);
        Complex c10 = new Complex(-1,0);
        stack.push(c10);
        Complex c11 = new Complex(0,-1);
        stack.push(c11);
        Complex c12 = new Complex(0,1);
        stack.push(c12);
        
        Complex[] array = stack.visit();
        Complex[] expResult0 = {c12,c11,c10,c9,c8,c7,c6,c5,c4,c3,c2,c1};
        Assert.assertArrayEquals(expResult0,array);
        
        stack.pop();
        array = stack.visit();
        Complex[] expResult1 = {c11,c10,c9,c8,c7,c6,c5,c4,c3,c2,c1};
        Assert.assertArrayEquals(expResult1,array);
        
        stack.pop();
        array = stack.visit();
        Complex[] expResult2 = {c10,c9,c8,c7,c6,c5,c4,c3,c2,c1};
        Assert.assertArrayEquals(expResult2,array);
        
        stack.pop();
        array = stack.visit();
        Complex[] expResult3 = {c9,c8,c7,c6,c5,c4,c3,c2,c1};
        Assert.assertArrayEquals(expResult3,array);
        
        stack.pop();
        array = stack.visit();
        Complex[] expResult4 = {c8,c7,c6,c5,c4,c3,c2,c1};
        Assert.assertArrayEquals(expResult4,array);
        
        stack.pop();
        array = stack.visit();
        Complex[] expResult5 = {c7,c6,c5,c4,c3,c2,c1};
        Assert.assertArrayEquals(expResult5,array);
        
        stack.pop();
        array = stack.visit();
        Complex[] expResult6 = {c6,c5,c4,c3,c2,c1};
        Assert.assertArrayEquals(expResult6,array);
        
        stack.pop();
        array = stack.visit();
        Complex[] expResult7 = {c5,c4,c3,c2,c1};
        Assert.assertArrayEquals(expResult7,array);
        
        stack.pop();
        array = stack.visit();
        Complex[] expResult8 = {c4,c3,c2,c1};
        Assert.assertArrayEquals(expResult8,array);
    }

    /**
     * Test of destroy method, of class StackCalc.
     */
    @Test
    public void testDestroy() {
        System.out.println("destroy test\n");
        
        Complex c1 = new Complex(1,2);
        Complex c2 = new Complex(4,2);
        Complex c3 = new Complex(45,5);
        Complex c4 = new Complex(4.6,22);
        
        stack.push(c1);
        stack.push(c2);
        stack.push(c3);
        stack.push(c4);
        
        Complex c5 = new Complex(-2,11);
        stack.push(c5);
        Complex c6 = new Complex(5,-1);
        stack.push(c6);
        Complex c7 = new Complex(-9,-6);
        stack.push(c7);
        
        Complex c8 = new Complex(0,0);
        stack.push(c8);
        Complex c9 = new Complex(1,0);
        stack.push(c9);
        Complex c10 = new Complex(-1,0);
        stack.push(c10);
        Complex c11 = new Complex(0,-1);
        stack.push(c11);
        Complex c12 = new Complex(0,1);
        stack.push(c12);
        
        stack.destroy();
        Complex[] array = stack.visit();
        Complex[] expResult0 = null;
        Assert.assertArrayEquals(expResult0,array);
        
        stack.destroy();
        array = stack.visit();
        Complex[] expResult1 = null;
        Assert.assertArrayEquals(expResult1,array);
    }
    
    @Test
    public void testDrop() {
        System.out.println("drop test\n");
        
        Complex c1 = new Complex(1,2);
        Complex c2 = new Complex(4,2);
        Complex c3 = new Complex(45,5);
        Complex c4 = new Complex(4.6,22);
        
        stack.push(c1);
        stack.push(c2);
        stack.push(c3);
        stack.push(c4);
        
        Complex c5 = new Complex(-2,11);
        stack.push(c5);
        Complex c6 = new Complex(5,-1);
        stack.push(c6);
        Complex c7 = new Complex(-9,-6);
        stack.push(c7);
        
        Complex c8 = new Complex(0,0);
        stack.push(c8);
        Complex c9 = new Complex(1,0);
        stack.push(c9);
        Complex c10 = new Complex(-1,0);
        stack.push(c10);
        Complex c11 = new Complex(0,-1);
        stack.push(c11);
        Complex c12 = new Complex(0,1);
        stack.push(c12);
        
        stack.drop();
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
        Assert.assertEquals(string,stack.toString());
        
        stack.drop();
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
        Assert.assertEquals(string,stack.toString());
        
        stack.drop();
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
        Assert.assertEquals(string,stack.toString());
        
        stack.drop();
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
        Assert.assertEquals(string,stack.toString());
        
        stack.drop();
        //System.out.print(stacc.toString());
        string = "[1.0 + 2.0j\n" +
                        ", 4.0 + 2.0j\n" +
                        ", 45.0 + 5.0j\n" +
                        ", 4.6 + 22.0j\n" +
                        ", -2.0 + 11.0j\n" +
                        ", 5.0 -1.0j\n" +
                        ", -9.0 -6.0j\n" +
                        "]";
        Assert.assertEquals(string,stack.toString());
        
        stack.drop();
        //System.out.print(stacc.toString());
        string = "[1.0 + 2.0j\n" +
                        ", 4.0 + 2.0j\n" +
                        ", 45.0 + 5.0j\n" +
                        ", 4.6 + 22.0j\n" +
                        ", -2.0 + 11.0j\n" +
                        ", 5.0 -1.0j\n" +
                        "]";
        Assert.assertEquals(string,stack.toString());
        
        stack.drop();
        //System.out.print(stacc.toString());
        string = "[1.0 + 2.0j\n" +
                        ", 4.0 + 2.0j\n" +
                        ", 45.0 + 5.0j\n" +
                        ", 4.6 + 22.0j\n" +
                        ", -2.0 + 11.0j\n" +
                        "]";
        Assert.assertEquals(string,stack.toString());
        
        stack.drop();
        //System.out.print(stacc.toString());
        string = "[1.0 + 2.0j\n" +
                        ", 4.0 + 2.0j\n" +
                        ", 45.0 + 5.0j\n" +
                        ", 4.6 + 22.0j\n" +
                        "]";
        Assert.assertEquals(string,stack.toString());
        
        stack.drop();
        //System.out.print(stacc.toString());
        string = "[1.0 + 2.0j\n" +
                        ", 4.0 + 2.0j\n" +
                        ", 45.0 + 5.0j\n" +
                        "]";
        Assert.assertEquals(string,stack.toString());
        
        stack.drop();
        //System.out.print(stacc.toString());
        string = "[1.0 + 2.0j\n" +
                        ", 4.0 + 2.0j\n" +
                        "]";
        Assert.assertEquals(string,stack.toString());
        
        
        stack.drop();
        //System.out.print(stacc.toString());
        string = "[1.0 + 2.0j\n" +
                        "]";
        Assert.assertEquals(string,stack.toString());
        
        stack.drop();
        //System.out.print(stacc.toString());
        string = "[" +
                        "]";
        Assert.assertEquals(string,stack.toString());
        
        stack.drop();
        //System.out.print(stacc.toString());
        string = "[" +
                        "]";
        Assert.assertEquals(string,stack.toString());
    }
    
    /*
    * Test of dup method, of class StackCalc.
     */
    @Test
    public void testDup() {
        System.out.println("*** TEST dup() ***");
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
    
        @Test
    public void Testswap(){
        System.out.println("swap test\n");
        
        Complex c1 = new Complex(1,2);
        Complex c2 = new Complex(4,2);
        Complex c3 = new Complex(45,5);
        Complex c4 = new Complex(0,0);
        
        stack.push(c1);
        stack.push(c2);
        stack.push(c3);
        stack.push(c4);
        
        stack.swap();
        //System.out.print(stacc.toString());
        String string = "[1.0 + 2.0j\n" +
                        ", 4.0 + 2.0j\n" +
                        ", 0.0 + 0.0j\n" +
                        ", 45.0 + 5.0j\n" +
                        "]";
        Assert.assertEquals(string,stack.toString());
        
        stack.swap();
        //System.out.print(stacc.toString());
                string = "[1.0 + 2.0j\n" +
                        ", 4.0 + 2.0j\n" +
                        ", 45.0 + 5.0j\n" +
                        ", 0.0 + 0.0j\n" +
                        "]";
        Assert.assertEquals(string,stack.toString());
        
        stack.pop();
        stack.pop();
               
        stack.swap();
                string = "[4.0 + 2.0j\n" +
                        ", 1.0 + 2.0j\n" +
                        "]";
        Assert.assertEquals(string,stack.toString());
   
    }
    
    @Test
    public void testOver(){
        System.out.println("over test\n");
        
        stack.over();
        
        Complex c1 = new Complex(1,2);
        Complex c2 = new Complex(4,2);
        Complex c3 = new Complex(45,5);
        Complex c4 = new Complex(4.6,22);
        
        stack.push(c1);
        stack.push(c2);
        stack.push(c3);
        stack.push(c4);
        
        Complex c5 = new Complex(-2,11);
        stack.push(c5);
        Complex c6 = new Complex(5,-1);
        stack.push(c6);
        Complex c7 = new Complex(-9,-6);
        stack.push(c7);
        
        Complex c8 = new Complex(0,0);
        stack.push(c8);
        Complex c9 = new Complex(1,0);
        stack.push(c9);
        Complex c10 = new Complex(-1,0);
        stack.push(c10);
        Complex c11 = new Complex(0,-1);
        stack.push(c11);
        Complex c12 = new Complex(0,1);
        stack.push(c12);
        
        stack.over();
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
                        ", 0.0 + 1.0j\n" +
                        ", 0.0 -1.0j\n" +
                        "]";
        Assert.assertEquals(string,stack.toString());
    }
}
