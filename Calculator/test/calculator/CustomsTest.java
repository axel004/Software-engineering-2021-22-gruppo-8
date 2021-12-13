/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import Exception.DeleteCostumOpException;
import Exception.VariableException;
import Exception.LessArgException;
import Exception.EditCustomOpException;
import Exception.CustomException;
import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alberto
 */
public class CustomsTest {

    /**
     * Test of crea method, of class Customs.
     */
    @Test
    public void testCrea() {
        System.out.println("crea test\n");
        String nomeOperazione = "somma";
        OperatorFactory of = new OperatorFactory();
        Customs instance = new Customs(of);
        boolean expResult = true;
        boolean result = instance.create(nomeOperazione);
        assertEquals(expResult, result);

        expResult = false;
        result = instance.create(nomeOperazione);
        assertEquals(expResult, result);

        expResult = false;
        result = instance.create("+");
        assertEquals(expResult, result);
    }

    /**
     * Test of modifica method, of class Customs.
     */
    @Test
    public void testModifica() {
        System.out.println("modifica test\n");
        String nomeOperazione = "somma";
        String operazione = "+";
        OperatorFactory of = new OperatorFactory();
        Customs instance = new Customs(of);
        instance.create(nomeOperazione);
        instance.modify(nomeOperazione, operazione);
        assertEquals(instance.getOperation(nomeOperazione), "+");

        nomeOperazione = "somma";
        operazione = "+";
        instance.modify(nomeOperazione, operazione);
        assertEquals(instance.getOperation(nomeOperazione), "+");

        nomeOperazione = "somma";
        operazione = "+,-,+-";
        instance.modify(nomeOperazione, operazione);
        assertEquals(instance.getOperation(nomeOperazione), "+,-,+-");

        nomeOperazione = "somma";
        operazione = "+,-,+-";
        instance.modify(nomeOperazione, operazione);
        assertEquals(instance.getOperation(nomeOperazione), "+,-,+-");

        nomeOperazione = "somma";
        operazione = "+,+-,-";
        instance.modify(nomeOperazione, operazione);
        assertEquals(instance.getOperation(nomeOperazione), "+,+-,-");

        nomeOperazione = "differenza";
        operazione = "+,+-,-";
        instance.modify(nomeOperazione, operazione);
        assertEquals(instance.getOperation(nomeOperazione), null);

        nomeOperazione = "somma";
        operazione = "+,5+5j";
        instance.modify(nomeOperazione, operazione);
        assertEquals(instance.getOperation(nomeOperazione), "+,5+5j");

        nomeOperazione = "somma";
        operazione = "+,5j";
        instance.modify(nomeOperazione, operazione);
        assertEquals(instance.getOperation(nomeOperazione), "+,5j");

        nomeOperazione = "somma";
        operazione = "+,5";
        instance.modify(nomeOperazione, operazione);
        assertEquals(instance.getOperation(nomeOperazione), "+,5");

        nomeOperazione = "somma";
        operazione = "+,<t";
        instance.modify(nomeOperazione, operazione);
        assertEquals(instance.getOperation(nomeOperazione), "+,<t");

        nomeOperazione = "somma";
        operazione = "+,>t";
        instance.modify(nomeOperazione, operazione);
        assertEquals(instance.getOperation(nomeOperazione), "+,>t");

        nomeOperazione = "somma";
        operazione = "+,-t";
        instance.modify(nomeOperazione, operazione);
        assertEquals(instance.getOperation(nomeOperazione), "+,-t");

        nomeOperazione = "somma";
        operazione = "+,+t";
        instance.modify(nomeOperazione, operazione);
        assertEquals(instance.getOperation(nomeOperazione), "+,+t");

        nomeOperazione = "somma";
        operazione = "+,>z";
        instance.modify(nomeOperazione, operazione);
        assertEquals(instance.getOperation(nomeOperazione), "+,>z");

        nomeOperazione = "somma";
        operazione = "+,GGG";
        instance.modify(nomeOperazione, operazione);
        assertEquals(instance.getOperation(nomeOperazione), "+,>z");

        nomeOperazione = "somma";
        operazione = "+,GG";
        instance.modify(nomeOperazione, operazione);
        assertEquals(instance.getOperation(nomeOperazione), "+,>z");

        nomeOperazione = "somma";
        operazione = "+,>GG";
        instance.modify(nomeOperazione, operazione);
        assertEquals(instance.getOperation(nomeOperazione), "+,>z");

        nomeOperazione = "somma";
        operazione = "+,>A";
        instance.modify(nomeOperazione, operazione);
        assertEquals(instance.getOperation(nomeOperazione), "+,>z");

        nomeOperazione = "somma";
        operazione = "+,>gg";
        instance.modify(nomeOperazione, operazione);
        assertEquals(instance.getOperation(nomeOperazione), "+,>z");
    }

