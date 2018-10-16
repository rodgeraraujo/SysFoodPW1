package com.ifpb.pw1.sysfood.command.impl;

import com.ifpb.pw1.sysfood.command.Command;
import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.entities.Estabelecimento;
import com.ifpb.pw1.sysfood.entities.Usuario;
import com.ifpb.pw1.sysfood.managers.GerenciadorEstabelecimento;
import com.ifpb.pw1.sysfood.managers.GerenciadorPesquisa;
import com.ifpb.pw1.sysfood.managers.GerenciadorUsuario;
import sun.plugin.javascript.navig.Array;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Pesquisa implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException,
            PersistenciaException, SQLException {

        GerenciadorEstabelecimento gerenciadorE = new GerenciadorEstabelecimento();
        GerenciadorUsuario gerenciadorU = new GerenciadorUsuario();
        HttpSession session = req.getSession();
        String nome = req.getParameter("q");

        try{


            List<Estabelecimento> estabelecimentos = gerenciadorE.buscarNome(nome);
            List<Usuario> usuarios = gerenciadorU.buscaNome(nome);


            session.setAttribute("usuarios", usuarios);
            session.setAttribute("estabelecimentos", estabelecimentos);

            RequestDispatcher dispatcher = req.getRequestDispatcher("search.jsp?nome="+ nome);
            dispatcher.forward(req, res);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
