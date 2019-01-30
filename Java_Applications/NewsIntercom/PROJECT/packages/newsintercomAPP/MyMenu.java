
package newsintercomAPP;

import tablesConstructors.User;
import tablesConstructors.LogInfo;
import tablesDAO.LogInfoCRUD;
import tablesDAO.MessageCRUD;
import tablesDAO.UserCRUD;
import static newsintercomAPP.ConsoleUtils.clearConsole;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nikos
 */
public class MyMenu {

    Scanner input = new Scanner(System.in);
    
    public void myMainMenu(){
        MyMenu mm = new MyMenu();
        OperationMethods om = new OperationMethods();
        clearConsole();
        System.out.println("Welcome!\n");
        System.out.println("1 --------- Log IN");
        System.out.println("2 --------- Register");
        System.out.println("3 --------- Exit");
        String in = input.next();
        while(!in.equals("1")&&!in.equals("2")&&!in.equals("3")){
            System.out.println("Not a valid option, choose again");
            in = input.nextLine();
        }
        switch(in){
            case "1": mm.myLoginMenu();
            
            case "2": om.registerUser();
            
            case "3": System.exit(0);
        }
        
        
    }
    
    public void myLoginMenu(){
        clearConsole();
        MyMenu mm = new MyMenu();
        OperationMethods om = new OperationMethods();
        User user = om.loginUser();
        String capacity = om.returnRole(user);
        
        switch(capacity){
            case "Administrator": mm.superAdminMenus(user);
                
            case "Editor": mm.editorMenus(user);
                
            case "Writer": mm.writerMenus(user);
        }
        
    }
    
    public void superAdminMenus(User user){
        clearConsole();
        MyMenu mm = new MyMenu();
        OperationMethods om = new OperationMethods();
        LogInfoCRUD lc = new LogInfoCRUD();
        String login = om.loginTime();
        int userId;
        UserCRUD uc = new UserCRUD();
        System.out.println("Welcome "+user.getFname()+" "+user.getLname()+"!");
        System.out.println("1 --------- Create USER");
        System.out.println("2 --------- View Users Info");
        System.out.println("3 --------- View ONLINE USERS");
        System.out.println("4 --------- View Logs");
        System.out.println("5 --------- View All Sent And Received Messages By User ID");
        System.out.println("6 --------- Log Out");        
        String in = input.next();
        while(!in.equals("1")&&!in.equals("2")&&!in.equals("3")&&!in.equals("4")&&!in.equals("5")&&!in.equals("6")){
            System.out.println("Not a valid option, choose again");
            in = input.next();
        }
        switch(in){
            case "1": om.createDummyUser();mm.superAdminMenus(user); break;
            case "2": mm.superAdminUserMethods(); break;
            case "3": {om.viewOnlineUsers();mm.superAdminMenus(user);}break;
            case "4": {
                        if(lc.findAllLogs()==null){
                            System.out.println("No Logs Found");
                            om.promptEnterKey();
                            mm.superAdminMenus(user);
                        }
                        else{
                            for(LogInfo lg:lc.findAllLogs()){
                            System.out.println("LOG ID: "+lg.getLogId()+"  USER ID: "+lg.getLogUserId()
                                +"  LOGIN: "+lg.getLogin()+"  LOGOUT: "+lg.getLogout());
                            }
//                            System.out.println("\n1 --------- Main Menu");
//                            in = input.next();
//                            while(!in.equals("1")){
//                                System.out.println("Not a valid option, choose again");
//                                in = input.next();
//                            }
                            om.promptEnterKey();
                            mm.superAdminMenus(user);
                            }
                        }break;
            case "5": {
                        om.viewAllUsers();
                        
                        do{System.out.println("SELECT USER BY USER ID");
                            while(!input.hasNextInt()){
                            System.out.println("That's not a correct ID, enter again: ");
                            input.next();
                            }
                            userId = input.nextInt();input.nextLine();
                        } while(uc.findUserById(userId) == null );
                            clearConsole();
                            om.viewMyInboxMessages(uc.findUserById(userId),true);
                            om.viewMySentMessages(uc.findUserById(userId),true);
                            om.viewMyDeletedMessages(uc.findUserById(userId),true);
                            om.promptEnterKey();
                            mm.superAdminMenus(user);
                        }    break; 
            case "6": om.logOut(user.getId(),login);
        }
    }
    
