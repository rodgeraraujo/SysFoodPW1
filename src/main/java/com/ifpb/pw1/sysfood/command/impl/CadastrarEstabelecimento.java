package com.ifpb.pw1.sysfood.command.impl;

import com.ifpb.pw1.sysfood.command.Command;
import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.entities.Estabelecimento;
import com.ifpb.pw1.sysfood.entities.Usuario;
import com.ifpb.pw1.sysfood.managers.GerenciadorEstabelecimento;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.websocket.Session;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Base64;

public class CadastrarEstabelecimento implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException,
            PersistenciaException, SQLException {
        HttpSession session = req.getSession();
        Usuario u = (Usuario) session.getAttribute("usuario");
        Estabelecimento e = new Estabelecimento();

        String nome = req.getParameter("nome");
        Part part = req.getPart("fotoPerfil");
        String descricao = req.getParameter("descricao");
        String tipo = req.getParameter("tipo");
        String rua = req.getParameter("rua");
        String cidade = req.getParameter("cidade");
        String checkin = req.getParameter("checkin");
        String checkout = req.getParameter("checkout");
        String estado = req.getParameter("estado");
        String numero = req.getParameter("numero");
        String cep = req.getParameter("cep");
        String usuarioEmail = u.getEmail();
        int status = e.getATIVO();

        byte[] foto = new byte[(int) part.getSize()];
        InputStream stream = part.getInputStream();
        stream.read(foto);
        stream.close();

        String fotoPerfil = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(foto);

        GerenciadorEstabelecimento gerenciadorEstabelecimento = new GerenciadorEstabelecimento();
        Boolean cadastrar = gerenciadorEstabelecimento.cadastrar(nome, checkin, checkout, rua, numero, cidade,
                estado, cep, tipo, fotoPerfil, descricao, usuarioEmail, status);

        if(cadastrar){
            res.setStatus(200);
        }else{
            res.setStatus(400);
            res.setHeader("errorMessage", "Não foi possível cadastrar o estabelecimento");
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("home.jsp?value=2");
        requestDispatcher.forward(req,res);

    }
}
