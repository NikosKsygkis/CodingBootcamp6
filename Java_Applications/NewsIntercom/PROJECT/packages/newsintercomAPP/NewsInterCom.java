
package newsintercomAPP;

import static newsintercomAPP.ConsoleUtils.clearConsole;

/**
 *
 * @author user
 */

public class NewsInterCom  {

/* ==The package newsintercomAPP contains the main method inside this class.

        -The ConsoleUtiles class contains the method that clears the terminal 

        -The Database class contains the basic info of the Database and the method that creates a Connection

        -The MessageFile class contains the methods required to create and append to a txt-file all the info
         of a message that has been created

        -The MyMenu class contains all the menus and operations that appear on the terminal based on the 
         logged-in User's Role/Capacity

        -OperationMethods class contains all the required methods that a USER utilizes for this Application

   ==The package tablesConstructors contains the constructors of every Database-Table Object

   ==The package tablesDAO contains all the CRUD operations that are required for every Object of the database
*/
    
    public static void main(String[] args){
        
        clearConsole();
        System.out.println("Welcome!\nBefore running this application, "
                + "make sure to adjust the path of the file that will\ncontain Messaging Information."
                + " It is located under the package 'newsintercomAPP',\ninside the MessageFile.java"
                + " , in the String Variable 'path' on line: 15\n");
        
        OperationMethods op = new OperationMethods(); // OperationMethods is the class that its methods utilize
                                                      // All the DAO methods in order to make CRUD operations
        op.promptEnterKey();
        
        MyMenu menu = new MyMenu();                   // MyMenu is the class witch consists of the different menus
                                                      // that this application will utilize, based on the capacity
                                                      // of the user that has logged in. (administrator, editor or writer)
        
        menu.myMainMenu(); 
        
    }   
}
