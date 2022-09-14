package com.luyenthithpt.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.luyenthithpt.dao.IGenericDAO;
import com.luyenthithpt.mapper.IMapper;
import com.luyenthithpt.utils.AES;

public class GenericDAO<T> implements IGenericDAO<T> {

//	public static void main(String[] args) {
//		String mykey = "luyenthithptqg";
//		System.out.println(AES.encrypt("root", mykey));
//		System.out.println(AES.encrypt("123anham12345", mykey));
//		System.out.println(AES.encrypt("jdbc:mysql://localhost:3306/luyenthithptqg", mykey));	
//	}


	@Override
	public List<T> query(String sql, IMapper<T> mapper, Object... parameters) {
		List<T> results = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			results = new ArrayList<>();
			while (resultSet.next()) {
				results.add(mapper.map(resultSet));
			}
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
	}

	@Override
	public T findOne(String sql, IMapper<T> mapper, Object... parameters) {
		List<T> results = query(sql, mapper, parameters);
		if(results.size()==0) return null;
		return  results.get(0);
	}
	
	@Override
		public Object getAttribute(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getObject(1);
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		}
	
	@Override
	public void update(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
	
	@Override
	public Integer insert(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			Integer id = null;
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameter(statement, parameters);
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getInt(1);
			}
			connection.commit();
			return id;
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}	
	
	private Connection getConnection() {
		String mykey = "luyenthithptqg";

		try {
			String userName = AES.decrypt("Dtkqcj1H0UhlQIKUMGYW/A==", mykey);
			String password = AES.decrypt("dkv2u5G6nZ9ydt37v5NQHQ==", mykey);
			String mySQL = AES.decrypt("Jlo9s2fefkBGLqCJ/HzaUMd/kA4bK31CCtYchdWxSf+5c0D5JYZV1taQwe1SJljO", mykey);
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(mySQL, userName, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	private void setParameter(PreparedStatement statement, Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if (parameter instanceof Long) {
					statement.setLong(index, (Long) parameter);
				} else if (parameter instanceof String) {
					statement.setString(index, (String) parameter);
				} else if (parameter instanceof Integer) {
					statement.setInt(index, (Integer) parameter);
				} else if (parameter instanceof java.util.Date) {
					java.util.Date utilDate = (java.util.Date) parameter;
					statement.setDate(index, new java.sql.Date(utilDate.getTime()));
				} else if (parameter instanceof Float) {
					statement.setFloat(index, (Float) parameter);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}



}