    /**
     * Test of istanziaNuovaOperazione method, of class Customs.
     */
    @Test
    public void testIstanziaNuovaOperazione() {
        System.out.println("istanziaNuovaOperazione test\n");
        String nomeOperazione = "somma";
        String operazione = "+,+-,-";
        OperatorFactory of = new OperatorFactory();
        Customs instance = new Customs(of);
        instance.createNewOperation(nomeOperazione, operazione);
        assertEquals(instance.getOperation(nomeOperazione), "+,+-,-");

        nomeOperazione = "somma";
        operazione = "+,+-,-";
        instance.createNewOperation(nomeOperazione, operazione);
        assertEquals(instance.getOperation(nomeOperazione), "+,+-,-");

        nomeOperazione = "differenza";
        operazione = "+,+-,-";
        instance.createNewOperation(nomeOperazione, operazione);
        assertEquals(instance.getOperation(nomeOperazione), "+,+-,-");

        nomeOperazione = "doppiasomma";
        operazione = "+,+";
        instance.createNewOperation(nomeOperazione, operazione);
        assertEquals(instance.getOperation(nomeOperazione), "+,+");

        nomeOperazione = "doppio";
        operazione = "+,gagag";
        instance.createNewOperation(nomeOperazione, operazione);
        assertEquals(instance.getOperation(nomeOperazione), null);

        nomeOperazione = "doppio";
        operazione = "+,+";
        instance.createNewOperation(nomeOperazione, operazione);
        assertEquals(instance.getOperation(nomeOperazione), "+,+");

        nomeOperazione = "doppio";
        operazione = "+,5+5j";
        instance.createNewOperation(nomeOperazione, operazione);
        assertEquals(instance.getOperation(nomeOperazione), "+,+");

        nomeOperazione = "doppio";
        operazione = "+,5j";
        instance.createNewOperation(nomeOperazione, operazione);
        assertEquals(instance.getOperation(nomeOperazione), "+,+");

        nomeOperazione = "doppio";
        operazione = "+,5";
        instance.createNewOperation(nomeOperazione, operazione);
        assertEquals(instance.getOperation(nomeOperazione), "+,+");
    }

