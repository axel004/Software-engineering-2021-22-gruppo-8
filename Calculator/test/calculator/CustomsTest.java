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
        boolean result = instance.crea(nomeOperazione);
        assertEquals(expResult, result);

        expResult = false;
        result = instance.crea(nomeOperazione);
        assertEquals(expResult, result);

        expResult = false;
        result = instance.crea("+");
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
        instance.crea(nomeOperazione);
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione), "+");

        nomeOperazione = "somma";
        operazione = "+";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione), "+");

        nomeOperazione = "somma";
        operazione = "+,-,+-";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione), "+,-,+-");

        nomeOperazione = "somma";
        operazione = "+,-,+-";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione), "+,-,+-");

        nomeOperazione = "somma";
        operazione = "+,+-,-";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione), "+,+-,-");

        nomeOperazione = "differenza";
        operazione = "+,+-,-";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione), null);

        nomeOperazione = "somma";
        operazione = "+,5+5j";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione), "+,5+5j");

        nomeOperazione = "somma";
        operazione = "+,5j";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione), "+,5j");

        nomeOperazione = "somma";
        operazione = "+,5";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione), "+,5");

        nomeOperazione = "somma";
        operazione = "+,<t";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione), "+,<t");

        nomeOperazione = "somma";
        operazione = "+,>t";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione), "+,>t");

        nomeOperazione = "somma";
        operazione = "+,-t";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione), "+,-t");

        nomeOperazione = "somma";
        operazione = "+,+t";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione), "+,+t");

        nomeOperazione = "somma";
        operazione = "+,>z";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione), "+,>z");

        nomeOperazione = "somma";
        operazione = "+,GGG";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione), "+,>z");

        nomeOperazione = "somma";
        operazione = "+,GG";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione), "+,>z");

        nomeOperazione = "somma";
        operazione = "+,>GG";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione), "+,>z");

        nomeOperazione = "somma";
        operazione = "+,>A";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione), "+,>z");

        nomeOperazione = "somma";
        operazione = "+,>gg";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione), "+,>z");
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
        instance.istanziaNuovaOperazione(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione), "+,+-,-");

        nomeOperazione = "somma";
        operazione = "+,+-,-";
        instance.istanziaNuovaOperazione(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione), "+,+-,-");

        nomeOperazione = "differenza";
        operazione = "+,+-,-";
        instance.istanziaNuovaOperazione(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione), "+,+-,-");

        nomeOperazione = "doppiasomma";
        operazione = "+,+";
        instance.istanziaNuovaOperazione(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione), "+,+");

        nomeOperazione = "doppio";
        operazione = "+,gagag";
        instance.istanziaNuovaOperazione(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione), null);

        nomeOperazione = "doppio";
        operazione = "+,+";
        instance.istanziaNuovaOperazione(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione), "+,+");

        nomeOperazione = "doppio";
        operazione = "+,5+5j";
        instance.istanziaNuovaOperazione(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione), "+,+");

        nomeOperazione = "doppio";
        operazione = "+,5j";
        instance.istanziaNuovaOperazione(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione), "+,+");

        nomeOperazione = "doppio";
        operazione = "+,5";
        instance.istanziaNuovaOperazione(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione), "+,+");
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
        c.istanziaNuovaOperazione("provaComplex", "5-7j,+");
        c.istanziaNuovaOperazione("provaStack", "clear,6+1j");
        c.istanziaNuovaOperazione("provaVariable", "8-2j,>g");
        c.istanziaNuovaOperazione("provaCustom", "provaStack,4,+");
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
        c.istanziaNuovaOperazione("ProvaOperazioni", "+,+-,-");
        c.executeCustom("ProvaOperazioni");
        assertEquals(new Complex(6, 0), stack.peek());
        stack.push(val1);
        stack.push(val1);
        stack.push(val3);
        stack.push(val2);
        c.istanziaNuovaOperazione("ProvaOperazioni2", "+,-,clear");
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
        c.istanziaNuovaOperazione("ProvaOperazioni", "+,+-,-");
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
        c.istanziaNuovaOperazione("ProvaOperazioni", ">a,>b,<a");
        c.executeCustom("ProvaOperazioni");
    }
    
    @Test
    public void testLoadFromFile() {
        System.out.println("*** LoadFromFile() test ***");
        OperatorFactory of = new OperatorFactory();
        Customs instance = new Customs(of);
        File file = new File("test/calculator/test.txt");
        // verifico che il file esista
        assertEquals(true, file.exists());
        // verifico che tutte le operazioni siano state inserite con il giusto nome
        // e la giusta sequenza associata
        instance.loadFromFile(file);
        String[] str = instance.toString().split("\\n");
        for (String s : str) {
            String opName = s.split(":")[0];
            String opSeq = s.split(":")[1].trim();
            assertEquals(opSeq, instance.getOperazione(opName));
        }
        // verifico che un file non esistente restituisca null
        File fileNotExists = new File("test/calculator/thisNotExists.txt");
        assertEquals(false, fileNotExists.exists());
        assertEquals(null, instance.loadFromFile(fileNotExists));
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

        instance.istanziaNuovaOperazione("addizione","+");
        instance.istanziaNuovaOperazione("moltiplicazione", "addizione,*");
        instance.istanziaNuovaOperazione("divisione", "/");
        instance.istanziaNuovaOperazione("radice", "addizione,sqrt");
        instance.istanziaNuovaOperazione("somma","+,-,moltiplicazione");
        
        instance.editCustomOperation("divisione", "+,-");
        assertEquals("+,-",instance.getOperazione("divisione")); //controllo il corretto funzionamento
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
        assertEquals("somma,radice,sqrt,swap",instance.getOperazione("addizione"));
    
        try {
          instance.editCustomOperation("moltiplicazione", "dup,radice,sqrt,swap"); //controllo il corretto funzionamento del lancio dell'eccezione
        } catch (EditCustomOpException e) {
          thrown = true;
          assertEquals("[somma]",e.getMessage());
        }
        assertTrue(thrown);
        assertEquals("dup,radice,sqrt,swap",instance.getOperazione("moltiplicazione"));
    }
    
    /**
     * Test of EditCostumOp method, of class Customs.
     */
    @Test(expected = EditCustomOpException.class)
    public void checkEditCostumOpException1() throws Exception {
        System.out.println("checkEditCostumOpException1 test\n");
        OperatorFactory of = new OperatorFactory();
        Customs instance = new Customs(of);
        instance.istanziaNuovaOperazione("addizione","+");
        instance.istanziaNuovaOperazione("moltiplicazione", "addizione,*");
        instance.istanziaNuovaOperazione("divisione", "/");
        instance.istanziaNuovaOperazione("radice", "addizione,sqrt");
        instance.istanziaNuovaOperazione("somma","+,-,moltiplicazione");
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
        instance.istanziaNuovaOperazione("addizione","+");
        instance.istanziaNuovaOperazione("moltiplicazione", "addizione,*");
        instance.istanziaNuovaOperazione("divisione", "/");
        instance.istanziaNuovaOperazione("radice", "addizione,sqrt");
        instance.istanziaNuovaOperazione("somma","+,-,moltiplicazione");
        instance.editCustomOperation("addizione", "somma,radice,sqrt,swap"); //controllo il corretto funzionamento del lancio dell'eccezione
        
    }
    
    @Test
    public void testDeleteCostum() throws Exception {
        System.out.println("test EditCostumOperation\n");
        OperatorFactory of = new OperatorFactory();
        Customs instance = new Customs(of);
        boolean thrown = false;

        instance.istanziaNuovaOperazione("addizione", "+");
        instance.istanziaNuovaOperazione("moltiplicazione", "addizione,*");
        instance.istanziaNuovaOperazione("divisione", "/");
        instance.istanziaNuovaOperazione("radice", "addizione,sqrt");
        instance.istanziaNuovaOperazione("somma", "+,-,moltiplicazione");
        
        try {
            assertEquals(false, instance.deleteCustom("addizione"));//controllo il corretto funzionamento

        } catch (DeleteCostumOpException e) {
            assertEquals(null, instance.getOperazione("addizione"));
            assertEquals(null, instance.getOperazione("radice"));
        }

        assertTrue(instance.deleteCustom("divisione"));
        assertEquals(null, instance.getOperazione("divisione")); //controllo che la divisione sia stata correttamente cancellata
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
        instance.istanziaNuovaOperazione("addizione", "+");
        instance.istanziaNuovaOperazione("moltiplicazione", "addizione,*");
        instance.istanziaNuovaOperazione("divisione", "/");
        instance.istanziaNuovaOperazione("radice", "addizione,sqrt");
        instance.istanziaNuovaOperazione("somma", "+,-,moltiplicazione");
        assertEquals(false, instance.deleteCustom("addizione")); //controllo il corretto funzionamento del lancio dell'eccezione

    }
}
