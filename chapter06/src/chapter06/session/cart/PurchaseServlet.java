package chapter06.session.cart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.spec.IvParameterSpec;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PurchaseServlet
 */
@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");

		if (id == null) {
			String url = "/chapter06/ListBookServlet";
			resp.sendRedirect(url);
			return;
		}

		Book book = BookDB.getBook(id);
		HttpSession session = req.getSession();
		List<Book> cart = (List<Book>) session.getAttribute("cart");
		if (cart == null) {
			cart = new ArrayList<Book>();
			session.setAttribute("cart", cart);
		}

		cart.add(book);
		/*
		 * 以下这段代码 如果浏览器的Cookie功能被禁止，那么服务器端是无法通过Session保存用户会话信息的。 Cookie cookie =
		 * new Cookie("JSESSIONID", session.getId()); cookie.setMaxAge(60*30);
		 * cookie.setPath("/chapter06"); resp.addCookie(cookie);
		 */

		String url = "/chapter06/CartServlet";
		/*
		 * 考虑到浏览器可能不支持Cookie的情况，Servlet规范中还引入了URL重写机制来保存用户的会话信息。
		 * 所谓URL重写，指的是将Session的会话标识号以参数的形式附加在超链接的URL地址后面。
		 */
		url = resp.encodeRedirectURL(url);
		resp.sendRedirect(url);
	}

}
