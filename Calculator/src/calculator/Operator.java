/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculator;

import calculator.Operations;

/**
 *
 * @author Asus
 */
public class Operator {

    public Operator() {
        
    }
   
    
    public boolean isoperator(String operator, StackCalc e) throws Exception{
        Complex val1;
        Complex val2;
        Operations o = new Operations();
        switch(operator){
            case "clear":
                e.clear();
            case "dup":
                if (e.size()>=1){
                    e.dup();
                    return true;
                }
                else
                    throw new Exception("Non ci sono valori nello stack");
            case "drop":
                if (e.size()>=1){
                    e.drop();
                    return true;
                }
                else
                    throw new Exception("Non ci sono valori nello stack");
            case "swap":
                if (e.size()>=2) {
                    e.swap();
                    return true;
                } else
                    throw new Exception("Non ci sono abbastanza valori nello stack");
            case "over":
                if (e.size()>=2) {
                    //chiamata alla funzione over
                    return true;
                } else
                    throw new Exception("Non ci sono abbastanza valori nello stack");
            case "+":
                if(e.size()>=2){            //controllo se ci sono almeno due valori
                    val2 = e.pop();
                    val1 = e.pop();         //ottengo i due valori dallo stackj
                    e.push(o.sum(val1,val2)); //inserisco il nuovo valore
                    return true;
                }
                else
                    throw new Exception("Non ci sono abbastanza valori nello stack");

            case "-":
                if(e.size()>=2){            //controllo se ci sono almeno due valori
                    val2 = e.pop();
                    val1 = e.pop();         //ottengo i due valori dallo stackj
                    e.push(o.differenza(val1,val2)); //inserisco il nuovo valore
                    return true;
                }
                else
                    throw new Exception("Non ci sono abbastanza valori nello stack");

            case "/":
                if(e.size()>=2){            //controllo se ci sono almeno due valori
                    if (e.peek().equals(new Complex(0,0))) {
                        throw new IllegalArgumentException();
                    }
                    val2 = e.pop();
                    val1 = e.pop();         //ottengo i due valori dallo stackj
                    e.push(o.divisione(val1,val2)); //inserisco il nuovo valore
                    return true;
                }
                else
                    throw new Exception("Non ci sono abbastanza valori nello stack");
            case "*":
            if(e.size()>=2){            //controllo se ci sono almeno due valori
                    val2 = e.pop();
                    val1 = e.pop();         //ottengo i due valori dallo stackj
                    e.push(o.multiply(val1,val2)); //inserisco il nuovo valore
                    return true;
                }
                else
                    throw new Exception("Non ci sono abbastanza valori nello stack");
            case "+-":
                if(e.size()>=1){            //controllo se ci sono almeno due valori
                    val1 = e.pop();         //ottengo i due valori dallo stackj
                    e.push(o.reverseSign(val1)); //inserisco il nuovo valore
                    return true;
                }
                else
                    throw new Exception("Non ci sono abbastanza valori nello stack");
                    case "sqrt":
                if(e.size()>=1){
                val1 = e.pop();             // ottengo il valore dallo stack
                e.push(o.radice(val1));        //inserisco nello stack il nuovo valore    
                return true;
                }
                else 
                    throw new Exception("Non ci sono abbastanza valori nello stack");
        }
        
        return false;
    }   
}
