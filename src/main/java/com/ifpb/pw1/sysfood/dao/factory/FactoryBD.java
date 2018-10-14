package com.ifpb.pw1.sysfood.dao.factory;

import com.ifpb.pw1.sysfood.dao.impl.AvaliarEstabelecimentoDaoBD;
import com.ifpb.pw1.sysfood.dao.impl.ComidaDaoBD;
import com.ifpb.pw1.sysfood.dao.impl.EstabelecimentoDaoBD;
import com.ifpb.pw1.sysfood.dao.impl.UsuarioDaoBD;
import com.ifpb.pw1.sysfood.dao.interfaces.*;

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
    @Override
    public ComidaDao getDaoComida(){
        try{
            return new ComidaDaoBD();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public AvaliaEstabelecimentoDao getAvaliaEstabelecimentoDao() {
        try{
            return new AvaliarEstabelecimentoDaoBD();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
