package chapter06.cookies;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.fastinfoset.tools.FI_DOM_Or_XML_DOM_SAX_SAXEvent;

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
		//cookie.setMaxAge(-1);若不设置MaxAge的值，默认是-1，当浏览器关闭时，将删除这个Cookies对象。
		/*
		 * 在设置setPath时需要注意的是，由于浏览器的每个站点最多只能存放20个Cookie，因此，在创建Cookie对象时，
		 * 一般都会设置它的路径，例如增加一行代码cookie.setPath("/chapter06");，那么用户浏览器在访问整个
		 * chapter06工程下的资源时都会回送Cookie的信息。
		 */
		resp.addCookie(cookie);
	}

}
