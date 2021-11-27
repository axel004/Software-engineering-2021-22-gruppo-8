package calculator;

/**
 *
 * @author Asus
 */
public class Operator {

    public Operator() {
    }
   
    
    public boolean isoperator(String operator, StackCalc e){
        Complex val1;
        Complex val2;
        Operations o = new Operations();
        switch(operator){
            case "+":
                //sum();
                return true;
            case "-":
                //val2 = e.pop();
                //val1 = e.pop();
                //e.push(o.differenza(val1,val2));
                return true;
            case "/":
                //div();
                return true;
            case "*":
                //prod();                
                return true;
            case "+-":
                //cambio();
                return true;
            case "sqrt":
                //val1 = e.pop();
                //e.push(o.radice(val1));
                //val1.setComplex((val1.getComplex())*-1);
                //e.push(val1);
                return true;
        }
        
        return false;
    }    
    
}
