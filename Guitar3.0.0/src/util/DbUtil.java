package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbUtil {
	static String url="jdbc:sqlite:/e:/Guitar.db3";
	static Connection conn=null;
	public static Connection getConnection(){
		
		try{
			Class.forName("org.sqlite.JDBC");	
			conn=DriverManager.getConnection(url);
		}catch(ClassNotFoundException e){
			
		}		//鐎点倛娅ｉ悵娑㈠礆閻�?牊娈堕柟璇�?�枛缁ㄩ亶鎯冮崟顔剧闁圭尨鎷�
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}

	public void closeConnection(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
