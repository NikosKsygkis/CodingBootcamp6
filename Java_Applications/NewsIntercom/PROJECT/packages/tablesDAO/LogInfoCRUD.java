
package tablesDAO;

import tablesConstructors.LogInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import newsintercomAPP.Database;

/**
 *
 * @author nikos ksygkis
 */
public class LogInfoCRUD {
    private Connection connection = Database.getConnection();
    
        public int createLogInfo(LogInfo loginfo) {
            String sql = "INSERT INTO `newsintercom`.`loginfo`(user_id, login, logout)" 
                                    + "VALUES(?,?,?)";
            int id = 0;

                try {
                        PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                        pstmt.setInt(1, loginfo.getLogUserId());
                        pstmt.setString(2, loginfo.getLogin());
                        pstmt.setString(3, loginfo.getLogout());
                      
                        // Creating USER Account
                        if (pstmt.executeUpdate() > 0) {
                                ResultSet rs = pstmt.getGeneratedKeys(); 
                                                                                                                      

                                if (rs.next())
                                        id = rs.getInt(1);
                                        loginfo.setLogId(id);
                        }
                } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                }

                return id;
            }
        
 
	public void deleteLogInfoByUserId(Integer id) {
		String sql = "DELETE FROM `newsintercom`.`loginfo` WHERE `user_id`=?";

		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);

			
			pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}        
	public LogInfo findLogInfoById(Integer id) {
		String sql = "SELECT * FROM `newsintercom`.`loginfo` WHERE id=?";

		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);

			
			ResultSet resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				LogInfo loginfo = new LogInfo();
				loginfo.setLogId(resultSet.getInt(1));
				loginfo.setLogUser(resultSet.getInt(2));
				loginfo.setLogin(resultSet.getString(3));
				loginfo.setLogout(resultSet.getString(4));
				
				return loginfo;
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return null;
	}
        
        public List<LogInfo> findLogInfoByUserId(Integer user_id) {
		String sql = "SELECT * FROM `newsintercom`.`loginfo` WHERE `user_id`=? ORDER BY `login`";
		List<LogInfo> logInformation = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
                        pstmt.setInt(1, user_id);
			
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				if (logInformation == null)
					logInformation = new ArrayList<>();

				LogInfo loginfo = new LogInfo();
				loginfo.setLogId(resultSet.getInt(1));
				loginfo.setLogUser(resultSet.getInt(2));
				loginfo.setLogin(resultSet.getString(3));
				loginfo.setLogout(resultSet.getString(4));
				
				logInformation.add(loginfo);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return logInformation;
	}
        public List<LogInfo> findAllLogs() {
		String sql = "SELECT * FROM `newsintercom`.`loginfo` ORDER BY `login`";
		List<LogInfo> logInformation = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				if (logInformation == null)
					logInformation = new ArrayList<>();

				LogInfo loginfo = new LogInfo();
				loginfo.setLogId(resultSet.getInt(1));
				loginfo.setLogUser(resultSet.getInt(2));
				loginfo.setLogin(resultSet.getString(3));
				loginfo.setLogout(resultSet.getString(4));
				
				logInformation.add(loginfo);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return logInformation;
	}         
}
