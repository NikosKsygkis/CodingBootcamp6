
package tablesConstructors;
/**
 *
 * @author nikos ksygkis
 */
public class Message {
    
    private Integer msg_id;
    private Integer reply_msg_id;
    private int sender_id;
    private int receiver_id;
    private String sender_username;
    private String receiver_username;
    private String title;
    private String data;
    private String submit;
    private Boolean is_read;                // If not READ by the receiver, it is marked as UNREAD
    private Boolean is_sender_active;       // If the message sender has marked it as false, the message appears deleted to the sender
    private Boolean is_receiver_active;     // If the message receiver has marked it as false, the message appears deleted to the receiver

    
    public Message(){
    }
    
    public Message(Integer reply_msg_id,int sender_id, int receiver_id,String sender_username,
            String receiver_username, String title, String data, String submit, Boolean is_read,
            Boolean is_sender_active, Boolean is_receiver_active){
        
        this.reply_msg_id = reply_msg_id;
        this.sender_id = sender_id;
        this.receiver_id = receiver_id;
        this.sender_username = sender_username;
        this.receiver_username = receiver_username;
        this.title = title;
        this.data = data;
        this.submit = submit;
        this.is_read = is_read;
        this.is_sender_active = is_sender_active;
        this.is_receiver_active = is_receiver_active;
    }

    public Integer getMsg_id(){
        return this.msg_id;
    }
    public void setMsg_id(Integer msg_id){
        this.msg_id = msg_id;
    }    
    public Integer getReply_msg_id(){
        return this.reply_msg_id;
    }
    public void setReply_msg_id(Integer reply_msg_id){
        this.reply_msg_id = reply_msg_id;
    }    
    public int getSenderId(){
        return this.sender_id;
    }
    public void setSender(int sender_id){
        this.sender_id = sender_id;
    }
    public int getReceiverId(){
        return this.receiver_id;
    }
    public void setReceiver(int receiver_id){
        this.receiver_id = receiver_id;
    }
    public String getSenderUsername(){
    return this.sender_username;
    }
    public void setSenderUsername(String sender_username){
        this.sender_username = sender_username;
    }
    public String getReceiverUsername(){
    return this.receiver_username;
    }
    public void setReceiverUsername(String receiver_username){
        this.receiver_username = receiver_username;
    }    
    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getData(){
        return this.data;
    }
    public void setData(String data){
        this.data = data;
    }
    public String getSubmit(){
        return this.submit;
    }
    public void setSubmit(String submit){
        this.submit = submit;
    }
    public Boolean getIsRead(){
        return this.is_read;
    }
    public void setIsRead(Boolean is_read){
        this.is_read = is_read;
    }    
    public Boolean getIsSenderActive(){
        return this.is_sender_active;
    }
    public void setIsSenderActive(Boolean is_sender_active){
        this.is_sender_active = is_sender_active;
    }
    public Boolean getIsReceiverActive(){
        return this.is_receiver_active;
    }
    public void setIsReceiverActive(Boolean is_receiver_active){
        this.is_receiver_active = is_receiver_active;
    }  
}


