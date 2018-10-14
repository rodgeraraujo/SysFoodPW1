package com.ifpb.pw1.sysfood.dao.interfaces;

import com.ifpb.pw1.sysfood.entities.AvaliarComida;

public interface AvaliarComidaDao {

    Float MediaNota();

    boolean Avaliar(AvaliarComida avaliar);
}