    public void superAdminUserMethods(){
        clearConsole();
        UserCRUD uc = new UserCRUD();
        OperationMethods om = new OperationMethods();
        int userId;
        MyMenu mm = new MyMenu();
        om.viewAllUsersSuperAdmin(); 
        System.out.println("\n1 --------- Update USER INFO");
        System.out.println("2 --------- Delete USER");
        System.out.println("3 --------- Update USER Capacity");
        System.out.println("4 --------- Back");
        String in = input.next();
        while(!in.equals("1")&&!in.equals("2")&&!in.equals("3")&&!in.equals("4")){
            System.out.println("That's not a valid option");
            in = input.next();
        }
        switch(in){
            case "1":  {om.viewAllUsersSuperAdmin();
                        System.out.println("SELECT USER BY USER ID:");
                                do{
                        while(!input.hasNextInt()){
                        System.out.println("That's not a correct ID, enter again: ");
                        input.next();
                        }
                        userId = input.nextInt();input.nextLine();
                        } while(uc.findUserById(userId) == null);
                        om.updateUserInfo(userId);}break;
            case "2": om.deleteUser();break;
            case "3": om.updateUserRoles();break;
            case "4": mm.superAdminMenus(uc.findUserByUsername("admin"));
        }
    }
    
    
//======================================================================================================    
    public void editorMenus(User user){
        clearConsole();
        MyMenu mm = new MyMenu();
        OperationMethods om = new OperationMethods();
        String login = om.loginTime();
        MessageCRUD mc = new MessageCRUD();
        System.out.println("Welcome "+user.getFname()+" "+user.getLname()+"!\n");
        System.out.println("1 --------- View my INFO");
        System.out.println("2 --------- View ONLINE USERS");
        System.out.println("3 --------- Create New Message");
        System.out.println("4 --------- Create New Message And Send To All Writers");        
        System.out.println("5 --------- View my INBOX Messages  "+mc.findNewMessageByReceiverId(user.getId())+" UNREAD MESSAGES");
        System.out.println("6 --------- View my SENT Messages");
        System.out.println("7 --------- View my DELETED Messages");
        System.out.println("8 --------- View my Message Corrections");
        System.out.println("9 --------- Log Out");
        String in = input.next();
        while(!in.equals("1")&&!in.equals("2")&&!in.equals("3")&&!in.equals("4")&&!in.equals("5")&&!in.equals("6")&&!in.equals("7")&&!in.equals("8")&&!in.equals("9")){
            System.out.println("Not a valid option, choose again");
            in = input.next();
        }
        switch(in){
            case "1": {om.viewUser(user); om.promptEnterKey(); mm.editorMenus(user);}break;
            case "2": {om.viewOnlineUsers(); mm.editorMenus(user);}break;
            case "3": {
                        try {
                            om.createNewMessage(user);
                        } catch (IOException ex) {
                            Logger.getLogger(MyMenu.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        mm.editorMenus(user);}break;
            case "4":  {om.createMsgToAllWriters(user);
                        mm.editorMenus(user);}break;
            case "5": {om.viewMyInboxMessages(user,false);mm.operatingInboxMessages(user);}break;
            case "6": {om.viewMySentMessages(user,false); mm.operatingSentMessages(user);}break;
            case "7": {om.viewMyDeletedMessages(user,false); mm.operatingDeletedMessages(user);}break;
            case "8": {om.viewReceivedCorrectedMessages(user); mm.operatingCorrectedMessages(user);}break;
            case "9": om.logOut(user.getId(),login);
        }
    }
    public void editorMessageOperations(User user, int msg_id){
        OperationMethods om = new OperationMethods();
        MyMenu mm = new MyMenu();
        System.out.println("1 --------- Reply");
        System.out.println("2 --------- Forward");
        System.out.println("3 --------- Make Corrections");
        System.out.println("4 --------- Delete");
        System.out.println("5 --------- Clean Delete");
        System.out.println("6 --------- Main Menu");
        String in = input.next();
        while(!in.equals("1")&&!in.equals("2")&&!in.equals("3")&&!in.equals("4")&&!in.equals("5")&&!in.equals("6")){
            System.out.println("Not a valid option, choose again");
            in = input.next();
        }
        switch(in){
            case "1": {
                        try {
                        om.replyToMessage(user, msg_id);
                        } catch (IOException ex) {
                        Logger.getLogger(MyMenu.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                        mm.editorMenus(user);break;
            case "2": {
                    try {
                            om.forwardMessage(user, msg_id);
                        } catch (IOException ex) {
                            Logger.getLogger(MyMenu.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                        mm.editorMenus(user);break;
            case "3": {
            try {
                        om.correctAMessage(user, msg_id);
                    } catch (IOException ex) {
                    Logger.getLogger(MyMenu.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    mm.editorMenus(user);break;
            case "4": om.shallowDeleteMessage(user, msg_id); mm.editorMenus(user);break;
            case "5": om.deepDeleteMessage(user, msg_id); mm.editorMenus(user);break;
            case "6": mm.editorMenus(user);
        }
    }
    
    public void operatingInboxMessages(User user){
        MyMenu mm = new MyMenu();
        OperationMethods om = new OperationMethods();
        System.out.println("\n1 --------- Open Message");
        System.out.println("2 --------- Back"); 
        
        String in = input.next();
        while(!in.equals("1")&&!in.equals("2")){
            System.out.println("Not a valid option, choose again");
            in = input.next();
        }
        switch(in){
            case "1": om.selectInboxMessage(user);break;
            case "2": if(om.returnRole(user).equals("Editor")){
                        mm.editorMenus(user);
                        }
                        else{mm.writerMenus(user);}
            break;
        } 
    }
    public void operatingSentMessages(User user){
        MyMenu mm = new MyMenu();
        OperationMethods om = new OperationMethods();
        System.out.println("1 --------- Open Message");
        System.out.println("2 --------- Back"); 
        
        String in = input.next();
        while(!in.equals("1")&&!in.equals("2")){
            System.out.println("Not a valid option, choose again");
            in = input.next();
        }
        switch(in){
            case "1": om.selectSentMessage(user);break;
            case "2": if(om.returnRole(user).equals("Editor")){
                        mm.editorMenus(user);
                        }
                        else{mm.writerMenus(user);}
        } 
    }    
    public void operatingDeletedMessages(User user){
        MyMenu mm = new MyMenu();
        OperationMethods om = new OperationMethods();
        System.out.println("1 --------- Open Message");
        System.out.println("2 --------- Back"); 
        
        String in = input.next();
        while(!in.equals("1")&&!in.equals("2")){
            System.out.println("Not a valid option, choose again");
            in = input.next();
        }
        switch(in){
            case "1": om.selectDeletedMessage(user);break;
            case "2": if(om.returnRole(user).equals("Editor")){
                        mm.editorMenus(user);
                        }
                        else{
                            mm.writerMenus(user);
                        }break;
        } 
    }    
    public void operatingCorrectedMessages(User user){
        MyMenu mm = new MyMenu();
        OperationMethods om = new OperationMethods();
        System.out.println("1 --------- Open Message");
        System.out.println("2 --------- Back"); 
        
        String in = input.next();
        while(!in.equals("1")&&in.equals("2")){
            System.out.println("Not a valid option, choose again");
            in = input.next();
        }
        switch(in){
            case "1": om.selectInboxMessage(user);
            case "2": mm.writerMenus(user);
        } 
    }    
    public void operatingReceivedCorrectedMessages(User user){
        MyMenu mm = new MyMenu();
        OperationMethods om = new OperationMethods();
        System.out.println("1 --------- Open Message");
        System.out.println("2 --------- Back"); 
        
        String in = input.next();
        while(!in.equals("1")&&in.equals("2")){
            System.out.println("Not a valid option, choose again");
            in = input.next();
        }
        switch(in){
            case "1": om.selectInboxMessage(user);break;
            case "2": mm.editorMenus(user);break;
        } 
    }
    public void operatingSentCorrectedMessages(User user){
        MyMenu mm = new MyMenu();
        OperationMethods om = new OperationMethods();
        System.out.println("1 --------- Open Message");
        System.out.println("2 --------- Back"); 
        
        String in = input.next();
        while(!in.equals("1")&&!in.equals("2")){
            System.out.println("Not a valid option, choose again");
            in = input.next();
        }
        switch(in){
            case "1": om.selectSentMessage(user);break;
            case "2": mm.writerMenus(user);break;
        } 
    }
    
    public void writerMenus(User user){
        clearConsole();
        MyMenu mm = new MyMenu();
        OperationMethods om = new OperationMethods();
        String login = om.loginTime();
        MessageCRUD mc = new MessageCRUD();
        System.out.println("Welcome "+user.getFname()+" "+user.getLname()+"!\n");
        System.out.println("1 --------- View my INFO");
        System.out.println("2 --------- View ONLINE USERS");
        System.out.println("3 --------- Create New Message");        
        System.out.println("4 --------- View my INBOX Messages  "+mc.findNewMessageByReceiverId(user.getId())+" UNREAD MESSAGES");
        System.out.println("5 --------- View my SENT Messages");
        System.out.println("6 --------- View my DELETED Messages");
        System.out.println("7 --------- View my Message Corrections");
        System.out.println("8 --------- Log Out");
        String in = input.next();
        while(!in.equals("1")&&!in.equals("2")&&!in.equals("3")&&!in.equals("4")&&!in.equals("5")&&!in.equals("6")&&!in.equals("7")&&!in.equals("8")){
            System.out.println("Not a valid option, choose again");
            in = input.next();
        }
        switch(in){
            case "1": {om.viewUser(user);om.promptEnterKey();mm.writerMenus(user);}break;
            case "2": {om.viewOnlineUsers();mm.writerMenus(user);}break;
            case "3": {try {
                                om.createNewMessage(user);
                            } catch (IOException ex) {
                                Logger.getLogger(MyMenu.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            mm.writerMenus(user);}break;
            case "4": {om.viewMyInboxMessages(user,false);mm.operatingInboxMessages(user);}break;
            case "5": {om.viewMySentMessages(user,false); mm.operatingSentMessages(user);}break;
            case "6": {om.viewMyDeletedMessages(user,false); mm.operatingDeletedMessages(user);}break;
            case "7": {om.viewSentCorrectedMessages(user); mm.operatingSentCorrectedMessages(user);}break;
            case "8": om.logOut(user.getId(),login);
        }
    }        
    public void writerMessageOperations(User user, int msg_id){
        OperationMethods om = new OperationMethods();
        MessageCRUD mc = new MessageCRUD();
        MyMenu mm = new MyMenu();
        if(mc.findMessageById(msg_id).getSenderId()==user.getId()){
            System.out.println("1 --------- Forward");
            System.out.println("2 --------- Delete");
            System.out.println("3 --------- Main Menu");
            String in = input.next();
            while(!in.equals("1")&&!in.equals("2")&&!in.equals("3")&&!in.equals("4")){
                System.out.println("Not a valid option, choose again");
                in = input.next();
            }
            switch(in){
                case "1": {
                            try {
                                om.forwardMessage(user, msg_id);
                            } catch (IOException ex) {
                                Logger.getLogger(MyMenu.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            mm.writerMenus(user);break;
                case "2": om.shallowDeleteMessage(user, msg_id); mm.writerMenus(user);break;
                case "3": mm.writerMenus(user);
                }
            }
        else{
        System.out.println("1 --------- Reply");
        System.out.println("2 --------- Forward");
        System.out.println("3 --------- Delete");
        System.out.println("4 --------- Main Menu");
        String in = input.next();
        while(!in.equals("1")&&!in.equals("2")&&!in.equals("3")&&!in.equals("4")){
            System.out.println("Not a valid option, choose again");
            in = input.next();
        }
        switch(in){
            case "1": {
                        try {
                            om.replyToMessage(user, msg_id);
                        } catch (IOException ex) {
                            Logger.getLogger(MyMenu.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                            mm.writerMenus(user);break;
            case "2": {
                        try {
                            om.forwardMessage(user, msg_id);
                        } catch (IOException ex) {
                            Logger.getLogger(MyMenu.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                            mm.writerMenus(user);break;
            case "3": om.shallowDeleteMessage(user, msg_id); mm.writerMenus(user);break;
            case "4": mm.writerMenus(user);
            }
        }
    }    
}
