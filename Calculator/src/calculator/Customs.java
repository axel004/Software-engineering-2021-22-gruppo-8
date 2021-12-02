/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.HashMap;

/**
 *
 * @author Alberto
 */
public class Customs {
    private HashMap<String,String> mappa = new HashMap();
    
    /*
    "crea" inserisce una chiave nomeOperazione nella mappa, e vi inserisce la stringa "0" come valore;
    putIfAbsent restituisce null se la posizione non era occupata, altrimenti restituisce il valore associato alla chiave
    */
    public boolean crea(String nomeOperazione){
        try{
            if(mappa.putIfAbsent(nomeOperazione, "0") != null){
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
    "modifica" va a modificare il valore della chiave nomeOperazione;
    */
    public void modifica(String nomeOperazione, String operazione){
        try{
            mappa.replace(nomeOperazione, operazione);
        }
        catch(Exception e){
            System.out.print("Modify error\n");
        }
    }
    
    /*
    "istanziaNuovaOperazione" effettua sia la creazione che la modifica della nuova operazione dichiarata
    */
    public void istanziaNuovaOperazione(String nomeOperazione, String operazione){
        if(this.crea(nomeOperazione)){
            this.modifica(nomeOperazione, operazione);
        }
        else{
            System.out.print("Errore istanziazione operazione\n");
        }
    }
    
    /*
    getOperazione restituisce la sequenza di operazioni inserita 
    */
    public String getOperazione(String nomeOperazione){
        try{
            return mappa.get(nomeOperazione);
        }
        catch(Exception e){
            System.out.print("get operation error\n");
            return null;
        }
    }
    
}
