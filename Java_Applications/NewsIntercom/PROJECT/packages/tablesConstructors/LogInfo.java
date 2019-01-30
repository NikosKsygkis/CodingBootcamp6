
package tablesConstructors;

/**
 *
 * @author nikos ksygkis
 */
public class LogInfo {
    
    private Integer id;
    private Integer user_id;
    private String login;
    private String logout;
    
    public LogInfo(){}
    
    public LogInfo(Integer user_id, String login){
        this.user_id = user_id;
        this.login = login;
    }
    
    public LogInfo(Integer user_id, String login, String logout){
        this.user_id = user_id;
        this.login = login;
        this.logout = logout;
    }
    
    public int getLogId(){
        return this.id;
    }
    public void setLogId(int id){
        this.id = id;
    }
    public Integer getLogUserId(){
        return this.user_id;
    }
    public void setLogUser(Integer user_id){
        this.user_id = user_id;
    }
    public String getLogin(){
        return this.login;
    }
    public void setLogin(String login){
        this.login = login;
    }
    public String getLogout(){
        return this.logout;
    }
    public void setLogout(String logout){
        this.logout = logout;
    } 
}
