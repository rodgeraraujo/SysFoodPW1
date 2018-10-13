package com.ifpb.pw1.sysfood.managers;

import com.ifpb.pw1.sysfood.dao.impl.PesquisaDaoBD;

import java.util.List;

public class GerenciaPesquisa {

    private PesquisaDaoBD dao;

    public List<Object> Pesquisa(String nome){
        return dao.buscar(nome);
    }
}
