package com.ifpb.pw1.sysfood.managers;

import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.dao.factory.Factory;
import com.ifpb.pw1.sysfood.dao.interfaces.ComidaDao;
import com.ifpb.pw1.sysfood.dao.interfaces.FactoryDao;
import com.ifpb.pw1.sysfood.entities.Comida;

public class GerenciadorComida {
    private FactoryDao factory = null;
    private ComidaDao dao = null;


    public GerenciadorComida(){
        factory = Factory.createFactory();
        dao = factory.getDaoComida();
    }

    public Boolean cadastrar(Comida comida) throws PersistenciaException {
        return dao.salvar(comida);
    }

}
