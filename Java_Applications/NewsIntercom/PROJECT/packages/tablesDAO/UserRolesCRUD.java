
package tablesDAO;

import tablesConstructors.UserRoles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import newsintercomAPP.Database;

/**
 *
 * @author nikos ksygkis
 */
public class UserRolesCRUD {
    
    private Connection connection = Database.getConnection();
    
        public void createUserRole(UserRoles role) {
            String sql = "INSERT INTO `newsintercom`.`userroles`(user_id, administrator, editor, writer)" 
                                    + "VALUES(?,?,?,?)";
            int id = 0;

                try {
                    PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    pstmt.setInt(1, role.getRoleUserId());
                    pstmt.setBoolean(2, role.getAdministrator());
                    pstmt.setBoolean(3, role.getEditor());
                    pstmt.setBoolean(4, role.getWriter());

                    // Creating Role for user
                    if (pstmt.executeUpdate() > 0) {
                        ResultSet rs = pstmt.getGeneratedKeys(); 

                        if (rs.next())
                            id = rs.getInt(1);
                    }
                } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                }            
        }
        
	public void updateUserRole(UserRoles role) {
		String sql = "UPDATE `newsintercom`.`userroles` SET editor=?, writer=? " 
					+ "WHERE `user_id`=?";

		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setBoolean(1, role.getEditor());
			pstmt.setBoolean(2, role.getWriter());
			pstmt.setInt(3, role.getRoleUserId());

			
			pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void deleteUserRole(Integer id) {
		String sql = "DELETE FROM `newsintercom`.`userroles` WHERE `user_id`=?";

		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);

			
			pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	public UserRoles findUserRoleByUserId(Integer id) {
		String sql = "SELECT * FROM `newsintercom`.`userroles` WHERE user_id=?";

		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);

			
			ResultSet resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				UserRoles role = new UserRoles();
				role.setRoleId(resultSet.getInt(1));
				role.setRoleUserId(resultSet.getInt(2));
				role.setAdministrator(resultSet.getBoolean(3));
				role.setEditor(resultSet.getBoolean(4));
				role.setWriter(resultSet.getBoolean(5));

				return role;
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return null;
	}        
}
