/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
        assertEquals(instance.getOperazione(nomeOperazione),"+");
        
        nomeOperazione = "somma";
        operazione = "+";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione),"+");
        
        nomeOperazione = "somma";
        operazione = "+,-,+-";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione),"+,-,+-");
        
        nomeOperazione = "somma";
        operazione = "+,-,+-";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione),"+,-,+-");
        
        nomeOperazione = "somma";
        operazione = "+,+-,-";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione),"+,+-,-");
        
        nomeOperazione = "differenza";
        operazione = "+,+-,-";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione),null);
        
        nomeOperazione = "somma";
        operazione = "+,5+5j";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione),"+,5+5j");
        
        nomeOperazione = "somma";
        operazione = "+,5j";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione),"+,5j");
        
        nomeOperazione = "somma";
        operazione = "+,5";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione),"+,5");
        
        nomeOperazione = "somma";
        operazione = "+,<t";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione),"+,<t");
        
        nomeOperazione = "somma";
        operazione = "+,>t";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione),"+,>t");
        
        nomeOperazione = "somma";
        operazione = "+,-t";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione),"+,-t");
        
        nomeOperazione = "somma";
        operazione = "+,+t";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione),"+,+t");
        
        nomeOperazione = "somma";
        operazione = "+,>z";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione),"+,>z");
        
        nomeOperazione = "somma";
        operazione = "+,GGG";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione),"+,>z");
        
        nomeOperazione = "somma";
        operazione = "+,GG";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione),"+,>z");
        
        nomeOperazione = "somma";
        operazione = "+,>GG";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione),"+,>z");
        
        nomeOperazione = "somma";
        operazione = "+,>A";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione),"+,>z");
        
        nomeOperazione = "somma";
        operazione = "+,>gg";
        instance.modifica(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione),"+,>z");
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
        assertEquals(instance.getOperazione(nomeOperazione),"+,+-,-");
        
        nomeOperazione = "somma";
        operazione = "+,+-,-";
        instance.istanziaNuovaOperazione(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione),"+,+-,-");
        
        nomeOperazione = "differenza";
        operazione = "+,+-,-";
        instance.istanziaNuovaOperazione(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione),"+,+-,-");
        
        nomeOperazione = "doppiasomma";
        operazione = "+,+";
        instance.istanziaNuovaOperazione(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione),"+,+");
        
        nomeOperazione = "doppio";
        operazione = "+,gagag";
        instance.istanziaNuovaOperazione(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione),null);
        
        nomeOperazione = "doppio";
        operazione = "+,+";
        instance.istanziaNuovaOperazione(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione),"+,+");
        
        nomeOperazione = "doppio";
        operazione = "+,5+5j";
        instance.istanziaNuovaOperazione(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione),"+,+");
        
        nomeOperazione = "doppio";
        operazione = "+,5j";
        instance.istanziaNuovaOperazione(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione),"+,+");
        
        nomeOperazione = "doppio";
        operazione = "+,5";
        instance.istanziaNuovaOperazione(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione),"+,+");
    }

    /**
     * Test of executeCustom method, of class Customs.
     */
    @Test
    public void testExecuteCustom() throws Exception{
        System.out.println("executeCustom test\n");
        OperatorFactory of = new OperatorFactory();
        Customs c = new Customs(of);
        StackCalc stack = StackCalc.getStack();
        Variable v = Variable.getVariable(stack);
        stack.push(new Complex(3,0));
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

    }
    
    /**
     * Test of executeCustom method, of class Customs.
     */
    @Test(expected=CustomException.class)
    public void checkExpectedException() throws Exception {
        System.out.println("checkExpectedException test\n");
        OperatorFactory of = new OperatorFactory();
        Customs c = new Customs(of);
        c.istanziaNuovaOperazione("ProvaOperazioni", "+,+-,-");
        c.executeCustom("ProvaOperazioni");
        c.executeCustom("provaCustom");
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
    
    
    @Test
    public void testEditCostumOperation() throws Exception{
        System.out.println("test EditCostumOperation\n");
        OperatorFactory of = new OperatorFactory();
        Customs instance = new Customs(of);
        boolean thrown = false;

        instance.istanziaNuovaOperazione("addizione","+");
        instance.istanziaNuovaOperazione("moltiplicazione", "addizione,*");
        instance.istanziaNuovaOperazione("divisione", "/");
        instance.istanziaNuovaOperazione("radice", "addizione,sqrt");
        instance.istanziaNuovaOperazione("somma","+,-");
        
        assertEquals(true,instance.EditCostumOperation("divisione", "+,-"));   //controllo il corretto funzionamento
        System.out.println(instance.getOperazione("divisione"));
        assertEquals(false,instance.EditCostumOperation("swap", "+,-")); //controllo il caso in cui l'operazione non è presente
 
        assertEquals(false,instance.EditCostumOperation("radice", "*+sqrt")); //controllo il caso in cui l'operazione non è corretta

        assertEquals(false,instance.EditCostumOperation("addizione", "potenza,sqrt,swap"));
        
        try {
          instance.EditCostumOperation("addizione", "somma,radice,sqrt,swap"); //controllo il corretto funzionamento del lancio dell'eccezione
        } catch (EditCostumOpException e) {
          thrown = true;
        }
        assertTrue(thrown);
        System.out.println(instance.getOperazione("addizione"));
    }
}
