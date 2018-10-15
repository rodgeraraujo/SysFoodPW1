package com.ifpb.pw1.sysfood.command.impl;

import com.ifpb.pw1.sysfood.command.Command;
import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.managers.GerenciadorPesquisa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Pesquisa implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException,
            PersistenciaException, SQLException {

        GerenciadorPesquisa gerenciador = new GerenciadorPesquisa();
        HttpSession session = req.getSession();
        String nome = req.getParameter("q");

        try{
            List<Object> objects = gerenciador.Pesquisa(nome);

            session.setAttribute("pesquisa", objects);

            RequestDispatcher dispatcher = req.getRequestDispatcher("search.jsp?nome="+ nome);
            dispatcher.forward(req, res);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
