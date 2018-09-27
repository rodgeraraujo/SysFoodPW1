package com.ifpb.pw1.sysfood.command.impl;


import com.ifpb.pw1.sysfood.command.Command;
import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.entities.Usuario;
import com.ifpb.pw1.sysfood.managers.GerenciadorUsuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Login extends HttpServlet implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        GerenciadorUsuario gerenciadorUsuario = new GerenciadorUsuario();
        HttpSession session = request.getSession();

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuario u = (Usuario) session.getAttribute("usuario");

        try {
            if (u != null) {
                response.sendRedirect("home2.jsp");
            } else if (gerenciadorUsuario.autenticar(email, senha))  {
                System.out.println("1");

                Usuario usuario = gerenciadorUsuario.buscaUsuario(email);
                session.setAttribute("usuario", usuario);

                request.getRequestDispatcher("home2.jsp").forward(request, response);

            } else {
                response.sendRedirect("login.jsp");
                System.out.println("erro login");

                PrintWriter out = response.getWriter();
                out.println("<font color=red>Email ou senha inválidos.</font>");
            }
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException | PersistenciaException e) {
            e.printStackTrace();
        }

    }
}
