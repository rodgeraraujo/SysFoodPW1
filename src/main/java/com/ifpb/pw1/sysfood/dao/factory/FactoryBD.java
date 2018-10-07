package com.ifpb.pw1.sysfood.dao.factory;

import com.ifpb.pw1.sysfood.dao.impl.EstabelecimentoDaoBD;
import com.ifpb.pw1.sysfood.dao.impl.LoginDaoBD;
import com.ifpb.pw1.sysfood.dao.impl.UsuarioDaoBD;
import com.ifpb.pw1.sysfood.dao.interfaces.EstabelecimentoDao;
import com.ifpb.pw1.sysfood.dao.interfaces.FactoryDao;
import com.ifpb.pw1.sysfood.dao.interfaces.LoginDao;
import com.ifpb.pw1.sysfood.dao.interfaces.UsuarioDao;

import java.sql.SQLException;

public class FactoryBD implements FactoryDao {


    @Override
    public UsuarioDao getDaoUsuario() {
        try{
            return new UsuarioDaoBD();
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public EstabelecimentoDao getDaoEstabelecimento() {
        try{
            return new EstabelecimentoDaoBD();
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}
