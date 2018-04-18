package com.learning.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.learning.user.model.User;
import com.learning.user.utils.ConnectionUtil;

public class UserDAOImpl implements UserDAO{

	private final String INSERT_USER_QUERY="INSERT INTO USERS(USER_ID, USER_FIRST_NAME , USER_LAST_NAME, USER_EMAIL, USER_PASSWORD) values(?,?,?,?,?)";
	private final String DELETE_BY_USER_ID_QUERY="DELETE FROM USERS WHERE USER_ID=?";
	private String SEARCH_USER_QUERY="SELECT USER_ID, USER_FIRST_NAME,USER_LAST_NAME, USER_EMAIL, USER_PASSWORD FROM USERS WHERE ";

	@Override
	public boolean createUser(User user) {
		
		Connection conn=null;
		PreparedStatement psmt=null;
		boolean executeSucess=false;
		try {
			conn=ConnectionUtil.getConnection();
			psmt=conn.prepareStatement(INSERT_USER_QUERY);
			psmt.setString(1, user.getUserId());
			psmt.setString(2, user.getUserFirstName());
			psmt.setString(3, user.getUserLastName());
			psmt.setString(4, user.getUserEmail());
			psmt.setString(5, user.getUserPassword());
			if(psmt.executeUpdate()==1){
				executeSucess=true;
			};
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error Creating User: "+e.getMessage());
		}
		finally{
			if(psmt!=null){
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			ConnectionUtil.closeConnection(conn);
		}
		return executeSucess;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> searchUser(User user) {

		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		List<User> usersList=null;
		try {
			boolean isAndNeeded=false;
			if(StringUtils.isNotBlank(user.getUserId())){
				SEARCH_USER_QUERY=SEARCH_USER_QUERY+" USER_ID like '%"+user.getUserId() +"%'";
				isAndNeeded=true;
			}
			if(StringUtils.isNotBlank(user.getUserFirstName())){
				if(isAndNeeded){
					SEARCH_USER_QUERY=SEARCH_USER_QUERY+" AND ";
				}
				
				SEARCH_USER_QUERY=SEARCH_USER_QUERY+" USER_FIRST_NAME like '%"+user.getUserFirstName() +"%'";
				isAndNeeded=true;
			}
			System.out.println("Final SEARCH_USER_QUERY="+SEARCH_USER_QUERY);
			conn=ConnectionUtil.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(SEARCH_USER_QUERY);
			usersList=new ArrayList<>();
			while(rs.next()){
				User dbUser=new User();
				dbUser.setUserId(rs.getString("USER_ID"));
				dbUser.setUserFirstName(rs.getString("USER_FIRST_NAME"));
				dbUser.setUserLastName(rs.getString("USER_LAST_NAME"));
				dbUser.setUserEmail(rs.getString("USER_EMAIL"));
				dbUser.setUserPassword(rs.getString("USER_PASSWORD"));
				usersList.add(dbUser);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error Creating User: "+e.getMessage());
		}
		finally{
			ConnectionUtil.closeRS(rs);
			ConnectionUtil.closeStmt(stmt);
			ConnectionUtil.closeConnection(conn);
		}
		return usersList;

	}

	@Override
	public boolean deleteUserbyUserId(User user) {
		
		Connection conn=null;
		PreparedStatement psmt=null;
		boolean executeSucess=false;
		try {
			conn=ConnectionUtil.getConnection();
			psmt=conn.prepareStatement(DELETE_BY_USER_ID_QUERY);
			psmt.setString(1, user.getUserId());
			if(psmt.executeUpdate()==1){
				executeSucess=true;
			};
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error Creating User: "+e.getMessage());
		}
		finally{
			if(psmt!=null){
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			ConnectionUtil.closeConnection(conn);
		}
		return executeSucess;
	}

	@Override
	public boolean deleteUserbyId(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
