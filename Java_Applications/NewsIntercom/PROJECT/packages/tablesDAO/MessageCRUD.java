
package tablesDAO;

import tablesConstructors.Message;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import newsintercomAPP.Database;

/**
 *
 * @author nikos ksygkis
 */
public class MessageCRUD {
    
    
    private Connection connection = Database.getConnection();
    
    
        public void createMessage(Message message) {
            String sql = "INSERT INTO `newsintercom`.`messages`(reply_id, creator_id, receiver_id, "
                    + "creator_username, receiver_username, title, mdata, submit_date, is_read, is_creator_active, is_receiver_active)" 
                                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            int id = 0;

                try {
                    PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    if(message.getReply_msg_id()==null){
                        pstmt.setNull(1, Types.INTEGER);
                    }
                    else{
                        pstmt.setInt(1, message.getReply_msg_id());
                    }
                    pstmt.setInt(2, message.getSenderId());
                    pstmt.setInt(3, message.getReceiverId());
                    pstmt.setString(4, message.getSenderUsername());
                    pstmt.setString(5, message.getReceiverUsername());
                    pstmt.setString(6, message.getTitle());
                    pstmt.setString(7, message.getData());
                    pstmt.setString(8, message.getSubmit());
                    pstmt.setBoolean(9, message.getIsRead());
                    pstmt.setBoolean(10, message.getIsSenderActive());
                    pstmt.setBoolean(11, message.getIsReceiverActive());

                    // Creating Message
                    if (pstmt.executeUpdate() > 0) {
                        ResultSet rs = pstmt.getGeneratedKeys(); 

                        if (rs.next())
                            id = rs.getInt(1);
                    }
                } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                }
                
        }    
	public void updateMessage(Message message) {
		String sql = "UPDATE `newsintercom`.`messages` SET title=?, mdata=? " 
					+ "WHERE `id`=?";

		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
                        pstmt.setString(1, message.getTitle());
			pstmt.setString(2, message.getData());
			pstmt.setInt(3, message.getMsg_id());

			// Update message
			pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
        public void updateIsRead(Message message) {
        String sql = "UPDATE `newsintercom`.`messages` SET is_read=? " 
                                + "WHERE `id`=?";

        try {
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setBoolean(1, true);
                pstmt.setInt(2, message.getMsg_id());

                // Update message
                pstmt.executeUpdate();

        }   catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
	}
        public void updateIsSenderActive(Message message) {
        String sql = "UPDATE `newsintercom`.`messages` SET is_creator_active=? " 
                                + "WHERE `id`=?";

        try {
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setBoolean(1, false);
                pstmt.setInt(2, message.getMsg_id());

                // Update message
                pstmt.executeUpdate();

        }   catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
	}
        
        public void updateIsReceiverActive(Message message) {
        String sql = "UPDATE `newsintercom`.`messages` SET is_receiver_active=? " 
                                + "WHERE `id`=?";

        try {
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setBoolean(1, false);
                pstmt.setInt(2, message.getMsg_id());

                // Update message
                pstmt.executeUpdate();

        }   catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
	}        
	public void deleteMessage(Integer id) {
		String sql = "DELETE FROM `newsintercom`.`messages` WHERE `id`=?";

		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);

			// Delete Message
			pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}        
	public Message findMessageById(Integer id) {
		String sql = "SELECT * FROM `newsintercom`.messages WHERE id=?";

		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);

			// Getting Message by creator
			ResultSet resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				Message message = new Message();
				message.setMsg_id(resultSet.getInt(1));
				message.setReply_msg_id(resultSet.getInt(2));
				message.setSender(resultSet.getInt(3));
				message.setReceiver(resultSet.getInt(4));
                                message.setSenderUsername(resultSet.getString(5));
                                message.setReceiverUsername(resultSet.getString(6));
				message.setTitle(resultSet.getString(7));
                                message.setData(resultSet.getString(8));
                                message.setSubmit(resultSet.getString(9));
                                message.setIsRead(resultSet.getBoolean(10));
                                message.setIsSenderActive(resultSet.getBoolean(11));
                                message.setIsReceiverActive(resultSet.getBoolean(12));

				return message;
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return null;                             
	}
        
        
        
        public List<Message> findMessagesByCreatorId(Integer id) {
		String sql = "SELECT * FROM `newsintercom`.`messages` WHERE `creator_id`=?"
                        + "  ORDER BY `submit_date`";
		List<Message> messages = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
                        pstmt.setInt(1, id);
			
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				if (messages == null)
					messages = new ArrayList<>();

				Message message = new Message();
				message.setMsg_id(resultSet.getInt(1));
				message.setReply_msg_id(resultSet.getInt(2));
				message.setSender(resultSet.getInt(3));
				message.setReceiver(resultSet.getInt(4));
                                message.setSenderUsername(resultSet.getString(5));
                                message.setReceiverUsername(resultSet.getString(6));
				message.setTitle(resultSet.getString(7));
                                message.setData(resultSet.getString(8));
                                message.setSubmit(resultSet.getString(9));
                                message.setIsRead(resultSet.getBoolean(10));
                                message.setIsSenderActive(resultSet.getBoolean(11));
                                message.setIsReceiverActive(resultSet.getBoolean(12));

				messages.add(message);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return messages;
	}         
        public List<Message> findMessagesByReceiverId(int id) {
		String sql = "SELECT * FROM `newsintercom`.`messages` WHERE `receiver_id`=?"
                        + "  ORDER BY `submit_date`";
		List<Message> messages = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
                        pstmt.setInt(1, id);
			
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				if (messages == null)
					messages = new ArrayList<>();

				Message message = new Message();
				message.setMsg_id(resultSet.getInt(1));
				message.setReply_msg_id(resultSet.getInt(2));
				message.setSender(resultSet.getInt(3));
				message.setReceiver(resultSet.getInt(4));
                                message.setSenderUsername(resultSet.getString(5));
                                message.setReceiverUsername(resultSet.getString(6));
				message.setTitle(resultSet.getString(7));
                                message.setData(resultSet.getString(8));
                                message.setSubmit(resultSet.getString(9));
                                message.setIsRead(resultSet.getBoolean(10));
                                message.setIsSenderActive(resultSet.getBoolean(11));
                                message.setIsReceiverActive(resultSet.getBoolean(12));

				messages.add(message);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return messages;
	} 
        
	public int findNewMessageByReceiverId(Integer id) {
		String sql = "SELECT COUNT(*) FROM `newsintercom`.`messages` WHERE `receiver_id`=? AND"
                        + "`is_read` IS false ORDER BY `submit_date`";

		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);

			
			ResultSet resultSet = pstmt.executeQuery();
			if (resultSet.next()) {

				return resultSet.getInt(1);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return 0;        
        }
        
}
