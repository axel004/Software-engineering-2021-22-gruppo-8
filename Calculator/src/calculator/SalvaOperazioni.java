/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 *
 * @author Alberto
 */
public class SalvaOperazioni {

    SalvaOperazioni(File file, Customs operazioni) {
        try {
            FileWriter myWriter = new FileWriter(file);
            for(String key: operazioni.getOperationMap().keySet()){
                myWriter.write(key);
                myWriter.write(":");
                myWriter.write(operazioni.getOperazione(key) + "\n");
            }
            myWriter.close();

        } catch (Exception e) {
            System.out.println("Errore scrittura file\n");
        }
    }

}
