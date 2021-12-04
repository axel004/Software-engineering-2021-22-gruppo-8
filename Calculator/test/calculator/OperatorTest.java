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
    StackCalc e = StackCalc.getStack();
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
            assertEquals(false,instance.isOperator("ciao", e));
            assertEquals(true,instance.isOperator("+", e));
            assertEquals(true,instance.isOperator("/", e));
            assertEquals(true,instance.isOperator("-", e));
            assertEquals(true,instance.isOperator("*", e));
            assertEquals(true,instance.isOperator("+-", e));
            assertEquals(true,instance.isOperator("sqrt", e));
        }
        catch(Exception a){
                System.out.print("isoperator error");
        }
    }
    
    @Test
    public void testisStackOperator(){
        System.out.println("isStackOperator");
        Complex val1=new Complex(5,10);
        Complex val2=new Complex(2,10);
        Complex val3=new Complex(9,10);
        e.push(val3);
        e.push(val2);
        e.push(val1);
        
        Operator instance = new Operator();
        try{
            assertEquals(false,instance.isStackOperator("+", e));  //operatore errato
            assertEquals(true,instance.isStackOperator("dup", e));  //check dup
            assertEquals(true,instance.isStackOperator("drop", e)); //check drop
            assertEquals(true,instance.isStackOperator("swap", e)); //check swap
            assertEquals(true,instance.isStackOperator("over", e));  //check over 
            assertEquals(false,instance.isStackOperator("ciao", e));  //operatore errato
            assertEquals(true,instance.isStackOperator("clear", e));  //check clear
        }
        catch(Exception a){
                System.out.print("isStackOperator error");
        }
        
    }
    
    @Test
    public void testisVariableOperator(){
        System.out.println("isVariableOperator");
        Complex val1=new Complex(5,10);
        Complex val2=new Complex(2,10);
        Complex val3=new Complex(9,10);
        e.push(val3);
        e.push(val2);
        e.push(val1);
        Variable var = Variable.getVariable(e);
        Complex val4 = new Complex(0,90);
        var.setVariable("x",val4);
        
        Operator instance = new Operator();
        try{
            assertEquals(false,instance.isVariableOperator("+", var));      //operatore troppo piccolo
            assertEquals(true,instance.isVariableOperator(">x", var));      //sovrasscrivo x con il valore in cima allo stack
            assertEquals(true,instance.isVariableOperator("<x", var));      //inserisco il valore associato a x in cima allo stack
            assertEquals(true,instance.isVariableOperator("+x", var));      //sommo il valore associato a x con il valore in cima allp stack
            assertEquals(true,instance.isVariableOperator("-x", var));      //sottraggo il valore associato a x con il valore in cima allp stack
            assertEquals(false,instance.isVariableOperator("<ff", var));    //operatore troppo lungo
            assertEquals(false,instance.isVariableOperator("<F", var));     //operatore errato perchp lettera maiuscola
            assertEquals(false,instance.isVariableOperator("<9", var));     //operatore errato perchè è un numero 
            assertEquals(false,instance.isVariableOperator(" ", var));      //operatore errato 
            assertEquals(true,instance.isVariableOperator(">c", var));      //inserisco nella map chiave c e come valore quello in cima allo stack
            //assertEquals(true,instance.isVariableOperator("<j", var));    //assert per il lancio dell'eccezione
            //assertEquals(true,instance.isVariableOperator("+k", var));
            //assertEquals(true,instance.isVariableOperator("-a", var));
        }
        catch(Exception a){
                System.out.print("isVariableOperator error");
        }      
    }
}
