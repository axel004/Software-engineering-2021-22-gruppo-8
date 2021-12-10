/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.io.File;
import java.io.FileNotFoundException;
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
        Map<String, Command> operationMap = new HashMap<>();
        operationMap.put("+", new SumCommand());
        operationMap.put("-", new DiffCommand());
        operationMap.put("+-", new RevSignCommand());
        Customs instance = new Customs(operationMap);
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
        Map<String, Command> operationMap = new HashMap<>();
        operationMap.put("+", new SumCommand());
        operationMap.put("-", new DiffCommand());
        operationMap.put("+-", new RevSignCommand());
        Customs instance = new Customs(operationMap);
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
    }

    /**
     * Test of istanziaNuovaOperazione method, of class Customs.
     */
    @Test
    public void testIstanziaNuovaOperazione() {
        System.out.println("istanziaNuovaOperazione test\n");
        String nomeOperazione = "somma";
        String operazione = "+,+-,-";
        Map<String, Command> operationMap = new HashMap<>();
        operationMap.put("+", new SumCommand());
        operationMap.put("-", new DiffCommand());
        operationMap.put("+-", new RevSignCommand());
        Customs instance = new Customs(operationMap);
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
    
    @Test
    public void testLoadFromFile() {
        System.out.println("*** LoadFromFile() test ***");
        OperatorFactory of = new OperatorFactory();
        Customs instance = new Customs(of.getOperationMap());
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

    
}
