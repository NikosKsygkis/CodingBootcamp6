
package tablesConstructors;

/**
 *
 * @author nikos ksygkis
 */
public class UserRoles{
    
    private int id;
    private boolean administrator;
    private boolean editor;
    private boolean writer;
    private int user_id;
    
    public UserRoles(){}
    
    public UserRoles(int user_id,boolean administrator,boolean editor, boolean writer){
        this.user_id = user_id;
        this.administrator = administrator;
        this.editor = editor;
        this.writer = writer;
    }

    public int getRoleUserId(){
        return this.user_id;
    }
    public void setRoleUserId(int user_id){
        this.user_id=user_id;
    }
    public int getRoleId(){
        return this.id;
    }
    public void setRoleId(int id){
        this.id=id;
    }
    public boolean getAdministrator(){
        return this.administrator;
    }
    public void setAdministrator(boolean administrator){
        this.administrator=administrator;
    }
    public boolean getEditor(){
        return this.editor;
    }
    public void setEditor(boolean editor){
        this.editor=editor;
    }
    public boolean getWriter(){
        return this.writer;
    }
    public void setWriter(boolean writer){
        this.writer=writer;
    }
    
    
}
