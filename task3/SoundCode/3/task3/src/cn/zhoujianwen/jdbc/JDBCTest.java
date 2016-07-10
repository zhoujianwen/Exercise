package cn.zhoujianwen.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {

	private static String sql; // sql语句
	private static String uid = "root"; // 数据库帐号
	private static String pwd = "mysql123456"; // 数据库密码
	private static Connection connection;
	private static Statement statement;

	public JDBCTest() {
	}

	// Connection对象
	public static Connection getConnection() {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/test_db?characterEncoding=utf8&useSSL=true", uid, pwd);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	// Statement对象
	public static Statement getStatement() {
		try {
			statement = JDBCTest.getConnection().createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statement;
	}

	// 查询
	public static void executeQuery(String sql) {
		try {
			ResultSet rs = null;
			rs = JDBCTest.getStatement().executeQuery(sql);
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "  ");
				System.out.print(rs.getString(2) + "  ");
				System.out.print(rs.getInt(3) + "  ");
				System.out.print(rs.getString(4) + "  ");
				System.out.println(rs.getString(5) + "  ");
			}
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Destroy();
		}

	}

	// 插入
	public static void executeInsert(String sql) {
		try {
			int rs = 0;
			rs = JDBCTest.getStatement().executeUpdate(sql);
			System.out.println("向用户表中插入了" + rs + "条记录！");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Destroy();
		}

	}

	// 删除
	public static void executeDelete(String sql) {
		try {
			int rs = 0;
			rs = JDBCTest.getStatement().executeUpdate(sql);
			System.out.println("向用户表中删除了" + rs + "条记录！");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Destroy();
		}

	}
	
	//关闭数据库连接
	public static void Destroy() {
		try {
			if (!statement.isClosed()) {
				statement.close();
			}
			if (!connection.isClosed()) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// 1、向数据表写入十条不同的数据，并将数据库中所有的数据输出
		JDBCTest.executeInsert(
				"insert into t_students(stu_name,stu_age,stu_gender,stu_adress)" + "values('张三','20','男','广东'),"
						+ "('李红红','22','女','北京')," + "('周松','35','男','浙江')," + "('李雅婷','45','女','上海'),"
						+"('张伯','55','男','西藏'),"
						+"('刘萱','33','女','香港'),"
						+"('刘莹','18','女','澳门'),"
						+"('唐李','60','女','西安'),"
						+"('古柏','25','男','珠海'),"
						+"('曾健','27','男','广州');"		
				);
		System.out.println("将数据库中所有的数据输出：");
		JDBCTest.executeQuery("select stu_id,stu_name,stu_age,stu_gender,stu_adress from t_students");
		System.out.println("--------------------------------------------");
		
		
		// 2、查询年龄大于15岁的男生，并将数据输出
		JDBCTest.executeQuery("select stu_id,stu_name,stu_age,stu_gender,stu_adress from  t_students"
							+ " where stu_age > 15 and stu_gender='男'");
		System.out.println("将数据库中所有的数据输出：");
		JDBCTest.executeQuery("select stu_id,stu_name,stu_age,stu_gender,stu_adress from t_students;");
		System.out.println("--------------------------------------------");
		
		
		// 3、删除所有男生的数据，并将删除之后，数据库中的所有数据输出
		JDBCTest.executeDelete("DELETE FROM t_students WHERE stu_gender = '男';");
		System.out.println("将数据库中所有的数据输出：");
		JDBCTest.executeQuery("select stu_id,stu_name,stu_age,stu_gender,stu_adress from t_students;");

	}
}
