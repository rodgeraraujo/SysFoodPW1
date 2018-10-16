package com.ifpb.pw1.sysfood.command.impl;

import com.ifpb.pw1.sysfood.command.Command;
import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.entities.Publicacao;
import com.ifpb.pw1.sysfood.entities.Usuario;
import com.ifpb.pw1.sysfood.managers.GerenciadorUsuario;

import javax.ejb.Local;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SalvarPublicacao implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException,
            PersistenciaException, SQLException {

        try {
            GerenciadorUsuario gerencia = new GerenciadorUsuario();
            HttpSession session = req.getSession();
            Usuario u = (Usuario) session.getAttribute("usuario");

            if (u != null) {

                String usuarioNome = u.getNome();
                String conteudo = req.getParameter("conteudo");
                int idUsuario = u.getId();
                String dataPublicacao = "" + LocalDate.now();
                Part part = req.getPart("fotoPublicacao");
                String usuarioFoto = u.getFotoPerfil();


                byte[] foto = new byte[(int) part.getSize()];
                InputStream stream = part.getInputStream();
                stream.read(foto);

                String fotoPublicacao = "" + Base64.getEncoder().encodeToString(foto);

                gerencia.salvaPublicacao(
                        new Publicacao(usuarioNome, conteudo, idUsuario, dataPublicacao, fotoPublicacao, usuarioFoto)
                );
                stream.close();

                RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp?value=3");
                dispatcher.forward(req, res);
            } else {
                res.sendRedirect("login.jsp?value=2");
            }
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
}
