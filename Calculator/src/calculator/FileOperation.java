/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

/**
 *
 * @author Alberto
 */
public class FileOperation {
    
    /*
    salva su un file le operazioni custom
    */
    public void storeOnFile(File file, Customs operazioni) {
        try {
            FileWriter myWriter = new FileWriter(file);
            for(String key: operazioni.getOperationMap().keySet()){
                myWriter.write(key);
                myWriter.write(":");
                myWriter.write(operazioni.getOperation(key) + "\n");
            }
            myWriter.close();

        } catch (Exception e) {
            System.out.println("Errore scrittura file\n");
        }
    }
    
    /*
    Carica su file le operazioni custom
     */
    public Customs loadFromFile(File file, Customs operazioni) {
        try (Scanner i = new Scanner(new BufferedReader(new FileReader(file)))) {
            // espressione regolare con OR logico dei caratteri pipe e fine linea
            String name;
            String seq;
            String line;

            while (i.hasNext()) {
                line = i.next();
                name = line.split(":")[0];
                seq = line.split(":")[1];
                operazioni.createNewOperation(name, seq);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found: " + file);
            return null;
        }

        return operazioni;
    }

}
