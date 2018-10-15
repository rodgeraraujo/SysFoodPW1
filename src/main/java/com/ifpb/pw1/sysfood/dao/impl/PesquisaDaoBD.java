package com.ifpb.pw1.sysfood.dao.impl;

import com.ifpb.pw1.sysfood.dao.connect.ConFactory;
import com.ifpb.pw1.sysfood.dao.connect.DataBase;
import com.ifpb.pw1.sysfood.dao.interfaces.PesquisaDao;
import com.ifpb.pw1.sysfood.entities.Estabelecimento;
import com.ifpb.pw1.sysfood.entities.Usuario;
import com.ifpb.pw1.sysfood.managers.GerenciadorEstabelecimento;
import com.ifpb.pw1.sysfood.managers.GerenciadorUsuario;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PesquisaDaoBD implements PesquisaDao {

    private DataBase props;
    private Connection conexao;

    public PesquisaDaoBD() throws SQLException, ClassNotFoundException {
        this.props = new DataBase();
        this.conexao = ConFactory.getConnection(props.getUrl(),props.getUser(),props.getPassword());
    }

    @Override
    public List<Object> buscar(String nome) {

        System.out.println("dao" + nome);
        List<Object> objects = new ArrayList<Object>();

        GerenciadorEstabelecimento gereciaE = new GerenciadorEstabelecimento();
        GerenciadorUsuario gerenciaU = new GerenciadorUsuario();

        List<Estabelecimento> e = gereciaE.buscarNome(nome);
        objects.add(e);
        List<Usuario> u = gerenciaU.buscaNome(nome);
        objects.add(u);
        System.out.println(objects);
        return objects;
    }


}
