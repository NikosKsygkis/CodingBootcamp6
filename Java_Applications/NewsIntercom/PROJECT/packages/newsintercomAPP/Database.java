
package newsintercomAPP;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author nikos ksygkis
 */
public class Database {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/newsintercom?zeroDateTimeBehavior=convertToNull&serverTimezone=Europe/Athens&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static Connection connection = null;
    
    	
	
    public static Connection getConnection(){
            if(connection==null){
                    try{
                            //Loading The Driver Class
                            Class.forName(DRIVER);

                            //Getting the connection Object
                            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    }catch (Exception ex) {
                            System.out.println(ex.getMessage());
                    }
            }

            return connection;
    }
    
//    public static void Backupdbtosql() {
//        try {
//
//            /*NOTE: Getting path to the Jar file being executed*/
//            /*NOTE: YourImplementingClass-> replace with the class executing the code*/
//            CodeSource codeSource = Database.class.getProtectionDomain().getCodeSource();
//            File jarFile = new File(codeSource.getLocation().toURI().getPath());
//            String jarDir = jarFile.getParentFile().getPath();
//
//
//            /*NOTE: Creating Database Constraints*/
//            String dbName = "newsintercom";
//            String dbUser = "root";
//            String dbPass = "root";
//
//            /*NOTE: Creating Path Constraints for folder saving*/
//            /*NOTE: Here the backup folder is created for saving inside it*/
//            String folderPath = jarDir + "\\backup";
//
//            /*NOTE: Creating Folder if it does not exist*/
//            File f1 = new File(folderPath);
//            f1.mkdir();
//
//            /*NOTE: Creating Path Constraints for backup saving*/
//            /*NOTE: Here the backup is saved in a folder called backup with the name backup.sql*/
//             String savePath = "\"" + jarDir + "\\backup\\" + "backup.sql\"";
//
//            /*NOTE: Used to create a cmd command*/
//            String executeCmd = "mysqldump -u" + dbUser + " -p" + dbPass + " --database " + dbName + " -r " + savePath;
//
//            /*NOTE: Executing the command here*/
//            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
//            int processComplete = runtimeProcess.waitFor();
//
//            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
//            if (processComplete == 0) {
//                System.out.println("Backup Complete");
//            } else {
//                System.out.println("Backup Failure");
//            }
//
//        } catch (URISyntaxException | IOException | InterruptedException ex) {
//            JOptionPane.showMessageDialog(null, "Error at Backuprestore" + ex.getMessage());
//        }
//    }    
    
}
