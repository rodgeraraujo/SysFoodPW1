package com.ifpb.pw1.sysfood.dao.interfaces;

import com.ifpb.pw1.sysfood.entities.AvaliarEstabelecimento;

public interface AvaliaEstabelecimentoDao {

    Float MediaNOta();

    boolean Avaliar(AvaliarEstabelecimento avaliar);
}
