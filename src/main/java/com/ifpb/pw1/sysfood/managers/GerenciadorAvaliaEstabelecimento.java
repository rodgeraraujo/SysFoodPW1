package com.ifpb.pw1.sysfood.managers;

import com.ifpb.pw1.sysfood.dao.factory.Factory;
import com.ifpb.pw1.sysfood.dao.impl.AvaliarEstabelecimentoDaoBD;
import com.ifpb.pw1.sysfood.dao.interfaces.FactoryDao;
import com.ifpb.pw1.sysfood.entities.AvaliarEstabelecimento;

public class GerenciadorAvaliaEstabelecimento {

    private FactoryDao factory = null;
    private AvaliarEstabelecimentoDaoBD dao = null;

    public GerenciadorAvaliaEstabelecimento(){
        factory = Factory.createFactory();
        dao = (AvaliarEstabelecimentoDaoBD) factory.getAvaliaEstabelecimentoDao();
    }


    public boolean Avaliar(AvaliarEstabelecimento avaliar){
        return dao.Avaliar(avaliar);
    }

    public Float MediaNota(){
        return dao.MediaNota();
    }
}
