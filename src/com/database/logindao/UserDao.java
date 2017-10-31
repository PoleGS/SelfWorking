package com.database.logindao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	//private static Logger logger = LogManager.getLogger(UserDao.getClass().getName()); 
	
	public static Connection getConnection(){
		String driver ="com.mysql.jdbc.Driver";
		String url ="jdbc:mysql://localhost:3306/mytest";
		String user ="root";
		String password ="123456";
		Connection connection =null;
		try {
			Class.forName(driver);
			connection =DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Jar 文件缺失");
		} catch (SQLException e) {
			throw new RuntimeException("数据库连接失败");
		}
		return connection;
	}
	/*
	 * 添加用户
	 */
	public void addUser(String username, String password) {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO user(username,password) VALUES(?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("用户添加操作失败");
		}finally{
			try {
				if( connection != null){
					connection.close();
				}
				if(preparedStatement != null ){
					preparedStatement.close();
				}
			} catch (SQLException e2) {
				throw new RuntimeException("数据库连接失败");
			}
		}
	}
	/*
	 * 用用户名查询该用户密码
	 */
	public String findUser(String username){
		String password = null;
		String sql = "select * from user where username=?";
		Connection connection =getConnection();
		PreparedStatement preparedStatement =null;
		ResultSet resultSet = null;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				password=resultSet.getString("password");
			}else{
				password=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(connection != null){
					connection.close();
				}
				if(preparedStatement != null){
					preparedStatement.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			} 
		}
		return password;
	}
}
