package chapter06.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class ListBookServlet
 */
@WebServlet("/ListBookServlet")
public class ListBookServlet extends HttpServlet {

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
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		Collection<Book> books = BookDB.getAll();
		out.write("本站提供的图书有：<br>");
		for (Book book : books) {
			String url = "/chapter06/PurchaseServlet?id=" + book.getId();
			HttpSession session = req.getSession();
			url = resp.encodeRedirectURL(url);//重写url，并将sessionid附加在url地址后面
			out.write(book.getName() + "<a href='" + url + "'>点击购买</a><br>");
		}
	}

}
