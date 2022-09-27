package controller;
import model.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import model.ClienteDAO;

@WebServlet("/Registrar")
public class Registrar extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		int fone = Integer.parseInt(request.getParameter("fone"));
		String senha = request.getParameter("senha");
		
		Cliente Cliente = new Cliente();
		
		  Cliente.setNome(nome); 
		  Cliente.setCpf(cpf); 
		  Cliente.setEmail(email);
		  Cliente.setFone(fone);
		  Cliente.setSenha(senha);
		 
		ClienteDAO ClienteDAO = new ClienteDAO();
		ClienteDAO.save(Cliente);
		
		
		response.sendRedirect("home.html");
		
		
		
	}

}
