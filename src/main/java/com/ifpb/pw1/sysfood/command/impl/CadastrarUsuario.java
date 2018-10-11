package com.ifpb.pw1.sysfood.command.impl;

import com.ifpb.pw1.sysfood.command.Command;
import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
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
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException, PersistenciaException {
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        //ANIVERSÁARIO NÃO IMPLEMENTADO
        String aniversario = req.getParameter("dia")+"-"+req.getParameter("mes")+"-"+req.getParameter("ano");
        String profissao = req.getParameter("profissao");
        String sexo = req.getParameter("sexo");
        Part part = req.getPart("fotoPerfil");
        String descricao = req.getParameter("descricao");
        String rua = req.getParameter("rua");
        String numero= req.getParameter("numero");
        String cidade = req.getParameter("cidade");
        String estado = req.getParameter("estado");
        String cep = req.getParameter("cep");
        String telefone = req.getParameter("telefone");

        //int num = Integer.valueOf(numero)

        byte[] fotoPerfil = new byte[(int) part.getSize()];
        InputStream stream = part.getInputStream();
        stream.read(fotoPerfil);
        stream.close();

        GerenciadorUsuario gerenciadorUsuario = new GerenciadorUsuario();
            Boolean cadastrar = gerenciadorUsuario.cadastrar(nome, email,profissao, sexo,
                    fotoPerfil, descricao, rua, numero, cidade, estado, cep, telefone, senha);

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
