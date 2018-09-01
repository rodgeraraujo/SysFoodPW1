package com.ifpb.pw1.sysfood.servlets;

import com.ifpb.pw1.sysfood.command.Command;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/front")
@MultipartConfig
public class FrontController extends HttpServlet {
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        try {
            Command command = (Command)
                    Class.forName("com.ifpb.pw1.sysfood.command.impl." + action).newInstance();
            command.execute(request,response);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            response.sendError(500);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request,response);
    }

}
