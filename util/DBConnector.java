//ここでは接続するデータベースの場所や名前。ユーザー名、パスワードの設定を行う

package com.internousdev.ecsite.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//↓接続に必要な情報を書いていく
public class DBConnector {
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/ecsite7";

	private static String user = "root";
	private static String password = "mysql";

	public Connection getConnection(){
		Connection con = null;

		try{
			Class.forName(driverName);
			con = (Connection) DriverManager.getConnection(url,user,password);
//			↑例外が発生する可能性がある処理
		}catch(ClassNotFoundException e){
//			　　　↑例外の型　　　　　↑引数
			e.printStackTrace();
//			↑エラーが発生したときの処理
		}catch(SQLException e){
			e.printStackTrace();
		}
//		finallyは例外の有無にかかわらず、最後に必ず実行される
		return con;
	}
}
