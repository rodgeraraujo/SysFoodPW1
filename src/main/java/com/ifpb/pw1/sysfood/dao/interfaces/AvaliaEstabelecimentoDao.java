package com.ifpb.pw1.sysfood.dao.interfaces;

import com.ifpb.pw1.sysfood.entities.AvaliarEstabelecimento;

import java.util.List;

public interface AvaliaEstabelecimentoDao {

    Float MediaNota();

    boolean Avaliar(AvaliarEstabelecimento avaliar);

    List<AvaliarEstabelecimento> buscar(int id);
}
