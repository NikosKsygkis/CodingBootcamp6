
package newsintercomAPP;

import java.io.Console;
import tablesDAO.UserRolesCRUD;
import tablesConstructors.Message;
import tablesConstructors.UserRoles;
import tablesConstructors.User;
import tablesConstructors.LogInfo;
import tablesDAO.LogInfoCRUD;
import tablesDAO.MessageCRUD;
import tablesDAO.UserCRUD;
import static newsintercomAPP.ConsoleUtils.clearConsole;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nikos ksygkis
 */
public class OperationMethods {
    
   
   
    public void promptEnterKey(){
    System.out.println("Press \"ENTER\" to continue...");
    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();
    }
  
    public void registerUser(){                                                 // Registers a new User in the Database table `user`
        Scanner input = new Scanner(System.in);
        UserRolesCRUD urc = new UserRolesCRUD();
        OperationMethods om = new OperationMethods();
        UserCRUD uc = new UserCRUD();
        System.out.println("Please enter your username, use up to 25 characters: ");
        String username = input.next();
        
        while(username.length()>=25){
            System.out.println("Try again, use up to 25 characters: ");
            username=input.next();
        }    
        while(uc.findUserByUsername(username)!=null){
            System.out.println("This username is alreade used, enter another");
            username=input.next();
        }
        
        System.out.println("Please enter password, use at least 6 characters and up to 25 characters");
        String password = om.passwordConsole();
        System.out.println(password.length());
        
        while(password.length()<5 || password.length()>=25){
            System.out.println("Please enter a valid password between 6 and 25 characters: ");
            password=om.passwordConsole();
        }
        System.out.println("Please enter your First Name: ");
        String fname = input.next();
        while(fname.length()>=25){
            System.out.println("Please use up to 45 characters: ");
            fname=input.next();
        }        
        System.out.println("Please enter your Last Name: ");
        String lname = input.next();
        while(lname.length()>=25){
            System.out.println("Please use up to 45 characters: ");
            lname=input.next();
        }

        
        Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        String creationDate = (String.valueOf(currentTimestamp));

        uc.createUser(new User(username, password, fname, lname, creationDate,false));                  // Inserts the user that registered
        
        urc.createUserRole(new UserRoles(uc.findUserByUsername(username).getId(),false,false,true));    // With the default capacity of a 'Writer'

        User as = uc.findUserByUsername(username);
        System.out.println("Congratulations Mr/Ms "+as.getFname()+" "+ as.getLname()+", Registration Completed!");
        System.out.println("Return To The Previous Menu To Login!");
    }
//========================================================================================================
    
    public User loginUser(){                            // Returns the User that has logged in
        Scanner input = new Scanner(System.in);
        OperationMethods om = new OperationMethods();
        UserCRUD uc = new UserCRUD();
        System.out.println("Please enter your username: ");
        String username = input.next();
        System.out.println("Please enter your password");
        String password = om.passwordConsole();
        
        while(uc.findUserByUsernamePassword(username, password) == null){
            System.out.println("Your credentials are invalid, please try again \n");
            System.out.println("Enter username: ");
            username=input.next();
            System.out.println("Enter password");
            password=om.passwordConsole();
        } 
               uc.updateUserOnline(uc.findUserByUsernamePassword(username, password));  // The User who logged In, appears ONLINE
               
        return uc.findUserByUsernamePassword(username, password);
    }

