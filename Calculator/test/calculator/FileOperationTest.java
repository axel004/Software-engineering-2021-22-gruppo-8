/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package calculator;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author paola
 */
public class FileOperationTest {
    
    public FileOperationTest() {
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
     * Test of loadFromFile method, of class FileOperation.
     */
    @Test
    public void testLoadFromFile() {
        System.out.println("*** LoadFromFile() test ***");
        OperatorFactory of = new OperatorFactory();
        Customs instance = new Customs(of);
        FileOperation f = new FileOperation();
        File file = new File("test/calculator/test.txt");
        // verifico che il file esista
        assertEquals(true, file.exists());
        // verifico che tutte le operazioni siano state inserite con il giusto nome
        // e la giusta sequenza associata
        f.loadFromFile(file,instance);
        String[] str = instance.toString().split("\\n");
        for (String s : str) {
            String opName = s.split(":")[0];
            String opSeq = s.split(":")[1].trim();
            assertEquals(opSeq, instance.getOperation(opName));
        }
        // verifico che un file non esistente restituisca null
        File fileNotExists = new File("test/calculator/thisNotExists.txt");
        assertEquals(false, fileNotExists.exists());
        assertEquals(null, f.loadFromFile(fileNotExists, instance));
    }
    
}
