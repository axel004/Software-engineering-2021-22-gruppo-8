/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author HP115-CS0026
 */
public class VariableTest {
    
   
    /**
     * Test of setVariable method, of class Variable.
     */
    @Test
    public void testSetVariable() {
        System.out.println("*** TEST setVariable() ***");
        StackCalc stack = new StackCalc();
        Variable v = new Variable(stack);
        Complex value = new Complex(32,15);
        Complex newValue = new Complex(19,23);
        // caso 1: creo variabile con nome numerico e quindi non ammissibile --> null
        assertEquals(null, v.setVariable("1", value));
        // caso 2: creo variabile con nome ammissibile --> valore
        assertEquals(value, v.setVariable("a", value));  
        assertEquals(value, v.setVariable("b", value));  
        assertEquals(value, v.setVariable("c", value));  
        // caso 3: creo variabile con nome più lungo di un carattere e quindi non ammissibile --> null
        assertEquals(null, v.setVariable("abc", value));
        // caso 4: sovrascrivo variabile --> nuovo valore
        v.setVariable("a",value);
        assertEquals(newValue, v.setVariable("a", newValue));
        // caso 5: creo variabile con nome alfanumerico --> null
        assertEquals(null, v.setVariable("a1", value));  
    }

    /**
     * Test of getVariable method, of class Variable.
     */
    @Test()
    public void testGetVariable() {
        System.out.println("*** TEST getVariable() ***");
        StackCalc stack = new StackCalc();
        Variable v = new Variable(stack);        
  
        Complex value = new Complex(32,15);
        Complex newValue = new Complex(19,23);
        // caso 1: variabile ammissibile non ancora inizializzata
        assertEquals(null, v.getVariable("a"));
        // caso 2: variabile non ammissibile
        assertEquals(null, v.getVariable("ab"));
        // caso 3: variabile ammissibile e inizializzata
        v.setVariable("a", value);
        assertEquals(value, v.getVariable("a"));
        // caso 4: variabili ammissibile e sovrascritta
        v.setVariable("a", newValue);
        assertEquals(newValue, v.getVariable("a")); 
    }
    
    // test null key per getVariable
    @Test(expected = NullPointerException.class)
    public void testGetVariableNullKey() {
        System.out.println("*** TEST getVariable() with null Key ***");
        StackCalc stack = new StackCalc();
        Variable v = new Variable(stack);
        v.getVariable(null);
    }
    
    /**
     * Test of savingInVariable method, of class Variable.
     */
    @Test
    public void testSavingInVariable() throws Exception {
        System.out.println("*** TEST savingInVariable() ***");
        StackCalc stack = new StackCalc();
        Variable v = new Variable(stack);
        Complex value = new Complex(75, 87);
        Complex value2 = new Complex(8, -19);
        Complex value3 = new Complex(100, 30);
        Complex value4 = new Complex(-0.5, -9);
        Complex value5 = new Complex(34, 12);
        
        stack.push(value);
        stack.push(value2);
        stack.push(value3);
        stack.push(value4);
        stack.push(value5);
        v.savingInVariable("a");
        assertEquals(value5, v.getVariable("a"));
        v.savingInVariable("k");
        assertEquals(value4, v.getVariable("k"));
        v.savingInVariable("w");
        assertEquals(value3, v.getVariable("w"));
        v.savingInVariable("z");
        assertEquals(value2, v.getVariable("z"));
    }
    
    /**
     * Test of savingInStack method, of class Variable.
     */
    @Test
    public void testSavingInStack() throws Exception {
        System.out.println("*** TEST savingInStack() ***");
        StackCalc stack = new StackCalc();
        Variable v = new Variable(stack);
        Complex value = new Complex(75, 87);
        Complex value2 = new Complex(8, -19);
        Complex value3 = new Complex(100, 30);
        Complex value4 = new Complex(-0.5, -9);
        Complex value5 = new Complex(34, 12);
        v.setVariable("a", value);
        v.setVariable("m", value2);
        v.setVariable("r", value3);
        v.setVariable("c", value4);
        v.setVariable("h", value5);
        try {
            v.savingInStack("a");
            assertEquals(value, stack.peek());
            v.savingInStack("m");
            assertEquals(value2, stack.peek());
            v.savingInStack("r");
            assertEquals(value3, stack.peek());
            v.savingInStack("c");
            assertEquals(value4, stack.peek());
            v.savingInStack("h");
            assertEquals(value5, stack.peek());
            v.savingInStack("q");
        } catch (Exception e) {
            System.out.println("La variabile non è stata ancora utilizzata");
        }
    }
    
    /**
     * Test of sumVariable method, of class Variable.
     */
    @Test
    public void testSumVariable() throws Exception {
        System.out.println("*** TEST sumVariable() ***");
        StackCalc stack = new StackCalc();
        Variable v = new Variable(stack);
        Operations op = new Operations();
        Complex value = new Complex(0, 0);
        Complex value2 = new Complex(8, -19);
        Complex value3 = new Complex(10, 30);
        Complex value4 = new Complex(-0.5, -9);
        Complex value5 = new Complex(34, 12);
        stack.push(value);
        stack.push(value2);
        stack.push(value3);
        v.setVariable("c", value4);
        v.setVariable("h", value5);
        v.sumVariable("c", op);
        assertEquals(new Complex(9.5, 21), v.getVariable("c"));
        v.sumVariable("h", op);
        assertEquals(new Complex(42, -7), v.getVariable("h"));
    }
    
    /**
     * Test of diffVariable method, of class Variable.
     */
    @Test
    public void testDiffVariable() throws Exception {
        System.out.println("*** TEST diffVariable() ***");
        StackCalc stack = new StackCalc();
        Variable v = new Variable(stack);
        Operations op = new Operations();
        Complex value = new Complex(0, 0);
        Complex value2 = new Complex(8, -19);
        Complex value3 = new Complex(10, 30);
        Complex value4 = new Complex(-0.5, -9);
        Complex value5 = new Complex(34, 12);
        stack.push(value);
        stack.push(value2);
        stack.push(value3);
        v.setVariable("c", value4);
        v.setVariable("h", value5);
        v.diffVariable("c", op);
        assertEquals(new Complex(-10.5, -39), v.getVariable("c"));
        v.diffVariable("h", op);
        assertEquals(new Complex(26, 31), v.getVariable("h"));
    }
}
