package com.database.loginservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.logindao.UserDao;

public class RegistServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");  
        resp.setContentType("text/html;charset=utf-8");  
        String username = req.getParameter("username");  
        String password = req.getParameter("password");
        //得到表单输入的内容
        String rpsw = req.getParameter("rpsw");  
        if(username==null||username.trim().isEmpty()){  
            req.setAttribute("msg", "帐号不能为空");  
            req.getRequestDispatcher("/regist.jsp").forward(req, resp);  
            return;  
        }  
        if(password==null||password.trim().isEmpty()){  
            req.setAttribute("msg", "密码不能为空");  
            req.getRequestDispatcher("/regist.jsp").forward(req, resp);  
            return;  
        }  
        if(!password.equals(rpsw)){  
            req.setAttribute("msg", "两次输入的密码不同");  
            req.getRequestDispatcher("/regist.jsp").forward(req, resp);  
            return;  
        }  
        UserDao u = new UserDao(); 
        //System.out.println("lala");
        u.addUser(username,password);
        req.setAttribute("msg", "恭喜："+username+"，注册成功");  
        req.getRequestDispatcher("/index.jsp").forward(req, resp);  
	}
	
}
