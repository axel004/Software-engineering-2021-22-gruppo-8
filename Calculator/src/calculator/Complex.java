/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author paola
 */
public class Complex {
    private String numComplex;

    public Complex(String numComplex) {
        this.numComplex = numComplex;
    }
    
    //questa funzione verifica che il numero complesso inserito sia nella forma cartesiana e, nel caso, lo inserisce
    //nello stack. Altrimenti invia una notifica all'utente e non inserisce il numero.
    //Nel caso in cui l'utente inserisce un numero reale, questo verrà trasformato in un numero complesso nella forma 
    //cartesiana
    public void checkComplex(){
        if (numComplex.matches("[0-9]{2}(.*)[0-9]{2}j")|| numComplex.matches("[0-9]{1}(.*)[0-9]{1}j")
                || numComplex.matches("[0-9]{1}(.*)[0-9]{2}j") || numComplex.matches("[0-9]{2}(.*)[0-9]{1}j")){
            System.out.println("Ok");
        }
        else if (numComplex.matches("[0-9]{2}") || numComplex.matches("[0-9]{1}")){
            String real=numComplex.concat("+0j");
            System.out.println("Numero reale: " + real);
        }
        else {
            System.out.println("Inserire il numero complesso nella forma cartesiana!");
        }
        //devo controllare se la stringa è vuota?
    }
}
