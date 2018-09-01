package com.ifpb.pw1.sysfood.command.impl;

import com.ifpb.pw1.sysfood.command.Command;
import com.ifpb.pw1.sysfood.managers.GerenciadorUsuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

public class CadastrarUsuario implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String profissao = req.getParameter("profissao");
        String sexo = req.getParameter("sexo");
        String descricao = req.getParameter("descricao");
        String telefone = req.getParameter("telefone");
        Part part = req.getPart("fotoPerfil");
        String senha = req.getParameter("senha");

        byte[] foto = new byte[(int) part.getSize()];
        InputStream stream = part.getInputStream();
        stream.read(foto);
        stream.close();

        GerenciadorUsuario gerenciadorUsuario = new GerenciadorUsuario();
            Boolean cadastrar = gerenciadorUsuario.cadastrar(nome, email,profissao, sexo, foto, descricao, telefone, senha);

        if(cadastrar){
            res.setStatus(200);
        }else{
            res.setStatus(400);
            res.setHeader("errorMessage", "Não foi possível cadastrar o usuário");
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(req,res);
    }
}
