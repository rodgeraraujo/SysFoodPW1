package com.ifpb.pw1.sysfood.command.impl;

import com.ifpb.pw1.sysfood.command.Command;
import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.entities.Estabelecimento;
import com.ifpb.pw1.sysfood.entities.Publicacao;
import com.ifpb.pw1.sysfood.entities.PublicacaoEstabelecimento;
import com.ifpb.pw1.sysfood.entities.Usuario;
import com.ifpb.pw1.sysfood.managers.GerenciadorEstabelecimento;
import com.ifpb.pw1.sysfood.managers.GerenciadorUsuario;

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

public class SalvarPublicacaoEstab implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException,
            ServletException, PersistenciaException, SQLException {

        try {
            GerenciadorEstabelecimento gerencia = new GerenciadorEstabelecimento();
            HttpSession session = req.getSession();
            Usuario u = (Usuario) session.getAttribute("usuario");
            Estabelecimento e = (Estabelecimento) session.getAttribute("estabelecimento");

            if (u != null) {

                String nomeEstabelecimento = e.getNome();
                String conteudo = req.getParameter("conteudo");
                int idEstabelecimento = e.getId();
                String dataPublicacao = "" + LocalDate.now();
                Part part = req.getPart("fotoPublicacao");
                String estabelecimentoFoto = e.getFotoPerfil();


                byte[] foto = new byte[(int) part.getSize()];
                InputStream stream = part.getInputStream();
                stream.read(foto);

                String fotoPublicacao = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(foto);

                String tipo = "e";

                gerencia.salvaPublicacao(
                        new PublicacaoEstabelecimento(nomeEstabelecimento, conteudo, idEstabelecimento,
                                dataPublicacao, fotoPublicacao, estabelecimentoFoto, tipo)
                );
                stream.close();

                RequestDispatcher dispatcher = req.getRequestDispatcher("/page/profile.jsp?id=" + e.getId());
                dispatcher.forward(req, res);
            } else {
                res.sendRedirect("login.jsp?value=2");
            }
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);

        }
    }


}
