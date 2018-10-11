package com.ifpb.pw1.sysfood.command.impl;

import com.ifpb.pw1.sysfood.command.Command;
import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.managers.GerenciadorEstabelecimento;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Time;

public class CadastrarEstabelecimento implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException,
            PersistenciaException, SQLException {
        int status = 0;

        String nome = req.getParameter("nome");
        String dataHoraFuncionamento = req.getParameter("funcionamento");
        String rua = req.getParameter("rua");
        int numero= req.getIntHeader("numero");
        String cidade = req.getParameter("cidade");
        String estado = req.getParameter("estado");
        String cep = req.getParameter("cep");
        String tipo = req.getParameter("tipo");
        Part part = req.getPart("fotoPerfil");
        String descricao = req.getParameter("descricao");
        if (req.getParameter("status") == "off"){
            status = 0;
        }

        //int num = Integer.valueOf(numero)

        byte[] fotoPerfil = new byte[(int) part.getSize()];
        InputStream stream = part.getInputStream();
        stream.read(fotoPerfil);
        stream.close();

        GerenciadorEstabelecimento gerenciadorEstabelecimento = new GerenciadorEstabelecimento();
        Boolean cadastrar = gerenciadorEstabelecimento.cadastrar(nome, dataHoraFuncionamento, rua, numero, cidade,
                estado, cep, tipo, fotoPerfil, descricao, status);

        if(cadastrar){
            res.setStatus(200);
        }else{
            res.setStatus(400);
            res.setHeader("errorMessage", "Não foi possível cadastrar o estabelecimento");
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("home.jsp");
        requestDispatcher.forward(req,res);

    }
}