    /**
     * Test of executeCustom method, of class Customs.
     */
    @Test
    public void testExecuteCustom() throws Exception {
        System.out.println("executeCustom test\n");
        OperatorFactory of = new OperatorFactory();
        Customs c = new Customs(of);
        StackCalc stack = StackCalc.getStack();
        Variable v = Variable.getVariable(stack);
        stack.push(new Complex(3, 0));
        c.createNewOperation("provaComplex", "5-7j,+");
        c.createNewOperation("provaStack", "clear,6+1j");
        c.createNewOperation("provaVariable", "8-2j,>g");
        c.createNewOperation("provaCustom", "provaStack,4,+");
        c.executeCustom("provaComplex");
        assertEquals(new Complex(8, -7), stack.peek());
        c.executeCustom("provaStack");
        assertEquals(new Complex(6, 1), stack.peek());
        c.executeCustom("provaVariable");
        assertEquals(new Complex(8, -2), v.getValue("g"));
        c.executeCustom("provaCustom");
        assertEquals(new Complex(10, 1), stack.peek());
        Complex val1 = new Complex(1, 0);
        Complex val2 = new Complex(2, 0);
        Complex val3 = new Complex(3, 0);
        stack.push(val3);
        stack.push(val2);
        stack.push(val1);
        c.createNewOperation("ProvaOperazioni", "+,+-,-");
        c.executeCustom("ProvaOperazioni");
        assertEquals(new Complex(6, 0), stack.peek());
        stack.push(val1);
        stack.push(val1);
        stack.push(val3);
        stack.push(val2);
        c.createNewOperation("ProvaOperazioni2", "+,-,clear");
        c.executeCustom("ProvaOperazioni2");
        assertEquals(0, stack.size());
    }

    /**
     * Test of executeCustom method, of class Customs.
     */
    @Test(expected = CustomException.class)
    public void checkCustomException() throws Exception {
        System.out.println("checkCustomException test\n");
        OperatorFactory of = new OperatorFactory();
        Customs c = new Customs(of);
        c.executeCustom("provaCustom");
    }
    
    /**
     * Test of executeCustom method, of class Customs.
     */
    @Test(expected = LessArgException.class)
    public void checkLessArgException() throws Exception {
        System.out.println("checkLessArgException test\n");
        OperatorFactory of = new OperatorFactory();
        Customs c = new Customs(of);
        StackCalc stack = StackCalc.getStack();
        Variable v = Variable.getVariable(stack);
        stack.push(new Complex(3, 0));
        c.createNewOperation("ProvaOperazioni", "+,+-,-");
        c.executeCustom("ProvaOperazioni");
    }
    
    /**
     * Test of executeCustom method, of class Customs.
     */
    @Test(expected = VariableException.class)
    public void checkVariableException() throws Exception {
        System.out.println("checkVariableException test\n");
        OperatorFactory of = new OperatorFactory();
        Customs c = new Customs(of);
        StackCalc stack = StackCalc.getStack();
        Variable v = Variable.getVariable(stack);
        stack.push(new Complex(3, 0));
        c.createNewOperation("ProvaOperazioni", ">a,>b,<a");
        c.executeCustom("ProvaOperazioni");
    }
    
    
    /**
     * Test of EditCostumOperation method, of class Customs.
     */
    @Test
    public void testEditCustomOperation() throws Exception{
        System.out.println("test EditCustomOperation\n");
        OperatorFactory of = new OperatorFactory();
        Customs instance = new Customs(of);
        boolean thrown = false;

        instance.createNewOperation("addizione","+");
        instance.createNewOperation("moltiplicazione", "addizione,*");
        instance.createNewOperation("divisione", "/");
        instance.createNewOperation("radice", "addizione,sqrt");
        instance.createNewOperation("somma","+,-,moltiplicazione");
        
        instance.editCustomOperation("divisione", "+,-");
        assertEquals("+,-",instance.getOperation("divisione")); //controllo il corretto funzionamento
        assertEquals(false,instance.editCustomOperation("swap", "+,-")); //controllo il caso in cui l'operazione non è presente
 
        assertEquals(false,instance.editCustomOperation("radice", "*+sqrt")); //controllo il caso in cui l'operazione non è corretta

        assertEquals(false,instance.editCustomOperation("addizione", "potenza,sqrt,swap"));
        
        assertEquals(false,instance.editCustomOperation("divisione", "suop,+,-"));
  
        try {
          instance.editCustomOperation("addizione", "somma,radice,sqrt,swap"); //controllo il corretto funzionamento del lancio dell'eccezione
        } catch (EditCustomOpException e) {
          thrown = true;
          assertEquals("[moltiplicazione, radice]",e.getMessage());
        }
        assertTrue(thrown);
        assertEquals("somma,radice,sqrt,swap",instance.getOperation("addizione"));
    
        try {
          instance.editCustomOperation("moltiplicazione", "dup,radice,sqrt,swap"); //controllo il corretto funzionamento del lancio dell'eccezione
        } catch (EditCustomOpException e) {
          thrown = true;
          assertEquals("[somma]",e.getMessage());
        }
        assertTrue(thrown);
        assertEquals("dup,radice,sqrt,swap",instance.getOperation("moltiplicazione"));
    }
    
