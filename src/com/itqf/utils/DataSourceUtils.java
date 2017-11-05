package com.itqf.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils {
	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	// 创建好了线程本地变量
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

	/*
	 * 获取连接池
	 * 
	 */

	public static DataSource getDataSource() {
		return ds;
	}

	/*
	 * 从c3p0中获取数据库连接
	 * 
	 * 
	 */
	public static Connection getConnection() throws SQLException {
		Connection connection = tl.get();
		if (connection == null) {
			// 当前线程对应的本地变量没有保存过connection
			connection = ds.getConnection();
			// 放到线程本地变量中
			tl.set(connection);
		}

		return connection;
	}

	public static void startTranscation() {
		try {
			getConnection().setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void commit() {
		try {
			Connection connection = getConnection();
			// 提交
			connection.commit();
			connection.close();// 连接关闭
			tl.remove();// 线程本地变量移除 connection

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * 进行数据回滚 并且进行本地线程本地资源释放，connection放回连接池
	 */
	public static void rollback() {
		try {
			Connection connection = getConnection();
			connection.rollback();// 数据回滚
			connection.close();// 放回c3p0的连接池
			tl.remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void closeResource(Connection conn, PreparedStatement ps, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		closeConn(conn);
	}

	/*
	 * 关闭connection方法
	 * 
	 */
	public static void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();

				tl.remove();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
