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
     * Test of pop method, of class StackCalc.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        StackCalc instance = new StackCalc();
        Complex expResult = null;
        Complex result = instance.pop();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of push method, of class StackCalc.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        Complex item = null;
        StackCalc instance = new StackCalc();
        Complex expResult = null;
        Complex result = instance.push(item);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class StackCalc.
     */
    @Test
    public void testDestroy() {
        System.out.println("destroy");
        StackCalc instance = new StackCalc();
        Stack expResult = null;
        Stack result = instance.destroy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
