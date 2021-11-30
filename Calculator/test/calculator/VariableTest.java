/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

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
        Variable v = new Variable();
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
        Variable v = new Variable();
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
        Variable v = new Variable();
        v.getVariable(null);
    }

}
