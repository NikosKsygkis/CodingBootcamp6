
package tablesConstructors;

/**
 *
 * @author nikos ksygkis
 */
public class User {
    
    private int id;
    private String username;
    private String password;
    private String fname;
    private String lname;
    private String creationdate;
    private Boolean is_online;


    public User(){
    }

    public User(String username, String password, String fname, String lname,String creationDate,Boolean is_online) {
            this.username = username;
            this.password = password;
            this.fname = fname;
            this.lname = lname;
            this.creationdate = creationDate;
            this.is_online = is_online;

    }    

    public int getId() {
            return id;
    }

    public void setId(int id) {
            this.id = id;
    }

    public String getUsername() {
            return username;
    }

    public void setUsername(String username) {
            this.username = username;
    }

    public String getPassword() {
            return password;
    }

    public void setPassword(String password) {
            this.password = password;
    }

    public String getFname() {
            return fname;
    }

    public void setFname(String fname) {
            this.fname = fname;
    }

    public String getLname() {
            return lname;
    }

    public void setLname(String lname) {
            this.lname = lname;
    }

    public String getCreationDate() {
            return creationdate;
    }

    public void setCreationDate(String creationdate) {
            this.creationdate = creationdate;
    }
    public Boolean getIsOnline(){
        return is_online;
    }
    public void setIsOnline(Boolean is_online){
        this.is_online = is_online;
    }
}
    

