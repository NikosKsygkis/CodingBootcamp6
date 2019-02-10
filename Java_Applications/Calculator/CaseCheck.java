/*
            In this class, i create methods for the GCD case, for the prime number case, 
            for the Fibonacci number case and for the Fibonacci validation case. The rest, 
            are methods for checking Negative, real, infinite or null results. All these 
            methods are implemented inside the main method.
*/
package weeklyproject2;

import java.util.Scanner;

/**
 *
 * @author nikolaos ksygkis
 */
public class CaseCheck {
    
//=========================== GREATEST COMMON DIVISOR ======================================================   
     
    
    
    public static int greatestCommonDivisor(int result1, int result2){
        
        int a=result1;  int b=result2;  int c=1;
        
        if(a>=b){
        for(int i=1; i<b;i++){
            
            if(a%i==0&&b%i==0)
                c = i; 
            }
        }
        else {
            for(int i=1; i<a;i++){          
            if(a%i==b%i&&b%i==0)
                c = i;                  
            }
        }
      
      System.out.println("The Greatest Common Divisor Between the two results, is: "+c+"\n");
      return c;
  }
    
 //============================ PRIME NUMBER ===============================================================   
    public static boolean primeResult(int a){
    
        
        for(int i=2;i<a;i++){
           
            if(a%i==0){
               System.out.println("The second Result "+a+" IS NOT a Prime Number!\n");
               return false;
              
                               }
            }
        System.out.println("The second Result "+a+" IS a Prime Number\n");
        return true;
    }
//============================= FIBONACCI NUMBER ===========================================================

    public static long fibonacciNumber(int a) {
               
        long x = 0; long y = 1; long fibo = 0;
            for(int i = 2; i <= a; i++) {
                fibo = x + y;
                x = y;
                y = fibo;
                                        }
        System.out.println("The Fibonacci Number is: "+fibo+"\n");
        return fibo;
    }

//============================== FIBONACCI VALIDATION     ==================================================    
    
    public static boolean fiboValidation(int a){       // not an optimal way to implement it, or a resource-friendly
        
        if(a == 1){System.out.println("The Result is a Fibonacci number! And it's the number 1 of the Fibonacci Sequence!\n"); return true;}
        if(a == 2){System.out.println("The Result is a Fibonacci number! And it's the number 2 of the Fibonacci Sequence!\n"); return true;}
        if(a == 3){System.out.println("The Result is a Fibonacci number! And it's the number 3 of the Fibonacci Sequence!\n");return true;}       
        long x = 0; long y = 1; long fibo;
            for(int i = 2; i <= (a); i++) {
                fibo = y + x;
                x = y;
                y = fibo;
            if(a == fibo){
                System.out.println("Your second Result is a Fibonacci number! And it it's the number "+i+" of the Fibonacci Sequence!\n");
                return true;}
            }
        
        System.out.println("Your second Result is NOT a Fibonacci number!\n");
    return false;    
    }
    

//====================== INFINITY CHECK ======================================================================    
    
public static void infinityCheck(double result1, double result2){    
            double infinity = Double.POSITIVE_INFINITY;
        double ninfinity = Double.NEGATIVE_INFINITY;
if(result1==infinity||result2==infinity||result1==ninfinity||result2==ninfinity){
    System.out.println("For further calculations infinite numbers "
            + "cannot be used, please restart the application"); 
    System.exit(0);
    }
}   
    
    
//============================ REAL/NULL NUMBERS CHECK =======================================================

public static void realOrNull(double result1, double result2){
   if(result1%1!=0||result2%1!= 0||result1==0||result2==0||result1==0){
    System.out.println("For further calculations, real OR null numbers cannot be used\n\nIf NOT null,");
    Scanner input = new Scanner(System.in);
    System.out.println("Would you like to round the results to the nearest integer? (Y/N)");
        String answer = input.nextLine();
        while(!answer.equals("Y")&&! answer.equals("y")&&! answer.equals("N")&&! answer.equals("n")){
            
            System.out.println("Please Try Again with Y or N: ");
            answer = input.nextLine();
            }
        if(answer.equals("N")||answer.equals("n")){
            System.out.println("Please Start The Application Again");System.exit(0);
            }
        System.out.println("result 1 = "+result1+"  result 2 = "+result2);
        }     
    }   
//============================== NULL NUMBER AFTER ROUNDING TO THE NEXT INTEGER ==============================  
public static void nullAfterRound(int result_1,int result_2){    
        if(result_1==0||result_2==0){
         System.out.println("result 1= "+result_1+"  result 2= "+result_2+"\n\n");
            System.out.println("One or Both of the Results are NULL,\nPLEASE TRY AGAIN");System.exit(0);}
        }
    
//======================================   NEGATIVITY CHECK ==================================================

public static void negativeCheck(int result_1, int result_2){
        if(result_1 < 0||result_2 < 0){
            System.out.println("For further calculations, negative numbers cannot be used\nWould you like to use their absolute values?\n");

            Scanner input = new Scanner(System.in);
            System.out.println("(Y/N)");
                String answer = input.nextLine();
                while(!answer.equals("Y")&&! answer.equals("y")&&! answer.equals("N")&&! answer.equals("n")){

                    System.out.println("Please Try Again with Y or N: ");
                    answer = input.nextLine();
                }
                if(answer.equals("N")||answer.equals("n")){
                    System.out.println("Please Start The Application Again");System.exit(0);
                }
            //result_1=Math.abs(result_1); result_2=Math.abs(result_2);
            }

                System.out.println("result 1=  "+Math.abs(result_1)+"  result 2=  "+Math.abs(result_2)+"\n\n");
    }

}