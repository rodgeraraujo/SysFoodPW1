package com.ifpb.pw1.sysfood.managers;

import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.dao.factory.Factory;
import com.ifpb.pw1.sysfood.dao.interfaces.FactoryDao;
import com.ifpb.pw1.sysfood.dao.interfaces.LoginDao;
import com.ifpb.pw1.sysfood.entities.LoginBean;
import com.ifpb.pw1.sysfood.entities.Usuario;

public class GerenciadorLogin {
    private FactoryDao factory = null;
    private LoginDao dao = null;

    public GerenciadorLogin() {
        factory = Factory.createFactory();
        dao = factory.getDaoLogin();
    }

    public Usuario autenticar(String email, String senha) throws PersistenciaException {
        LoginBean login = new LoginBean(email, senha);
        return dao.autentica(login);
    }
}
