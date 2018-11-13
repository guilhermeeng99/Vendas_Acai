package br.ucsal.loja.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.loja.dao.LojaDao;
import br.ucsal.loja.model.Loja;

@WebServlet("/AlterarLojaEmailServlet")
public class AlterarLojaEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AlterarLojaEmailServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Loja user = (Loja) request.getSession().getAttribute("user");
		String email = request.getParameter("email");
		user.setEmail(email);

		LojaDao lojaDao;

		try {
			lojaDao = new LojaDao();
			if (user.getSenha().equals(null)) {
			}
			lojaDao.alteraEmail(user);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		response.sendRedirect("/ListarLojaServlet");

	}

}