    /**
     * Test of EditCostumOp method, of class Customs.
     */
    @Test(expected = EditCustomOpException.class)
    public void checkEditCostumOpException1() throws Exception {
        System.out.println("checkEditCostumOpException1 test\n");
        OperatorFactory of = new OperatorFactory();
        Customs instance = new Customs(of);
        instance.createNewOperation("addizione","+");
        instance.createNewOperation("moltiplicazione", "addizione,*");
        instance.createNewOperation("divisione", "/");
        instance.createNewOperation("radice", "addizione,sqrt");
        instance.createNewOperation("somma","+,-,moltiplicazione");
        instance.editCustomOperation("moltiplicazione", "dup,radice,sqrt,swap"); //controllo il corretto funzionamento del lancio dell'eccezione
        
    }
    
    /**
     * Test of EditCostumOp method, of class Customs.
     */
    @Test(expected = EditCustomOpException.class)
    public void checkEditCostumOpException2() throws Exception {
        System.out.println("checkEditCostumOpException2 test\n");
        OperatorFactory of = new OperatorFactory();
        Customs instance = new Customs(of);
        instance.createNewOperation("addizione","+");
        instance.createNewOperation("moltiplicazione", "addizione,*");
        instance.createNewOperation("divisione", "/");
        instance.createNewOperation("radice", "addizione,sqrt");
        instance.createNewOperation("somma","+,-,moltiplicazione");
        instance.editCustomOperation("addizione", "somma,radice,sqrt,swap"); //controllo il corretto funzionamento del lancio dell'eccezione
        
    }
    
    @Test
    public void testDeleteCostum() throws Exception {
        System.out.println("test EditCostumOperation\n");
        OperatorFactory of = new OperatorFactory();
        Customs instance = new Customs(of);
        boolean thrown = false;

        instance.createNewOperation("addizione", "+");
        instance.createNewOperation("moltiplicazione", "addizione,*");
        instance.createNewOperation("divisione", "/");
        instance.createNewOperation("radice", "addizione,sqrt");
        instance.createNewOperation("somma", "+,-,moltiplicazione");
        
        try {
            assertEquals(false, instance.deleteCustom("addizione"));//controllo il corretto funzionamento

        } catch (DeleteCostumOpException e) {
            assertEquals(null, instance.getOperation("addizione"));
            assertEquals(null, instance.getOperation("radice"));
        }

        assertTrue(instance.deleteCustom("divisione"));
        assertEquals(null, instance.getOperation("divisione")); //controllo che la divisione sia stata correttamente cancellata
        assertEquals(false, instance.deleteCustom("swap")); //controllo il caso in cui l'operazione non è presente
    }
    
    /**
     * Test of deleteCostumOp method, of class Customs.
     */
    @Test(expected = DeleteCostumOpException.class)
    public void checkDeleteCostumOpException() throws Exception {
        System.out.println("checkDeleteCostumOpException test\n");
        OperatorFactory of = new OperatorFactory();
        Customs instance = new Customs(of);
        instance.createNewOperation("addizione", "+");
        instance.createNewOperation("moltiplicazione", "addizione,*");
        instance.createNewOperation("divisione", "/");
        instance.createNewOperation("radice", "addizione,sqrt");
        instance.createNewOperation("somma", "+,-,moltiplicazione");
        assertEquals(false, instance.deleteCustom("addizione")); //controllo il corretto funzionamento del lancio dell'eccezione

    }
}
