
/*

            *   I HAVE USED 3 ADDITIONAL CLASSES IN 3 DIFFERENT .JAVA FILES

            *   ONE FOR THE CALCULATOR'S CORE METHODS (CalculatorClass.java)

            *   ONE FOR THE CONSTRUCTORS WHICH EXTENDS THE CALCULATOR'S CORE METHD CLASS (CalculatorConstructor.java)

            *   ONE FOR THE CASES WE NEED TO CHECK, ON THE SECOND RESULT (CaseCheck.java)

            Also, i used USER-CONTROLLED iterations, for the addition, subtraction and division, in case the user wants
            to add, subtract OR divide more than two numbers. For the DEFAULT CASE, choose '1'
*/

package weeklyproject2;

/**
 *
 * @author nikolaos ksygkis
 */

public class WeeklyProject2MAIN extends CaseCheck {

    
    private static String type;
    private static double result;
    private static double result1;
    private static double result2;
    
    
    public static void main(String[] args) {
                
        CalculatorConstructor a = new CalculatorConstructor(type, result);  // Object a. Arguments( Calculation type, Calculation result)
        CalculatorConstructor b = new CalculatorConstructor(type, result);  // Object b. Arguments( Calculation type, Calculation result)
        
        a.setCalculationType();                                             // Setter 1 for Object a. User sets the type
        a.setCalculation();                                                 // Setter 2 for Object a. User inputs data for the calculation
        

System.out.println("\n\n\n=====================================================================");
System.out.println("=====================================================================");
System.out.println("============= C A L C U L A T I O N    N U M B E R    2 =============");
System.out.println("=====================================================================");
System.out.println("\n\n\n=====================================================================");

        
        b.setCalculationType();                                             // Setter 1 for Object b. User sets the type      
        b.setCalculation();                                                 // Setter 2 for Object b. User inputs data for the calculation  
                                                   
                                                          
        result1 = a.getCalculation();   System.out.println("\n\n\nYour FIRST result is: "+result1); //Getter for object's a calculation result, 
                                                                                                    //stored in variable result1
        
        result2 = b.getCalculation();   System.out.println("Your SECOND result is: "+result2);      //Getter for object's b calculation result, 
                                                                                                    //stored in variable result2

        System.out.println("\n\n\n");
        

//=============================Infinity, Real number, Null number, Negativity, CHECK ==========================================================    

    infinityCheck(result1,result2);
    realOrNull(result1, result2);     
    System.out.println("\n\n");
int result_1=(int)Math.round(result1); int result_2=(int)Math.round(result2);        
    nullAfterRound(result_1, result_2);
    negativeCheck(result_1, result_2);
    result_1=Math.abs(result_1); result_2=Math.abs(result_2);

//============================ GREATEST COMMON DIVISOR CASE ================================================================================== 

        greatestCommonDivisor(result_1, result_2);
            
//============================ PRIME NUMBER CASE =============================================================================================
 
        primeResult(result_2);   
        
//============================ FIBONACCI NUMBER CALCULATION ==================================================================================

        fibonacciNumber(result_2);
        
//============================ FIBONACCI NUMBER VALIDATION CASE ==============================================================================
        
        fiboValidation(result_2);
        
//============================================================================================================================================       
        
    } 
}
    
    

