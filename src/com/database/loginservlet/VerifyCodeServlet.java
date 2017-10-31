package com.database.loginservlet;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.utils.VerifyCode;

public class VerifyCodeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		VerifyCode vc = new VerifyCode();
		BufferedImage image = vc.getImage(90,30);
		req.getSession().setAttribute("sessionverify", vc.getText());
		VerifyCode.output(image, resp.getOutputStream());
	}

}
