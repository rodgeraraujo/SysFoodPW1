package com.ifpb.pw1.sysfood.command.impl;

import com.ifpb.pw1.sysfood.command.Command;
import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.entities.AvaliarEstabelecimento;
import com.ifpb.pw1.sysfood.entities.Estabelecimento;
import com.ifpb.pw1.sysfood.entities.Usuario;
import com.ifpb.pw1.sysfood.managers.GerenciadorAvaliaEstabelecimento;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class AvaliarEstabeleciment implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException, PersistenciaException, SQLException {

        HttpSession session = req.getSession();

        GerenciadorAvaliaEstabelecimento gerenciador = new GerenciadorAvaliaEstabelecimento();
        Estabelecimento e = (Estabelecimento) session.getAttribute("estabelecimento");
        Usuario u = (Usuario) session.getAttribute("usuario");

        int idEstabelecimento = e.getId();
        int idUsuario = u.getId();
        float nota;

        switch (req.getParameter("rating")){
            case "0.5": nota = (float) 0.5;
            break;

            case "1": nota = 1;
            break;

            case "1.5": nota = (float) 1.5;
            break;

            case "2": nota = 2;
            break;

            case "2.5": nota = (float) 2.5;
            break;

            case "3": nota = 3;
            break;

            case "3.5": nota = (float) 3.5;
            break;

            case "4" : nota = 4;
            break;

            case "4.5": nota = (float) 4.5;
            break;

            case "5": nota = 5;
            break;

            default: nota = 0;
            break;
        }

        String comentario = req.getParameter("comentario");
        Timestamp dataAvaliacao = new Timestamp(System.currentTimeMillis());

        AvaliarEstabelecimento avaliar = new AvaliarEstabelecimento(idUsuario, idEstabelecimento, nota, comentario, dataAvaliacao);

        gerenciador.Avaliar(avaliar);

        RequestDispatcher dispatcher = req.getRequestDispatcher("front?action=BuscarEstabelecimento&id=" + idEstabelecimento);
        dispatcher.forward(req, res);
    }
}
