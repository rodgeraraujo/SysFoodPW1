package com.ifpb.pw1.sysfood.command.impl;

import com.ifpb.pw1.sysfood.command.Command;
import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.entities.Usuario;
import com.ifpb.pw1.sysfood.managers.GerenciadorUsuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Publicacao implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException,
            PersistenciaException, SQLException {

        try {
            GerenciadorUsuario gerencia = new GerenciadorUsuario();
            HttpSession session = req.getSession();
            Usuario u = (Usuario) session.getAttribute("usuario");

            if (u != null) {
                gerencia.salvaPublicacao(
                        new com.ifpb.pw1.sysfood.entities.Publicacao(
                                u.getNome(),
                                req.getParameter("conteudo"),
                                u.getId(),
                                req.getParameter("dataPublicacao"),
                                req.getParameter("fotoPublicacao"))
                );

                RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp?value=3");
                dispatcher.forward(req, res);
            } else {
                res.sendRedirect("login.jsp?value=2");
            }
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
}
