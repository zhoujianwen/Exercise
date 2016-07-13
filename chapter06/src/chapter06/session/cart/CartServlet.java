package chapter06.session.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		List<Book> cart = null;
		boolean purFlag = true;
		HttpSession session = request.getSession(false);
		if (session == null) {
			purFlag = false;
		} else {
			cart = (List) session.getAttribute("cart");
			if (cart == null) {
				purFlag = false;
			}
		}

		if (!purFlag) {
			out.write("对不起！您还没有购买任何商品！<br>");
		} else {
			out.write("您购买的图书有：<br>");
			//double price = 0;
			for (Book book : cart) {
				out.write(book.getName() + "<br>");
			}
		}
	}

}
