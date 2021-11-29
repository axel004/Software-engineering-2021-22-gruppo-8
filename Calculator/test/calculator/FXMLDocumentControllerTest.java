/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package calculator;

import org.junit.*;
import static org.junit.Assert.*;



/**
 *
 * @author paola
 */
public class FXMLDocumentControllerTest {
    
    /**
     * Test of checkComplex method, of class FXMLDocumentController.
     */
    @Test
    public void testCheckComplex() {
        FXMLDocumentController check = new FXMLDocumentController();
        check.checkComplex("5+6j");
        check.checkComplex("-5-6j");
        check.checkComplex("-5+6j");
        check.checkComplex("5-6j");
        check.checkComplex("5");
        check.checkComplex("-5");
        check.checkComplex("0-0j");
        check.checkComplex("-0+0j");
        check.checkComplex("0");
        check.checkComplex("3j");
        check.checkComplex("-3j");
    }
    
    /**
     * Test of checkComplex method, of class FXMLDocumentController.
     */
    @Test(expected=NumberFormatException.class)
    public void checkExpectedException() {
        FXMLDocumentController check = new FXMLDocumentController();
        check.checkComplex("pp");
        check.checkComplex("5+6i");
        check.checkComplex("-5-6i");
        check.checkComplex("-5+6");
        check.checkComplex("");
    }
    
}
