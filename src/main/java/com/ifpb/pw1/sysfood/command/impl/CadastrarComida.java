package com.ifpb.pw1.sysfood.command.impl;

import com.ifpb.pw1.sysfood.command.Command;
import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.entities.Comida;
import com.ifpb.pw1.sysfood.entities.Estabelecimento;
import com.ifpb.pw1.sysfood.managers.GerenciadorComida;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Base64;

public class CadastrarComida implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException, PersistenciaException, SQLException {
        HttpSession session = req.getSession();

        GerenciadorComida gerenciador = new GerenciadorComida();
        Estabelecimento e = (Estabelecimento) session.getAttribute("estabelecimento");

        String nome = req.getParameter("nome");
        String descricao = req.getParameter("descricao");
        Part part = req.getPart("fotoComida");

        Timestamp dataPublicacao = new Timestamp(System.currentTimeMillis());

        int idEstabelecimento = e.getId();

        byte[] foto = new byte[(int) part.getSize()];
        InputStream stream = part.getInputStream();
        stream.read(foto);
        stream.close();

        String fotoComida = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(foto);


        gerenciador.cadastrar(new Comida(nome, descricao, idEstabelecimento, fotoComida, dataPublicacao));
        stream.close();
        RequestDispatcher dispatcher = req.getRequestDispatcher("front?action=BuscarEstabelecimento&id=" + idEstabelecimento);
        dispatcher.forward(req, res);
    }


}
