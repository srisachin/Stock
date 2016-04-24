package com.sachin.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sachin.dao.UserDao;


@Repository("userDao")
public class UserDaoImpl implements UserDao
{
	@Autowired
	DataSource dataSource ;

	public DataSource getDataSource()
	{
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	@Override
	public boolean isValidUser(String username, String password) throws SQLException
	{
		String query = "SELECT * from \"public\".\"user\""
				+ " where \"username\" =\'"+ username +
				"\' and password =\'" +password + "\'";
		//"SELECT * FROM \"public\".\"Historical\" where \"Name\"=\'" + id +"\' limit 100;"
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		//pstmt.setString(1, username);
		//pstmt.setString(2, password);
		ResultSet resultSet = pstmt.executeQuery();
		if(resultSet.next())
		{	
			System.out.println(resultSet.getString("username"));
		    //return (resultSet.getInt(1) > 0);
			return true;
		}
        else
           return false;
    }

}