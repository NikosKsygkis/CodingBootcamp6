
/*          I have created two methods for this class

            The calculatorCase() wich determines what 
            type of calculation the user needs.

            And the calculator() wich uses a switch statement
            to implement the calculation.

            Both methods use user's input data.

            !Note! In the calculator() method, i use iterations
            to determine by the user, how many numbers are needed
            for the addition, subtraction or division. The default
            Case where we need only two numbers is highlighted at
            runtime.

*/


package weeklyproject2;
/**
 *
 * @author nikolaos ksygkis
 */

import java.util.Scanner;
import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import java.util.*;


public class CalculatorClass {
    
        
        private double num1;
        private double num2;
        private String calc;
        
    
    
//===========================================================================================================================    
//                  The following method determines what type of calculation will be used
//===========================================================================================================================        
        public String calculatorCase(){
        
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter type of Calculation here, choose between '+', '-', '/', '%' and 'sqrt': ");
        calc=input.next().toLowerCase();
        
        while(!calc.equals("+")&&!calc.equals("-")&&!calc.equals("/")&&!calc.equals("%")&&!calc.equals("sqrt")){
            System.out.println("Try again, choose between '+', '-', '/', '%' and 'sqrt': ");
            calc=input.next().toLowerCase();
        }
        return calc;
        }
        
        
//===========================================================================================================================
//                                The following method implements the calculation
//===========================================================================================================================        
        public Double calculator(){
        
        
        Scanner input = new Scanner(System.in);
        int i;
        double result;
        List<Double> iterations = new ArrayList<Double>();  
        
        switch(calc){  
            
            
        case "+":       System.out.println("How many numbers do you want to add? (DEFAULT CASE, choose '1'): ");
                        while(!input.hasNextInt()){
                        System.out.println("That's not a correct number, enter again: ");
                        input.next();
                        }
                        i = abs(input.nextInt());

                        System.out.println("Please enter first number: ");
        
                        while(!input.hasNextDouble()){
                        System.out.println("That's not a correct number, enter again: ");
                        input.next();
                        }
                        num1=input.nextDouble();
                        result=num1;
                        
                        System.out.println("\n");
                        
                    for(int j=0; j<i;j++){    
                        System.out.println("Please enter next number for the addition: ");
                        while(!input.hasNextDouble()){
                        System.out.println("That's not a correct number, enter again: ");
                        input.next();
                        }
                        //num2=input.nextDouble();
                        iterations.add(j, input.nextDouble());
                        result+=iterations.get(j);
                        }
     
                        System.out.println("result = "+result);
                        
                        break;
       
                   
                    
        case "-":   System.out.println("How many numbers do you want to subtract? (DEFAULT CASE, choose '1'): ");
                        while(!input.hasNextInt()){
                        System.out.println("That's not a correct number, enter again: ");
                        input.next();
                        
                        }
                        i = abs(input.nextInt());

                        System.out.println("Please enter substahend: ");
        
                        while(!input.hasNextDouble()){
                        System.out.println("That's not a correct number, enter again: ");
                        input.next();
                        }
                        num1=input.nextDouble();
                        result=num1;
                        System.out.println("\n");
                        
                    for(int j=0; j<i;j++){    
                        System.out.println("Please enter next subtracter here (sign '-' is used by default): ");
                        while(!input.hasNextDouble()){
                        System.out.println("That's not a correct number, enter again: ");
                        input.next();
                        }
                        //num2=input.nextDouble();
                        iterations.add(j, input.nextDouble());
                        result-=iterations.get(j);
                        }
     
                        System.out.println("result = "+result);
                        
                        break;
                    
            
        case "/":   System.out.println("How many numbers do you want to divide?(DEFAULT CASE, choose '1'): ");
                        while(!input.hasNextInt()){
                        System.out.println("That's not a correct number, enter again: ");
                        input.next();
                        
                        }
                        i = abs(input.nextInt());

                        System.out.println("Please enter the divisible here: ");
        
                        while(!input.hasNextDouble()){
                        System.out.println("That's not a correct number, enter again: ");
                        input.next();
                        }
                        num1=input.nextDouble();
                        result=num1;
                        
                        System.out.println("\n");
                        
                    for(int j=0; j<i;j++){    
                        System.out.println("Please enter next dividor here: ");
                        while(!input.hasNextDouble()){
                        System.out.println("That's not a correct number, enter again: ");
                        input.next();
                        }
                        //num2=input.nextDouble();
                        iterations.add(j, input.nextDouble());
                        result/=iterations.get(j);
                        }
     
                        System.out.println("result = "+result);
                        
                        break;
        
        
                            
        case "%":       System.out.println("Please enter the first number here: ");
                        while(!input.hasNextDouble()){
                        System.out.println("That's not a correct number, enter again: ");
                        input.next();
                        }
                        num1=input.nextDouble();
                        
                        
                        
                    do{  
                        System.out.println("Please enter a non zero number here: ");
                        while(!input.hasNextDouble()){
                        System.out.println("That's not a correct number, enter again: ");
                        input.next();
                            }
                        num2=input.nextDouble();}
                                
                        
                        while(num2==0);
                            result = num1%num2;
                            System.out.println("Result = "+result);

                        break;
                    
                          
        default:     // Square Root
                                  
                do{
                    System.out.println("Please enter a positive number here: ");
                    while (!input.hasNextDouble()) {
                        System.out.println("That's not a correct number, please enter again: ");
                        input.next();
                    }
                    num1 = input.nextDouble(); } 
                    while (num1 <= 0);
                        result = Math.sqrt(num1);
                        System.out.println("Result = "+result);
                    break;
                }
                return result;
   
    }
}

    
    
    
    
    

