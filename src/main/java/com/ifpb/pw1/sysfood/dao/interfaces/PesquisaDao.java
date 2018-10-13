package com.ifpb.pw1.sysfood.dao.interfaces;

import com.ifpb.pw1.sysfood.entities.Estabelecimento;
import com.ifpb.pw1.sysfood.entities.Usuario;

import java.util.List;

public interface PesquisaDao {
    List<Object> buscar(String nome);
}
