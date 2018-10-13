package com.ifpb.pw1.sysfood.dao.impl;

import com.ifpb.pw1.sysfood.dao.interfaces.PesquisaDao;
import com.ifpb.pw1.sysfood.entities.Estabelecimento;
import com.ifpb.pw1.sysfood.entities.Usuario;
import com.ifpb.pw1.sysfood.managers.GerenciadorEstabelecimento;
import com.ifpb.pw1.sysfood.managers.GerenciadorUsuario;

import java.util.ArrayList;
import java.util.List;

public class PesquisaDaoBD implements PesquisaDao {


    @Override
    public List<Object> buscar(String nome) {

        List<Object> objects = new ArrayList<Object>();

        GerenciadorEstabelecimento gereciaE = new GerenciadorEstabelecimento();
        GerenciadorUsuario gerenciaU = new GerenciadorUsuario();

        List<Estabelecimento> e = gereciaE.buscarNome(nome);
        objects.add(e);
        List<Usuario> u = gerenciaU.buscaNome(nome);
        objects.add(u);
        return objects;
    }
}