    public String loginTime(){              // Returns the TimeStamp of the User's Log In
        Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        String login = (String.valueOf(currentTimestamp));
        return login;
    }
    public String logoutTime(){             // Returns the Timestamp of the User's Log Out
        Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        String logout = (String.valueOf(currentTimestamp));
        return logout;
    }
    public void logOut(int id, String login){   // Method that creates a new Log Row in tha database table 'loginfo'
        UserCRUD uc = new UserCRUD();
        OperationMethods lio = new OperationMethods();
        MyMenu menu = new MyMenu();
        LogInfoCRUD lc = new LogInfoCRUD();
        String logout = lio.logoutTime();
        LogInfo log = new LogInfo(id, login, logout);   // id= User's ID, login= User's log-in Timestamp and logout= User's log-out Timestamp
        lc.createLogInfo(log);
        uc.updateUserOffline(uc.findUserById(id));      // The User is now OFFLINE
        menu.myMainMenu();                              // Returns to the Main Menu of the application
    }    
    
    
//===============================================================================================
    public String returnRole(User user){        // Returns the Capacity of a User
        UserRolesCRUD urc = new UserRolesCRUD();
        if(urc.findUserRoleByUserId(user.getId()).getAdministrator()) return "Administrator";
        else if(urc.findUserRoleByUserId(user.getId()).getEditor()) return "Editor";
        else if(urc.findUserRoleByUserId(user.getId()).getWriter()) return "Writer";
        else
        return null;
    }
//================================================================================================   
    public void createNewMessage(User user) throws IOException{     // Creates a New Message in the database table `messages` and 
                                                                    // returns back to the User's Menu(Editor's or Writer's menu accordingly)
        
        int receiverid;
        MyMenu menu = new MyMenu();
        OperationMethods om = new OperationMethods();
        MessageFile mf = new MessageFile();
        UserCRUD uc = new UserCRUD();
        MessageCRUD mc = new MessageCRUD();
        Scanner input = new Scanner(System.in);
        for(User vuser:uc.findAllUsers()){
            if(vuser.getId() != user.getId()&&!vuser.getUsername().equals("admin"))
            System.out.println(vuser.getFname()+" "+vuser.getLname()+" ID: "+vuser.getId());
        }
        System.out.println("Choose the ID of the message recipient: ");        
        do{
            while(!input.hasNextInt()){
            System.out.println("That's not a correct ID, enter again: ");
            input.next();
            }
            receiverid = input.nextInt();input.nextLine();
        } while(uc.findUserById(receiverid) == null||uc.findUserById(receiverid).getUsername().equals("admin"));

        System.out.println("Type message title here, use up to 100 characters:");
        String title = "\"" + input.nextLine() + "\"";
            while(title.length()>100){
                System.out.println("The title must be under 100 characters: ");
                title="\"" + input.nextLine() + "\""; 
            }
        System.out.println("Type your message here, use up to 250 characters: ");    
        String data = "\"" + input.nextLine() + "\"";
            while(data.length()>250){
                System.out.println("The message must be up to 250 characters: ");  
            }
            
        long millis=System.currentTimeMillis();  
        Timestamp registrationDT = new Timestamp(millis);
        String submit_date = registrationDT.toString();
            
        Message message = new Message(null,user.getId(),receiverid,user.getUsername(),
                uc.findUserById(receiverid).getUsername(), title,data,submit_date,false,true,true);
        mf.commenceWriteToFile(message);
        
        mc.createMessage(message);
        System.out.println("Message is sent!");
        om.promptEnterKey();
        menu.editorMenus(user);
    }
//=========================================================================================================    
    public void viewMyInboxMessages(User user, Boolean admin){      // Views the User's Received Messages that have not been deleted
                                                                    // And returns to the User's Menu to operate them accordingly
                                                                    // If the User is the administrator(Boolean admin=true), he can
                                                                    // only observe the messages of the other Users.
        MessageCRUD mc = new MessageCRUD();
        MyMenu menu = new MyMenu();
        int count = 0;
        OperationMethods om = new OperationMethods();
        System.out.println("================ User's Inbox =================================");
        if(mc.findMessagesByReceiverId(user.getId())== null){
            System.out.println("There are no messages");
            if(om.returnRole(user).equals("Editor")&&!admin){
                om.promptEnterKey();
                menu.editorMenus(user);
            }
            if(om.returnRole(user).equals("Writer")&&!admin){
                om.promptEnterKey();
                menu.writerMenus(user);
            }
        }        
        else {    
            for(Message msg:mc.findMessagesByReceiverId(user.getId())){       
                if(msg.getMsg_id()!=null&&msg.getIsReceiverActive()){
                    System.out.print("\nMessage ID: "+msg.getMsg_id()+"\tSent by: "+msg.getSenderUsername()+" at "
                    +msg.getSubmit()+"  To: "+msg.getReceiverUsername()+"\n"+"\t\tTitle: "+msg.getTitle());
                    if(!msg.getIsRead()){
                        System.out.print(" ------  **UNREAD** ");
                    } count+=1;   
                }
            }
            if(count == 0 && om.returnRole(user).equals("Editor")){
                System.out.println("There are no messages");
                if(!admin){
                    om.promptEnterKey();
                    menu.editorMenus(user);
                }
            }
            if(count == 0 && om.returnRole(user).equals("Writer")){
                System.out.println("There are no messages");
                if(!admin){
                    om.promptEnterKey();
                    menu.writerMenus(user);
                }
            }
        }
    }
//=========================================================================================================
    public void viewMySentMessages(User user, Boolean admin){       // The same as the viewMyInboxMessages method, except that in
                                                                    // this case, it refers to a User's SENT messages
        MessageCRUD mc = new MessageCRUD();
        MyMenu menu = new MyMenu();
        int count=0;
        OperationMethods om = new OperationMethods();
        System.out.println("\n================ User's Sent Messages =========================");
        if(mc.findMessagesByCreatorId(user.getId())== null){
            System.out.println("There are no messages");
            if(om.returnRole(user).equals("Editor")&&!admin){
                om.promptEnterKey();
                menu.editorMenus(user);
            }
            if(om.returnRole(user).equals("Writer")&&!admin){
                om.promptEnterKey();
                menu.writerMenus(user);
            }            
        }
        else {   
            for(Message msg:mc.findMessagesByCreatorId(user.getId())){
                if(msg.getMsg_id()!=null&&msg.getIsSenderActive()){
                    System.out.println("Message ID: "+msg.getMsg_id()+"\tSent to: "+msg.getReceiverUsername()+" at "
                        +msg.getSubmit()+"\n\t\t"+"Title: "+msg.getTitle());

                }count+=1;
            }
            if(count == 0 && om.returnRole(user).equals("Editor")){
                System.out.println("There are no messages");
                if(!admin){
                    om.promptEnterKey();
                    menu.editorMenus(user);}
            }
            if(count == 0 && om.returnRole(user).equals("Writer")&&!admin){
                System.out.println("There are no messages");
                if(!admin){
                    om.promptEnterKey();
                    menu.writerMenus(user);}
            }            
        }
    }
//============================================================================================================
    public void viewMyDeletedMessages(User user, Boolean admin){            // The same as the methods above, except that this,
                                                                            // refers to a user's deleted messages
        MessageCRUD mc = new MessageCRUD();
        int count=0;
        MyMenu menu = new MyMenu();
        OperationMethods om = new OperationMethods();
        System.out.println("================ User's Deleted Sent Messages ===============\n");
        if(mc.findMessagesByCreatorId(user.getId())== null){
            System.out.println("There are no deleted sent messages\n");
        }
        else if(!admin){
            for(Message msg:mc.findMessagesByCreatorId(user.getId())){
                if(!msg.getIsSenderActive()&&msg.getMsg_id()!= null){
                System.out.println("Message ID: "+msg.getMsg_id()+"\tSent to: "+msg.getReceiverUsername()+" at "
                        +msg.getSubmit()+"\n\t\t"+"Title: "+msg.getTitle());
                    count+=1;
                }        
            }
        }
        System.out.println("\n================ User's Deleted Inbox =======================\n");
        if(mc.findMessagesByReceiverId(user.getId())==null){
            System.out.println("There are no deleted received messages\n");
        }
        else if(!admin){
            for(Message msg:mc.findMessagesByReceiverId(user.getId())){
                if(!msg.getIsReceiverActive()&&msg.getMsg_id()!= null){
                    System.out.println("Message ID: "+msg.getMsg_id()+"\tSent by: "+msg.getSenderUsername()+" at "
                            +msg.getSubmit()+"\n\t\t"+"Title: "+msg.getTitle());
                count+=1;
                }
            }       
        if(count == 0&& om.returnRole(user).equals("Editor")&&!admin){ 
            System.out.println("There are no deleted messages");
            om.promptEnterKey();
            menu.editorMenus(user);}
        if(count == 0 && om.returnRole(user).equals("Writer")&&!admin){
            System.out.println("There are no deleted messages");
            om.promptEnterKey();
            menu.writerMenus(user);
            }
        }
    }
//=============================================================================================================
    public void selectInboxMessage(User user){          // Method that selects an inbox message by the user, in order to operate
                                                        // for example, reply, forward, delete the message
        int msgId;
        Scanner input = new Scanner(System.in);
        OperationMethods om = new OperationMethods();
        MyMenu menu = new MyMenu();
        MessageCRUD mc = new MessageCRUD();
        
        do{
            System.out.println("Open Message By Selecting Correct Message ID: ");
            while(!input.hasNextInt()){
            System.out.println("That's not a correct message ID, enter again: ");
            input.next();
            }
            msgId = input.nextInt();input.nextLine();
        } while(om.inboxValidation(user, msgId));
        
        System.out.println("Message ID: "+mc.findMessageById(msgId).getMsg_id()
                            +" Sent From: "+mc.findMessageById(msgId).getSenderUsername()+" To "
                            +mc.findMessageById(msgId).getReceiverUsername()+" At "+mc.findMessageById(msgId).getSubmit());
        System.out.println("Title: "+mc.findMessageById(msgId).getTitle());
        System.out.println("Message:\n"+mc.findMessageById(msgId).getData()+"\n");
        if(mc.findMessageById(msgId).getIsRead() == false){
            mc.updateIsRead(mc.findMessageById(msgId));}
        if(om.returnRole(user).equals("Editor")){
            om.promptEnterKey();
            menu.editorMessageOperations(user, msgId);
        }
        else{
            
            menu.writerMessageOperations(user, msgId);
        }
    }
//==============================================================================================================    
public boolean inboxValidation(User user, int id){      // This method assures that the inbox message that is selected by the user
                                                        // is the correct one.
    MessageCRUD mc = new MessageCRUD();
    if(mc.findMessageById(id)==null){
        return true;
    }
    else if(mc.findMessageById(id).getReceiverId() == mc.findMessageById(id).getSenderId()&&
            (!mc.findMessageById(id).getIsReceiverActive()&&!mc.findMessageById(id).getIsSenderActive())){
        return false;
    }
    else if(mc.findMessageById(id).getReceiverId()==user.getId() && mc.findMessageById(id).getIsReceiverActive()){
        return false;
    }
    else{
     return true;
    }
 }   
   
//=============================================================================================================
    public void selectSentMessage(User user){           // Method that selects a Sent message by the user, in order to operate
        int msgId;
        Scanner input = new Scanner(System.in);
        OperationMethods om = new OperationMethods();
        MyMenu menu = new MyMenu();
        MessageCRUD mc = new MessageCRUD();
        
        do{
            System.out.println("Open Message By Selecting Correct Message ID: ");
            while(!input.hasNextInt()){
            System.out.println("That's not a correct message ID, enter again: ");
            input.next();
            }
            //System.out.println("That's not a correct message ID, enter again: ");
            msgId = input.nextInt();input.nextLine();
        } while(om.sentboxValidation(user, msgId));
        System.out.println("Message ID: "+mc.findMessageById(msgId).getMsg_id()
                            +" Sent From: "+mc.findMessageById(msgId).getSenderUsername()+" To "
                            +mc.findMessageById(msgId).getReceiverUsername()+" At "+mc.findMessageById(msgId).getSubmit());
        System.out.println("Title: "+mc.findMessageById(msgId).getTitle());
        System.out.println("Message:\n"+mc.findMessageById(msgId).getData());
        if(om.returnRole(user).equals("Editor")) menu.editorMessageOperations(user, msgId);
        if(om.returnRole(user).equals("Writer")) menu.writerMessageOperations(user, msgId);
    }
//=============================================================================================================
    
