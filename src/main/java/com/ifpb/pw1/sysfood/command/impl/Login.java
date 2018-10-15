package com.ifpb.pw1.sysfood.command.impl;


import com.ifpb.pw1.sysfood.command.Command;
import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.entities.Publicacao;
import com.ifpb.pw1.sysfood.entities.Usuario;
import com.ifpb.pw1.sysfood.managers.GerenciadorUsuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Login extends HttpServlet implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, PersistenciaException {

        try {
            GerenciadorUsuario gerencia = new GerenciadorUsuario();
            HttpSession session = request.getSession();
            Usuario u = (Usuario) session.getAttribute("usuario");

            if (u != null) {
                response.sendRedirect("home.jsp?success=1");
            } else if (gerencia.autenticar(request.getParameter("email"), request.getParameter("senha"))) {
                Usuario usuarioAtual = gerencia.buscaUsuario(request.getParameter("email"));

//                String url = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(usuarioAtual.getFotoPerfil());

//                List<Publicacao> publicacaoList = gerencia.buscarPublicacao();

                session.setAttribute("usuario", usuarioAtual);
//                session.setAttribute("foto", url);
//                session.setAttribute("publicacaoList", publicacaoList);

                RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp?value=1");
                dispatcher.forward(request, response);
            } else {
                response.sendRedirect("login.jsp?value=1");
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

}
