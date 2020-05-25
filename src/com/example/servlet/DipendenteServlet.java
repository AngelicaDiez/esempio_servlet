package com.example.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.DipendenteDao;
import com.example.model.Dipendente;

@WebServlet("/")
public class DipendenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DipendenteDao dao;

	public void init() {
		dao = new DipendenteDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertDipendente(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				System.out.println("Update...");
				updateDipendente(request, response);
				break;
			default:
				System.out.println("Lista...");
				listDipendente(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void listDipendente(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Dipendente> listDipendente = dao.getAllDipendente();
		request.setAttribute("listDipendente", listDipendente);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-dipendente.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("dipendente-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Dipendente existingDipendente = dao.getDipendente(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("dipendente-form.jsp");
		request.setAttribute("dipendente", existingDipendente);
		dispatcher.forward(request, response);
	}

	private void insertDipendente(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String cod_fiscale = request.getParameter("cod_fiscale");
		int telefono = Integer.parseInt(request.getParameter("telefono"));
		Dipendente newDipendente = new Dipendente(id, nome, cognome, cod_fiscale, telefono);
		dao.saveDipendente(newDipendente);
		response.sendRedirect("list");
	}

	private void updateDipendente(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String cod_fiscale = request.getParameter("cod_fiscale");
		int telefono = Integer.parseInt(request.getParameter("telefono"));
		

		Dipendente dipendente = new Dipendente(id, nome, cognome, cod_fiscale, telefono);
		dao.updateDipendente(dipendente);
		response.sendRedirect("list");
	}

}
