package cn.zhoujianwen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.zhoujianwen.model.Tang;
import cn.zhoujianwen.utils.ConnectionFactory;

public class TangDao {

	private Connection connection = null;
	private PreparedStatement pstmt = null;

	public TangDao() {
		connection = ConnectionFactory.getInstance().makeConnection();
	}

	public List<Tang> queryByField(String args) {
		List<Tang> list = new ArrayList<Tang>();
		Tang tang = null;
		String[] strSql = null;
		if (!args.trim().isEmpty() && args != null) {
			strSql = args.split("=");
			strSql[0] = "select id,title,author,content from tang where " + strSql[0] + " like ?";
		}
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(strSql[0]);
			pstmt.setString(1, "%" + strSql[1] + "%");
		    rs = pstmt.executeQuery();
			while (rs.next()) {
				tang = new Tang();
				tang.setId(rs.getInt(1));
				tang.setTitle(rs.getString(2));
				tang.setAuthor(rs.getString(3));
				tang.setContent(rs.getString(4));
				list.add(tang);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}finally {
			try {
				rs.close();
				pstmt.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
}
