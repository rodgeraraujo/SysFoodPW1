package com.ifpb.pw1.sysfood.command.impl;

import com.ifpb.pw1.sysfood.command.Command;
import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.dao.interfaces.LoginDao;
import com.ifpb.pw1.sysfood.entities.Usuario;
import com.ifpb.pw1.sysfood.managers.GerenciadorLogin;
import com.ifpb.pw1.sysfood.managers.GerenciadorUsuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

public class LoginController implements Command {
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException, PersistenciaException {
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        GerenciadorLogin gerenciadorLogin = new GerenciadorLogin();
        Usuario login = gerenciadorLogin.autenticar(email, senha);

        if(login != null){
            System.out.print("Welcome, " + login.getNome());
            HttpSession session = request.getSession(true); // reuse existing

            session.setAttribute("email", login.getEmail());
            session.setMaxInactiveInterval(60); // 60 segundos
            response.sendRedirect("home.jsp");

            request.getRequestDispatcher("home.jsp").forward(request, response);
        }else {
            request.setAttribute("errorMessage", "Senha inválida");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        System.out.println("2 " + login);

//        }else{
//            res.setStatus(400);
//            res.setHeader("errorMessage", "Usuario não cadastrado!");
//        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("home.jsp");
        requestDispatcher.forward(req,res);
    }
}
