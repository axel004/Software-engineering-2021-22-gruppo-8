/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        Customs instance = new Customs();
        boolean expResult = true;
        boolean result = instance.crea(nomeOperazione);
        assertEquals(expResult, result);
        
        expResult = false;
        result = instance.crea(nomeOperazione);
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
        Customs instance = new Customs();
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
    }

    /**
     * Test of istanziaNuovaOperazione method, of class Customs.
     */
    @Test
    public void testIstanziaNuovaOperazione() {
        System.out.println("istanziaNuovaOperazione test\n");
        String nomeOperazione = "somma";
        String operazione = "+,+-,-";
        Customs instance = new Customs();
        instance.istanziaNuovaOperazione(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione),"+,+-,-");
        
        nomeOperazione = "somma";
        operazione = "+,+-,-";
        instance = new Customs();
        instance.istanziaNuovaOperazione(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione),"+,+-,-");
        
        nomeOperazione = "differenza";
        operazione = "+,+-,-";
        instance = new Customs();
        instance.istanziaNuovaOperazione(nomeOperazione, operazione);
        assertEquals(instance.getOperazione(nomeOperazione),"+,+-,-");
    }
    
}
