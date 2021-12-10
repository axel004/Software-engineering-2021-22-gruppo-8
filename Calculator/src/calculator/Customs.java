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
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Alberto
 */
public class Customs {
    private HashMap<String,String> mappa = new HashMap();
    private Map operazioniDefault;

    Customs(Map<String, Command> operationMap) {
        this.operazioniDefault = operationMap;
    }

    /*
    "crea" inserisce una chiave nomeOperazione nella mappa, e vi inserisce la stringa "0" come valore;
    putIfAbsent restituisce null se la posizione non era occupata, altrimenti restituisce il valore associato alla chiave
    non crea l'operazione se essa esiste già nelle operazioni di default o nelle operazioni custom con lo stesso nome
    */
    public boolean crea(String nomeOperazione){
        try{
            if(mappa.putIfAbsent(nomeOperazione, "default") != null || operazioniDefault.containsKey(nomeOperazione)){
                throw new Exception();
            }
            return true;
        }
        catch(Exception e){
            System.out.print("Create error\n");
            return false;
        }
    }
    
    /*
    "modifica" va a modificare il valore della chiave nomeOperazione se esiste
    */
    public void modifica(String nomeOperazione, String operazione){
        try{
            mappa.replace(nomeOperazione, operazione);
        }
        catch(Exception e){
            System.out.print("Errore modifica comportamento operazione custom\n");
        }
    }
    
    /*
    "istanziaNuovaOperazione" effettua sia la creazione che la modifica della nuova operazione dichiarata
    */
    public boolean istanziaNuovaOperazione(String nomeOperazione, String operazione){
        if(this.operationCheck(operazione)){
            if(this.crea(nomeOperazione)){
                this.modifica(nomeOperazione, operazione);
                return true;
            }
        }
        System.out.print("Errore istanziazione operazione\n");
        return false;
    }
    
    /*
    getOperazione restituisce la sequenza di operazioni inserita 
    */
    public String getOperazione(String nomeOperazione){
        try{
            return mappa.get(nomeOperazione);
        }
        catch(Exception e){
            System.out.print("Get operation error\n");
            return null;
        }
    }
    
    /*
    operazione che controlla la presenza di una delle operazioni dichiarate come costituenti di un'operazione custom 
    all'interno delle operazioni di default o delle operazioni personalizzate; controlla inoltre se è un numero complesso
    */
    private boolean operationCheck(String operazione){
        String[] split = operazione.split(",");
        for(String comando : split){
            if(!operazioniDefault.containsKey(comando)){
                if(!mappa.containsKey(comando)){
                    try{
                        if(!this.checkComplesso(comando)){
                            return false;
                        }
                    }
                    catch(Exception e){
                        System.out.println("Complex error\n");
                        return false;
                    }
                }
                else{
                    if("default".compareTo(mappa.get(comando))==0){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    /*
    controlla se ciò che è stato inserito è un numero complesso
    */
    private boolean checkComplesso(String numComplex) throws NumberFormatException {
        String number[], num = "";
        double real, complex;
        if (numComplex.contains("+")) {
            numComplex = numComplex.replace("j", "");
            number = numComplex.split(Pattern.quote("+"));
            real = Double.parseDouble(number[0]);
            complex = Double.parseDouble(number[1]);
        } else if (numComplex.contains("-")) {
            if (numComplex.startsWith("-")) {
                numComplex = numComplex.substring(1);
                num = "-";
            }
            if (!numComplex.contains("-")) {
                if (numComplex.contains("j")) {
                    numComplex = numComplex.replace("j", "");
                    real = 0;
                    complex = Double.parseDouble(num.concat(numComplex));
                } else {
                    real = Double.parseDouble(num.concat(numComplex));
                    complex = 0;
                }
            } else {
                numComplex = numComplex.replace("j", "");
                number = numComplex.split("-");
                real = Double.parseDouble(num.concat(number[0]));
                complex = Double.parseDouble("-".concat(number[1]));
            }
        } else if (numComplex.contains("j")) {
            numComplex = numComplex.replace("j", "");
            real = 0;
            complex = Double.parseDouble(numComplex);
        } else {
            real = Double.parseDouble(numComplex);
            complex = 0;
        }
        return true;
    }
    
    @Override 
    public String toString() {
        String str = "";
        for (Map.Entry<String, String> entry : mappa.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            str+=key+": "+value+"\n";
        }
        return str;
    }
    
    public Customs loadFromFile(File file) {
        try(Scanner i = new Scanner(new BufferedReader(new FileReader(file)))) {
             // espressione regolare con OR logico dei caratteri pipe e fine linea
            String name;
            String seq;
            String line;
            
            while(i.hasNext()){
                line = i.next();
                name = line.split(":")[0];
                seq = line.split(":")[1];
                this.istanziaNuovaOperazione(name, seq);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found: "+file);
            return null;
        }
        
        return this;
    }
}
