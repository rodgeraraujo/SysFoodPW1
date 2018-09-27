package com.ifpb.pw1.sysfood.command.impl;

import com.ifpb.pw1.sysfood.command.Command;
import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Logout")
public class Logout implements Command {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException, PersistenciaException, SQLException {
        //invalidate the session if exists
        HttpSession session = req.getSession(false);
        if(session != null){
            session.invalidate();
        }
        res.sendRedirect(req.getContextPath() + "/login.jsp");
    }
}
