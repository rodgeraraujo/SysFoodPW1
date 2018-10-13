package com.ifpb.pw1.sysfood.command.impl;

import com.ifpb.pw1.sysfood.command.Command;
import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.entities.Estabelecimento;
import com.ifpb.pw1.sysfood.entities.Usuario;
import com.ifpb.pw1.sysfood.managers.GerenciadorEstabelecimento;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class BuscarEstabelecimento implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException,
            ServletException, PersistenciaException, SQLException {

        HttpSession session = req.getSession();
        int id = Integer.valueOf(req.getParameter("id"));

        try {

            GerenciadorEstabelecimento gerencia = new GerenciadorEstabelecimento();
            //Usuario u = (Usuario) session.getAttribute("usuario");

            Estabelecimento e = gerencia.buscar_id(id);

            session.setAttribute("estabelecimento", e);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/page/profile.jsp?id="+ id);
            dispatcher.forward(req, res);

        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }
    }
}
