package chapter06;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LastAccessServlet extends HttpServlet {

	/**
	 * Cookies —— 显示用户上次访问时间
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=utf-8");

		String lastAccessTime = null;
		
		//获取所有的cookie，并将这些cookie存放在数组中
		Cookie[] cookies = req.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("lastAccess".equals(cookie.getName())) {
					lastAccessTime = cookie.getValue();
					break;
				}
			}
		}
		
		//判断是否存在名称为lastAccess的cookie
		String text = null;
		if (lastAccessTime == null) {
			text = "您是首次访问本站！！！";
		} else {
			text = "您上次的访问时间是：" + lastAccessTime;
		}
		resp.getWriter().println(text);
		
		//创建cookie，将当前时间作为cookie的值发送给客户端
		String currenttime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		Cookie cookie = new Cookie("lastAccess", currenttime);
		resp.addCookie(cookie);
	}

}
