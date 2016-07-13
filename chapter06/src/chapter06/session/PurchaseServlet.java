package chapter06.session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		List<Book> cart = (List<Book>)session.getAttribute("cart");
		if(cart==null)
		{
			cart = new ArrayList<Book>();
			session.setAttribute("cart", cart);
		}
	
		cart.add(book);
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setMaxAge(60*30);
		cookie.setPath("/chapter06");
		resp.addCookie(cookie);
		
		String url = "/chapter06/CartServlet";
		url = resp.encodeRedirectURL(url);
		resp.sendRedirect(url);
	}

}
