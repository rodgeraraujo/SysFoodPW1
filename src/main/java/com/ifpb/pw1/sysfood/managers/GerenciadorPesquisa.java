package com.ifpb.pw1.sysfood.managers;

import com.ifpb.pw1.sysfood.dao.factory.Factory;
import com.ifpb.pw1.sysfood.dao.impl.PesquisaDaoBD;
import com.ifpb.pw1.sysfood.dao.interfaces.FactoryDao;
import com.ifpb.pw1.sysfood.dao.interfaces.UsuarioDao;

import java.util.List;

public class GerenciadorPesquisa {
    private FactoryDao factory = null;
    private PesquisaDaoBD dao;

    public GerenciadorPesquisa() {
        factory = Factory.createFactory();
        dao = factory.getDaoPesquisa();
    }

    public List<Object> Pesquisa(String nome){
        return dao.buscar(nome);
    }
}
