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
   
    
    public boolean isOperator(String operator, StackCalc e) throws Exception{
        Complex val1;
        Complex val2;
        Operations o = new Operations();
        switch(operator){
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

    public boolean isStackOperator(String operator, StackCalc e) throws Exception {
        switch (operator) {
            case "clear":
                e.clear();
                return true;
            case "dup":
                if (e.size() >= 1) {   //controllo la lunghezza dello stack
                    e.dup();
                    return true;
                } else {
                    throw new Exception("Non ci sono valori nello stack");
                }
            case "drop":
                if (e.size() >= 1) {       //controllo la lunghezza dello stack
                    e.drop();
                    return true;
                } else {
                    throw new Exception("Non ci sono valori nello stack");
                }
            case "swap":
                if (e.size() >= 2) {      //controllo la lunghezza dello stack
                    e.swap();
                    return true;
                } else {
                    throw new Exception("Non ci sono abbastanza valori nello stack");
                }
            case "over":
                if (e.size() >= 2) {      //controllo la lunghezza dello stack
                    e.over();
                    return true;
                } else {
                    throw new Exception("Non ci sono abbastanza valori nello stack");
                }
        }
        return false;
    }

    public boolean isVariableOperator(String operator, Variable varmap) throws VariableException, Exception {
        Operations op = new Operations();
        String[] opval = operator.split("(?!^)");

        if (opval.length != 2 || !varmap.checkVariable(opval[1])) //controllo se la variabile rientra nell'aòfabeto e se l'operatore 
        {
            return false;                                      //è formato da due valori(il tipo di operazione e la variabile)
        }
        switch (opval[0]) {
            case "<":
                if (varmap.getVariable(opval[1]) != null) { //controllo l'esistenza della chiave
                    varmap.savingInStack(opval[1]);
                    return true;
                } else {
                    throw new VariableException("La variabile non è stata definita");
                }
            case ">":
                if (varmap.getStack().size() >= 1) { //controllo che ci sia almeno un valore nello stack
                    varmap.savingInVariable(opval[1]);
                    return true;
                } else {
                    throw new VariableException("La variabile non è stata definita oppure lo stack è vuoto");
                }
            case "+":
                if (varmap.getVariable(opval[1]) != null && varmap.getStack().size() >= 1) { //controllo l'esistenza della chiave e l'esistenza di almeno un valore nello stack
                    varmap.sumVariable(opval[1], op);
                    return true;
                } else {
                    throw new VariableException("La variabile non è stata definita oppure lo stack è vuoto");
                }
            case "-":
                if (varmap.getVariable(opval[1]) != null && varmap.getStack().size() >= 1) { //controllo l'esistenza della chiave e l'esistenza di almeno un valore nello stack
                    varmap.diffVariable(opval[1], op);
                    return true;
                } else {
                    throw new VariableException("La variabile non è stata definita oppure lo stack è vuoto");
                }
        }
        return false;
    }
}