    public boolean sentboxValidation(User user, int id){        // This method assures that the inbox message that is selected by the user
                                                                // is the correct one.
        MessageCRUD mc = new MessageCRUD();
        if(mc.findMessageById(id)==null){
            return true;
        }
        else if(mc.findMessageById(id).getReceiverId() == mc.findMessageById(id).getSenderId()&&
                (!mc.findMessageById(id).getIsReceiverActive()&&!mc.findMessageById(id).getIsSenderActive())){
            return false;
        }
        else if(mc.findMessageById(id).getSenderId()==user.getId() && mc.findMessageById(id).getIsSenderActive()){
            return false;
        }
        else{
         return true;
        }
     }
//==============================================================================================================
    public void selectDeletedMessage(User user){        // Method that selects a deleted message by the user
        int msgId;
        Scanner input = new Scanner(System.in);
        MessageCRUD mc = new MessageCRUD();
        OperationMethods om = new OperationMethods();
        MyMenu menu = new MyMenu();
        
        do{
            System.out.println("Open Message By Selecting Correct Message ID: ");
            while(!input.hasNextInt()){
            System.out.println("That's not a correct message ID, enter again: ");
            input.next();
            }
            
            msgId = input.nextInt();input.nextLine();
        } while(om.deleteboxValidation(user, msgId));
        System.out.println("Message ID: "+mc.findMessageById(msgId).getMsg_id()
                            +" Sent From: "+mc.findMessageById(msgId).getSenderUsername()+" To "
                            +mc.findMessageById(msgId).getReceiverUsername()+" At "+mc.findMessageById(msgId).getSubmit());
        System.out.println("Title: "+mc.findMessageById(msgId).getTitle());
        System.out.println("Message:\n"+mc.findMessageById(msgId).getData());
        if(om.returnRole(user).equals("Editor")) menu.editorMessageOperations(user, msgId);
        if(om.returnRole(user).equals("Writer"))menu.writerMessageOperations(user, msgId);
    }
//=============================================================================================================
    
