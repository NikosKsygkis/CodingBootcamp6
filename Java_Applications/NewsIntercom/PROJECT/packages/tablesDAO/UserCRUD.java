
package tablesDAO;

import tablesConstructors.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import newsintercomAPP.Database;

/**
 *
 * @author nikos ksygkis
 */

public class UserCRUD {
    
    private Connection connection= Database.getConnection();;
    
    
        public void createUser(User user) {
            

            String sql = "INSERT INTO `newsintercom`.`user`(username, password, fname, lname, creation_date, is_online)" 
                                    + "VALUES(?,?,?,?,?,?)";
            int id = 0;
                try {

                    PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    pstmt.setString(1, user.getUsername());
                    pstmt.setString(2, user.getPassword());
                    pstmt.setString(3, user.getFname());
                    pstmt.setString(4, user.getLname());
                    pstmt.setString(5, user.getCreationDate());
                    pstmt.setBoolean(6, user.getIsOnline());

                    // Creating USER Account

                    if (pstmt.executeUpdate() > 0) {                       

                        ResultSet rs = pstmt.getGeneratedKeys();

                        if (rs.next()){
                            id = rs.getInt(1);
                        }
                    }
                } catch (SQLException ex) {
                        ex.printStackTrace();
                }
                
                
            }    
	public void updateUser(User user) {
            String sql = "UPDATE `newsintercom`.`user` SET username=?, password=?, fname=?, lname=?" 
                                    + " WHERE `id`=?";

            try {
                    PreparedStatement pstmt = connection.prepareStatement(sql);
                    pstmt.setString(1, user.getUsername());
                    pstmt.setString(2, user.getPassword());
                    pstmt.setString(3, user.getFname());
                    pstmt.setString(4, user.getLname());
                    pstmt.setInt(5, user.getId());

                    // Update User Account
                    pstmt.executeUpdate();

            } catch (Exception ex) {
                    System.out.println(ex.getMessage());
            }
	}    
	public void updateUserOnline(User user) {
            String sql = "UPDATE `newsintercom`.`user` SET is_online = ?" 
                                    + " WHERE `id`=?";

            try {
                    PreparedStatement pstmt = connection.prepareStatement(sql);
                    pstmt.setBoolean(1, true);
                    pstmt.setInt(2, user.getId());

                    // Update User Account
                    pstmt.executeUpdate();

            } catch (Exception ex) {
                    System.out.println(ex.getMessage());
            }
	}
	public void updateUserOffline(User user) {
            String sql = "UPDATE `newsintercom`.`user` SET is_online = ?" 
                                    + " WHERE `id`=?";

            try {
                    PreparedStatement pstmt = connection.prepareStatement(sql);
                    pstmt.setBoolean(1, false);
                    pstmt.setInt(2, user.getId());

                    // Update User Account
                    pstmt.executeUpdate();

            } catch (Exception ex) {
                    System.out.println(ex.getMessage());
            }
	}        
	public void deleteUser(Integer id) {
            String sql = "DELETE FROM `newsintercom`.`user` WHERE `id`=?";

            try {
                    PreparedStatement pstmt = connection.prepareStatement(sql);
                    pstmt.setInt(1, id);

                    // Delete Customer Account
                    pstmt.executeUpdate();

            } catch (Exception ex) {
                    System.out.println(ex.getMessage());
            }
	}        

	public User findUserById(Integer id) {
            String sql = "SELECT * FROM `newsintercom`.user WHERE id=?";

            try {
                    PreparedStatement pstmt = connection.prepareStatement(sql);
                    pstmt.setInt(1, id);

                   
                    ResultSet resultSet = pstmt.executeQuery();
                    if (resultSet.next()) {
                            User user = new User();
                            user.setId(resultSet.getInt(1));
                            user.setUsername(resultSet.getString(2));
                            user.setPassword(resultSet.getString(3));
                            user.setFname(resultSet.getString(4));
                            user.setLname(resultSet.getString(5));
                            user.setCreationDate(resultSet.getString(6));
                            user.setIsOnline(resultSet.getBoolean(7));
                            return user;
                    }
            } catch (Exception ex) {
                    System.out.println(ex.getMessage());
            }

            return null;
	}
	public User findUserByUsernamePassword(String username, String password) {
            String sql = "SELECT * FROM `newsintercom`.user WHERE username=? AND password=?";
            try {
                    PreparedStatement pstmt = connection.prepareStatement(sql);
                    pstmt.setString(1, username);
                    pstmt.setString(2, password);

                  
                    ResultSet resultSet = pstmt.executeQuery();
                    if (resultSet.next()) {
                        User user = new User();
                        user.setId(resultSet.getInt(1));
                        user.setUsername(resultSet.getString(2));
                        user.setPassword(resultSet.getString(3));
                        user.setFname(resultSet.getString(4));
                        user.setLname(resultSet.getString(5));
                        user.setCreationDate(resultSet.getString(6));
                        user.setIsOnline(resultSet.getBoolean(7));

                        return user;
                    }
            } catch (Exception ex) {
                    System.out.println(ex.getMessage());
            }

            return null;
	}
	public User findUserByUsername(String username) {
		String sql = "SELECT * FROM `newsintercom`.user WHERE username=?";

		try {
                    PreparedStatement pstmt = connection.prepareStatement(sql);
                    pstmt.setString(1, username);

                  
                    ResultSet resultSet = pstmt.executeQuery();
                    if (resultSet.next()) {
                        User user = new User();
                        user.setId(resultSet.getInt(1));
                        user.setUsername(resultSet.getString(2));
                        user.setPassword(resultSet.getString(3));
                        user.setFname(resultSet.getString(4));
                        user.setLname(resultSet.getString(5));
                        user.setCreationDate(resultSet.getString(6));
                        user.setIsOnline(resultSet.getBoolean(7));

                        return user;
                    }
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return null;
	}        
       
        public List<User> findAllUsers() {
		String sql = "SELECT * FROM `newsintercom`.`user`";
		List<User> users = null;
		try {
                    PreparedStatement pstmt = connection.prepareStatement(sql);

                 
                    ResultSet resultSet = pstmt.executeQuery();
                    while (resultSet.next()) {
                        if (users == null)
                                users = new ArrayList<>();

                        User user = new User();
                        user.setId(resultSet.getInt(1));
                        user.setUsername(resultSet.getString(2));
                        user.setPassword(resultSet.getString(3));
                        user.setFname(resultSet.getString(4));
                        user.setLname(resultSet.getString(5));
                        user.setCreationDate(resultSet.getString(6));
                        user.setIsOnline(resultSet.getBoolean(7));


                        users.add(user);
                    }

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
            return users;
	}
        public List<User> findOnlineUsers() {
		String sql = "SELECT * FROM `newsintercom`.`user` WHERE `is_online` IS true";
		List<User> users = null;
		try {
                    PreparedStatement pstmt = connection.prepareStatement(sql);

                 
                    ResultSet resultSet = pstmt.executeQuery();
                    while (resultSet.next()) {
                        if (users == null)
                                users = new ArrayList<>();

                        User user = new User();
                        user.setId(resultSet.getInt(1));
                        user.setUsername(resultSet.getString(2));
                        user.setPassword(resultSet.getString(3));
                        user.setFname(resultSet.getString(4));
                        user.setLname(resultSet.getString(5));
                        user.setCreationDate(resultSet.getString(6));
                        user.setIsOnline(resultSet.getBoolean(7));


                        users.add(user);
                    }

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
            return users;
	}        
}
