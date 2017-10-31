package com.database.loginservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.logindao.UserDao;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String verifyCode = req.getParameter("verifycode");
		String svc = (String) req.getSession().getAttribute("sessionverify");
		UserDao ud = new UserDao();
		String psw = ud.findUser(username);
		if (!svc.equalsIgnoreCase(verifyCode)) {
			req.setAttribute("username", username);
			req.setAttribute("msg1", "* 验证码错误");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			return;
		}
		if (psw == null) {
			req.setAttribute("username", username);
			req.setAttribute("msg2", "* 用户不存在");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			return;
		}
		if (psw != null && !psw.equals(password)) {
			req.setAttribute("username", username);
			req.setAttribute("msg3", "* 密码错误");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			System.out.println();
			return;
		}
		if (psw.equals(password)) {
			req.setAttribute("msg", "用户：" + username + ",登陆成功");
			req.getRequestDispatcher("/welcome.jsp").forward(req, resp);
			// response.setHeader("Refresh","1;url=welcome.jsp");
		}
	}
}