    public boolean deleteboxValidation(User user, int id){  // This method assures that the deleted message that is selected by the user
                                                            // is the correct one.
        MessageCRUD mc = new MessageCRUD();
        if(mc.findMessageById(id)==null){
            return true;
        }
        else if(mc.findMessageById(id).getReceiverId() == user.getId()&&
                !mc.findMessageById(id).getIsReceiverActive()){
            return false;
        }
        else if(mc.findMessageById(id).getSenderId() == user.getId()&&
                !mc.findMessageById(id).getIsSenderActive()){
            return false;
        }
        else if(mc.findMessageById(id).getSenderId() == user.getId() && 
                mc.findMessageById(id).getReceiverId() == user.getId()
                &&(mc.findMessageById(id).getIsReceiverActive()&&mc.findMessageById(id).getIsSenderActive())){
            return true;
        }
        else if(mc.findMessageById(id).getSenderId() == user.getId() && 
                mc.findMessageById(id).getReceiverId() == user.getId()
                &&(mc.findMessageById(id).getIsReceiverActive()||mc.findMessageById(id).getIsSenderActive())){
            return false;
        }
        else{
         return true;
        }
     }    
//================================================================================================================
    public void shallowDeleteMessage(User user, int msgId){                 // Method that defines a message as deleted, but it 
                                                                            // still exists in the database table `messages`
        MessageCRUD mc = new MessageCRUD();
        OperationMethods om = new OperationMethods();
        if(mc.findMessageById(msgId).getReceiverId() == user.getId()){
            mc.updateIsReceiverActive(mc.findMessageById(msgId));
            System.out.println("Message Deleted");
            om.promptEnterKey();
        }
        else {
            mc.updateIsSenderActive(mc.findMessageById(msgId));
            System.out.println("Message Deleted");
            om.promptEnterKey();
        }
    }
//==================================================================================================================    
    public void deepDeleteMessage(User user, int msgId){        // Method that completely deletes a message from the database table `messages`
                                                                // Only an Editor can utilize it
        MessageCRUD mc = new MessageCRUD();
        OperationMethods om = new OperationMethods();
        mc.deleteMessage(msgId);
        System.out.println("Message Deleted");
        om.promptEnterKey();
    }       
//==================================================================================================================
    public void replyToMessage(User user, int msgId) throws IOException{        // Method that creates a new message as a reply to the message
                                                                                // that has been selected by the User
        Scanner input = new Scanner(System.in);
        MessageCRUD mc = new MessageCRUD();
        MessageFile mf = new MessageFile();
        UserCRUD uc = new UserCRUD();
        OperationMethods om = new OperationMethods();
        System.out.println("Type message title here, use up to 100 characters:");
        String title = "\"" + input.nextLine() + "\"";
            while(title.length()>=100){
                System.out.println("The title must be under 100 characters: ");
                title="\"" + input.nextLine() + "\"";
            }
        System.out.println("Type your message here, use up to 250 characters: ");    
        String data = "\"" + input.nextLine() + "\"";
            while(data.length()>=250){
                System.out.println("The message must be up to 250 characters: ");
                data = "\"" + input.nextLine() + "\"";
            }
        long millis=System.currentTimeMillis();  
        Timestamp registrationDT = new Timestamp(millis);
        String submit_date = registrationDT.toString();
        
        Message message = new Message(msgId,user.getId(),mc.findMessageById(msgId).getSenderId(),user.getUsername(),
                uc.findUserById(mc.findMessageById(msgId).getSenderId()).getUsername(), title,data,submit_date,false,true,true);
        mf.commenceWriteToFile(message);
        mc.createMessage(message);
        System.out.println("Message is Sent");
        om.promptEnterKey();
    }
//==================================================================================================================
    public void correctAMessage(User user, int msgId) throws IOException{   // Method that an editor utilizes to make
                                                                            // Corrections / re-write the message data
        MessageCRUD mc = new MessageCRUD();
        MyMenu menu = new MyMenu();
        MessageFile mf = new MessageFile();
        OperationMethods om = new OperationMethods();
        Message message = mc.findMessageById(msgId);
        Scanner input = new Scanner(System.in);
        String updatedTitle = "CORRECTIONS For Subject: "+message.getTitle();
        System.out.println("Message to Correct: ");
        System.out.println("Title: "+message.getTitle());
        System.out.println(message.getData());
        System.out.println("Update the message here, use up to 250 characters: ");    
        String updatedData = "\"" + input.nextLine() + "\"";
            while(updatedData.length()>=250){
                System.out.println("The message must be up to 250 characters: ");  
                updatedData = "\"" + input.nextLine() + "\"";
            }
        message.setTitle(updatedTitle);
        message.setData(updatedData);
        mc.updateMessage(message);
        mf.commenceWriteToFile(message);
        System.out.println("Corrections have been made");
        om.promptEnterKey();
        menu.editorMenus(user);
    }
//==================================================================================================================
    public void viewSentCorrectedMessages(User user){           // A method that a WRITER utilizes in order to view
                                                                // corrections to his message by an aditor.
        MessageCRUD mc = new MessageCRUD();
        MyMenu menu = new MyMenu();
        int count = 0;
        OperationMethods om = new OperationMethods();
        if(mc.findMessagesByCreatorId(user.getId())!=null){
            
            for(Message msg:mc.findMessagesByCreatorId(user.getId())){
                
                if(msg.getTitle().startsWith("CORRECTIONS For Subject:")){
                    System.out.println("Sent to: "+msg.getReceiverUsername()+" at "
                        +msg.getSubmit()+"\n"+"Title: "+msg.getTitle()+" Message ID: "+msg.getMsg_id());
                count+=1;}
            }
            
            if(count == 0){
                
                System.out.println("There are no corrected messages");
                om.promptEnterKey();
                menu.writerMenus(user);
            }
        }
        else{
            System.out.println("There are no corrected messages");
            om.promptEnterKey();
            menu.writerMenus(user);
            
        }
        
    }
//==================================================================================================================
    public void viewReceivedCorrectedMessages(User user){       // A method that an EDITOR utilizes in order to view the
                                                                // Corrections he has made on messages sent by other users.
        MessageCRUD mc = new MessageCRUD();
        MyMenu menu = new MyMenu();
        int count = 0;
        OperationMethods om = new OperationMethods();
        if(mc.findMessagesByReceiverId(user.getId())!=null){
            for(Message msg:mc.findMessagesByReceiverId(user.getId())){
                if(msg.getMsg_id()!=null && msg.getTitle().startsWith("CORRECTIONS For Subject:")){
                    System.out.println("Sent to: "+msg.getReceiverUsername()+" at "
                        +msg.getSubmit()+"\n"+"Title: "+msg.getTitle()+" Message ID: "+msg.getMsg_id());
                    count+=1;
                }
            }
            if(count ==0 ){
                System.out.println("There are no corrected messages");
                om.promptEnterKey();
                menu.editorMenus(user);
            }
        }
        else{
            System.out.println("There are no corrected messages");
            om.promptEnterKey();
            menu.editorMenus(user);
        }
    }    
//==================================================================================================================    
    public void forwardMessage(User user, int msgId) throws IOException{    // A method that forwards a selected message
                                                                            // It also creates a new record of the forwarded message
                                                                            // in the database table `messages`
        int receiverid;
        UserCRUD uc = new UserCRUD();
        MessageCRUD mc = new MessageCRUD();
        MessageFile mf = new MessageFile();
        OperationMethods om = new OperationMethods();
        Scanner input = new Scanner(System.in);

        for(User vuser:uc.findAllUsers()){
            if(!vuser.getUsername().equals("admin"))
            System.out.println(vuser.getFname()+" "+vuser.getLname()+" ID: "+vuser.getId());
        }
        System.out.println("Choose the ID of the message recipient: ");        
        do{
            while(!input.hasNextInt()){
            System.out.println("That's not a correct ID, enter again: ");
            input.next();
            }
            receiverid = input.nextInt();input.nextLine();
        } while(uc.findUserById(receiverid) == null || uc.findUserById(receiverid).getUsername().equals("admin"));
            
        long millis=System.currentTimeMillis();  
        Timestamp registrationDT = new Timestamp(millis);
        String submit_date = registrationDT.toString();
            
        Message message = new Message(null,user.getId(),receiverid,user.getUsername(),
                uc.findUserById(receiverid).getUsername(), mc.findMessageById(msgId).getTitle(),
                mc.findMessageById(msgId).getData(),submit_date,false,true,true);
        mc.createMessage(message);
        mf.commenceWriteToFile(message);
        System.out.println("Message Sent!\n");
        om.promptEnterKey();
    }
//========================================================================================================================    
    public void createMsgToAllWriters(User user){       // A method that an EDITOR can utilize in order to sent a message to 
                                                        // every WRITER
        Scanner input = new Scanner(System.in);
        UserCRUD uc = new UserCRUD();
        MessageCRUD mc = new MessageCRUD();
        MessageFile mf = new MessageFile();
        OperationMethods om = new OperationMethods();

        System.out.println("Type message title here, use up to 100 characters:");
        String title = input.nextLine();
            while(title.length()>100){
                System.out.println("The title must be under 100 characters: ");
                title=input.nextLine();   
            }
        System.out.println("Type your message here, use up to 250 characters: ");    
        String data = input.nextLine();
            while(data.length()>250){
                System.out.println("The message must be up to 250 characters: ");  
            }
        long millis=System.currentTimeMillis();  
        Timestamp registrationDT = new Timestamp(millis);
        String submit_date = registrationDT.toString(); 
        
        for(User vuser:uc.findAllUsers()){            
            if(om.returnRole(vuser).equals("Writer")){
                Message message = new Message(null,user.getId(),vuser.getId(),user.getUsername(),
                vuser.getUsername(), title,data,submit_date,false,true,true);
                mc.createMessage(message);
                try {
                    mf.commenceWriteToFile(message);
                } catch (IOException ex) {
                    Logger.getLogger(OperationMethods.class.getName()).log(Level.SEVERE, null, ex);
                }
            }          
        }
        System.out.println("Message Sent!\n");
        om.promptEnterKey();        
    }
//================================================================================================================    
    public String passwordConsole(){        // Method that creates a Password String from a Scanner object, 
                                            // or a MASKED String Password from a Console Object
                                            // The IDE Netbeans cannot utilize the Console Object
        String password;
        Scanner input = new Scanner(System.in);
        password = input.nextLine();
        
//        Console console = System.console();
//        password = new String(console.readPassword());
        
        
       return password; 
    }
//================================================================================================================    
//================================================================================================================
    public void viewUser(User user){        // A method that a user utilizes in order to view the user's info
        clearConsole();
        UserCRUD uc = new UserCRUD();
        OperationMethods lr = new OperationMethods();
        uc.findUserById(user.getId());
                    System.out.println("ID: "+user.getId()+"\t First Name: "+user.getFname()+", Last Name: "
                    +user.getLname()+", Username: "+user.getUsername()+", password: "+user.getPassword()
                    +",  Registered in: "+user.getCreationDate()+" Capacity: "+lr.returnRole(user));    
    }
    public void viewAllUsers(){             // A method that a user utilizes in order to view every user's basic info except the admin's
        clearConsole();
        UserCRUD uc = new UserCRUD();
        OperationMethods lr = new OperationMethods();
        for(User user : uc.findAllUsers()){
            if(!user.getUsername().equals("admin")){
            System.out.println("Capacity: "+lr.returnRole(user)+", First Name: "+user.getFname()+", Last Name: "
                    +user.getLname()+", Username: "+user.getUsername()+"\t\tID: "+user.getId());
            }
        }        
    }
    public void viewOnlineUsers(){      // A method that every user utilizes in order to view all the currently logged-in USERS except the admin
        clearConsole();
        int count = 0;
        UserCRUD uc = new UserCRUD();
        OperationMethods om = new OperationMethods();
        if(uc.findOnlineUsers()==null){
            System.out.println("There aren't any users online at the moment");
        }
        else{
            for(User user : uc.findOnlineUsers()){
                if(!user.getUsername().equals("admin")){
                System.out.println("First Name: "+user.getFname()+", Last Name: "
                        +user.getLname()+", Username: "+user.getUsername()+" Capacity: "+om.returnRole(user)+"\t\tID: "+user.getId());
                        count+=1;
                }
            }
            if(count == 0){System.out.println("None is Online");}
        }
        om.promptEnterKey();
    }    
//================================================================================================================
//============================ S U P E R A D M I N   M E T H O D S ===============================================
//================================================================================================================
    
