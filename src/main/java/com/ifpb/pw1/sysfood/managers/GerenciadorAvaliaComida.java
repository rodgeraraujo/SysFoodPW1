package com.ifpb.pw1.sysfood.managers;

import com.ifpb.pw1.sysfood.dao.interfaces.AvaliarComidaDao;
import com.ifpb.pw1.sysfood.dao.interfaces.FactoryDao;
import com.ifpb.pw1.sysfood.entities.AvaliarComida;

public class GerenciadorAvaliaComida {
    private FactoryDao factory = null;
    private AvaliarComidaDao dao = null;


    public Boolean Avaliar(AvaliarComida avaliar){
        return dao.Avaliar(avaliar);
    }

    public Float Media(){
        return dao.MediaNota();
    }
}
