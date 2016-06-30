package cn.zhoujianwen.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import javax.servlet.http.HttpServlet;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import com.sun.corba.se.spi.orbutil.fsm.Input;

public class ConnectionFactory {

	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;
	private Connection connection;

	private static final ConnectionFactory factory = new ConnectionFactory();

	static {
		Properties properties = new Properties();
	
		try {
			InputStream inputStream = ConnectionFactory.class.getClassLoader()
					.getResourceAsStream("/../dbconfig.properties");
			properties.load(inputStream);
		} catch (Exception e) {
			System.out.println("========配置文件读取错误========");
		}

		driver = properties.getProperty("driver");
		dburl = properties.getProperty("dburl");
		user = properties.getProperty("user");
		password = properties.getProperty("password");

	}

	private ConnectionFactory() {
	}

	public static ConnectionFactory getInstance() {
		return factory;
	}

	public Connection makeConnection() {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(dburl, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
