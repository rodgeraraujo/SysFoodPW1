package com.ifpb.pw1.sysfood.dao.interfaces;

import com.ifpb.pw1.sysfood.managers.GerenciadorAvaliaEstabelecimento;

public interface FactoryDao {
    UsuarioDao getDaoUsuario();
    EstabelecimentoDao getDaoEstabelecimento();
    ComidaDao getDaoComida();
    AvaliaEstabelecimentoDao getAvaliaEstabelecimentoDao();
}
