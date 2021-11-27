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
public class OperationsTest {
    
   
    /**
     * Test of reverseSign method, of class Operations.
     */
    @Test
    public void testReverseSign() {
        Operations op = new Operations();
        // a
        assertEquals(new Complex(-2,0),op.reverseSign(new Complex(2,0)));
        // -a
        assertEquals(new Complex(2,-0),op.reverseSign(new Complex(-2,0)));
        // a+jb
        assertEquals(new Complex(2,2),op.reverseSign(new Complex(-2,-2)));
        // a-jb
        assertEquals(new Complex(2,-2),op.reverseSign(new Complex(-2,2)));
        // -a+jb
        assertEquals(new Complex(-2,2),op.reverseSign(new Complex(2,-2)));
        // -a-jb
        assertEquals(new Complex(-2,-2),op.reverseSign(new Complex(2,2)));
        // jb
        assertEquals(new Complex(-0,2),op.reverseSign(new Complex(0,-2)));
        // -jb
        assertEquals(new Complex(-0,-2),op.reverseSign(new Complex(0,2)));
    }
    
}
