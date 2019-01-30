
package newsintercomAPP;
import tablesConstructors.Message;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.json.simple.JSONObject;

/**
 *
 * @author nikos ksygkis
 */
public class MessageFile {

    String path="C:/Users/user/Desktop/Foundation Project/myfile.txt";
    
    boolean appendtofile = true;
    
    public String myJson(Message msg) {
        JSONObject msgJson = new JSONObject();
              
        msgJson.put("id", msg.getMsg_id());
        msgJson.put("reply_id", msg.getReply_msg_id());
        msgJson.put("creator_id", msg.getSenderId());
        msgJson.put("receiver_id", msg.getReceiverId());
        msgJson.put("creator_username", msg.getSenderUsername());
        msgJson.put("receiver_username", msg.getReceiverUsername());
        msgJson.put("title", msg.getTitle());
        msgJson.put("mdata", msg.getData());
        msgJson.put("submit_date", msg.getSubmit());
        msgJson.put("is_read", msg.getIsRead());
        msgJson.put("is_creator_active", msg.getIsSenderActive());
        msgJson.put("is_receiver_active", msg.getIsReceiverActive());
        
        return msgJson.toJSONString();    
    }
    
    
    public void writeToFile(String text){
     
        FileWriter fwriter;
        try {
            fwriter = new FileWriter(path, appendtofile);
         
        PrintWriter pwriter = new PrintWriter(fwriter);
        pwriter.format("%s%n%n", text);
        pwriter.close();
        }catch (IOException ex) {
            System.out.println("ERROR! WRONG FILE PATH");
        }
    }
    
    public void commenceWriteToFile(Message msg) throws IOException{
        MessageFile mf = new MessageFile();
        mf.writeToFile(mf.myJson(msg));
    }
}
