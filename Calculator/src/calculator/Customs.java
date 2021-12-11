/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import Exception.DeleteCostumOpException;
import Exception.EditCustomOpException;
import Exception.LessArgException;
import Exception.VariableException;
import Exception.CustomException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private OperatorFactory operatorfac;

    Customs(OperatorFactory of) {
        this.operazioniDefault = of.getOperationMap();
        this.operatorfac = of;
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
            if(this.operationCheck(operazione)){
                mappa.replace(nomeOperazione, operazione);
            }
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
                        String[] splot = comando.split("(?!^)");
                        if(!((splot[0].matches(Pattern.quote("+"))||splot[0].matches("-")||splot[0].matches("<")||splot[0].matches(">")) && splot[1].matches("[a-z]{1}")) || comando.length()>2){
                            if(!this.checkComplesso(comando)){
                                return false;
                            }
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
    
    public HashMap<String, String> getOperationMap() {
        return mappa;
    }

    /*
    * la funzione prende in ingresso la variabile text che rappresenta il nome della funzione custom
    * la funzione esegue l'operazione custom e nel caso in cui l'operazione non esiste o si verificano errori con le operazioni specificate viene lanciata l'eccezione CustomException
     */
    public void executeCustom(String text) throws LessArgException, VariableException, CustomException{
        if (!mappa.containsKey(text)) { //riconoscimento del comando
            throw new CustomException();
        }
        String value = getOperazione(text);
        String operazioni[]=value.split(",");
        OperatorFactory operator = new OperatorFactory();
        FXMLDocumentController f = new FXMLDocumentController();
        Operator op = Operator.getOperator();
        StackCalc stack = StackCalc.getStack();
        Command c; 
        for (String operazione : operazioni){
            c=operator.getCommand(operazione);
            if(c!=null){
                    op.execute(c, operazione);
            }
            else if(getOperazione(operazione)!=null){
                executeCustom(operazione); 
            }
            else {
                try {
                   f.checkComplex(operazione); 
                }
                catch(Exception e){
                    throw new CustomException();
                }
            }
        }
        op.clear();
    }

    public ArrayList<String> getListOfValues() {
        ArrayList<String> list = new ArrayList<>();
        for(Map.Entry<String,String> entry : mappa.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            list.add(key+" => "+value);
        }
        return list;
    }
    
    public boolean editCustomOperation(String nomeOperazione, String operazione) throws EditCustomOpException{
        List<String> listOfKeys = new ArrayList();
        if(operationCheck(operazione)){  //controllo se l'operazione è corretta
            if(mappa.containsKey(nomeOperazione)){  //controllo se la mappa contiene il nome dell'operazione da modificare
                for (String value : mappa.values()) {
                    if(value.contains(nomeOperazione)){ //creo la lista delle chaivi che hanno come valore il nome dell'operazione da modificare
                        keyList(mappa,value,listOfKeys); 
                    }
                }
                modifica(nomeOperazione,operazione);  //effettuo la modifica
            if(!listOfKeys.isEmpty()){
                throw new EditCustomOpException(listOfKeys.toString()); //se la lista non è vuota lancio l'allert altrimenti ritorno true
            }else
                return true;
            }
            return false;
        }
        return false;
    }
           
    public void keyList(Map<String, String> mappa, String value, List<String> listOfKeys) {
        for (Map.Entry<String, String> entry : mappa.entrySet()) {
            // Check if value matches with given value
            if (entry.getValue().equals(value)) // Store the key from entry to the list
            {
                listOfKeys.add(entry.getKey());
            }
        }
    }

    
    public boolean deleteCustom(String nomeOperazione) throws DeleteCostumOpException {
        List<String> listOfKeys = new ArrayList();
            if (mappa.containsKey(nomeOperazione)) {  //controllo se la mappa contiene il nome dell'operazione da cancellare
                for (String value : mappa.values()) {
                    if (value.contains(nomeOperazione)) //creo la lista delle chaivi che hanno come valore il nome dell'operazione da cancellare
                    {
                        keyList(mappa, value, listOfKeys);
                    }
                }
                listOfKeys.add(nomeOperazione);
                for (String key : listOfKeys){
                    mappa.remove(key);
                }
                listOfKeys.remove(nomeOperazione);
                if (!listOfKeys.isEmpty()) {
                    throw new DeleteCostumOpException(listOfKeys.toString()); //se la lista non è vuota lancio l'allert altrimenti ritorno true
                } else {
                    return true;
                }
            }
            return false;
    }
}

