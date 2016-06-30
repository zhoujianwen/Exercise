package cn.zhoujianwen.servlet;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.zhoujianwen.dao.TangDao;
import cn.zhoujianwen.model.Tang;

/**
 * Servlet implementation class TangServlet
 */
// @WebServlet("/Poem/TangServlet")
public class TangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TangServlet() {
		super();
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
		request.setCharacterEncoding("UTF-8");
		String selTxtType = request.getParameter("selTxtType");
		String searText = request.getParameter("searText");
		HttpSession session = request.getSession();
		String url = null;
		if (searText.trim().isEmpty()) {
			url = "../index.jsp";
			session.removeAttribute("list");
		} else {
			if (selTxtType.equals("题目")) {
				selTxtType = "title";
			} else if (selTxtType.equals("作者")) {
				selTxtType = "author";
			} else {
				selTxtType = "content";
			}
			String args = selTxtType.trim() + "=" + searText;
			TangDao tangDao = new TangDao();
			List<Tang> list = tangDao.queryByField(args);
			session.setAttribute("list", list);
			url = "../search.jsp";
		}
		response.sendRedirect(url);
	}

}
