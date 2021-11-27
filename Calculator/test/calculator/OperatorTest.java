/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package calculator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Asus
 */
public class OperatorTest {
    
    public OperatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isoperator method, of class Operator.
     */
    @Test
    public void testIsoperator() {
        System.out.println("isoperator");
        Complex val1=new Complex(5,10);
        Complex val2=new Complex(2,10);
        Complex val3=new Complex(9,10);
        StackCalc e = new StackCalc();
        e.push(val3);
        e.push(val2);
        e.push(val1);
        e.push(val3);
        e.push(val2);
        e.push(val1);
        e.push(val3);
        e.push(val2);
        e.push(val1);
        e.push(val3);
        e.push(val2);
        e.push(val1);
        e.push(val3);
        e.push(val2);
        e.push(val1);
        e.push(val3);
        e.push(val2);
        e.push(val1);
        
        Operator instance = new Operator();
        try{
            assertEquals(false,instance.isoperator("ciao", e));
            assertEquals(true,instance.isoperator("+", e));
            assertEquals(true,instance.isoperator("/", e));
            assertEquals(true,instance.isoperator("-", e));
            assertEquals(true,instance.isoperator("*", e));
            assertEquals(true,instance.isoperator("+-", e));
            assertEquals(true,instance.isoperator("sqrt", e)); 
        }
        catch(Exception a){
                System.out.print("isoperator error");
        }
    }
}
