package com.ifpb.pw1.sysfood.command.impl;

import com.ifpb.pw1.sysfood.command.Command;
import com.ifpb.pw1.sysfood.managers.GerenciadorUsuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DadosController implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        try {
            HttpSession session = request.getSession();

            GerenciadorUsuario user = new GerenciadorUsuario();

            RequestDispatcher dispatcher = request.getRequestDispatcher("home2.jsp");
            dispatcher.forward(request, response);

        } catch (IOException ex) {
            Logger.getLogger(DadosController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
