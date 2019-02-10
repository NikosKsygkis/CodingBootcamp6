/*
                In this Class, i create the constructor with 2
                arguments. One String, the calculation type, and
                one double, for the calculation result. I use it
                to create two objects inside the main method and
                i use the getters and setters to store the results
                in variables.
                
                The class, extends the CalculatorClass, and i use
                its methods inside the setters.
*/

package weeklyproject2;
/**
 *
 * @author nikolaos ksygkis
 */

public class CalculatorConstructor extends CalculatorClass{
    
   
    private double calculation;
    private String calculationType;
    
    
    public CalculatorConstructor(String calculationType,double calculation){
        
        this.calculationType=calculationType;
        this.calculation=calculation;

    }
    
//=========== GETTERS ====================================
    
//    public String getCalculationType(){
//        return this.calculationType;
//    }
    
    public double getCalculation(){
        return this.calculation;
    }
    
//========== SETTERS ======================================

    public void setCalculationType(){
      
       this.calculationType = calculatorCase();
   
    }
    
    public void setCalculation(){
        this.calculation = calculator();
    }    
    
}
