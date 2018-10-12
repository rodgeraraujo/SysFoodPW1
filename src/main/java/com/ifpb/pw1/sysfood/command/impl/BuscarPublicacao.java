package com.ifpb.pw1.sysfood.command.impl;

import com.ifpb.pw1.sysfood.command.Command;
import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.entities.Publicacao;
import com.ifpb.pw1.sysfood.entities.Usuario;
import com.ifpb.pw1.sysfood.managers.GerenciadorUsuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BuscarPublicacao implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException, PersistenciaException, SQLException {
        GerenciadorUsuario gerencia = new GerenciadorUsuario();
        HttpSession session = req.getSession();
        Usuario u = (Usuario) session.getAttribute("usuario");

        if (u != null) {
            List<Publicacao> publicacaoList = gerencia.buscarPublicacao();

            session.setAttribute("publicacaoList", publicacaoList);

            RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
            dispatcher.forward(req, res);
        }
    }
}
