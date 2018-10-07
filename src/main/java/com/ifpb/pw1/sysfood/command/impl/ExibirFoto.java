package com.ifpb.pw1.sysfood.command.impl;

import com.ifpb.pw1.sysfood.command.Command;
import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.entities.Usuario;
import com.ifpb.pw1.sysfood.managers.GerenciadorUsuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExibirFoto implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException,
            PersistenciaException, SQLException {

        HttpSession session = req.getSession();

        imprimir(req.getParameter("usuario"), res);
    }

    private void imprimir(String usuario, HttpServletResponse res) throws PersistenciaException, SQLException, IOException {

        GerenciadorUsuario g = new GerenciadorUsuario();
        Usuario u = g.buscaUsuario(usuario);
        System.out.println(u.getNome());

        try {
            res.getOutputStream().write(u.getFotoPerfil());
        } catch (IOException ex) {
            Logger.getLogger(ExibirFoto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