    public void createDummyUser(){                              // Method that only an administrator can utilize in order to create a new User
        Scanner input = new Scanner(System.in);
        UserCRUD uc = new UserCRUD();
        MyMenu menu = new MyMenu();
        OperationMethods om = new OperationMethods();
        UserRolesCRUD urc = new UserRolesCRUD();
        System.out.println("Please enter username, use up to 25 characters: ");
        String username = input.next();
        
        while(username.length()>=25){
            System.out.println("Try again, use up to 25 characters: ");
            username=input.next();
        }    
        while(uc.findUserByUsername(username)!=null){
            System.out.println("This username is alreade used, enter another");
            username=input.next();
        }
        
        System.out.println("Please enter password, use at least 6 characters and up to 25 characters");
        String password = om.passwordConsole();
        System.out.println(password.length());
        
        while(password.length()<5 || password.length()>=25){
            System.out.println("Please enter a valid password between 6 and 25 characters: ");
            password=om.passwordConsole();
        }
        System.out.println("Please enter First Name: ");
        String fname = input.next();
        while(fname.length()>=25){
            System.out.println("Please use up to 45 characters: ");
            fname=input.next();
        }        
        System.out.println("Please enter Last Name: ");
        String lname = input.next();
        while(lname.length()>=25){
            System.out.println("Please use up to 45 characters: ");
            lname=input.next();
        }        
       
        Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        String creationDate = (String.valueOf(currentTimestamp));

        uc.createUser(new User(username, password, fname, lname, creationDate, false));
        
        urc.createUserRole(new UserRoles(uc.findUserByUsername(username).getId(),false,false,true));

        User as = uc.findUserByUsername(username);
        System.out.println("The user "+as.getFname()+" "+ as.getLname()+", has been registered!");  
        om.promptEnterKey();
        
        
    }
//===============================================================================================================================
    public void updateUserInfo(int userId){             // A Method that the administrator uses to update a User's information
        Scanner input = new Scanner(System.in);
        MyMenu menu = new MyMenu();
        UserCRUD uc = new UserCRUD();
        OperationMethods om = new OperationMethods();        
        
        String fname; String lname; String username; String password;        
                

        User user = uc.findUserById(userId);
        System.out.println("1 --------- Update First Name");
        System.out.println("2 --------- Update Last Name");
        System.out.println("3 --------- Update Username");
        System.out.println("4 --------- Update Password");
        System.out.println("5 --------- Back");      

        String in = input.nextLine();
        while(!in.equals("1")&&!in.equals("2")&&!in.equals("3")&&!in.equals("4")&&!in.equals("5")){
            in = input.nextLine();
        }
        
        
        switch(in){
            case "1": {
                        System.out.println("Please update First Name: ");
                        fname = input.nextLine();
                        while(fname.length()>=25){
                        System.out.println("Please use up to 45 characters: ");
                        fname=input.nextLine();
                            }
                        user.setFname(fname);
                        uc.updateUser(user);
                        om.viewUser(user);
                        om.updateUserInfo(userId);
                        }break;
            
            case "2": {
                        System.out.println("Please update Last Name: ");              
                        lname = input.nextLine();
                        while(lname.length()>=25){
                        System.out.println("Please use up to 45 characters: ");
                        lname=input.nextLine();         
                            }
                        user.setLname(lname);
                        uc.updateUser(user);
                        om.viewUser(user);
                        om.updateUserInfo(userId);
                        }break;
            
            case "3":  {
                        System.out.println("Update Username:");
                        username = input.nextLine();  
                        while(username.length()>=25 || uc.findUserByUsername(username)!=null){
                        System.out.println("Try again, use a different username which is up to 25 characters: ");
                        username=input.nextLine();
                            }
                        user.setUsername(username);
                        uc.updateUser(user);
                        om.viewUser(user);
                        om.updateUserInfo(userId);
                        }break;
            
            case "4":  { 
                        System.out.println("Update password");
                        password = om.passwordConsole();
                        while(password.length()<5 || password.length()>=25){
                        System.out.println("Please enter a valid password between 6 and 25 characters: ");
                        password=om.passwordConsole();
                            }
                        user.setPassword(password);
                        uc.updateUser(user);
                        om.viewUser(user);
                        om.updateUserInfo(userId);
                        }break;
            case "5": menu.superAdminUserMethods();
        }
        
        
        
        clearConsole();
        om.viewAllUsersSuperAdmin();
        om.promptEnterKey();
        menu.superAdminUserMethods();
    }
//=====================================================================================================================================
    public void deleteUser(){                                       // A method the administrator can utilize in order to delete a User
                                                                    
        LogInfoCRUD lc = new LogInfoCRUD();
        MyMenu menu = new MyMenu();
        Scanner input = new Scanner(System.in);
        UserCRUD uc = new UserCRUD();
        UserRolesCRUD urc = new UserRolesCRUD();
        OperationMethods om = new OperationMethods();
        clearConsole();
        om.viewAllUsersSuperAdmin();
        int userId;
        System.out.println("SELECT USER TO DELETE, BY USER ID:");        
        do{
            while(!input.hasNextInt()){
            
            input.next();
            }
            System.out.println("Choose a correct Id");
            userId = input.nextInt();input.nextLine();
        } while(uc.findUserById(userId) == null && userId!=1 && uc.findUserById(userId).getIsOnline());
        urc.deleteUserRole(userId);             // The user's Role is Deleted
        lc.deleteLogInfoByUserId(userId);       // The user's loginfo is Deleted
        uc.deleteUser(userId);                  // The User is deleted and the user's ID will now be null in the messages table
                                                // whether he was a the message's Sender, OR Recepient 
        om.promptEnterKey();
        clearConsole();
        menu.superAdminUserMethods();
    }
//===================================================================================================================================
    public void updateUserRoles(){              // A method that the administrator utilizes in order to change the capacity of an Editor OR a Writer
                                                // It's either a promotion from a Writer to an Editor, or a Demotion from an Editor to a Writer
        int userId;
        UserCRUD uc = new UserCRUD();
        MyMenu menu = new MyMenu();
        Scanner input = new Scanner(System.in);
        UserRolesCRUD urc = new UserRolesCRUD();
        OperationMethods om = new OperationMethods();
        om.viewAllUsersSuperAdmin();
        System.out.println("Choose a USER to PROMOTE to EDITOR OR DEMOTE to WRITER");
        System.out.println("SELECT BY USER ID:");        
        do{
            while(!input.hasNextInt()){
            System.out.println("That's not a correct ID, enter again: ");
            input.next();
            }
            userId = input.nextInt();input.nextLine();
        } while(uc.findUserById(userId) == null);
        if(om.returnRole(uc.findUserById(userId)).equals("Writer")){
            
            UserRoles role = urc.findUserRoleByUserId(userId);
           
            role.setEditor(true); role.setAdministrator(false); role.setWriter(false);
            urc.updateUserRole(role);
            System.out.println(uc.findUserById(userId).getUsername()+" has been promoted to Editor!");
        }
        else if(om.returnRole(uc.findUserById(userId)).equals("Editor")){
            UserRoles role = urc.findUserRoleByUserId(userId);
            role.setEditor(false); role.setAdministrator(false); role.setWriter(true);
            urc.updateUserRole(role);
            System.out.println(uc.findUserById(userId).getUsername()+" has been demoted to Writer!");
        }
        else {System.out.println("You couldn't update the current user's position");}
        om.promptEnterKey();
        menu.superAdminUserMethods();
    }
    
//=================================================================================================================================
     
    public void viewAllUsersSuperAdmin(){      //A method that the administrator utilizes in order to view All the info of every USER
    clearConsole();
    UserCRUD uc = new UserCRUD();
    OperationMethods lr = new OperationMethods();
    for(User user : uc.findAllUsers()){
            if(!user.getUsername().equals("admin")){
            System.out.println("ID: "+user.getId()+"\t First Name: "+user.getFname()+", Last Name: "
                    +user.getLname()+", Username: "+user.getUsername()+", password: "+user.getPassword()
                    +",  Registered in: "+user.getCreationDate()+" Capacity: "+lr.returnRole(user));
            }
        }
    }
   
}
